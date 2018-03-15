package zw.co.tengahuku.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@Table(name="PERMISSION")
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="PERMISSION_SHORT_NAME")
	private String permissionShortName;
	@Column(name="PERMISSION_DESCRIPTION")
	private String permissionDescription;
	@Column(name="ROLE_ID")
	private int roleId;
	@Column(name="CREATED_ON")
	private Date createdOn;
	@Column(name="UPDATED_ON")
	private Date updatedOn;

}
