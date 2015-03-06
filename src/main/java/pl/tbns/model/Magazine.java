/**
 * 
 */
package pl.tbns.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * @author Szymon
 *
 */
@Entity
@Table(name = "Magazine")
public class Magazine implements Serializable {

	private static final long serialVersionUID = 1816879387948066857L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "magazine_id", unique = true, nullable = false)
	private long id;
	
	@ManyToMany
	private List<Equipment> equipment;
	
	@OneToMany(mappedBy = "sourceMagazine")
	private Set<TransmissionHistory> transmisHistFromSource = new HashSet<TransmissionHistory>();
	
	@OneToMany(mappedBy = "destMagazine")
	private Set<TransmissionHistory> transmisHistFormDest = new HashSet<TransmissionHistory>();
	
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date openDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date closeDate;
	
	private Boolean status;
	
	@Column(name = "magazineDescription")
	@Size(min = 0, max = 2000)
	private String description;
	
	public Magazine() {
		
	}

	public Magazine(List<Equipment> equipment, String name, Date openDate,
			Date closeDate, Boolean status, String description) {
		this.equipment = equipment;
		this.name = name;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.status = status;
		this.description = description;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((closeDate == null) ? 0 : closeDate.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((openDate == null) ? 0 : openDate.hashCode());
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
		Magazine other = (Magazine) obj;
		if (closeDate == null) {
			if (other.closeDate != null)
				return false;
		} else if (!closeDate.equals(other.closeDate))
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
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (openDate == null) {
			if (other.openDate != null)
				return false;
		} else if (!openDate.equals(other.openDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
}
