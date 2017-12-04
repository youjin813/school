package com.school.web.serviceImpl;

import java.util.Scanner;

import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;

public class StudentServiceImpl implements StudentService{
	
	private StudentBean[] students;
	private int count;
	
	public StudentServiceImpl(int count) {
		this.count=0;
	    students = new StudentBean [count];
 		}
	
	@Override
    public int getCount() {
			return count;
		}

	@Override
	public void addStudent(StudentBean student) {
		students[count] = student;
		count ++;
		/* public[0]=student;
		     한명만 남음
		   for(start=0;start<count;start++){
		   student[start] = student;}
		     똑같은 사람을 계속 만들어냄**/
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
	@Override
	public StudentBean[] list() {
		return students;
	}

	@Override
	public StudentBean findStudentById(String id) {
		StudentBean student = new StudentBean();
		for(int i=0;i<count;i++) {
			if(id.equals(students[i].getId())) {      //외부에서 넘어온 값으로 
				student = students[i];
				break;
			}
		}
		//String userid = students[6].getId();
		return student;
	}

	@Override
	public StudentBean[] findStudentByName(String name) {
		StudentBean[] students = null;
		int matchCount = 0;
		for(int i=0;i<count;i++) {
			if(name.equals(this.students[i].getName())) {
			matchCount++;
			}
		}
		if(matchCount!=0) {}
		students = new StudentBean[matchCount];
		int j = 0;
		for(int i=0;i<count;i++) {
			if(name.equals(this.students[i].getName())) {
			students[j]= this.students[i];
			j++;
			if(j==matchCount) {
				break;
			}
			}
		}
		return students;
	}
}