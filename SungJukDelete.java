package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukDelete implements SungJuk {

	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력: ");
		String findName = scanner.nextLine();
		int found = 0; // 데이터에서 일치하는 No를 찾은 횟수를 저장한다.
		// switch 변수라고 하며, 변수명은 sw를 주로 쓴다.
		
		
		for (int i = 0; i<arrayList.size(); i++) {
			if(findName.equals (arrayList.get(i).getName())) {
				found++;
				arrayList.remove(i);
			}//if
			
		}//for
		foundPrint(found);
		// 찾을 데이터가 한 사람인 경우(동명이인이 없는 경우)
		// found = 1이며, foundPrint는 매개변수인 found가 1일 경우에만
		// "삭제하였습니다." 를 출력하도록 한다.
		// found가 1 이상이면 출력되지 않으며, 아래에서 출력될 것이다.
		
		if(found==0) { // 이름이 일치하는 데이터를 찾지 못한 경우
			System.out.println("회원의 정보가 없습니다.");
		}
		if(found!=0) { // 이름이 일치하는 데이터를 찾은 경우
			for (int i = 1; i<found-1; i++) {
				// 동명이인이 있다면 found-1만큼 추가 삭제를 진행해야 한다.
				// 이 구문이 없으면 동명이인이 있어도 모두 삭제하지 않고
				//	순서가 더 앞쪽인 데이터 하나만 삭제하게 된다.
				for (int j = 0; j<arrayList.size(); j++) {
					if(findName.equals (arrayList.get(j).getName())) {
						// 일치하는 이름을 찾아 삭제해야 한다.
						// 이름은 String Value이므로
						// ==가 아닌 .equals()로 조건을 작성해야 한다.
						found++;
						arrayList.remove(j);
					}//if
				}//for int j
			}//for int i
					
		if(found>1)
			System.out.println("삭제하였습니다.");
			// 메시지 중복 출력을 막기 위함
			// 동명이인이 있는 경우에는 추가 삭제를 진행한 후에 
			// "삭제하였습니다." 가 출력되어야 한다.
		} // if(found!=0)
	}//execute
	
	public void foundPrint(int found) {
		if(found==1) {
			System.out.println("삭제하였습니다.");
		}
		else {
			return;
		}
	}

}