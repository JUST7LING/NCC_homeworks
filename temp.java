package sungJuk;

import java.util.Scanner;

public class temp {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int cont = 0;
//		
//		while(cont!= 6) {
//			System.out.println("************************");
//			System.out.println("\t1. 입력");
//			System.out.println("\t2. 출력");
//			System.out.println("\t6. 종료");
//			System.out.println("************************");
//			System.out.print("번호 : ");
//			cont = scanner.nextInt();
//			
//			if(cont==6) break;
//			switch(cont) {
//			case 1: System.out.println("입력 선택");
//					break;
//			case 2: System.out.println("출력 선택");
//					break;
//			
//			default: System.out.println("값이 잘못되었습니다.");
//					 continue;
//			}// switch
//		}// while
//		
		int dice1 = 0;
		int dice2 = 0;
		int sum = 0;
		
		while(sum!=6) {
			
			dice1 = (int)(Math.random() * 6 + 1);
			System.out.println("dice1  = "+dice1);
			dice2 = (int)(Math.random() * 6 + 1);
			System.out.println("dice2  = "+dice2);
			sum = dice1 + dice2;
			System.out.println("sum = "+sum);
			
		//	if(sum == 6)
		//		break;
		}
		
		
	//	x = 10; y = 20;
		
	//	System.out.println((++x)+(y--));
	}// main
}
/*

5. SungJukUpdate.java
- 없는 번호가 입력되면 "잘못된 번호 입니다." 라고 출력한다.
- 있는 번호가 입력되면 번호에 해당하는 데이틀 출력 후 수정한다.
번호 입력 : 78
잘못된 번호 입니다.

또는 
번호 입력 : 10

번호		이름		국어		영어		수학		총점		평균
10		홍길동

수정 할 이름 입력 : 
수정 할 국어 입력 : 
수정 할 영어 입력 : 
수정 할 수학 입력 : 

수정하였습니다.

6. SungJukDelete.java
- 이름을 입력하여 없는 이름이면 "회원의 정보가 없습니다" 출력하시오
- 똑같은 이름이 있으면 모두 삭제한다.

삭제할 이름 입력 : 천사
회원의 정보가 없습니다

또는 
삭제할 이름 입력 : 홍길동 (홍길동이라는 이름 가진 SungJukDTO를 모두 제거)
삭제하였습니다.

7. SungJukSort.java
- menu() 만들어서 작성하시오

********************
  1. 총점으로 내림차순
  2. 이름으로 오름차순
  3. 이전 메뉴
********************
  번호 : 
*/