package step9_02.atm_v2_풀이;

import java.util.Scanner;

public class ATM {
	Scanner scan = new Scanner(System.in);
	int identifier = -1;
	UserManager um = UserManager.getInstance();
	
	void play() {
		FileManager.getInstance().load();
		UserManager.getInstance().printAllUser();
		
		while (true) {
			System.out.println("[ ATM_DJ ]");
			System.out.println("[ 1. 회원가입 ]");
			System.out.println("[ 2. 로그인 ]");
			System.out.println("[ 0. 종료 ]");
			System.out.println("입력: ");
			
			int sel = scan.nextInt();
			
			if (sel == 1) join();
			else if (sel == 2) login();
			else if (sel == 3) break;
			
		}
	}
	
	
	void login() {
		identifier = um.logUser();
		
		if (identifier != -1) {
			loginMenu();
		}
		else {
			System.out.println("[ 메시지 ] 아이디가 없거나 비밀번호가 틀렸습니다.");
		}
	}
	
	void loginMenu() {
		
		while (true) {
			
			System.out.println("[ 메시지 ] " + um.userList[identifier].id + "님 로그인되었습니다.");
			System.out.println("[ 1. 계좌생성 ]");
			System.out.println("[ 2. 계좌삭제 ]");
			System.out.println("[ 3. 조    회 ]");
			System.out.println("[ 4. 회원탈퇴 ]");
			System.out.println("[ 0. 로그아웃 ]");
			System.out.print("입력: ");
			int selLoginMenu = scan.nextInt();
			
			if (selLoginMenu == 1) {
				AccountManager.getInstance().createAcc(identifier);
				FileManager.getInstance().save();
			}
			
			else if (selLoginMenu == 2) {
				AccountManager.getInstance().removeAcc(identifier);
				FileManager.getInstance().save();
				
			}
			
			else if (selLoginMenu == 3) {
				
			}
			
			else if (selLoginMenu == 4) {
				
			}
			
			else if (selLoginMenu == 0) {
				break;
			}
			
		}
		
	}
	
	
	void join() {
		UserManager.getInstance().joinMember();			// 회원가입창으로 이동 >> UswerManager.joinMember
	}

	
}
