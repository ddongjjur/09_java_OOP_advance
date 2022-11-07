package step9_01.atm_v1_풀이;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager userManager = new UserManager();
	int identifier = -1;
	
	
	void printMainMenu() {
				
		while (true) {
			System.out.println("[ MEGA ATM ]_made by 동주(1.0.0)");
			System.out.println("[1. 로그인] [2.로그아웃] [3.회원가입] [4.회원탈퇴] [0.종료]");
			System.out.print("입력: ");
			int sel = scan.nextInt();
			
			if (sel == 1) 			login();
			else if (sel == 2) 		logout();
			else if (sel == 3) 		join();
			else if (sel == 4) 		leave();
			else if (sel == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			
		}
		
	}
	
	
	void login() {
		identifier = userManager.logUser();
		
		if (identifier == 1) {
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
		
		if (identifier == -1) {
			System.out.println("[메시지] 로그인 후 이용해주세요.");
		}
		else if (identifier == 1) {
			identifier = -1;
			System.out.println("[메시지] 로그아웃 되었습니다.");
		}
		
	}
	
	
	void leave() {
		userManager.leave();
	}
	
	
	void printAccountMenu() {
		
		while (true) {
			System.out.println("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] : ");
			int sel = scan.nextInt();
												
			String makeAccount = Integer.toString(ran.nextInt(90000) + 10000);
			
			if (sel == 1) {
				
				if (userManager.user[identifier].accCount == 0) {
					
					userManager.user[identifier].acc = new Account[1];
					userManager.user[identifier].acc[0] = new Account();
					
					userManager.user[identifier].acc[0].number = makeAccount;
				}
				
				else if (userManager.user[identifier].accCount != 0) {
					
					Account[] temp = userManager.user[identifier].acc;
					int tempAccCount = userManager.user[identifier].accCount;
					
					userManager.user[identifier].acc = new Account[tempAccCount + 1];
					for (int i = 0; i < tempAccCount; i++) {
						userManager.user[identifier].acc[i] = temp[i];
					}
					userManager.user[identifier].acc[tempAccCount] = new Account();
					userManager.user[identifier].acc[tempAccCount].number = makeAccount;
				}
				userManager.user[identifier].accCount++;
				System.out.println("[메시지]" + makeAccount + "계좌가 생성되었습니다.");
			}
			
			else if (sel == 2) {
				
				if (userManager.user[identifier].accCount == 0) {
					System.out.println("[메시지] 더 이상 삭제할 수 없습니다.");
					continue;
				}
				else if (userManager.user[identifier].accCount == 1) {
					System.out.println("[메시지] 계좌번호: <" + userManager.user[identifier].acc[0].number +"> 계좌가 생성되었습니다.");
					userManager.user[identifier].acc[0].number = null;
				}
				else if (userManager.user[identifier].accCount > 1) {
					System.out.print("[메시지] 삭제하고 싶은 계좌번호를 입력하세요: ");
					String del_acc = scan.next();
					int delIdx = -1;
					
					for (int i = 0; i < userManager.user[identifier].accCount; i++) {
						if (del_acc.equals(userManager.user[identifier].acc[i].number)) {
							delIdx = i;
						}
					}
					if (delIdx == -1) {
						System.out.println("[메시지] 계좌번호를 다시 확인해주세요.\n");
						continue;
					}
					
					else if (delIdx != -1) {
						System.out.println("[메시지] '" + userManager.user[identifier].acc[delIdx].number + "' 계좌가 삭제되었습니다.\n");
					
						Account[] temp = userManager.user[identifier].acc;
						userManager.user[identifier].acc = new Account[userManager.user[identifier].accCount - 1];
					 
						for (int i = 0; i < delIdx; i++) {
							userManager.user[identifier].acc[i] = temp[i];
						}
						for (int i = delIdx; i < userManager.user[identifier].accCount - 1; i++) {
							userManager.user[identifier].acc[i] = temp[i + 1];
						}
					}
					userManager.user[identifier].accCount--;
				}
			}
			
			else if (sel == 3) {
				if (userManager.user[identifier].accCount == 0) {
					System.out.println("[메시지] 생성된 계좌가 없습니다.\n");
				}
				else if (userManager.user[identifier].accCount != 0) {
					userManager.user[identifier].printAccount();
				}
			}
			
			else if (sel == 0) {
				logout();
				break;
			}
			
		}
		
	}	
}
