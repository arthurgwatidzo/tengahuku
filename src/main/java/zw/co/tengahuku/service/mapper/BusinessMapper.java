package zw.co.tengahuku.service.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import zw.co.tengahuku.dto.UserDTO;
import zw.co.tengahuku.model.User;

public class BusinessMapper {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(BusinessMapper.class);
	 
	 public static User map(UserDTO userDTO){
		 
		 if (userDTO == null) {
	            return null;
	        }
		 
		return null;
		 
	 }

}
