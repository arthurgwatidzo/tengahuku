package zw.co.tengahuku.dto;

import java.util.Date;

public class PermissionDTO {

	private int id;
	private String permissionShortName;
	private String permissionDescription;
	private int roleId;
	private Date createdOn;
	private Date updatedOn;
	
	

	public PermissionDTO(int id, String permissionShortName, String permissionDescription, int roleId, Date createdOn,
			Date updatedOn) {
		this.id = id;
		this.permissionShortName = permissionShortName;
		this.permissionDescription = permissionDescription;
		this.roleId = roleId;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}
