package zw.co.tengahuku.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import zw.co.tengahuku.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long>{
	
	@Query("SELECT u FROM User u WHERE u.emailUserName = :emailUserName")
	User findUserByEmailUserName(String emailUserName);
	
	@Modifying
	@Query("update User u set u.emailUserName = :emailUserName, u.password = :password where u.emailUserName = :emailUserName")
	void updateUser(@Param("emailUserName") String emailUserName, @Param("password") String password);
	@Modifying
	@Query("update User u set u.accountLocked = :accountLocked where u.id = :id")
	void updateAccountLocked(@Param("accountLocked") Boolean accountLocked,@Param("id") Long id);

}
