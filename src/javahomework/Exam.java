package javahomework;

import java.util.Scanner;

public class Exam {
	private String name = null;
	private String dap = null;
	private char[] ox = null;
	private int score = 0;
	private final String JUNG = "11111";
	
	public Exam() {
		Scanner sc = new Scanner(System.in);
		
			System.out.print("이름 입력 : ");
			name = sc.nextLine();
			System.out.print("답 입력 : ");
			dap = sc.nextLine();
			System.out.println();
			
		compare();
	}
	
	public void compare(){
		char[] correct;
		char[] dapArr;
		
		ox = new char[JUNG.length()];
		
		correct = new char[JUNG.length()]; // 정답
		
		for(int k = 0; k<JUNG.length(); k++) {
			correct[k] = JUNG.charAt(k);
		}// for, correct = {'1', '1', '1', '1', '1'}
		
		try {
			dapArr = new char[JUNG.length()]; // 제출된 답안
			for(int l = 0; l<JUNG.length(); l++) {
				dapArr[l] = dap.charAt(l);
			}//for int l
			
			for(int m = 0; m<correct.length; m++) {
				if(correct[m]==dapArr[m]) {
					ox[m] = 'O';
				}//if correct == dapArr
				else {
					ox[m] = 'X';
				}//else
			} // for int m
			
			for(int o = 0; o<ox.length; o++) {
				if(ox[o]=='O') {
					score+=20;
				}
				
			}
				
		} // try
		
		catch(Exception e){
			System.err.println("입력값이 잘못되었습니다. 답안은 다섯 자리의 글자여야 합니다.");
		} // catch
		
	}// public void compare
	
	
	public String getName() {
		return name;
	}
	
	public char[] getOx() {
		return ox;
	}
	
	public int getScore() {
		return score;
	}
}// public class Exam
/*
[문제] 사지선다형
- 총 5문제의 답을 입력받는다
- 정답은 "11111" 이다
- 맞으면 'O', 틀리면 'X'
- 1문제당 점수는 20점씩 처리

클래스명 : Exam
* 필드
private String name = null;
private String dap = null;
private char[] ox = null;
private int score = 0;
private final String JUNG = "11111"; //상수화

* 메소드
생성자 - Scanner 를 이용하여 이름과 답을 입력받는다. 
compare() - 비교
getName()
getOx()
getScore()

클래스명 : ExamMain

[실행결과]
인원수 입력 : 2

이름 입력 : 홍길동
답 입력 : 12311  

이름 입력 : 코난
답 입력 : 24331

이름		1 2 3 4 5	점수
홍길동  	O X X O O	60
코난  	X X X X O	20
 */