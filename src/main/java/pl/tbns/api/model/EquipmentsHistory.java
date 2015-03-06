/**
 * 
 */
package pl.tbns.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
	
	@ManyToOne
	@JoinColumn(name = "equipment_id", nullable = false)
	private List<Equipment> equipment;
	
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

	public EquipmentsHistory(List<Equipment> equipment, Date historyDate) {
		super();
		this.equipment = equipment;
		this.historyDate = historyDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((acceptDate == null) ? 0 : acceptDate.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result
				+ ((historyDate == null) ? 0 : historyDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((rejectDate == null) ? 0 : rejectDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentsHistory other = (EquipmentsHistory) obj;
		if (acceptDate == null) {
			if (other.acceptDate != null)
				return false;
		} else if (!acceptDate.equals(other.acceptDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		if (historyDate == null) {
			if (other.historyDate != null)
				return false;
		} else if (!historyDate.equals(other.historyDate))
			return false;
		if (id != other.id)
			return false;
		if (rejectDate == null) {
			if (other.rejectDate != null)
				return false;
		} else if (!rejectDate.equals(other.rejectDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
}
