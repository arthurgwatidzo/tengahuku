package zw.co.tengahuku.service;

import java.util.List;

import zw.co.tengahuku.model.User;

public interface IUserService {
	User findUserByEmailUserName(String emailUserName);
	void updateUser(String emailUsername, String password);
	void updateAccountLocked(Boolean accountLocked, Long id);
	User createUser(User user);
	List<User> findAllUserAccounts();

}
