package com.coderscampus.Unit_7_Assignment_4;

public class StudentApp {
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		Student[] students = studentService.readStudentsFromFile();
		studentService.gatherStudentsIntoCorrectCourse(students);
	}
}
