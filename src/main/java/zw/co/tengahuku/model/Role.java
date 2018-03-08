package zw.co.tengahuku.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@Table(name="ROLE")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="ROLE_NAME")
	private String roleName;
	@Column(name="CREATED_AT")
	private Date createdAt;
	@Column(name="UPDATED_AT")
	private Date updatedAt;
	
	@OneToMany(targetEntity=UserRole.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<UserRole> userRoles;
	

}
