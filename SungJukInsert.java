package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukInsert implements SungJuk {
	public SungJukInsert() {
		
		int no, kor, eng, math;
		String name;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("번호 입력 : ");
		no = scanner.nextInt();
		scanner.nextLine(); // 키보드 버퍼 비우기
		System.out.print("이름 입력 : ");
		name = scanner.nextLine();
		System.out.print("국어 입력 : ");
		kor = scanner.nextInt();
		System.out.print("영어 입력 : ");
		eng = scanner.nextInt();
		System.out.print("수학 입력 : ");
		math = scanner.nextInt();
		
		SungJukDTO dto = new SungJukDTO(no, name, kor, eng, math);
		
		System.out.println("입력되었습니다.");
	}

	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {
		
		
	}
}
