package zw.co.tengahuku.dto;

public class UserRoleDTO {

	private int id;
	private UserDTO user;
	private RoleDTO role;

	public UserRoleDTO(int id, UserDTO user, RoleDTO role) {
		this.id = id;
		this.user = user;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

}
