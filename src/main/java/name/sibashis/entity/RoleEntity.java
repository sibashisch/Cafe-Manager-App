package name.sibashis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="CL_ROLE_MST")
public class RoleEntity {

	@Id
	@Column (name="ROLE_ID")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int roleID;
	@Column (name="ROLE_NAME")
	private String roleName;
	
	public RoleEntity () {}
	
	public RoleEntity (int roleID, String roleName) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
	
}
