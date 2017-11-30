package com.school.web.serviceImpl;

import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;

public class StudentServiceImpl implements StudentService{
	private StudentBean[] students;
	public StudentServiceImpl() {
		students = new StudentBean [3];
	}
	
	@Override
	public void addStudent(StudentBean student) {
		students[0] = student;
		
	}
	@Override
	public void addScore(StudentBean score) {
	
}
	@Override
	public StudentBean login(StudentBean student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentBean find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
