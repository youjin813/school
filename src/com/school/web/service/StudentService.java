package com.school.web.service;

import com.school.web.bean.StudentBean;

public interface StudentService {
	public void addStudent(StudentBean student);
	public void addScore(StudentBean score);
	public StudentBean login(StudentBean student);
	public StudentBean find(String id);
	public int getCount();
	public StudentBean[] list();

}
