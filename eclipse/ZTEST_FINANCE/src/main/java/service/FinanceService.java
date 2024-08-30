package service;

import java.util.List;

import home.Finance;
import home.FinanceDAO;

public class FinanceService {
	private FinanceDAO financeDAO;
	
	public FinanceService() {
		financeDAO = new FinanceDAO();
	}
	
	public List<Finance> selectAllChart() {
        return financeDAO.selectAllChart();
    }
	
	public List<Finance> selectAllHiredate(){
		return financeDAO.selectAllHiredate();
	}
	
	public List<Finance> selectAllByHiredate(String date){
		return financeDAO.selectAllByHiredate(date);
	}
	
	
}
