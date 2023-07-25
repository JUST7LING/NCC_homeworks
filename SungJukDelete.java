package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukDelete implements SungJuk {

	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {
		SungJuk sungJuk = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력: ");
		String findName = scanner.nextLine();
		
		for (int i = 0; i<arrayList.size(); i++) {
			if(findName.equals (arrayList.get(i).getName())) {
				arrayList.remove(i);
				System.out.println("삭제하였습니다.");
			}//if
			else {
				System.out.println("회원의 정보가 없습니다.");
			}
		}//for
		
	}

}
