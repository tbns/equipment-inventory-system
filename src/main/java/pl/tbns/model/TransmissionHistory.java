/**
 * 
 */
package pl.tbns.model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 * @author Szymon Iwański
 * @author Maciej Skowyra
 *
 */
@Entity
@Table(name = "TransmissionHistory")
public class TransmissionHistory implements Serializable {

	private static final long serialVersionUID = -6545040713713942954L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transmisHist_id", unique = true, nullable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;
	
	@ManyToOne
	@JoinColumn(name = "sourceMagazine_id")
	private Magazine sourceMagazine; //magazyn źródłowy
	
	@ManyToOne
	@JoinColumn(name = "destMagazine_id")
	private Magazine destMagazine; //magazyn docelowy
	
	@Temporal(TemporalType.DATE)
	private Date transmisDate; //data wydania dyspozycji do przekazania sprzetu
	
	@Temporal(TemporalType.DATE)
	private Date acceptDate; //data przyjęcia sprzętu na magazyn
	
	@Temporal(TemporalType.DATE)
	private Date rejectDate; //data odrzucenia sprzętu z magazynu
	
	private boolean status;
	
	@Column(name = "equipmentDescription")
	@Size(min = 0, max = 2000)
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateCreated;

	public TransmissionHistory() {
	}

	public TransmissionHistory(Equipment equipment, Magazine sourceMagazine,
			Magazine destMagazine, Date transmisDate, Date acceptDate,
			Date rejectDate, Boolean status, String description,
			Date dateCreated) {
		this.equipment = equipment;
		this.sourceMagazine = sourceMagazine;
		this.destMagazine = destMagazine;
		this.transmisDate = transmisDate;
		this.acceptDate = acceptDate;
		this.rejectDate = rejectDate;
		this.status = status;
		this.description = description;
		DateCreated = dateCreated;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Magazine getSourceMagazine() {
		return sourceMagazine;
	}

	public void setSourceMagazine(Magazine sourceMagazine) {
		this.sourceMagazine = sourceMagazine;
	}

	public Magazine getDestMagazine() {
		return destMagazine;
	}

	public void setDestMagazine(Magazine destMagazine) {
		this.destMagazine = destMagazine;
	}

	public Date getTransmisDate() {
		return transmisDate;
	}

	public void setTransmisDate(Date transmisDate) {
		this.transmisDate = transmisDate;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return DateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		DateCreated = dateCreated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((DateCreated == null) ? 0 : DateCreated.hashCode());
		result = prime * result
				+ ((acceptDate == null) ? 0 : acceptDate.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((destMagazine == null) ? 0 : destMagazine.hashCode());
		result = prime * result
				+ ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((rejectDate == null) ? 0 : rejectDate.hashCode());
		result = prime * result
				+ ((sourceMagazine == null) ? 0 : sourceMagazine.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result
				+ ((transmisDate == null) ? 0 : transmisDate.hashCode());
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
		TransmissionHistory other = (TransmissionHistory) obj;
		if (DateCreated == null) {
			if (other.DateCreated != null)
				return false;
		} else if (!DateCreated.equals(other.DateCreated))
			return false;
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
		if (destMagazine == null) {
			if (other.destMagazine != null)
				return false;
		} else if (!destMagazine.equals(other.destMagazine))
			return false;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		if (id != other.id)
			return false;
		if (rejectDate == null) {
			if (other.rejectDate != null)
				return false;
		} else if (!rejectDate.equals(other.rejectDate))
			return false;
		if (sourceMagazine == null) {
			if (other.sourceMagazine != null)
				return false;
		} else if (!sourceMagazine.equals(other.sourceMagazine))
			return false;
		if (status != other.status)
			return false;
		if (transmisDate == null) {
			if (other.transmisDate != null)
				return false;
		} else if (!transmisDate.equals(other.transmisDate))
			return false;
		return true;
	}
}
