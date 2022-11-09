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
					data += "\n";
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
			if (fw != null) try {fw.close();} catch (IOException e) {e.printStackTrace();}
		}
		
	}
	
	
	void load() {
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
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
			
			// 여기부터
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
