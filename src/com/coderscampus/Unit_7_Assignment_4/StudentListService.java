package com.coderscampus.Unit_7_Assignment_4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class StudentListService {

	public void gatherStudentsIntoCorrectCourse(Student[] students) throws IOException {
		Student[] compSciStudents = new Student[students.length];
		Student[] statStudents = new Student[students.length];
		Student[] apmthStudents = new Student[students.length];

		int compSciCount = 0;
		int statCount = 0;
		int apmthCount = 0;

		for (Student student : students) {
			String courseName = student.getCourse();

			if (courseName.contains("COMPSCI")) {
				compSciStudents[compSciCount++] = student;
			} else if (courseName.contains("STAT")) {
				statStudents[statCount++] = student;
			} else if (courseName.contains("APMTH")) {
				apmthStudents[apmthCount++] = student;
			}
		}

		sortStudents(compSciStudents, compSciCount);
		sortStudents(statStudents, statCount);
		sortStudents(apmthStudents, apmthCount);

		writeStudentsToCSV(compSciStudents, "course1.csv", compSciCount);
		writeStudentsToCSV(statStudents, "course2.csv", statCount);
		writeStudentsToCSV(apmthStudents, "course3.csv", apmthCount);
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
}
