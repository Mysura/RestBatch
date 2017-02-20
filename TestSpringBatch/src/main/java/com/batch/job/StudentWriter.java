package com.batch.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.web.client.RestTemplate;

import com.batch.model.Student;

public class StudentWriter implements ItemWriter<Student> {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentWriter.class);

	public StudentWriter(String requiredProperty, RestTemplate restTemplate) {
		
	}

	public StudentWriter() {
		super();
		
	}

	@Override
	public void write(List<? extends Student> students) throws Exception {
		LOGGER.info("Received the information of {} students", students.size());

		students.forEach(i -> LOGGER.debug("Received the information of a student: {}", i));

	}
}