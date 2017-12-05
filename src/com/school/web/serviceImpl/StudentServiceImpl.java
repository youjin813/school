package com.school.web.serviceImpl;

import java.util.Scanner;

import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;

public class StudentServiceImpl implements StudentService{
	
	private StudentBean[] students;
	private int count;
	
	public StudentServiceImpl() {
		this.count=0;
	    students = new StudentBean [2];
 		}
	
	@Override
    public int getCount() {
			return count;
		}

	@Override
	public void addStudent(StudentBean student) {
		if(count==students.length) {                                        
			StudentBean[] home = new StudentBean[count+2];
			System.arraycopy(students, 0, home, 0, count);   
			students = home;
		}
		this.students[count ++] = student;
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
		if(matchCount!=0) {
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
		}
		return students;
	}
	@Override
	public void updatePass(StudentBean student) {  //void일때 this 위로 올라가서 확인하고 배열 
		for(int i=0;i<count;i++) {
			if(student.getId().equals(students[i].getId())) {          //for if는 검색의 기본
				this.students[i].setPass(student.getPass());
				break;
			 }									
		}
		/*StudentBean t =findStudentById(student.getId());          1번
		t.setPass(student.getPass());**/
																		//이거로 쓰면 91~93안씀 왜냐면 위에 findStudentById에서 이미 위에 로직을 만듬
		//findStudentById(student.getId()).setPass(student.getPass());  1번과 같음.합쳐서 쓴거

		//this.students[0].setPass(student.getPass());
		
	}

	@Override
	public void deleteStudent(String id) {
		for(int i=0;i<count;i++) {
			if(id.equals(students[i].getId())) {
				students[i] = null;
				students[i] = students[count-1];
				students[count-1] = null;
				count--;
				break;
			}
		}
	}

}