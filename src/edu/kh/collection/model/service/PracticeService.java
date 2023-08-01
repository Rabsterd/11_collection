package edu.kh.collection.model.service;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Practice;

public class PracticeService {
	
	private Scanner sc = new Scanner(System.in);
	
	private List<Practice> book = new LinkedList<Practice>();
	private List<Practice> book2 = new LinkedList<Practice>();
	
	
	public PracticeService() {
		book.add(new Practice("용의자 X의 헌신", "히가시노 게이고", "15,120", "재인 출판사") );
		book.add(new Practice("용의자 X의 헌신", "히가시노 게이고", "15,120", "재인 출판사") );
		book.add(new Practice("용의자 X의 헌신", "히가시노 게이고", "15,120", "재인 출판사") );
		book.add(new Practice("용의자 X의 헌신", "히가시노 게이고", "15,120", "재인 출판사") );
		
		book2.add(new Practice("용의자 X의 헌신", "히가시노 게이고"));
		
	}
	
	public void program() {
		
		int menuNum = 0;
		
		do {
			System.out.println("===== 도서목록 프로그램 =====\n");
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 조회");
			System.out.println("3. 도서 수정");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 즐겨찾기 등록");
			System.out.println("6. 즐겨찾기 삭제");
			
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴를 선택하세요 : ");
		
			try {
				menuNum = sc.nextInt();
				System.out.println();
			
				switch(menuNum){
				case 1 : addbook(); break;
				case 2 : selectAll(); break;
				case 3 : System.out.print("도서수정"); break;
				case 4 : removebook(); break;
				case 5 : addfavorite(); break;
				case 6 : removefavorite(); break;
				case 0 : System.out.print("프로그램 종료"); break;
				default : System.out.print("메뉴에 작성된 번호만 입력해주세요");
				}
			} catch(InputMismatchException e){
			
				System.out.println("\nerror : 입력형식이 유효하지 않습니다. 다시 시도해주세요.");
			
				sc.nextLine();
			
				menuNum = -1;
			}
			
		} while(menuNum !=0);	
		
	}
	
	public String addbook() {
		
		System.out.println("===== 도서 추가 =====");
		
		System.out.print("도서명 : ");
		String name = sc.next();
		
		System.out.print("작가명 : ");
		String author = sc.next();
		
		System.out.print("가격 : ");
		String price = sc.next();
		
		System.out.print("출판사 : ");
		String publishingHouse = sc.next();
		
		if(book.add(new Practice(name, author, price, publishingHouse) ) ) {
			
			return "성공";
		} else {
			return "실패";
		}
		
	}
	
	public void selectAll() {
		
		System.out.println("===== 도서 목록 =====");
		System.out.println();
		
		if(book.isEmpty() ) {
			System.out.println("도서 정보가 없습니다");
			
			return;
		}
		int index = 1;
		for(Practice pr : book) {
			System.out.print( (index++) + "번 도서 : ");
			System.out.println(pr); //pr(.toString)이 생략되어 있다
		}
		System.out.println();
		System.out.println("===== 좋아요 도서 목록 =====");
		System.out.println();
		
		if(book2.isEmpty()) {
			System.out.println("도서 정보가 없습니다");
			
			return;
		}
		int index2 = 1;
		for(Practice pr2 : book2) {
			System.out.println( (index2++) + "번 도서 : ");
			System.out.println(pr2.favorite());
			
			System.out.println();
		}
	}
	
	public String removebook() {
		System.out.println("===== 도서 삭제 =====");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		if(book.isEmpty() ) {
			
			return "입력하신 도서 정보가 없습니다";
			
		} else if(index < 0 ) {
			
			return "음수는 입력할 수 없습니다";
		
		} else if(index >= book.size() ) {
			
			return "범위를 넘어선 값을 입력할 수 없습니다";
			
		} else {
			
			System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0);
			if(ch == 'Y') {
				Practice temp = book.remove(index);
				return temp.getName() + "의 정보가 삭제되었습니다";

			} else {
				return "취소";
			}
		}
	
	}
	
	public String addfavorite() {
		
		System.out.println("===== 즐겨찾기 도서 추가 =====");
		
		System.out.print("도서명 : ");
		String name = sc.next();
		
		System.out.print("작가명 : ");
		String author = sc.next();

		
		if(book2.add(new Practice(name, author) ) ) {
			
			return "성공";
		} else {
			return "실패";
		}
		
		
	}
	
	public String removefavorite() {
		System.out.println("===== 즐겨찾기 도서 삭제 =====");
		
		System.out.print("인덱스 번호 입력 : ");
		int index2 = sc.nextInt();
		
		if(book2.isEmpty() ) {
			
			return "입력하신 도서 정보가 없습니다";
			
		} else if(index2 < 0 ) {
			
			return "음수는 입력할 수 없습니다";
		
		} else if(index2 >= book2.size() ) {
			
			return "범위를 넘어선 값을 입력할 수 없습니다";
			
		} else {
			
			System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0);
			if(ch == 'Y') {
				Practice temp = book2.remove(index2);
				return temp.getName() + "의 정보가 삭제되었습니다";

			} else {
				return "취소";
			}
		}
	}
}
