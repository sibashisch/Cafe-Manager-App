package name.sibashis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="CL_USER_MST")
public class UserEntity {
	
	@Id
	@Column (name="USER_ID")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int userID;
	@Column (name="USER_NAME")
	private String userName;
	@Column (name="DISPLAY_NAME")
	private String displayName;
	@Column (name="USER_ROLE")
	private String userRole;
	@Column (name="USER_PASS")
	private String userPass;
	@Column (name="CRT_BY")
	private String crtBy;
	@Column (name="UPD_BY")
	private String updBy;
	
	public UserEntity() {}

	public UserEntity(int userID, String userName, String displayName, String userRole, String userPass, String crtBy,
			String updBy) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.displayName = displayName;
		this.userRole = userRole;
		this.userPass = userPass;
		this.crtBy = crtBy;
		this.updBy = updBy;
	}

	public String getUpdBy() {
		return updBy;
	}

	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getCrtBy() {
		return crtBy;
	}

	public void setCrtBy(String crtBy) {
		this.crtBy = crtBy;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
}
