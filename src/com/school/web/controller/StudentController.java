package com.school.web.controller;

import java.lang.reflect.Member;
//import java.util.Scanner;   스캐너 사용 안하니까 필요 없음
import javax.swing.JOptionPane;
import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;
import com.school.web.serviceImpl.StudentServiceImpl;
import com.school.web.ui.MainPage;

public class StudentController {
	public static void main(String[] args) {
		StudentService studentService = new StudentServiceImpl();
		StudentBean student = null;
		StudentBean[] students = null;
		String message ="";
		
		while(true) {
			switch(JOptionPane.showInputDialog("[메뉴] 0.종료 \n1.학생등록\n 3.총 학생수\n 4.학생 이름 리스트\n 5.내 정보 보기\n 6.이름 검색\n 7.비번 변경\n 8.삭제\n 9.화면보기")) {
			case "0" :
				JOptionPane.showMessageDialog(null, "시스템 종료");
				return;
			case "1" :
				student = new StudentBean();
				student.setId(JOptionPane.showInputDialog("ID입력"));
				student.setPass(JOptionPane.showInputDialog("PASS입력"));
				student.setName(JOptionPane.showInputDialog("이름입력"));
				studentService.addStudent(student);
				JOptionPane.showMessageDialog(null, "등록 완료");
				break;
			case "3" :
				JOptionPane.showMessageDialog(null, "총학생수는 :"+studentService.getCount());
				break;
			case "4" :
				message = "";
				students = studentService.list();
				for(int i=0;i<studentService.getCount();i++) {
					message +=students[i].getName()+"\n";
				}
				JOptionPane.showMessageDialog(null, message);
				break;
			case "5" :
				student = studentService.findStudentById(JOptionPane.showInputDialog("아이디 입력"));
				break;
			case "6" :
				message = "";
				students = studentService.findStudentByName(JOptionPane.showInputDialog("검색 이름을 입력하세요."));
				if(students == null) {
					message = "검색하려는 이름이 없습니다.";
				}else {
					for(int i=0;i<students.length;i++) {
						message = students[i].toString();
					}
				}
				
				break;
			case "7" :
				student = new StudentBean();          //검색하기 위한 student
				student.setId(JOptionPane.showInputDialog("수정하고자하는 비번의 아이디"));
				student.setPass(JOptionPane.showInputDialog("수정할 비번 아이디 입력"));
				studentService.updatePass(student);		//비번 업데이트 
				break;
			case "8" :
				studentService.deleteStudent(JOptionPane.showInputDialog("삭제하려는 아이디를 입력하세요"));
				break;
			case "9" :
				MainPage mp = new MainPage();
				break;
			}
		}
	}
}
