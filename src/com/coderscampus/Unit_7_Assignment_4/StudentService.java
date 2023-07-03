package com.coderscampus.Unit_7_Assignment_4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class StudentService {
	
	FileService fileService = new FileService();

	public void sortAndWriteStudents(Student[] students, String courseCode, String filePath) throws IOException {
		Student[] courseStudents = new Student[students.length];
		
		int count = 0;
		
		for (Student student : students) {
			String courseName = student.getCourse();
			
			if (courseName.contains(courseCode)) {
				courseStudents[count++] = student;
			}
		}
		
		sortStudents(courseStudents, count);
		writeStudentsToCSV(courseStudents, filePath, count);
	}
	
	public void gatherStudentsIntoCorrectCourse(Student[] students) {
		try {
			sortAndWriteStudents(students, "COMPSCI", "course1.csv");
		} catch (IOException e) {
			System.out.println("Error writing COMPSCI students to file");
		}
		try {
			sortAndWriteStudents(students, "STAT", "course2.csv");
		} catch (IOException e) {
			System.out.println("Error writing STAT students to file");
		}
		try {
			sortAndWriteStudents(students, "APMTH", "course3.csv");
		} catch (IOException e) {
			System.out.println("Error writing APMTH students to file");
		}
	}
	
	private void sortStudents(Student[] students, int count) {
		if (count > 0) {
			Arrays.sort(students, 0, count);
//			Uncomment to visualize the the Students sorted in the console
//			for (int i = 0; i < count; i++) {
//				System.out.println(students[i]);
//			}
		}
	}

	private void writeStudentsToCSV(Student[] students, String fileName, int count) throws IOException {
		try (FileWriter fileWriter = new FileWriter(fileName)) {
			fileWriter.write("Student ID, Student Name, Course, Grade");
			fileWriter.write(System.lineSeparator());

			for (int i = 0; i < count; i++) {
				fileWriter.write(students[i].toString());
				fileWriter.write(System.lineSeparator());
			}
		}
	}
	
	public Student[] readStudentsFromFile() {
		try {
			return fileService.readFile();
		} catch (IOException e) {
			System.out.println("Error in reading file");
			e.printStackTrace();
		}
		return null;
	}
}
