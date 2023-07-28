package student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
	private Connection conn;
	private PreparedStatement pstmt;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";
	// DB Connection Setting
	
	public Student() {

		// driver load
				try {
					Class.forName(driver);
					System.out.println("로딩 성공");
				
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
	}
	
	public void getConnection() {
		try {					
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("conn에 문제가 있습니다.");
		}
	}
	
	public void menu() throws InputMismatchException{
		Scanner sc = new Scanner(System.in);
		int num =0;
		
		while(num!=4) {
			System.out.print  ("**************** \n"
								+ "관리 \n"+
							   "**************** \n"
							   +"1. 입력\n"+
							   "2. 검색\n"+
							   "3. 삭제\n"+
							   "4. 종료\n"+
							   "**************** \n"
							   +"번호선택 : ");
				num = sc.nextInt();
		
				if(num == 4) break;
				switch(num) {
				case 1:try {
							insertArticle();
							break;
						} catch(InputMismatchException e) {
						System.out.println("숫자만 입력해 주세요.");
						
						}//catch
						
				case 2 :try {
							selectArticle();
							break;
						} catch(InputMismatchException e) {
							System.out.println("숫자만 입력해 주세요.");
						} 
							
				case 3 :try { 
							deleteArticle();
							break;
						} catch(InputMismatchException e) {
							System.out.println("숫자만 입력해 주세요.");
						} 
				default: System.out.println("잘못된 값을 입력했어요.");
						 break;
				
				
				}// switch
			
		}//while
	}
	
	public void insertArticle() throws InputMismatchException{
		Scanner sc = new Scanner(System.in);
		int num =0;
		String question = ""; // var of void insertArticle()
		
		String name, value;
		int number =0; // var of SQL table student
	
		while(num!=4) {
			System.out.print  (
							   "**************** \n"
							   +"1. 학생\n"+
							   "2. 교수\n"+
							   "3. 관리자\n"+
							   "4. 이전메뉴\n"+
							   "**************** \n"
							   +"번호선택 : ");
				num = sc.nextInt();
		
				if(num == 4) return;
				switch(num) {
				case 1: number = 1;
						question = "학번";
						break;
						
				case 2: number = 2;
						question = "과목";
						break;
						
				case 3: number = 3;
						question = "부서";
						break;
				
				default: System.out.println("잘못된 값을 입력했어요.");
						 break;
				
				}// switch

				sc.nextLine(); // flush
				System.out.print("이름 입력: ");
				name = sc.nextLine();
				System.out.print(question+" 입력: ");
				value = sc.nextLine();
				int dupli = duplicateCheck(name, value, number);
				if (dupli==0) {
					try {
					
						this.getConnection(); // 접속
						pstmt = conn.prepareStatement("insert into student values(?,?, ?)");
					
						pstmt.setString(1, name);
						pstmt.setString(2, value);
						pstmt.setInt(3, number);
					
						int su = pstmt.executeUpdate();
					
						System.out.println(su+"개 행이 삽입되었습니다.");
					
				
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("pstmt에 문제가 있습니다.");
					
					}finally {
						try {
							if(pstmt!=null) {
								pstmt.close();
							}
							if(conn!=null) {
								conn.close();
							}
						} catch (SQLException e) {
							System.out.println("닫는 과정에서 에러가 발생했습니다.");
							e.printStackTrace();
						} // catch
					
					
					} // finally
				
				}//if
				else {
					System.out.println("이미 등록된 정보입니다. 다시 시도하세요");
				}
		}//while
		
	}// insertArticle
	
	public void selectArticle() throws InputMismatchException{
		Scanner sc = new Scanner(System.in);
		int num =0;
		int found = 0;
		String question = "";
		String search = "";
		String sql ="";// var of void insertArticle()
		
		ResultSet rs;
		String name, value;
		int number =0; // var of SQL table student
	
		while(num!=3) {
			System.out.print  (
							   "**************** \n"
							   +"1. 이름 검색\n"+
							   "2. 전체 검색\n"+
							   "3. 이전메뉴\n"+
							   "**************** \n"
							   +"번호선택 : ");
				num = sc.nextInt();
		
				if(num == 3) return;
				switch(num) {
				case 1: {sc.nextLine(); // flush
						System.out.print("검색할 이름 입력: ");
						search = sc.nextLine();
						search = "%"+search+"%";
						sql= "select * from student where name like ?";
						
						break;}
						
				case 2: sql="select * from student";
						;break;
				
				default: System.out.println("잘못된 값을 입력했어요.");
						 break;
				
				}// switch

				try {
					
					this.getConnection(); // 접속
					pstmt = conn.prepareStatement(sql);
					
					if (num == 1) {
						pstmt.setString(1, search);
					}
					
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						// 레코드가 있는 동안 반복
						name = rs.getString("name"); 
						value = rs.getString("value");
						number = rs.getInt("code");
						
						switch(number) {
						case 1: question ="학번"; break;
						case 2: question ="과목"; break;
						case 3: question ="부서"; break;
						default: question = "??"; break;
						
						}
						System.out.println("이름 = " + name + "\t" + question+" = " + value);
						found++;
					}// while
					
					if(found==0)
						System.out.println("일치하는 데이터를 찾지 못했어요.");
					
					found = 0; // 초기화
				
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("pstmt에 문제가 있습니다.");
					
				}finally {
					try {
						if(pstmt!=null) {
							pstmt.close();
						}
						if(conn!=null) {
							conn.close();
						}
					} catch (SQLException e) {
						System.out.println("닫는 과정에서 에러가 발생했습니다.");
						e.printStackTrace();
					} // catch
					
				} // finally
				
		}//while
		
	}//selectArticle
	
	public void deleteArticle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제를 원하는 이름 입력 : ");
		String delName = sc.nextLine();
		String sql = "delete from student where name = ?";
		
		try {
			
			this.getConnection(); // 접속
			pstmt = conn.prepareStatement(sql);
			
			// ?에 데이터 대입하기
			pstmt.setString(1, delName);
			
			int su = pstmt.executeUpdate();
			// 개수를 리턴함
			if(su == 0)
				System.out.println("삭제할 레코드 값을 찾을 수 없었습니다.");
			if(su!=0)
				System.out.println(su+"개 행이 삭제되었습니다.");
			
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("pstmt에 문제가 있습니다.");
			
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("닫는 과정에서 에러가 발생했습니다.");
				e.printStackTrace();
			} // catch
			
			
		} // finally
	}
	
	public int duplicateCheck(String name, String value, int number) {
		int dupli = 1; // 0이면 중복된 데이터가 없는 상태다.
		ResultSet rs;
		int found = 0; // 찾은 데이터의 수를 반환한다.
		try {
			
			this.getConnection(); // 접속
			pstmt = conn.prepareStatement("select * from student where name = ? and value = ? and code = ?");
			
			pstmt.setString(1, name);
			pstmt.setString(2, value);
			pstmt.setInt(3, number);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				found++;
			}// while
			
			if(found==0)
				dupli = 0;
			else {
				dupli = 1;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("pstmt에 문제가 있습니다.");
			
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("닫는 과정에서 에러가 발생했습니다.");
				e.printStackTrace();
			} // catch
			
		} // finally
		
		return dupli;
		
	}
	
	public static void main(String[] args) {
		
		Student student = new Student();
		while (true) {
			try {
				student.menu();
				break;
			} catch(InputMismatchException e) {
				System.out.println("숫자만 입력해 주세요.");
			} // catch
		
		} // while
	}//main
	
}
