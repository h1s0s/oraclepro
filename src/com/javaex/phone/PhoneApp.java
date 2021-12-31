package com.javaex.phone;

import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {
		// 미니 프로젝트
		Scanner sc = new Scanner(System.in);
		PhoneDao phoneDao = new PhoneDao();
		int i = 0;
		
		System.out.println("********************************");
		System.out.println("*       전화번호 관리 프로그램       *");
		System.out.println("********************************");
		while(i==0) {
			System.out.println("");
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("--------------------------------");
			System.out.print(">메뉴번호:");
			int put = sc.nextInt();
			
			switch (put) {
			case 1 :
				System.out.println("<1.리스트>");
				phoneDao.getSelect();
				break;
			case 2 :
				System.out.println("<2.등록>");
				sc.nextLine();//개행문자 제거
				System.out.print(">이름:");
				String putname = sc.nextLine();
				System.out.print(">휴대전화:");
				String puthp = sc.nextLine();
				System.out.print(">회사전화:");
				String putcompany = sc.nextLine();
				
				PersonVo p2 = new PersonVo(putname, puthp, putcompany);
				phoneDao.getInsert(p2);

				phoneDao.getSelect();
				
				break;
			case 3 :
				System.out.println("<3.삭제>");
				System.out.print(">번호:");
				int	putNum = sc.nextInt();
				phoneDao.getDelete(putNum);
				//System.out.println("[삭제되었습니다.]");
				break;
			case 4 :
				System.out.println("<4.검색>");
				sc.nextLine();//개행문자 제거
				System.out.print(">이름:");
				String putName = sc.nextLine();
				phoneDao.getSearch(putName);
				break;
			case 5 :
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
