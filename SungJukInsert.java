package sungJuk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SungJukInsert implements SungJuk{

	static ArrayList<SungJukDTO> arrayList = new ArrayList<>();
	static SungJukDTO sungJukDTO;
	
	public SungJukInsert() {

		int no;
		int kor = 0;
		int eng = 0;
		int math = 0;
		String name;
		SungJuk sungJuk = null;
		// 기본 
		Scanner scanner = new Scanner(System.in);
		System.out.print("번호 입력 : ");
		no = scanner.nextInt();
		
		scanner.nextLine(); // 키보드 버퍼 비우기
		System.out.print("이름 입력 : ");
		name = scanner.nextLine();
		
		System.out.print("국어 입력 : ");
		while(true) {
			kor = scanner.nextInt();
			if(kor<0 || kor>100) {
				System.out.println("잘못된 점수값입니다.");
				System.out.print("국어 입력 : ");
			}
			else
				break;
		}
		
		System.out.print("영어 입력 : ");
		while(true) {
			eng = scanner.nextInt();
			if(eng<0 || eng>100) {
				System.out.println("잘못된 점수값입니다.");
				System.out.print("영어 입력 : ");
			}
			else
				break;
		}
		
		System.out.print("수학 입력 : ");
		while(true) {
			math = scanner.nextInt();
			if(math<0 || math>100) {
				System.out.println("잘못된 점수값입니다.");
				System.out.print("수학 입력 : ");
			}
			else
				break;
		}
		
		sungJukDTO = new SungJukDTO(no, name, kor, eng, math);
		sungJukDTO.calc();
		
	}
	
	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {
		
		arrayList.add(sungJukDTO);
		System.out.println("입력되었습니다.");
		System.out.println();
	}
	
}
