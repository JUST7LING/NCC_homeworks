package javahomework;

import java.util.Scanner;

public class ExamMain {
	
	public static void print(int j) {
		if(j==0)
			System.out.println("이름\t\t1\t2\t3\t4\t5\t\t점수");
		else
			return;
		
	}
	
	public static void print(String name, char[] ox, int score) {
		System.out.print(name+"\t\t");
		for(int i = 0; i<ox.length; i++) {
			System.out.print(ox[i]+"\t");
		}
		System.out.println("\t"+score);
		
	}
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원수 입력 : ");
		int i = sc.nextInt();
		System.out.println();
		
		Exam[] e = new Exam[i];
		
		String name;
		char[] ox;
		int score;
		
		
		for (int j = 0; j<i; j++) {
			
			e[j] = new Exam();
		}
		
		for (int j = 0; j<i; j++) {

			print(j);
			name = e[j].getName();
			ox = e[j].getOx();
			score = e[j].getScore();
			print(name, ox, score);
			
		}
		
		
	
		
	}

}
