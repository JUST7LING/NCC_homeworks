package sungJuk;

import java.util.ArrayList;

public class SungJukList implements SungJuk {

	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {
		
		printline();
		for(SungJukDTO sungJukDTO : arrayList) {
			
			System.out.println(sungJukDTO);
		}
		System.out.println();
		

	}
	
	public void execute(ArrayList<SungJukDTO> arrayList, int i) {
	// for SungJukUpdate, getNo()가 일치하는 데이터만 출력한다	
			printline();
			
			System.out.println(arrayList.get(i).getNo()+"\t"+arrayList.get(i).getName()+"\t"+arrayList.get(i).getKor()
			+"\t"+arrayList.get(i).getEng()+"\t"+arrayList.get(i).getMath()+"\t"+arrayList.get(i).getTot()+"\t"+
					String.format("%.2f", arrayList.get(i).getAvg()));
			System.out.println();
			
			
	}// for
		


	public void printline(int a) { // SungJukService, choice (2)

		if(a==0) {
			System.out.println();
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		}
		else
			return;

	}
	
	public void printline() { // SungJukUpdate

			System.out.println();
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		
	}
}

