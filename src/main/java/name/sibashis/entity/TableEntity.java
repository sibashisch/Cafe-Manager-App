package name.sibashis.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.JsonObject;

import name.sibashis.service.TableStateService;

@Entity
@Table (name="CL_TABLE_MST")
public class TableEntity {

	@Id
	@Column (name="TABLE_ID")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int tableID;
	@Column (name="ORDER_ID")
	private Integer orderID;
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
	
	@ManyToOne
	@JoinColumn (name="TABLE_STATE")
	private TableStateEntity tableStateEntity;
	
	public TableEntity () {}

	public TableEntity(int tableID, int orderID, Date crtDt, String crtBy, Date updDt,
			String updBy) {
		super();
		this.tableID = tableID;
		this.orderID = orderID;
		this.crtDt = crtDt;
		this.crtBy = crtBy;
		this.updDt = updDt;
		this.updBy = updBy;
	}

	public int getTableID() {
		return tableID;
	}

	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
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
	
	public TableStateEntity getTableStateEntity() {
		return tableStateEntity;
	}

	public void setTableStateEntity(TableStateEntity tableStateEntity) {
		this.tableStateEntity = tableStateEntity;
	}
	
	public JsonObject toJson (TableStateService tableStateService) {
		
		JsonObject json = new JsonObject();
		json.addProperty("TABLE_ID", this.getTableID());
		json.addProperty("CURR_STATE_ID", this.getTableStateEntity().getStateID());
		json.addProperty("CURR_STATE_DESC", this.getTableStateEntity().getStateDesc());
		json.addProperty("NEXT_STATE_ID", this.getTableStateEntity().getNextState());
		json.addProperty("NEXT_STATE_DESC", tableStateService.getTableState(this.getTableStateEntity().getNextState()).getStateDesc());
		json.addProperty("BG_COLOR", this.getTableStateEntity().getBgColor());
		json.addProperty("FG_COLOR", this.getTableStateEntity().getFgColor());
		
		return json;
	}
	
}
