package zw.co.tengahuku.dto;

import java.util.Date;

public class RoleDTO {
	
	private int id;
	private String roleName;
	private Date createdAt;
	private Date updatedAt;
	
	
	
	
	public RoleDTO(int id, String roleName, Date createdAt, Date updatedAt) {
		this.id = id;
		this.roleName = roleName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
