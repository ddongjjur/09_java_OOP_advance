package step9_02.atm_v2;

public class User {		// acc, accCnt, id, pw
	
	Account[] acc = new Account[UserManager.getInstance().ACC_MAX_CNT];	
	int accCnt;	
	String id;											
	String pw;											
	
}


