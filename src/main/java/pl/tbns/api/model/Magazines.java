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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "Magazines")
public class Magazines implements Serializable{

	private static final long serialVersionUID = 4258742344885872472L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "magazine_id", unique = true, nullable = false)
	private long id;

	@OneToMany(mappedBy = "Magazines", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Equipment> equipments;
	
	//TODO: historia sprzętu - columny
	
	@Column(name = "magazinesName")
	@Size(min = 5, max = 100, message = "Nazwa nie może być krótsza niż 5 i dłuższa niż 100 znaków!")
	private String name;
	
	@Column(name = "openDate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date openDate;
	
	@Column(name = "closeDate")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date closeDate;
	
	
	@Column(name = "status")
	@Size(min = 2, max = 20)
	private String status;
	
	@Column(name = "description")
	@Size(min = 0, max = 2000)
	private String description;
	
	public Magazines() {
		
	}
	
	public Magazines(List<Equipment> equipments, String name, Date openDate, Date closeDate, String status, String description) {
		this.equipments = equipments;
		//TODO: historia sprzętu - konstruktor
		this.name = name;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.status = status;
		this.description = description;
	}
	
	public List<Equipment> getEquipments(){
		return equipments;
	}
	
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	
	//TODO: historia sprzętu - getery i setery
	
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
