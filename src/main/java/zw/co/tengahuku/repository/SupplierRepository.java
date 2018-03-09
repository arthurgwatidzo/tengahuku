package zw.co.tengahuku.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import zw.co.tengahuku.model.Supplier;
@Repository("supplierRepository")
public interface SupplierRepository extends JpaRepository<Supplier,Long>{
	
	 @Query("SELECT u FROM Supplier u WHERE u.contactPerson = :contactPerson")
	Supplier findSupplierByContactPerson(String contactPerson);
	
	 @Query("SELECT u FROM Supplier u WHERE u.emailAddress = :emailAddress")
	List<Supplier> findSupplierByEmailAddress(String emailAddress);
	
	

}
