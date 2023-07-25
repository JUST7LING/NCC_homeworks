package sungJuk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SungJukService {
	private ArrayList<SungJukDTO> arrayList
	 		= new ArrayList<SungJukDTO>();

	public void menu() throws InputMismatchException{
		
		Scanner scanner = new Scanner(System.in);
		int cont = 0;
		SungJuk sungJuk = null;
		while(cont!= 6) {
			System.out.println("************************");
			System.out.println("\t1. 입력");
			System.out.println("\t2. 출력");
			System.out.println("\t3. 수정");
			System.out.println("\t4. 삭제");
			System.out.println("\t5. 정렬");
			System.out.println("\t6. 종료");
			System.out.println("************************");
			System.out.print("번호 : ");
			cont = scanner.nextInt();

			if(cont==6) break;
			switch(cont) {
			
			case 1: try {
						sungJuk = new SungJukInsert();
					}catch(Exception e) {
						System.out.println("잘못된 입력값입니다.");
					}break;

			case 2:	sungJuk = new SungJukList();
					break;
					
			case 3: sungJuk = new SungJukUpdate();
					break;
					
			case 4: sungJuk = new SungJukDelete();
					break;
					
			case 5: sungJuk = new SungJukSort();
					break;
				
			default: System.out.println("값이 잘못되었습니다.");
					 continue;
			}// switch
			
			sungJuk.execute(arrayList);

		}// while
	}

}