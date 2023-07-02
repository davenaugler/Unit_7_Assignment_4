package com.coderscampus.Unit_7_Assignment_4;

import java.io.IOException;

public class StudentListApp {
	public static void main(String[] args) throws IOException {
		FileService fileService = new FileService();
		Student[] students = fileService.readFile();

		StudentListService studentListService = new StudentListService();
		studentListService.gatherStudentsIntoCorrectCourse(students);
	}
}
