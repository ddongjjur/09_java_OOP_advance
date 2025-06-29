package step9_02.atm_v2_풀이;

import java.util.Random;
import java.util.Scanner;

public class UserManager {
	
	private UserManager() {}
	private static UserManager instance = new UserManager();
	public static UserManager getInstance() {
		return instance;
	}
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	final int ACC_MAX_CNT = 3;
	User[] userList = null;
	int userCnt = 0;
	
	void printAllUser() {
		for (int i = 0; i < userCnt; i++) {
			System.out.print((i + 1)+ ". ID: " + userList[i].id + "\t Pw: " + userList[i].pw);
			if (userList[i].accCnt != 0) {
				for (int j = 0; j < userList[i].accCnt; j++) {
					System.out.println("\t 계좌" + (j+ 1) + ": " + userList[i].acc[j].accNumber + "\t 잔액: " + userList[i].acc[j].money);
				}
			}
			System.out.println();
		}
	}
	
	
	boolean getCheckAcc(String account) {
		
		boolean isDuple = false;
		
		for (int i = 0; i < userCnt; i++) {
			for (int j = 0; j < userCnt; j++) {
				if (account.equals(userList[i].acc[j].accNumber)) {
					isDuple = true;
				}
			}
		}
		
		return isDuple;
	}
	
	int logUser() {
		
		int identifier = -1;
		
		System.out.print("[ 로그인 ] 아이디를 입력하세요: ");
		String id = scan.next();
		System.out.print("[ 로그인 ] 비밀번호를 입력하세요: ");
		String pw = scan.next();

		for (int i = 0; i < userCnt; i++) {
			if (userList[i].id.equals(id) && userList[i].pw.equals(pw)) {
				identifier = i;
			}
		}
		
		return identifier;
	}
	
	
	boolean checkId(String id) {
		
		boolean isDuple = false;
		
		for (int i = 0; i < userCnt; i++) {
			if (userList[i].id.equals(id)) {
				isDuple = true;
			}
		}
		
		return isDuple;
	}
	
	
	void joinMember() {
		System.out.print("[ 회원가입 ] 아이디를 입력하세요: ");
		String id = scan.next();
		System.out.print("[ 회원가입 ] 비밀번호를 입력하세요: ");
		String pw = scan.next();
		
		boolean isDuple = checkId(id);
		
		if (isDuple == true) {
			System.out.println("[ 메시지 ] 중복된 아이디입니다.");
			return;
		}
		else if (isDuple == false && userCnt == 0) {
			
			userList = new User[1];	
			userList[userCnt] = new User();
		
		}
		
		else if (isDuple == false && userCnt > 0) {
		
			User[] temp = userList;
			userList = new User[userCnt + 1];
			userList[userCnt] = new User();
			
			for (int i = 0; i < userCnt; i++) {
				userList[i] = temp[i];
			}
			temp = null;
		}
		userList[userCnt].id = id;
		userList[userCnt].pw = pw;
		
		userCnt++;
		System.out.println("\n[ 메시지 ] "+ id + "님 회원가입을 축하합니다!\n");
	}

	
	int deleteMember(int identifier) {
		
		User[] tmp = userList;
		userList = new User[userCnt - 1];
		
		int j = 0;
		for (int i = 0; i < userCnt; i++) {
			if (i != identifier) {
				userList[j] = tmp[i];
				j++;
			}
		}
		userCnt--;
		tmp = null;
		identifier = -1;
		
		System.out.println("탈퇴되었습니다!");
		
		FileManager.getInstance().save();
		
		return identifier;
	}
	
	// (테스트생성용 메서드)  : 테스트 데이타 > 더미
	void setDummy() {
		
	}
	
}
