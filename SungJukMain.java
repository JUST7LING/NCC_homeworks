package sungJuk;

import java.util.InputMismatchException;

public class SungJukMain {

	public static void main(String[] args) {

		SungJukService sungJukService = new SungJukService();
				
		while(true) {
			try {
				sungJukService.menu();
				break;
			}catch(InputMismatchException e) {
				System.out.println("번호를 정확히 입력해 주세요."); 
			}
		}

	}

}
//[문제] 성적 처리
//
//[조건]
//1. SungJukDTO.java
//필드   : no(번호), 이름, 국어, 영어, 수학, 총점, 평균
//메소드 : 생성자를 이용하여 데이터 얻기
//       setter / getter
//       calc() - 총점, 평균하는 계산
//
//2. SungJukService.java
//- menu() 를 작성한다.
//
//3. SungJukInsert.java
//- 번호, 이름, 국어, 영어, 수학를 입력하여 총점과 평균을 계산한다.
//- 번호를 중복해서 입력하지 않는다.
//
//번호 입력 : 
//이름 입력 : 
//국어 입력 : 
//영어 입력 : 
//수학 입력 : 
//
//입력되었습니다
//
//4. SungJukList.java
//- ArrayList에 저장된 모든 데이터를 출력한다.
//- 소수이하 2째자리까지 출력한다.
// 
//번호		이름		국어		영어		수학 		총점		평균