package step9_02.atm_v2_풀이;

import java.util.Random;
import java.util.Scanner;

public class AccountManager {
	
	private AccountManager() {}
	private static AccountManager instance = new AccountManager();
	public static AccountManager getInstance() {
		return instance;
	}
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager um = UserManager.getInstance();
	
	void createAcc(int identifier) {
		
		int accCntByUser = um.userList[identifier].accCnt;
		
		if (accCntByUser == 3) {
			System.out.println("[ 메시지 ] 계좌 개설은 최대 3개까지 가능합니다.");
			return;
		}
		
		um.userList[identifier].acc[accCntByUser] = new Account();
		
		String makeAccount = "";
		while (true) {
			makeAccount = ran.nextInt(9000000) + 1000001 + "";
			if (!um.getCheckAcc(makeAccount)) {
				break;
			}
		}
		um.userList[identifier].acc[accCntByUser].accNumber = makeAccount;
		um.userList[identifier].accCnt++;
		System.out.println("[ 메시지 ] <" + makeAccount + "> 계좌가 생성되었습니다!");
		
	}
	// 여기부터
	void removeAcc(int identifier) {
		
		
	}

	void printAcc(int identifier) {
		
	}
	
}
