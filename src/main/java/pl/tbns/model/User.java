/**
 * 
 */
package pl.tbns.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Maciej Skowyra
 * @date Mar 27, 2015 1:10:05 PM
 */
@Entity
@Table(name="users")
public class User {

	
	@Id
	@Column(name = "login", unique = true, nullable = false)	
	private String login;
	private String password;
	private String first_name;
	private String last_name;
	private boolean status = true;
	private String email;
	private long mobilePhone;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateCreate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateUpdate;
	
	public User() {
	}

	public User(String login, String password, boolean status) {
		this.login = login;
		this.password = password;
		this.status = status;
	}

	public User(String login, String password, boolean status,Set<UserRole> userRole) {
		this.login = login;
		this.password = password;
		this.status = status;
		this.userRole = userRole;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(long mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public Date getDateCreate() {
		return DateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		DateCreate = dateCreate;
	}

	public Date getDateUpdate() {
		return DateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		DateUpdate = dateUpdate;
	}
	
	
	
	
}
