package com.batch.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.batch.model.Student;

public class StudentProcessor implements ItemProcessor<Student, Student> {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentProcessor.class);

	@Override
	public Student process(Student student) throws Exception {
		LOGGER.info("Processing student information: {}", student);
		return student;
	}
}