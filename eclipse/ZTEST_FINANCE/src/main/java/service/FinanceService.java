package service;

import java.util.List;

import home.Finance;
import home.FinanceDAO;

public class FinanceService {
	private FinanceDAO financeDAO;
	
	public FinanceService() {
		financeDAO = new FinanceDAO();
	}
	
	public List<Finance> selectAllFinance() {
        return financeDAO.selectAllFinance();
    }
	
}
