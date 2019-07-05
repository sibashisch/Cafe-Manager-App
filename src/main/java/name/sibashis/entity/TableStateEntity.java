package name.sibashis.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="CL_TABLE_STATE_MST")
public class TableStateEntity {
	
	@Id
	@Column (name="STATE_ID")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int stateID;
	@Column (name="STATE_DESC")
	private String stateDesc;
	@Column (name="NEXT_STATE")
	private int nextState;
	@Column (name="BG_COLOR")
	private String bgColor;
	@Column (name="FG_COLOR")
	private String fgColor;
	@Column (name="CRT_DT", columnDefinition="DATETIME")
	@Temporal (TemporalType.TIMESTAMP)
	private Date crtDt;
	@Column (name="CRT_BY")
	private String crtBy;
	@Column (name="UPD_DT", columnDefinition="DATETIME")
	@Temporal (TemporalType.TIMESTAMP)
	private Date updDt;
	@Column (name="UPD_BY")
	private String updBy;
	
	public static final int MAX_STATE = 6;
	
	public TableStateEntity () {}
	
	public TableStateEntity(int stateID, String stateDesc, Date crtDt, String crtBy, Date updDt, String updBy) {
		super();
		this.stateID = stateID;
		this.stateDesc = stateDesc;
		this.crtDt = crtDt;
		this.crtBy = crtBy;
		this.updDt = updDt;
		this.updBy = updBy;
	}

	public int getStateID() {
		return stateID;
	}

	public void setStateID(int stateID) {
		this.stateID = stateID;
	}

	public String getStateDesc() {
		return stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}
	
	public int getNextState() {
		return nextState;
	}

	public void setNextState(int nextState) {
		this.nextState = nextState;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getFgColor() {
		return fgColor;
	}

	public void setFgColor(String fgColor) {
		this.fgColor = fgColor;
	}

	public Date getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(Date crtDt) {
		this.crtDt = crtDt;
	}

	public String getCrtBy() {
		return crtBy;
	}

	public void setCrtBy(String crtBy) {
		this.crtBy = crtBy;
	}

	public Date getUpdDt() {
		return updDt;
	}

	public void setUpdDt(Date updDt) {
		this.updDt = updDt;
	}

	public String getUpdBy() {
		return updBy;
	}

	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}
	
	@OneToMany
    @JoinColumn(name="STATE_ID")
    private Set<TableEntity> tables;
	
	
}
