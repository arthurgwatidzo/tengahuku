package zw.co.tengahuku.service;

import zw.co.tengahuku.model.Deliverer;

public interface IDeliveryService {
	
	public Deliverer getDelivererDetails();
	public void processDelivery();
	public void addDeliverer();
	public void editDelivererDetails();
	public void deleteDelivery();
	
	
	

}
