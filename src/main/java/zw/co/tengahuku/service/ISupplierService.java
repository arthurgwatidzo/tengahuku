package zw.co.tengahuku.service;

import zw.co.tengahuku.model.Supplier;

public interface ISupplierService {
	
	Supplier findSupplierByContactPerson(String contactPerson);
	Supplier saveSupplier(Supplier supplier);
	void updateSupplier(Long id, String name, String contactPerson, String alternativeContactPerson, String emailAddress);

}
