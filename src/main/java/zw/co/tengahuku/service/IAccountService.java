package zw.co.tengahuku.service;

import java.util.Date;

public interface IAccountService {
	
	void deposit(Double amount);
	void withdraw(Double amount);
	void addInterest();
	void transfer(Double amount);
	void generateAccountHistory(Date effetiveFrom, Date effectiveTo);
	
}
