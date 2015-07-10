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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class User implements Serializable{

	private static final long serialVersionUID = 1565658206459245534L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", unique = true, nullable = false)
	private long id;

	@Column(unique = true)
	private String login;
	private String password;
	private String first_name;
	private String last_name;
	private boolean status = true;
	private String email;
	private long mobilePhone;
	
	@ManyToMany
	@JoinTable
	private List<UserRole> userRole;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateCreate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateUpdate;
	
	@OneToMany(mappedBy = "sourceUser")
	private Set<TransmissionHistory> transmisHistFromSource = new HashSet<TransmissionHistory>();
	
	@OneToMany(mappedBy = "destUser")
	private Set<TransmissionHistory> transmisHistFormDest = new HashSet<TransmissionHistory>();	
	
	public User() {
	}

	public User(String login, String password, boolean status) {
		this.login = login;
		this.password = password;
		this.status = status;
	}

	public User(String login, String password, boolean status,List<UserRole> userRole) {
		this.login = login;
		this.password = password;
		this.status = status;
		this.userRole = userRole;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
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

	public Set<TransmissionHistory> getTransmisHistFromSource() {
		return transmisHistFromSource;
	}

	public void setTransmisHistFromSource(
			Set<TransmissionHistory> transmisHistFromSource) {
		this.transmisHistFromSource = transmisHistFromSource;
	}

	public Set<TransmissionHistory> getTransmisHistFormDest() {
		return transmisHistFormDest;
	}

	public void setTransmisHistFormDest(
			Set<TransmissionHistory> transmisHistFormDest) {
		this.transmisHistFormDest = transmisHistFormDest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((DateCreate == null) ? 0 : DateCreate.hashCode());
		result = prime * result
				+ ((DateUpdate == null) ? 0 : DateUpdate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + (int) (mobilePhone ^ (mobilePhone >>> 32));
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime
				* result
				+ ((transmisHistFormDest == null) ? 0 : transmisHistFormDest
						.hashCode());
		result = prime
				* result
				+ ((transmisHistFromSource == null) ? 0
						: transmisHistFromSource.hashCode());
		result = prime * result
				+ ((userRole == null) ? 0 : userRole.hashCode());
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
		User other = (User) obj;
		if (DateCreate == null) {
			if (other.DateCreate != null)
				return false;
		} else if (!DateCreate.equals(other.DateCreate))
			return false;
		if (DateUpdate == null) {
			if (other.DateUpdate != null)
				return false;
		} else if (!DateUpdate.equals(other.DateUpdate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id != other.id)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (mobilePhone != other.mobilePhone)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status != other.status)
			return false;
		if (transmisHistFormDest == null) {
			if (other.transmisHistFormDest != null)
				return false;
		} else if (!transmisHistFormDest.equals(other.transmisHistFormDest))
			return false;
		if (transmisHistFromSource == null) {
			if (other.transmisHistFromSource != null)
				return false;
		} else if (!transmisHistFromSource.equals(other.transmisHistFromSource))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}

	
		
	
}
