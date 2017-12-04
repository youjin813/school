package com.school.web.controller;

import java.lang.reflect.Member;
import java.util.Scanner;

import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;
import com.school.web.serviceImpl.StudentServiceImpl;

public class StudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("학생수를 입력하세요.");
		int count = scanner.nextInt();
		StudentService studentService = new StudentServiceImpl(count);
		StudentBean student = null;
		
		while(true) {
			System.out.println("[메뉴] 0.종료 1.학생등록 3.총 학생수 4.학생 이름 리스트 5.내 정보 보기 6.이름 검색" );
			switch(scanner.nextInt()) {
			case 0 :
				System.out.println("시스템 종료");
				return;
			case 1 :
				student = new StudentBean();
				System.out.println("ID입력");
				student.setId(scanner.next());
				System.out.println("PASS입력");
				student.setPass(scanner.next());
				System.out.println("이름입력");
				student.setName(scanner.next());
				studentService.addStudent(student);
				break;
			case 3 :
				System.out.println("총학생수는"+studentService.getCount());
				break;
			case 4 :
				StudentBean[] students = studentService.list();
				for(int i=0;i<students.length;i++) {
					System.out.println(students[i].getName());
				}
				break;
			case 5 :
				String id = scanner.next();
				StudentBean temp = studentService.findStudentById(id);
				break;
			case 6 :
				System.out.println("검색 이름을 입력하세요.");
				StudentBean[] temp2 = studentService.findStudentByName(scanner.next());
				if(temp2 == null) {
					System.out.println("검색하려는 이름이 없습니다.");
				}else {
					for(int i=0;i<temp2.length;i++) {
						System.out.println(temp2[i].toString());
					}
				}
				break;
			}
		}
	}
}
