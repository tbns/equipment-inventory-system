/**
 * 
 */
package pl.tbns.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author Szymon
 *
 */

@Entity
@Table(name = "EquipmentsType")
public class EquipmentsType implements Serializable {
	
	private static final long serialVersionUID = 164065115201911914L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "equipmentsType_id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "equipmentsTypeName")
	@Size(min = 5, max = 100, message = "Nazwa nie może być krótsza niż 5 i dłuższa niż 100 znaków!")
	private String name;
	
	@Column(name = "equipmentsTypeDescription")
	@Size(min = 0, max = 2000)
	private String description;
	
	@OneToMany(mappedBy = "EquipmentsType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Equipment equipment;
	
	public EquipmentsType(){
		
	}
	
	public EquipmentsType(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	public Long getEquipmentsTypeId(){
		return id;
	}
	
	public void setEquipmentsTypeId(Long id){
		this.id = id;
	}
	
	public String getEquipmentsTypeName(){
		return name;
	}
	
	public void setEquipmentsTypeName(String name){
		this.name = name;
	}
	public String getEquipmentsTypeDescription(){
		return description;
	}
	
	public void setEquipmentsTypeDescription(String description){
		this.description = description;
	}
	
	public Equipment getEquipments(){
		return equipment;
	}
	
	public void setEquipment(Equipment equipment){
		this.equipment = equipment;
	}
}
