package zw.co.tengahuku.mapper;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import zw.co.tengahuku.dto.UserDTO;
import zw.co.tengahuku.model.User;

@Component
public class UserMapper<A extends User, B extends UserDTO> extends CustomMapper<A, B> {


	@Override
	public void mapAtoB(A user, B userDTO, MappingContext mappingContext) {
		super.mapAtoB(user, userDTO, mappingContext);

		if (user.getId() != null) {
			userDTO.setId(user.getId());
		}

		if (user.getEmailUserName() != null) {
			userDTO.setEmailUserName(user.getEmailUserName());
		}
			
		if(user.getAccountLocked()!=null){
		userDTO.setAccountLocked(user.getAccountLocked());
		}
		
		if (user.getPassword() != null) {
			userDTO.setPassword(user.getPassword());
		}
	}
	
	
	@Override
	public void mapBtoA(B userDTO, A user, MappingContext mappingContext){
		super.mapBtoA(userDTO, user, mappingContext);
		
		if (userDTO.getId() != null) {
			user.setId(user.getId());
		}

		if (userDTO.getEmailUserName() != null) {
			user.setEmailUserName(userDTO.getEmailUserName());
		}
			
		if(userDTO.getAccountLocked()!=null){
		user.setAccountLocked(userDTO.getAccountLocked());
		}
		
		if (userDTO.getPassword() != null) {
			user.setPassword(userDTO.getPassword());
		}
	}

}
