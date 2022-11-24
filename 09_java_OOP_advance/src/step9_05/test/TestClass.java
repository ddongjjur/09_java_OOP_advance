package step9_05.test;
import java.util.ArrayList;

class Member {
	
	private int    custno;			// 회원번호
	private String custname;		// 회원성명
	private String phone;			// 회원전화
	private String address;			// 통신사
	private String joindate;		// 가입일자
	private String grade;			// 고객등급
	private String city;			// 거주도시

	public Member() {}
	
	public Member(int custno, String custname, String phone, String address, String joindate, String grade, String city) {
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
		
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}



class Money {
	
	int custno;			// 회원번호
	int saleno; 		// 판매번호
	int pcost;			// 단가
	int amount;			// 수량
	int price;			// 가격(매출)
	String pcode;		// 상품코드
	String sdate;		// 판매일자
	 
	public Money() {}
	 
	public Money(int custno, int saleno, int pcost, int amount, int price, String pcode, String sdate) {
		this.custno = custno;
		this.saleno = saleno;
		this.pcost = pcost;
		this.amount = amount;
		this.price = price;
		this.pcode = pcode;
		this.sdate = sdate;
	}
	
}

class Total {
	
	int number;
	String name;
	int totalPrice;
	
	public Total(int number, String name, int totalPrice) {
		
		this.number = number;
		this.name = name;
		this.totalPrice = totalPrice;
		
	}

	public Total(Total total) {
		// TODO Auto-generated constructor stub
	}
	
}

class Manager{
	
	ArrayList<Member> memberList = new ArrayList<Member>();
	ArrayList<Money> moneyList = new ArrayList<Money>();
	
	ArrayList<Integer> numList = new ArrayList<Integer>();
	ArrayList<String> nameList = new ArrayList<String>();
	ArrayList<Integer> priceList = new ArrayList<Integer>();
	
	void init() {
		
		memberList.add(new Member(100001, "김행복", "010-1111-2222", "SK", "20151202", "A", "01"));		// 회원번호, 회원성명, 회원전화, 통신사, 가입일자, 고객등급, 거주도시
		memberList.add(new Member(100002, "이축복", "010-1111-3333", "SK", "20151206", "B", "01"));
		memberList.add(new Member(100003, "장믿음", "010-1111-4444", "SK", "20151001", "B", "30"));
		memberList.add(new Member(100004, "최사랑", "010-1111-5555", "SK", "20151113", "A", "30"));
		memberList.add(new Member(100005, "진평화", "010-1111-6666", "SK", "20151225", "B", "60"));
		memberList.add(new Member(100006, "차공단", "010-1111-7777", "SK", "20151211", "C", "60"));
		
		moneyList.add(new Money(100001, 20160001, 500, 5, 2500, "A001", "20160101"));	// 회원번호, 판매번호, 단가, 수량, 가격(매출), 상품코드, 판매일자
		moneyList.add(new Money(100001, 20160002, 1000, 4, 4000, "A002", "20160101"));
		moneyList.add(new Money(100001, 20160003, 500, 3, 1500, "A008", "20160101"));
		moneyList.add(new Money(100002, 20160004, 2000, 1, 2000, "A004", "20160102"));
		moneyList.add(new Money(100002, 20160005, 500, 1, 500, "A001", "20160103"));
		moneyList.add(new Money(100003, 20160006, 1500, 2, 3000, "A003", "20160103"));
		moneyList.add(new Money(100004, 20160007, 500, 2, 1000, "A001", "20160104"));
		moneyList.add(new Money(100004, 20160008, 300, 1, 300, "A005", "20160104"));
		moneyList.add(new Money(100004, 20160009, 600, 1, 600, "A006", "20160104"));
		moneyList.add(new Money(100004, 20160010, 3000, 1, 3000, "A007", "20160106"));
		
	}
	
	void numberProcess() {
			
		int cnt = 0;
		numList.add(moneyList.get(cnt).custno);
		
		for (int j = 0; j < moneyList.size(); j++) {
			
			for (int i = 0; i < moneyList.size(); i++) {
				if (numList.get(j) == moneyList.get(i).custno) {
					cnt++;
				}
			}
			numList.add(moneyList.get(cnt).custno);
			
			if (numList.get(numList.size() -1) == moneyList.get(moneyList.size() - 1).custno) {
				break;
			}
		}
		
	}
	
	void nameProcess() {
		
		for (int i = 0; i < numList.size(); i++) {
			for (int k = 0; k < memberList.size(); k++) {
				if (numList.get(i) == memberList.get(k).getCustno()) {
					nameList.add(memberList.get(k).getCustname());
				}
			}
		}
	}

	void priceProcess() {
		
		
		int pri = 0;
		int cnt = 0;
		
		for (int i = 0; i < numList.size(); i++) {
			for (int k = 0; k < moneyList.size(); k++) {
				if (numList.get(i) == moneyList.get(k).custno) {
					pri += moneyList.get(k).price;
					cnt++;
				}
			}
			priceList.add(pri);
			pri = 0;
		}
		
	}
	
	
	
	void totalProcess() {
		
		ArrayList<Total> totalList = new ArrayList<Total>();
			
			for (int i = 0; i < numList.size(); i++) {
				totalList.add(new Total(numList.get(i), nameList.get(i), priceList.get(i)));
			}
			
			for (int i = 0; i < totalList.size(); i++) {
				System.out.print(totalList.get(i).number + " ");
				System.out.print(totalList.get(i).name + " ");
				System.out.print(totalList.get(i).totalPrice);
				System.out.println();
			}
			System.out.println("\n");
			
			// 여기서부터
//			while (true) {
//				if (condition) {
//					break;
//				}
//				else () {
//					
//				}
// 			}
			for (int i = 0; i < totalList.size(); i++) {
				
				if (i != totalList.size() - 1) {
					if (totalList.get(i).totalPrice < totalList.get(i + 1).totalPrice) {
						
						Total temp = new Total(totalList.get(i));
						Total swich1 = new Total(totalList.get(i));
						Total swich2 = new Total(totalList.get(i + 1));
						
						temp = swich1;
						swich1 = swich2;
						swich2 = temp;
						
						temp = null;

//						totalList.get(i).number = totalList.get(i + 1).number;
//						totalList.get(i).name = totalList.get(i + 1).name;
//						totalList.get(i).totalPrice = totalList.get(i + 1).totalPrice;
//						
//						totalList.get(i + 1).number = temp.number;
//						totalList.get(i + 1).name = temp.name;
//						totalList.get(i + 1).totalPrice = temp.totalPrice;
						
						
						
					}
				}
				else if (i == totalList.size() - 1) {
					if (totalList.get(i).totalPrice > totalList.get(0).totalPrice) {
						Total temp = new Total(totalList.get(i).number, totalList.get(i).name, totalList.get(i).totalPrice);
						
						totalList.get(i).number = totalList.get(0).number;
						totalList.get(i).name = totalList.get(0).name;
						totalList.get(i).totalPrice = totalList.get(0).totalPrice;
						
						totalList.get(0).number = temp.number;
						totalList.get(0).name = temp.name;
						totalList.get(0).totalPrice = temp.totalPrice;
						
					}
				}
			}
			for (int i = 0; i < totalList.size(); i++) {
				System.out.print(totalList.get(i).number + " ");
				System.out.print(totalList.get(i).name + " ");
				System.out.print(totalList.get(i).totalPrice +"\n");
			}
		}
	
}

public class TestClass {

	public static void main(String[] args) {
		
		Manager mg = new Manager();
		
		mg.init();
		mg.numberProcess();
		mg.nameProcess();
		mg.priceProcess();
		mg.totalProcess();
		
		/*
		   [문제] 아래와 같이 출력  매출(price) 의 합계 + 내림차순 
		  
			100001	김행복		8000
			--------------------------------
			100004	최사랑		4900
			--------------------------------
			100003	장믿음		3000
			--------------------------------
			100002	이축복		2500
			--------------------------------
		 */
		
		
	}

}
