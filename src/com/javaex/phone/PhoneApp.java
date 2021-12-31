package com.javaex.phone;

import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {
		// 미니 프로젝트
		Scanner sc = new Scanner(System.in);
		PhoneDao phoneDao = new PhoneDao();
		int i = 0;
		PersonVo p;
		int put;
		int putNum;
		String putName;
		String putHp;
		String putCompany;
		
		System.out.println("********************************");
		System.out.println("*       전화번호 관리 프로그램       *");
		System.out.println("********************************");
		while(i==0) {
			System.out.println("");
			System.out.println("1.리스트 2.등록 3. 수정 4.삭제 5.검색 6.종료");
			System.out.println("--------------------------------");
			System.out.print(">메뉴번호:");
			put = sc.nextInt();
			
			switch (put) {
			case 1 :
				System.out.println("<1.리스트>");
				phoneDao.getSelect();
				break;
			case 2 :
				System.out.println("<2.등록>");
				sc.nextLine();//개행문자 제거
				System.out.print(">이름:");
				putName = sc.nextLine();
				System.out.print(">휴대전화:");
				putHp = sc.nextLine();
				System.out.print(">회사전화:");
				putCompany = sc.nextLine();
				
				p = new PersonVo(putName, putHp, putCompany);
				phoneDao.getInsert(p);

				phoneDao.getSelect();
				
				break;
			case 3 :
				System.out.println("<3.수정>");
				System.out.print(">번호:");
				putNum = sc.nextInt();
				System.out.print(">이름:");
				putName = sc.nextLine();
				System.out.print(">휴대전화:");
				putHp = sc.nextLine();
				System.out.print(">회사전화:");
				putCompany = sc.nextLine();
				
				p = new PersonVo(putNum, putName, putHp, putCompany);
				phoneDao.getUpdate(p);
				break;
			case 4 :
				System.out.println("<4.삭제>");
				System.out.print(">번호:");
				putNum = sc.nextInt();
				phoneDao.getDelete(putNum);
				break;
			case 5 :
				System.out.println("<5.검색>");
				sc.nextLine();//개행문자 제거
				System.out.print(">이름:");
				putName = sc.nextLine();
				phoneDao.getSearch(putName);
				break;
			case 6 :
				System.out.println("********************************");
				System.out.println("*           감사합니다           *");
				System.out.println("********************************");
				i++;
				break;
			default :
				System.out.println("[다시 입력해 주세요.]");
				break;
			}
		}
		sc.close();
	}

}
