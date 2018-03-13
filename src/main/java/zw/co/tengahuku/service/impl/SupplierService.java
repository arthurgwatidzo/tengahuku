package zw.co.tengahuku.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.tengahuku.exception.ApplicationDataException;
import zw.co.tengahuku.exception.BusinessException;
import zw.co.tengahuku.model.Supplier;
import zw.co.tengahuku.repository.SupplierRepository;
import zw.co.tengahuku.service.ISupplierService;

@Service
public class SupplierService implements ISupplierService{
	
	@Autowired
	SupplierRepository supplierRepository;
	
	public Supplier findSupplierByContactPerson(String contactPerson) throws ApplicationDataException{
		Supplier supplier = supplierRepository.findSupplierByContactPerson(contactPerson);
		 if(supplier == null) 
			 throw new ApplicationDataException("Could not find supplier."); 
		return supplier;
	}
	
	
	public Supplier saveSupplier(Supplier supplier) throws ApplicationDataException{
		
		Supplier savedSupplier  = new Supplier();
		if(Objects.nonNull(supplier)){
			savedSupplier = supplierRepository.save(supplier);
			supplierRepository.flush();
		}
		
		if(savedSupplier==null){
			throw new ApplicationDataException("Could not create new Supplier");
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
