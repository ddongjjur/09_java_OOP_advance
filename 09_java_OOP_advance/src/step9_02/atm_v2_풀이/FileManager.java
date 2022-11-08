package step9_02.atm_v2_풀이;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

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
		// 여기부터
		data = "";
		
	}
	
	
	void save() {
		
		setData();
		
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
			// 여기
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
