package step9_02.atm_v2;

import java.util.Random;
import java.util.Scanner;

public class AccountManager {		// <Accountmanager um> new, 스케너, 랜덤, <Usermanager um> new

	private AccountManager() {}
	private static AccountManager instance = new AccountManager();
	public static AccountManager getInstance() {
		return instance;
	}
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager um = UserManager.getInstance();

	void createAcc(int identifier) {			// 0 > (createAcc) > 1 ... 3 > (createAcc) > 4 >> X 이 작업
		
		int accCntByUser = um.userList[identifier].accCnt;
		
		if (accCntByUser == 3) {
			System.out.println("[메세지]계좌개설은 3개까지만 가능합니다.");
			return;
		}
		
		um.userList[identifier].acc[accCntByUser] = new Account();
		
		String makeAccount = "";
		while (true) {
			makeAccount = ran.nextInt(9000000) + 1000001 + "";		
			if (!um.getCheckAcc(makeAccount)){		// 랜덤으로 만들었는데 혹시 중복이 되면 getCheckAcc에서 true를 반환함
				break;
			}
		}
		um.userList[identifier].acc[accCntByUser].accNumber = makeAccount;
		um.userList[identifier].accCnt++;
		System.out.println("[메세지]'" + makeAccount + "'계좌가 생성되었습니다.\n");
		
	}
	
	void removeAcc(int identifier) {
		
		int accCntByUser = um.userList[identifier].accCnt;
		System.out.print("[메시지] 삭제하실 계좌를 선택해주세요: ");
		int selAcc = scan.nextInt() - 1;
		
		if (accCntByUser == 1) {
			um.userList[identifier].acc[0] = null;
		}
		
		else if (accCntByUser > 1) {
			um.userList[identifier].acc[selAcc] = null;
			
			for (int i = selAcc; i < accCntByUser - 1; i++) {
				um.userList[identifier].acc[i] = um.userList[identifier].acc[i + 1];
			}
		}
		
		um.userList[identifier].accCnt--;
		System.out.println("[메시지] 삭제되었습니다.\n");
	}
	

	void printAcc(int identifier) {
		
		User temp = um.userList[identifier];
		System.out.println("====================");
		System.out.println("ID : " + temp.id);
		System.out.println("====================");
		for (int i = 0; i < temp.accCnt; i++) {
			System.out.println("[" + (i + 1) + "]" + "accNumber:" +temp.acc[i].accNumber + " / money: " + temp.acc[i].money);
		}
		System.out.println("=============================\n");
		
	}
	
}
