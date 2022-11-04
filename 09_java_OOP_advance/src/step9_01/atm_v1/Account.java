package step9_01.atm_v1;

public class Account {									// 계좌번호, 계좌 잔액
	
	String number;
	int money;
	
	void printOwnAccount() {
		System.out.println(this.number +  " : " + this.money);
	}
	
}
