package sungJuk;

import java.util.ArrayList;

public class SungJukList implements SungJuk {

	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {

		for (int i = 0; i<arrayList.size(); i++) {

			printline(i);
			System.out.println(arrayList.get(i).getNo()+"\t"+arrayList.get(i).getName()+"\t"+arrayList.get(i).getKor()
			+"\t"+arrayList.get(i).getEng()+"\t"+arrayList.get(i).getMath()+"\t"+arrayList.get(i).getTot()+"\t"+
					String.format("%.2f", arrayList.get(i).getAvg()));
		}// for
		System.out.println();


	}
	
	public void execute(ArrayList<SungJukDTO> arrayList, int i) {
	// for SungJukUpdate		
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


//	public SungJukList() {
//		
//	//	SungJukDTO dto = new SungJukDTO();
//		ArrayList<SungJukDTO> arrayList = new ArrayList<SungJukDTO>();
//		
//		for (SungJukDTO dto : arrayList) {
//			System.out.print("\t"+dto.getNo()+"\t"+dto.getName()+"\t"+dto.getKor()
//			+"\t"+dto.getEng()+"\t"+dto.getMath());
//		}
//	}
}