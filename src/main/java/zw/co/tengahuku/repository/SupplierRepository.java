package zw.co.tengahuku.repository;

import java.util.List;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import zw.co.tengahuku.model.Supplier;
@Repository("supplierRepository")
public interface SupplierRepository extends JpaRepository<Supplier,Long>{
	
	Supplier findSupplierByContactPerson(String contactPerson);
	
	
	List<Supplier> findSupplierByEmailAddress(String emailAddress);
	
	//@Query("SELECT sp FROM Supplier WHERE sp.emailAddress = :emailAddress")
	//Page<Supplier> findSupplierPagesByEmailAddress(@Param("emailAddress") String emailAddress,Pageable pageable);
	

}
