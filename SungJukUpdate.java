package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukUpdate implements SungJuk  {
	
	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {
		
		SungJuk sungJuk = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("번호 입력: ");
		int number = scanner.nextInt();
		scanner.nextLine(); // 버퍼 비우기(flush)
		
		String newName;
		int newKor, newEng, newMath;
		int found =0;  // 찾은 횟수를 반환함
		
		for (int i = 0; i<arrayList.size(); i++) {
			if(number == arrayList.get(i).getNo()) {
				SungJukList sungJukList = new SungJukList();
				sungJukList.execute(arrayList,i);
				// execute(arrayList, i)는 
				// 해당 인덱스의 데이터만 출력하기 위하여
				// sungJukList 클래스 내부에 오버로딩하여 만든
				// 메서드이기 때문에, 인터페이스를 참조하여 객체 생성 시
				// execute()가 작동하지 않는다.
				// (오버라이딩한 메서드와 인수가 일치하지 않기 때문이다.)
				// 따라서 sungJukList를 참조한 객체로 생성하여야 한다.
				System.out.println(	"수정 할 이름 입력 : ");
				newName = scanner.nextLine();
				
				System.out.print("수정 할 국어 입력 : ");
				while(true) {
					newKor = scanner.nextInt();
					if(newKor<0 || newKor>100) {
						System.out.println("잘못된 점수값입니다.");
						System.out.print("수정 할 국어 입력 : ");
					}
					else
						break;
				}
				scanner.nextLine(); // 버퍼 비우기(flush)
				System.out.print("수정 할 영어 입력 : ");
				while(true) {
					newEng = scanner.nextInt();
					if(newEng<0 || newEng>100) {
						System.out.println("잘못된 점수값입니다.");
						System.out.print("수정 할 영어 입력 : ");
					}
					else
						break;
				}
				scanner.nextLine(); // 버퍼 비우기(flush)
				System.out.print("수정 할 수학 입력 : ");
				while(true) {
					newMath = scanner.nextInt();
					if(newMath<0 || newMath>100) {
						System.out.println("잘못된 점수값입니다.");
						System.out.print("수정 할 수학 입력 : ");
					}
					else
						break;
				}
				
				SungJukDTO temp = arrayList.get(i);
				temp.setName(newName);
				temp.setKor(newKor);
				temp.setEng(newEng);
				temp.setMath(newMath);
				temp.calc();
				
				arrayList.set(i, temp);	
				System.out.println("수정하였습니다.");
				System.out.println();
				found += 1;
				break;
			}//if
			
		}//for
		if(found==0) {
			System.out.println("잘못된 번호입니다.");
		}
	}//execute

}