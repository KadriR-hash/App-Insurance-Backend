package tn.enicarthage.springboot.Entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "T_users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(nullable = false, length = 20)
	private String name;

	@Column(nullable = false, unique = true, length = 30)
	private String email;

	@Column(nullable = false, length = 64)
	private String password;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@JsonManagedReference(value="user-enrollement")
	@OneToMany(mappedBy = "userc", cascade = CascadeType.ALL)
	private Set<Enrollement> Enrolls;

	public User() {

	}

	public User(Long id, String name, String email, String password, Role role, Set<Enrollement> Enrolls) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.Enrolls = Enrolls;
	}

	public Set<Enrollement> getEnrolls() {
		return Enrolls;
	}

	public void setEnrolls(Set<Enrollement> Enrolls) {
		this.Enrolls = Enrolls;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", Enrolls=" + Enrolls + "]";
	}

}
