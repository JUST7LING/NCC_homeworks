package class_;

import java.util.Scanner;

public class StringMain2 {

	public static void main(String[] args) {
	
		
	for (int i = 1; i<6; i++) {
		int up =0;
		String original, current, change;
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("문자열 입력 :");
		original = s.nextLine();
		original = original.toLowerCase();
		System.out.print("현재 문자열 입력 :");
		current = s.nextLine();
		current = current.toLowerCase();
		System.out.print("바꿀 문자열 입력 :");
		change = s.nextLine();
		change = change.toLowerCase();
		
		int cnt = original.indexOf(current);
		
		while(cnt !=-1) {
			
			cnt = original.indexOf(current,cnt+current.length()); // 이게 가능한지 봐야 한다.
			up++;
			
		}//while
		
		if(up == 0){
			if(original.length()<current.length() || original.length()<change.length()) {
				System.out.println("입력한 문자열의 크기가 작습니다.");
				
			}//if
			
			System.out.println("치환할 수 없습니다.");
		}
		else {
			System.out.println(original.replace(current,change));
			System.out.println(up+"개 치환");
		}
			
		
		}//for
		
		
		}//main
}

//}

