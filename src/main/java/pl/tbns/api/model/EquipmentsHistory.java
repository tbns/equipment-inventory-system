/**
 * 
 */
package pl.tbns.api.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Szymon
 *
 */
@Entity
@Table(name = "EquipmentsHistory")
public class EquipmentsHistory implements Serializable {

	private static final long serialVersionUID = 4988130287343613219L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "equipmentsHistory_id", unique = true, nullable = false)
	private long id;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "equipment_id", nullable = false)
	private Equipment equipment;
	
	//TODO: historia sprzętu
	
	@Column(name = "historyDate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date historyDate;
	
	@Column(name = "acceptDate")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date acceptDate;
	
	@Column(name = "rejectDate")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date rejectDate;
	
	@Column(name = "historyStatus")
	@Size(min = 2, max = 20)
	private String status;
	
	@Column(name = "description")
	@Size(min = 0, max = 2000)
	private String description;
	
	public EquipmentsHistory() {
		
	}
	
	public EquipmentsHistory(Equipment equipment, Date historyDate, Date acceptDate, Date rejectDate, String status, String description) {
		this.equipment = equipment;
		//TODO: historia sprzętu - konstruktor
		this.historyDate = historyDate;
		this.acceptDate = acceptDate;
		this.rejectDate = rejectDate;
		this.status = status;
		this.description = description;
	}
	
	public Equipment getEquipment(){
		return equipment;
	}
	
	public void setEquipments(Equipment equipment) {
		this.equipment = equipment;
	}
	
	//TODO: historia sprzętu - getery i setery
	
	public Date getHistoryDate() {
		return historyDate;
	}
	
	public void setHistoryDate(Date historyDate) {
		this.historyDate = historyDate;
	}
	
	public Date getAcceptDate() {
		return acceptDate;
	}
	
	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}
	
	public Date getRejectDate() {
		return rejectDate;
	}
	
	public void setRejectDate(Date rejectDate) {
		this.rejectDate = rejectDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
