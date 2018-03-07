package zw.co.tengahuku.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zw.co.tengahuku.model.User;
import zw.co.tengahuku.repository.UserRepository;
import zw.co.tengahuku.service.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User findUserByEmailUserName(String emailUserName) {
		return userRepository.findUserByEmailUserName(emailUserName);
	}

	@Override
	public void updateUser(String emailUsername, String password) {
		userRepository.updateUser(emailUsername, password);
		
	}

	@Override
	public void updateAccountLocked(Boolean accountLocked, Long id) {
		userRepository.updateAccountLocked(accountLocked, id);
		
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findAllUserAccounts() {
		return userRepository.findAll();
	}

}
