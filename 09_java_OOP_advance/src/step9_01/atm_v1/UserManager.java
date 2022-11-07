package step9_01.atm_v1;

import java.util.Scanner;

public class UserManager {							// 유저 배열, 유저의 수
	
	Scanner scan = new Scanner(System.in);
	User[] user = null;
	int userCount = 0;
	
	void printAllUser() {
		for(int i = 0; i < userCount; i++) {
			user[i].printAccount();
		}
	}
	
	
	void addUser() {
		
		if(userCount == 0) {								// userCount == 0 일 때
			
			user = new User[1];
			
			System.out.print("[가입] 아이디를 입력하세요 : ");
			String id = scan.next();
			
			user[userCount] = new User();					// User_>>>
			user[userCount].id = id;
			System.out.println("[메시지] ID : '" + id+ "' 가입 되었습니다.\n");
			userCount++;
			
			
		}
		else {												// userCount != 0 일 때
			
			System.out.print("[가입] 아이디를 입력하세요 : ");
			String id = scan.next();
			
			boolean isDuple = false;						// user[i].id 중복있는지 체크
			for (int i = 0; i < userCount; i++) {
				if (user[i].id.equals(id)) {
					isDuple = true;
				}
			}
			
			if (!isDuple) {	// = isDuple false				// user[i].id 중복없음
				
				User[] temp = user;							// User_>>>
															// user 복사 생성
				user = new User[userCount + 1];
				for(int i = 0; i < userCount; i++) {
					user[i] = temp[i];
				}
				temp = null;
				
				user[userCount] = new User();
				user[userCount].id = id;
				System.out.println("[메시지] ID : '" + id+ "' 가입 되었습니다.\n");
				userCount++;
				
			}
			else {											// user[i].id 중복있음
				
				System.out.println("[메시지] '"+ id + "'은 이미 가입된 아이디 입니다.\n");
			}
			
		}
		
	}
	
	
	User getUser(int idx) {
		return user[idx];
	}
	
	
	
	int logUser() {											// <<<_ATM_login
		
		int identifier = -1;
		System.out.print("[입력] 아이디를 입력하세요 : ");
		String name = scan.next();
		
		for (int i = 0; i < userCount; i++) {
			if (name.equals(user[i].id)) {
				identifier = i;
				System.out.println("[" + user[identifier].id + "] 님 로그인.\n");
			}
		}
		
		return identifier;									// ATM_login_>>>
		
	}
	
	
	void leave() {
		// 여기부터
		System.out.print("[입력] 탈퇴할 아이디를 입력하세요 : ");
		String name = scan.next();
		int identifier = -1;
		for (int i = 0; i < userCount; i++) {
			if (name.equals(user[i].id)) {
				identifier = i;			
			}
		}
		
		if(identifier == -1) {
			System.out.println("[메시지] 아이디를 다시 확인하세요.");
			return;
		}
		
		System.out.println("ID : '" +user[identifier].id + "' 가 탈퇴되었습니다.");
		
		User[] temp = user;
		user = new User[userCount - 1];
		
		for(int i = 0; i < identifier; i++) {
			user[i] = temp[i];
		}
		for(int i =identifier; i < userCount-1; i++) {
			user[i] =temp[i + 1];
		}
		
		userCount--;
		
	}
	
}
