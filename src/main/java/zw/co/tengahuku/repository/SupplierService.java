package zw.co.tengahuku.repository;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import zw.co.tengahuku.model.Supplier;

public class SupplierService {
	
	@Autowired
	SupplierRepository supplierRepository;
	
	Supplier findSupplierByContactPerson(String contactPerson){
		return supplierRepository.findSupplierByContactPerson(contactPerson);
	}
	
	
	public Supplier saveSupplier(Supplier supplier){
		
		Supplier savedSupplier  = new Supplier();
		if(Objects.nonNull(supplier)){
			savedSupplier = supplierRepository.save(supplier);
			supplierRepository.flush();
		}
		
		
		return savedSupplier;
	}
	
	
	public void updateSupplier(Long id, String name, String contactPerson, String alternativeContactPerson, String emailAddress){
		if(Objects.nonNull(id)){
			if(contactPerson!=null && !contactPerson.isEmpty()){
				supplierRepository.updateSupplier(id, name, contactPerson, alternativeContactPerson, emailAddress);
			}
		}
	}
	
	
	
	
}
