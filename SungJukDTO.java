package sungJuk;

import java.util.ArrayList;

import collection.PersonDTO;

public class SungJukDTO implements Comparable<SungJukDTO> {
	private int no;
	
	private String name;
	// 학생의 이름
	
	private int kor, eng, math, tot;
	// tot => 총점, kor => 국어, eng => 영어, math => 수학 점수
	
	private double avg;
	// avg => 평균
	
	@Override
	public int compareTo(SungJukDTO p) {
		
		// 총점으로 내림차순
		if(this.tot < p.tot) return 1;
		else if(this.tot > p.tot) return -1;
		else return 0;
		
	}
	
	public SungJukDTO() {
		
		// default 생성자. calc()를 실행하기 위해 이용된다
	}
	
	public SungJukDTO(int no, String name, int kor, int eng, int math, int tot, double avg) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = tot;
		this.avg = avg;
		
	} // arrayList에 담을 때는 이 생성자를 이용해야 한다.
	
	public SungJukDTO(int no, String name, int kor, int eng, int math) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	} // 수정본
	
	public void calc() {
		tot = kor + eng + math;
		avg = (double) tot / 3;
	}
	
	public int calc(int kor, int eng, int math) { // overloading
		
		tot = kor + eng + math;
		return tot;
	}
	
	public double calc(int tot) { // overloading
		
		avg = (double) tot/3;
		return avg;
	}
	
	@Override
	public String toString() {
		return no + "\t" + name  + "\t" + kor  + "\t" + eng
				 + "\t" + math  + "\t" + tot + "\t" + avg;
	}


	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}