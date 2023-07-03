package com.coderscampus.Unit_7_Assignment_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

	private final String FILENAME = "student-master-list.csv";
	private final int TOTAL_STUDENTS = 100;

	public Student[] readFile() throws IOException {
		Student[] students = new Student[TOTAL_STUDENTS];
		boolean isFirstLine = true;
		int counter = 0;

		try (BufferedReader fileReader = new BufferedReader(new FileReader(FILENAME))) {
			String line;
			while ((line = fileReader.readLine()) != null) {
				if (isFirstLine) {
					isFirstLine = false;
					continue; // Skip the first line
				}
				// Example 1: of organizing our student data | Example 2 in Student Constructor 
//				Student student = new Student(Integer.parseInt(studentInfo[0]), studentInfo[1], studentInfo[2], Integer.parseInt(studentInfo[3]));
				Student student = new Student(line.split(","));
				students[counter] = student;
				counter++;

				if (counter >= TOTAL_STUDENTS) {
					break; // Reached the total number of students in FILENAME, exit the loop
				}
			}
		}
		return students;
	}
}
