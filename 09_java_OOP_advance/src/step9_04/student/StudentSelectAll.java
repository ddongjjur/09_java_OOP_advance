package step9_04.student;

import java.util.Map;

public class StudentSelectAll {		//studentDAO
	
	private StudentDAO studentDAO;
	
	public StudentSelectAll(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	
	public Map<String , StudentVO> allSelect(){
		return studentDAO.getStudentDB();
	}
	
	
	public void printAll() {
		
		Map<String , StudentVO> map = studentDAO.getStudentDB();
		
		for (String key : map.keySet()) {
			map.get(key).printOneInfo();
		}
		
	}
	
}
