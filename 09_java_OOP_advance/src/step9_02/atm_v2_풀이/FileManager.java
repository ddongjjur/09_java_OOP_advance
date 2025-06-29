package step9_02.atm_v2_풀이;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	private FileManager() {}
	private static FileManager instance = new FileManager();
	public static FileManager getInstance () {
		return instance;
	}
	
	String fileName = "ATM_풀이.txt";
	String data = "";
	UserManager um = UserManager.getInstance();
	
	void setData() {
		
		data = "";
		int userCount = um.userCnt;
		data += userCount;
		data += "\n";
		
		for (int i = 0; i < userCount; i++) {
			data += um.userList[i].id;
			data += "\n";
			data += um.userList[i].pw;
			data += "\n";
			data += um.userList[i].accCnt;
			data += "\n";
			
			if (um.userList[i].accCnt == 0) {
				data += "0\n";
			}
			else {
				for (int j = 0; j < userCount; j++) {
					data += um.userList[i].acc[j].accNumber;
					data += "/";
					data += um.userList[i].acc[j].money;
					if (j != um.userList[i].accCnt - 1) {
						data += ",";
					}
				}
			}
			data += "\n";
		}
	}
	
	
	void save() {
		
		setData();
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) try {fw.close();} catch (Exception e) {e.printStackTrace();}
		}
		
	}
	
	
	void load() {
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			if (file.exists()) {
				
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					data += line;
					data += "\n";
				}
				
				String[] tmp = data.split("\n");
				um.userCnt = Integer.parseInt(tmp[0]);
				um.userList = new User[um.userCnt];
				
				for (int i = 0; i < um.userCnt; i++) {
					um.userList[i] = new User();
				}
				
				int j = 0;
				for (int i = 1; i < tmp.length; i++) {
					
					String id = tmp[i];
					String pw = tmp[i + 1];
					int accCnt = Integer.parseInt(tmp[i + 2]);
					
					um.userList[j].id = id;
					um.userList[j].pw = pw;
					um.userList[j].accCnt = accCnt;
					String accInfo = tmp[i + 3];
					
					if (accCnt == 1) {
						String[] temp = accInfo.split("/");
						
						um.userList[j].acc[0] = new Account();
						um.userList[j].acc[0].accNumber = temp[0];
						um.userList[j].acc[0].money = Integer.parseInt(temp[1]);
						
					}
					
					else if (accCnt > 1) {
						String[] temp = accInfo.split(",");
						
						for (int k = 0; k < temp.length; k++) {
							String[] parse = temp[k].split("/");
							um.userList[j].acc[k] = new Account();
							
							um.userList[j].acc[k].accNumber = parse[0];
							um.userList[j].acc[k].money = Integer.parseInt(parse[1]);
						}
					}
					j++;
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				if (br != null) {try {br.close();} catch (Exception e) {e.printStackTrace();}}
				if (fr != null) {try {fr.close();} catch (Exception e) {e.printStackTrace();}}
		}
	}
	
}
