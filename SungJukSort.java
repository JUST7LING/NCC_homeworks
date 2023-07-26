package sungJuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SungJukSort implements SungJuk {
	
	public int menu() {
		
		ArrayList<SungJukDTO> arrayList = new ArrayList<>();
		int cont = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("************************");
		System.out.println("\t1. 총점으로 내림차순");
		System.out.println("\t2. 이름으로 오름차순");
		System.out.println("\t3. 이전 메뉴로 돌아가기");
		System.out.println("************************");
		System.out.print("번호 : ");
		cont = scanner.nextInt();
			
		return cont;
			
	}
	
	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {
		
		int select = 0;
		
		while(select!=3) {
			select = menu();
		
			if(select==3) return;
		
			switch(select) {
		
			case 1: {totSort(arrayList);
			// 메서드 totSort()는 총점을 기준으로 정렬을 수행하는 메서드이다.
					continue;}
		
			case 2: {nameSort(arrayList);
			// 메서드 nameSort()는 이름을 기준으로 정렬을 수행하는 메서드이다.
					continue;}
		
			default: {System.out.println("값이 잘못되었습니다.");
				 	continue;}
			}// switch
		}
	}

	
	public void totSort(ArrayList<SungJukDTO> arrayList) {
		Collections.sort(arrayList);
		SungJukList list = new SungJukList();
		list.execute(arrayList);
	}
	
	public void nameSort(ArrayList<SungJukDTO> arrayList) {
		Comparator<SungJukDTO> com = new Comparator<>() {

			@Override
			public int compare(SungJukDTO s1, SungJukDTO s2) {
				return s1.getName().compareTo(s2.getName());
			}
			
		};
		
		Collections.sort(arrayList, com);
		SungJukList list = new SungJukList();
		list.execute(arrayList);
	}

}