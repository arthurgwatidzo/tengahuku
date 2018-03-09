package zw.co.tengahuku.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import zw.co.tengahuku.model.Account;

@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account,Long>{
	
	 @Query("SELECT u FROM Account u WHERE u.customer.id = :customerId AND  u.enabled=true")
	Account findAccountByCustomerId(Long customerId);
	 
	 @Query("SELECT u FROM Account u WHERE u.customer.id = :customerId AND  u.enabled=true")
		Account findAccountByCustomerName(Long customerId);
	 
	 @Query("SELECT u FROM Account u WHERE u.customer.customerACompany = true AND  u.enabled=true")
	 List<Account> findAllCompanyAccounts();
	 
	 @Query("SELECT u FROM Account u WHERE u.customer.customerACompany = false AND  u.enabled=true")
	 List<Account> findAllIndividualPersonAccounts();
	 
	 @Query("SELECT u FROM Account u WHERE  AND u.balance > 0 u.customer.id = :customerId AND  u.enabled=true")
	 Account findIfCustomerAccountIsInArrears(Long customerId);
	 
	 @Query("SELECT u FROM Account u WHERE  AND u.balance <= 0 AND u.enabled=true")
	 List<Account> findAllAccountsInArrears();
	 
	 @Query("SELECT u FROM Account u WHERE u.customer.customerACompany = true AND u.enabled=false")
	 List<Account> findAllClosedCompanyAccounts();
	 
	 @Query("SELECT u FROM Account u WHERE u.customer.customerACompany = false AND u.enabled=false")
	 List<Account> findAllOpenedCompanyAccounts();
	 
	 @Query("SELECT u FROM Account u WHERE u.enabled=true")
	 List<Account> findAllOpenedAccounts();
	 
	 @Query("SELECT u FROM Account u WHERE u.enabled=false")
	 List<Account> findAllClosedAccounts();
	 
	 @Modifying(clearAutomatically = true)
	 @Query("update Account u set u.accountFreezed = :accountFreezed WHERE u.id = :accountId")
	 void freezeAccount(Long accountId);
	 
	 @Modifying
	 @Query("update Account u set u.accountFreezed = :accountFreezed WHERE u.customer.id = :customerId AND u.enabled=true")
	 void freezeAccountByCustomerId(Long customerId);
	 
	 @Modifying
	 @Query("update Account u set u.enabled = false WHERE u.customer.id = :accountId AND u.enabled=true")
	 void closeAccount(Long accountId);
	 
	 @Modifying
	 @Query("update Account u set u.enabled = false WHERE u.customer.id = :customerId AND u.enabled=true")
	 void closeAccountByCustomerId(Long customerId);
	 
	 
}
