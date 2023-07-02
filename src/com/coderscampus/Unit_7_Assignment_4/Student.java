package com.coderscampus.Unit_7_Assignment_4;

public class Student implements Comparable<Student> {

	private Integer studentID;
	private String studentName;
	private String course;
	private Integer grade;

	public Student(Integer studentID, String studentName, String course, Integer grade) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.course = course;
		this.grade = grade;
	}

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return studentID + "," + studentName + "," + course + "," + grade;
	}

	@Override
	public int compareTo(Student that) {

		if (that == null) {
			return 1;
		}

		return Integer.compare(that.grade, this.grade);
	}
}
