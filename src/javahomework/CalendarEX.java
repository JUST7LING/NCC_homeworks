package javahomework;

import java.util.Calendar;

public class CalendarEX {

	private int year;
	private int month;
	
	public void setDate(int year, int month) {
		this.year = year;
		this.month = month;
	}
	
	public void calc() {
		
		Calendar day1 = Calendar.getInstance(); // 메서드를 통한 생성
		Calendar daylast = Calendar.getInstance(); // 메서드를 통한 생성
		
		day1.set(year, month-1, 1);
		daylast.set(year, month, 1);
		daylast.add(Calendar.DATE, -1);
		
		int dateDay1 = day1.get(Calendar.DAY_OF_MONTH);
		// 해당 달의 첫 날짜.(1일)
		int dateDayLast = daylast.get(Calendar.DAY_OF_MONTH);
		// 해당 달의 마지막 날짜.(28, 29, 30, 31 중 하나)
		int firstWeekday = day1.get(Calendar.DAY_OF_WEEK);
		// 일요일은 1, 월요일은 2, ...
		
		display(dateDay1, dateDayLast, firstWeekday);
		
	}// public void calc()
	
	public void display(int dateDay1, int dateDayLast, int firstWeekday) {
		
		String blankBefore="";
		
		System.out.println("\t\t\t"+year+"년\t"+month+"월");
		System.out.println();
		System.out.println("\t일\t월\t화\t수\t목\t금\t토");
		System.out.println();
		
		
		switch(firstWeekday) {
		case 1: blankBefore = "\t"; break;
		case 2: blankBefore = "\t\t"; break;
		case 3: blankBefore = "\t\t\t"; break;
		case 4: blankBefore = "\t\t\t\t"; break;
		case 5: blankBefore = "\t\t\t\t\t"; break;
		case 6: blankBefore = "\t\t\t\t\t\t"; break;
		case 7: blankBefore = "\t\t\t\t\t\t\t";
		}//switch
		
		System.out.print(blankBefore+dateDay1);
		
		int tempDay = firstWeekday;
		for (int i = dateDay1+1; i<=dateDayLast; i++) {
			if(tempDay%7==0) {
				System.out.println("\n");
			}//if
			System.out.print("\t");
			System.out.print(i);
			tempDay++;
//			if(tempDay%7==0) {
//				System.out.println("\n");
//			}//if
		}//for
		
		
		
		
	}// public void display()
	
}// public class CalendarEX
/*
[문제] 만년달력
- 년도, 월을 입력하여 달력을 작성하시오
        
클래스명 : CalendarEx
필드 : 
메소드 - 기본 생성자 : 월, 일을 입력
       calc()    : 매달 1일의 요일이 무엇인지? (Calendar에 메소드 준비)
                   매달 마지막이 28, 29, 30, 31 무엇인지? (Calendar에 메소드 준비)
       display() : 출력

클래스명 : CalendarMain

[실행결과]
년도 입력 : 2002
월 입력 : 10	

일	월	화	수	목	금	토
		1	2	3	4	5
6	7	8	9	10	11	12
13	14	15	16	17	18	19
20	21	22	23	24	25	26
27	28	29	30	31
 */