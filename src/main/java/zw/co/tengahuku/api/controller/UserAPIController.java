package zw.co.tengahuku.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import zw.co.tengahuku.model.User;
import zw.co.tengahuku.service.impl.UserService;

@RestController
@RequestMapping(value = "/tengahuku/api")
@Api(tags = "User" , description = "The user who is responsible for logging into the app and executes operations and transactions")
public class UserAPIController {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(UserAPIController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user.json/createUser",method=RequestMethod.POST, produces = "application/json")
	  @ResponseBody
	  public ResponseEntity<?> create(String emailUserName,String passWord, Boolean accountLocked) {
	    try {
	      User user = new User(emailUserName,passWord, Boolean.FALSE);
	      userService.createUser(user);
	      LOGGER.info("User Created");
	    }
	    catch (Exception ex) {
	    	 LOGGER.error("Failed to Create User" + ex.getMessage());
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	  
	    return new ResponseEntity<>(HttpStatus.OK);
	    
	  }
	
	@RequestMapping(value="/update/user.json/updateUser",params = { "emailUserName" },method=RequestMethod.PUT, produces = "application/json")
	  @ResponseBody
	  @ResponseStatus( HttpStatus.OK )
	  public String updateUser(@PathVariable ("emailUserName")  String emailUserName, @PathVariable ("password")  String password) {
	    try {
	      User user = userService.findUserByEmailUserName(emailUserName);
	      if(user!=null){
	    	  user.setPassword(password);
	    	  userService.updateUser(user.getEmailUserName(), user.getPassword());
	      }
	     
	    }
	    catch (Exception ex) {
	    	 LOGGER.error("Failed to Update User" + ex.getMessage());
	      return "Error updating the user: " + ex.toString();
	    }
	    return "User succesfully updated!";
	  } 

}
