package zw.co.tengahuku.dto;

import java.util.Date;

public class PermissionDTO {

	private int id;
	private String permissionShortName;
	private String permissionDescription;
	private int roleId;
	private Date createdAt;
	private Date updatedAt;
	
	

	public PermissionDTO(int id, String permissionShortName, String permissionDescription, int roleId, Date createdAt,
			Date updatedAt) {
		this.id = id;
		this.permissionShortName = permissionShortName;
		this.permissionDescription = permissionDescription;
		this.roleId = roleId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPermissionShortName() {
		return permissionShortName;
	}

	public void setPermissionShortName(String permissionShortName) {
		this.permissionShortName = permissionShortName;
	}

	public String getPermissionDescription() {
		return permissionDescription;
	}

	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
