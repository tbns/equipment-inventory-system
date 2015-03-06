/**
 * 
 */
package pl.tbns.model;

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

	private static final long serialVersionUID = -6064036581679301930L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "equipment_id", unique = true, nullable = false)
	private long id;
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setEquipmentsNumber(String equipmentsNumber) {
		this.equipmentsNumber = equipmentsNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}
