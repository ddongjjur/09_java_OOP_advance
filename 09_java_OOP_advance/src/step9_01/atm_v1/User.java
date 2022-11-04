package step9_01.atm_v1;

public class User {							// 아이디, 계좌갯수, 계좌배열
	
	String id;
	int accCount;
	Account[] acc;							// Account_ >>
	
	void printAccount() {
		
		for (int i = 0; i < accCount; i++) {
			acc[i].printOwnAccount();
		}	
		
	}
	
}
