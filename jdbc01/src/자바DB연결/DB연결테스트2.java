package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;

public class DB연결테스트2 {

	public static void main(String[] args) {
		try {
			// 1.오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1.오라클과 자바 연결할 부품 설정 성공");
			// 2.오라클 11g에 연결해보자.(java ---oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.오라클 연결 성공");
			
			//ipdaaress ==> InetAddress
			//String url = "http://www.naver.com";
			//URL u = new URL(url);
			//자바는 부품조립식이여서, String에 넣은 문자열을 특성한 부품으로 인식하지 못함.
			//특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			//SQL부품으로 만들어주어야 함.
			//PreparedStatement가 SQL부품 !!
			
			String sql = "delete from hr.MEMBER where id = 'win2' ";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			//con 부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.
			System.out.println("3.SQL문 부품(객체)으로 만들어주기");
			
			ps.executeUpdate();
			System.out.println("4.SQL문 오라클로 보내기 성공.");
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
