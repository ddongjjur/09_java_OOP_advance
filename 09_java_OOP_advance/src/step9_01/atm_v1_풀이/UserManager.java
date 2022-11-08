package step9_01.atm_v1_풀이;

import java.util.Scanner;

public class UserManager {
	Scanner scan = new Scanner(System.in);
	User[] user = null;
	int userCount = 0;
	
	void printAllUser() {
		
	}
	
	void addUser() {
		
		if (userCount == 0) {
			
			System.out.println("[가입] 아이디를 입력하세요: ");
			String id = scan.next();
			
			user[userCount] = new User();		// User_>>>
			user[userCount].id = id;
			System.out.println("[메시지] ID: " + id + "님 가입되었습니다!\n");
		}
		
		else {
			
			System.out.println("[가입] 아이디를 입력하세요: ");
			String id = scan.next();
			
			boolean isDuple = false;
			
			for (int i = 0; i < userCount; i++) {
				if (user[i].id.equals(id)) {
					isDuple = true;
				}
			}
			
			if (isDuple == false) {
				
				User[] temp = user;
				user = new User[userCount + 1];
				for (int i = 0; i < userCount; i++) {
					user[i] = temp[i];
				}
				temp = null;
				
				user[userCount] = new User();
				user[userCount].id = id;
				System.out.println("[메시지] ID: " + id + "님 가입되었습니다!");
			}
			
			else if (isDuple == true) {
				System.out.println("[메시지] " + id + "는 이미 가입된 아이디입니다.\n");
			}
		}
		
	}
	
	
	User getUser(int idx) {
		return user[idx];
	}
	
	
	
	int logUser() {								// ATM_login에서 받아옴
		
		int identifier = -1;
		System.out.println("[입력] 아이디를 입력하세요: ");
		String name = scan.next();
		
		for (int i = 0; i < userCount; i++) {
			if (name.equals(user[i].id)) {
				identifier = i;
				System.out.println("[" + user[i].id + "] 님 로그인.\n");
			}
		}
		
		return identifier;						// ATM_login
	}
	
	
	void leave() {
		System.out.print("[입력] 탈퇴할 아이디를 입력하세요: ");
		String leaveId = scan.next();
		
		for (int i = 0; i < userCount; i++) {
			if (user[i].equals(leaveId)) {
				
			}
		}
		// 여기부터
	}
	
}
