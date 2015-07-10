package pl.tbns.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * @author Maciej Skowyra
 * @date Mar 27, 2015 1:35:32 PM
 */

@Entity
@Table(name = "roles")
public class UserRole implements Serializable{

	private static final long serialVersionUID = -6477317399322633507L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userRole_id", unique = true, nullable = false)
	private long id;
	@ManyToMany(mappedBy = "userRole")
	private List<User> users;
	@Column(name = "roles", nullable = false, length = 45)
	private String role;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setId(long id) {
		this.id = id;
	}
}