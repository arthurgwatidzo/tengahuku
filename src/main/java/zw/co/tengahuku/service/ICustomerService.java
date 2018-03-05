package zw.co.tengahuku.service;

import zw.co.tengahuku.model.Customer;

public interface ICustomerService {
	
	public void addCustomer();
	public void editCustomer();
	public void makePayment();
	public void attachProofOfPayment();
	public void lockCustomer();
	public Customer searchCustomer();
	
	

}
