package sungJuk;

import java.util.ArrayList;

public class SungJukList implements SungJuk {

	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {
		
		for (int i = 0; i<arrayList.size(); i++) {
			
			printline(i);
			System.out.println("\t"+arrayList.get(i).getNo()+"\t"+arrayList.get(i).getName()+"\t"+arrayList.get(i).getKor()
			+"\t"+arrayList.get(i).getEng()+"\t"+arrayList.get(i).getMath());
		}
		
	}
	
	public void printline(int a) {
		
		if(a==0) {
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		}
		else
			return;
		
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
