/**
 * 
 */
package pl.tbns.api.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author Szymon
 *
 */
@Entity
@Table(name = "Equipment")
public class Equipment implements Serializable {

	private static final long serialVersionUID = 8717609392263968480L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "equipment_id", unique = true, nullable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "equipmentsType_id", nullable = false)
	private EquipmentsType equipmentsType;
	
	@ManyToOne
	@JoinColumn(name = "magazines_id", nullable = false)
	private Magazines magazine;
	
	@Column(name = "equipmentName")
	@Size(min = 5, max = 100, message = "Nazwa nie może być krótsza niż 5 i dłuższa niż 100 znaków!")
	private String name;
	
	@Column(name = "serialNumber")
	@Size(min = 2, max = 100, message = "Numer nie może być krótszy niż 2 i dłuższy niż 100 znaków!")
	private String serialNumber;
	
	@Column(name = "equipmentsNumber")
	@Size(min = 2, max = 100, message = "Numer nie może być krótszy niż 2 i dłuższy niż 100 znaków!")
	private String equipmentsNumber;
	
	@Column(name = "equipmentDescription")
	@Size(min = 0, max = 2000)
	private String description;
	
	public Equipment() {
		
	}
	
	public Equipment(EquipmentsType equipmentsType, Magazines magazine, String name, String serialNumber, String equipmentsNumber, String description) {
		this.equipmentsType = equipmentsType;
		this.magazine = magazine;
		this.name = name;
		this.serialNumber = serialNumber;
		this.equipmentsNumber = equipmentsNumber;
		this.description = description;
	}
	
	public EquipmentsType getEquipmentsType() {
		return equipmentsType;
	}
	
	public void setEquipmentsType(EquipmentsType equipmentsType) {
		this.equipmentsType = equipmentsType;
	}
	
	public Magazines getMagazine() {
		return magazine;
	}
	
	public void setMagazine(Magazines magazine) {
		this.magazine = magazine;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public String getEquipmentsNumber() {
		return equipmentsNumber;
	}
	
	public void setERquipmentsNumber(String equipmentsNumber) {
		this.equipmentsNumber = equipmentsNumber;
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
				+ ((description == null) ? 0 : description.hashCode());
		result = prime
				* result
				+ ((equipmentsNumber == null) ? 0 : equipmentsNumber.hashCode());
		result = prime * result
				+ ((equipmentsType == null) ? 0 : equipmentsType.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((magazine == null) ? 0 : magazine.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
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
		Equipment other = (Equipment) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (equipmentsNumber == null) {
			if (other.equipmentsNumber != null)
				return false;
		} else if (!equipmentsNumber.equals(other.equipmentsNumber))
			return false;
		if (equipmentsType == null) {
			if (other.equipmentsType != null)
				return false;
		} else if (!equipmentsType.equals(other.equipmentsType))
			return false;
		if (id != other.id)
			return false;
		if (magazine == null) {
			if (other.magazine != null)
				return false;
		} else if (!magazine.equals(other.magazine))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		return true;
	}
}
