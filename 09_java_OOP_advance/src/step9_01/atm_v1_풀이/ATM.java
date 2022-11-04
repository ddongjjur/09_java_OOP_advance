package step9_01.atm_v1_풀이;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager userManager = new UserManager();
	int identifer = -1;
	
	
	void printMainMenu() {
				
		while (true) {
			
			System.out.println("[ MEGA ATM ]");
			System.out.print("[1. 로그인] [2.로그아웃] [3.회원가입] [4.회원탈퇴] [0.종료] :");
			int sel = scan.nextInt();
			
			if (sel == 1) 			login();
			else if (sel == 2) 		logout();
			else if (sel == 3) 		join();
			else if (sel == 4) 		leave();
			else if (sel == 0) 		break;
			
			
		}
		
	}
	
	
	void login() {
		identifer = userManager.logUser();
		
		if (identifer == 1) {
			printAccountMenu(); 		// 정보 있으면 AccMenu로
		}
		
		else {
			System.out.println("아이디를 다시 확인해주세요");
		}
	}
	
	
	void join() {	
		userManager.addUser();
	}
	
	
	void logout() {
		
		
	}
	
	
	void leave() {
		
	}
	
	
	void printAccountMenu() {
		
		while (true) {
			System.out.println("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] : ");
			int sel = scan.nextInt();
												// 여기부터
			String makeAccount = Integer.toString(ran.nextInt(90001) + 10000);
			
			if (sel == 1) {
				
				if (userManager.user[identifer].accCount == 0) {
					
					userManager.user[identifer].acc = new Account[1];
					userManager.user[identifer].acc[0] = new Account();
					
					userManager.user[identifer].acc[0].number = makeAccount;
				}
				
			}
			
			else if (sel == 2) {
				
			}
			
			else if (sel == 3) {
				
			}
			
			else if (sel == 0) {
				break;
			}
			
		}
		
	}	
}
