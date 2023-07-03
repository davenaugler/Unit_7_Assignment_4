package com.coderscampus.Unit_7_Assignment_4;

import java.io.IOException;

public class StudentApp {
	public static void main(String[] args) throws IOException {
		FileService fileService = new FileService();
		Student[] students = fileService.readFile();

		StudentService studentListService = new StudentService();
		studentListService.gatherStudentsIntoCorrectCourse(students);
	}
}
