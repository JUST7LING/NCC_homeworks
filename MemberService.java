package constructor;

import java.util.Scanner;

public class MemberService {
	// 실제 연산을 수행하는 클래스
	public MemberService(){
		
	}
	// 회원은 다섯 명만 있어야 한다. 
	MemberDTO[] ar = new MemberDTO[3];
	int num;
	Scanner s = new Scanner(System.in);
	
	public void menu() {
		while(true) {
			// 무한루프
			System.out.println();
			System.out.println("*********");
			System.out.println("1. 가입");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			System.out.println("*********");
			System.out.println();
			
			System.out.print("번호 : ");
			num = s.nextInt();
			
			
			if (num==1) insert();
			if (num==2) display();
			if (num==3) update();
			if (num==4) delete();
			if (num==5) break;
			
			
		}// while
		
		
	} // break될 때 main으로 다시 돌아간다.
	
	public void insert() {
		
		String name, phone, address;
		int age;
		
		int i;
		
		for(i =0 ; i<ar.length; i++) {
			if(ar[i]==null) {
				System.out.print("이름 입력: ");
				name = s.next();
				System.out.print("나이 입력: ");
				age = s.nextInt();
				System.out.print("전화번호 입력: ");
				phone = s.next();
				System.out.print("주소 입력: ");
				address = s.next();
				
				ar[i] = new MemberDTO(name, age, phone, address);
				System.out.println("가입 완료");
				
				break; // for문 탈출
				// break는 반복문밖에 나가지 못한다.
				
			}// if
		}// for
		
		if(i == ar.length) System.out.println("회원 마감"); 
	} // insert
	
	public void display() {
		
		for(int i =0 ; i<ar.length; i++) {
			
			if(ar[i]!=null)System.out.println(ar[i].getName()+"\t"
									+ar[i].getAge()+"\t"+ar[i].getPhone()+"\t"+
									ar[i].getAddress()+"\t"		);
		}//for
		
		
	}//display
	
	public void update() {
		String phone;
		 s.nextLine();
		System.out.print("핸드폰 번호 입력 :");
		phone = s.nextLine();
		
		String name, address;
		int age;
		
		for(int i = 0; i<ar.length; i++) {
			
			 if(phone.equals(ar[i].getPhone())) {
				 
				 System.out.println("이름\t나이\t전화번호\t주소");
				 
				 System.out.println(ar[i].getName()+"\t"
							+ar[i].getAge()+"\t"+ar[i].getPhone()+"\t"+
							ar[i].getAddress()+"\t"		);
			//	 s.nextLine(); // 키보드 버퍼 비우기
				 System.out.println("수정할 이름 입력 : ");
				 name = s.nextLine();
				 System.out.println("수정할 전화번호 입력 : ");
				 phone = s.nextLine();
				 System.out.println("수정할 주소 입력 : ");
				 address = s.nextLine();
				 System.out.println("수정할 나이 입력 : ");
				 age = s.nextInt();
				 
				 ar[i] = new MemberDTO(name,age,phone,address);
				 
				 System.out.println("회원 정보 수정 완료");
				 break;
			 }//if
			 
			 else {
				 System.out.println("회원 정보를 찾을 수 없습니다.");
				 break;
			 }
			
		}//for
		
	}//update
	
	public void delete() {
		String phone, name, address;
		int age;
		 s.nextLine();
		System.out.print("핸드폰 번호 입력 :");
		phone = s.nextLine();
		
		for(int i = 0; i<ar.length; i++) {
			
			 if(phone.equals(ar[i].getPhone())) {
				 
				 		 ar[i] = null;
				 
				 System.out.println("회원 정보 삭제 완료");
				 break;
			 }//if
			 
			 else {
				 System.out.println("회원 정보를 찾을 수 없습니다.");
				 break;
			 }
			
		}//for
		
	}//delete
}

