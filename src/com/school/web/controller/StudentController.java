package com.school.web.controller;

import java.lang.reflect.Member;
import java.util.Scanner;

import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;
import com.school.web.serviceImpl.StudentServiceImpl;

public class StudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentService studentService = new StudentServiceImpl();
		StudentBean student = new StudentBean();
		while(true) {
			System.out.println("[메뉴] 0.종료 1.학생등록 2.성적등록" );
			switch(scanner.nextInt()) {
			case 0 :
				System.out.println("시스템 종료");
				return;
			case 1 :
				System.out.println("ID입력");
				student.setId(scanner.next());
				System.out.println("PASS입력");
				student.setPass(scanner.next());
				System.out.println("이름입력");
				student.setPass(scanner.next());
				studentService.addStudent(student);
				
			}
		}
	}
}
