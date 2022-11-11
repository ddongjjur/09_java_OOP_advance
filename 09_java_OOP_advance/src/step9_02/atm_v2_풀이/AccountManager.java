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
		System.out.println("\n[ 메시지 ] <" + makeAccount + "> 계좌가 생성되었습니다!\n");
		
	}
	void removeAcc(int identifier) {
		
		int accCountByUser = um.userList[identifier].accCnt;
		System.out.print("[ 메시지 ] 삭제하실 계좌를 선택해주세요: ");
		int selAcc = scan.nextInt() - 1;
		
		if (accCountByUser == 1) {
			um.userList[identifier].acc[selAcc] = null;
		}
		
		else if (accCountByUser > 1) {
			for (int i = selAcc; i < accCountByUser; i++) {
				um.userList[identifier].acc[i] = um.userList[identifier].acc[i + 1];
			}
		}
		um.userList[identifier].accCnt--;
		System.out.println("[ 메시지 ] 선택하신 계좌가 삭제되었습니다.");
	}

	void printAcc(int identifier) {
		System.out.println("\n");
		System.out.println("ID: " + um.userList[identifier].id);
		System.out.println("\n");
		
		for (int i = 0; i < um.userList[identifier].accCnt; i++) {
			System.out.println("[ " + i + 1 + " ]" + "계좌번호: " + um.userList[identifier].acc[i].accNumber + " / 잔고: " + um.userList[identifier].acc[i].money);
			System.out.println();
		}
		System.out.println("\n");
	}
	
}
