package com.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.batch.job.StudentProcessor;
import com.batch.job.StudentWriter;
import com.batch.job.StudentReader;
import com.batch.model.Student;

@Configuration
public class StudentConfig {

	private static final String PROPERTY_REST_API_URL = "rest.api.to.database.job.api.url";

	@Bean
	ItemReader<Student> restStudentReader(Environment environment, RestTemplate restTemplate) {
		return new StudentReader(environment.getRequiredProperty(PROPERTY_REST_API_URL), restTemplate);
	}

	@Bean
	ItemProcessor<Student, Student> restStudentProcessor() {
		return new StudentProcessor();
	}

	@Bean
	ItemWriter<Student> restStudentWriter() {
		return new StudentWriter();
	}

	@Bean
	Step restStudentStep(ItemReader<Student> restStudentReader, ItemProcessor<Student, Student> restStudentProcessor,
			ItemWriter<Student> restStudentWriter, StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("restStudentStep").<Student, Student>chunk(1).reader(restStudentReader)
				.processor(restStudentProcessor).writer(restStudentWriter).build();
	}

	@Bean
	Job restStudentJob(JobBuilderFactory jobBuilderFactory, @Qualifier("restStudentStep") Step restStudentStep) {
		return jobBuilderFactory.get("restStudentJob").incrementer(new RunIdIncrementer()).flow(restStudentStep).end()
				.build();
	}
}