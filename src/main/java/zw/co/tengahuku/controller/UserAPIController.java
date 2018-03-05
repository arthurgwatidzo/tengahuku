package zw.co.tengahuku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zw.co.tengahuku.model.User;
import zw.co.tengahuku.service.impl.UserService;

@Controller
public class UserAPIController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/create/user.api",method=RequestMethod.POST)
	  @ResponseBody
	  public String create(String emailUserName,String passWord, Boolean accountLocked) {
	    try {
	      User user = new User(emailUserName,passWord, Boolean.FALSE);
	      userService.createUser(user);
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created!";
	  }
	
	@RequestMapping(value="/update/user.api",method=RequestMethod.PUT)
	  @ResponseBody
	  public String updateName(long id, String email, String name) {
	    try {
	      User user = userService.findUserByEmailUserName(email);
	     
	      userService.updateUser(user.getEmailUserName(), user.getPassword());
	    }
	    catch (Exception ex) {
	      return "Error updating the user: " + ex.toString();
	    }
	    return "User succesfully updated!";
	  } 

}
