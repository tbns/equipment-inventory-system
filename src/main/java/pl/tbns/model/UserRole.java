package pl.tbns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Maciej Skowyra
 * @date Mar 27, 2015 1:35:32 PM
 */

@Entity
@Table(name = "user_role", 
			uniqueConstraints = @UniqueConstraint(
					columnNames = {"role", "login" }))
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userRole_id", unique = true, nullable = false)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "login", nullable = false)
	private User user;
	@Column(name = "role", nullable = false, length = 45)
	private String role;
	
		
	public UserRole() {
		}
		
	public UserRole(User user, String role) {
		this.user = user;
		this.role = role;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
