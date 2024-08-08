package drive;

import java.util.List;

import dept.DeptDAO;
import dept.DeptDTO;

public class Ex01 {

	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
		List<DeptDTO> list = dao.getDeptList();
		
//		dao.insertDept(new DeptDTO(50,"WORKER","SEOUL"));
		
		for(DeptDTO dto : list) {
			System.out.println(dto);
		}
		
		

	}

}
