package zw.co.tengahuku.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import zw.co.tengahuku.model.Account;
import zw.co.tengahuku.service.IAccountService;


@Service
public class AccountService implements IAccountService{
	
	private static final Log LOGGER = LogFactory.getLog(AccountService.class);
	private Account account;

	@Override
	public void deposit(Double amount) {

			if(amount<=0.00){
				
				LOGGER.info("Amount to be deposited should be positive");
						return;
			}else{
				 account.setBalance(account.getBalance() + amount);
			}
		
	}

	@Override
	public void withdraw(Double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInterest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transfer(Double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateAccountHistory(Date effetiveFrom, Date effectiveTo) {
		// TODO Auto-generated method stub
		
	}

}
