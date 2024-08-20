package service;

import java.util.List;

import home.Account;
import home.AccountDAO;

public class AccountService {
	private AccountDAO accountDAO;
	
	public AccountService() {
		accountDAO = new AccountDAO();
	}
	
	public List<Account> getAllAccount() {
        return accountDAO.selectAllAccount();
    }

    public Account getAccountByNum(Account account) {
        return accountDAO.selectAccountOne(account);
    }
    
    public boolean getAccountCheck(String id) {
    	return accountDAO.selectAccountCheck(id);
    }

    public void insertAccount(Account account) {
        accountDAO.insertAccount(account);
    }

    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
    }

    public void deleteAccount(String num) {
        accountDAO.deleteAccount(num);
    }
}
