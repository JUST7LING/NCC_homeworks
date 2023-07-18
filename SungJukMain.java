package class_;

class SungJuk{
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private String avg;
	private char grade;
	
	public void setData(String name, int kor, int eng,
			int math, int tot, String avg, char grade) {
		
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = tot;
		this.avg = avg;
		this.grade = grade;
		
	}
	
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getTot() {
		return tot;
	}
	public String getAvg() {
		return avg;
	}
	public char getGrade() {
		return grade;
	}
	
	public int calcTot(int a, int b, int c) {
		
		return a+b+c;
	}
	
	public String calcAvg(int tot) {
		
		float flt = (float) tot/3;
		String avg = String.format("%.2f", flt);
		return avg;
	}
	
	public char calcGrade(String avg) {
		
		String first = avg.substring(0,1);
		
		char grade;
		
		switch(first) {
			
		case("9"):{
			grade = 'A';
			break;
		}
		case("8"):{
			grade = 'B';
			break;
		}
		case("7"):{
			grade = 'C';
			break;
		}
		case("6"):{
			grade = 'D';
			break;
		}
		
		default : {
			grade = 'F';
			break;
		}
			
		}
		
		return grade;
	}
	
}


public class SungJukMain {

	public static void main(String[] args) {
		
		SungJuk sj = new SungJuk();
		
		int kor = 95;
		int eng = 85;
		int math = 78;
		
		int tot = sj.calcTot(kor, eng, math);
		
		String avg = sj.calcAvg(tot);
		
		char grd = sj.calcGrade(avg);
		
		sj.setData("홍길동", kor, eng, math, tot, avg, grd );
		
		System.out.println(" 이름 / 국어 / 영어 / 수학 / 총점 / 평균 / 학점 ");
		System.out.println(sj.getName()+"/ "+sj.getKor()+" / "+sj.getEng()+" / "+sj.getMath()
		+" / "+sj.getTot()+" / "+sj.getAvg()+" / "+sj.getGrade());
		
	}

}

