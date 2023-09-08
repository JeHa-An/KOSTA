package service;

import java.util.Scanner;

public class BaseballService {
	// 팀등록
	public void regTeam() {
		System.out.println("[팀등록]");
		System.out.print("팀명:");
		String teamName = sc.nextLine();
		System.out.print("연고지:");
		String local = sc.nextLine();
	}
	// 특정팀조회(팀명)
	// 팀목록조회
	
	// 선수등록
	public void regPlayer() {
		System.out.println("[선수등록]");
		System.out.print("선수명:");
		String playerName = sc.nextLine();
		System.out.print("등번호:");
		Integer backNum = Integer.parseInt(sc.nextLine());
		System.out.println("팀선택>>"); // 팀선택
		// 1: SSG랜더스
		// 2: 키움히어로즈
		// 3: LG트윈스
		// 4: KT위즈
		// 5: 
		// 6: SSG랜더스
		System.out.print("선택>>");
		Integer teamNum = Integer.parseInt(sc.nextLine());
	}
	// 특정선수조회(이름)
	// 특정선수조회(등번호)
	// 특정선수조회(번호로)
	// 특정팀 소속 선수 목록 조회
	Scanner sc = new Scanner(System.in);
	public int menu() {
		System.out.println("[야구 팀/선수 등록/조회]");
		System.out.println("1. 팀등록");
		System.out.println("2. 특정팀조회");
		System.out.println("3. 팀목록조회");
		System.out.println("4. 선수등록");
		System.out.println("----------------------");
		System.out.println("5. 특정선수조회(이름)");
		System.out.println("6. 특정선수조회(등번호)");
		System.out.println("7. 특정선수조회(번호로)");
		System.out.println("8. 특정팀 소속 선수 목록 조회");
		System.out.println("0. 종료");
		System.out.print("선택>>");
		return Integer.parseInt(sc.nextLine());
	}
	
	public static void main(String[] agrs) {
		
	}
}
