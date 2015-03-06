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
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "equipmentsType_id", nullable = false)
	private EquipmentsType equipmentsType;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
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
}
