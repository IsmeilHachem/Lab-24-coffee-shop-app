package co.grandcircus.coffeeshopapp.entity;

public class User {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;

	public User() {
	}

	public User(Long id, String firstName, String lastName, String userName, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", firstname=" + firstName + ", lastname=" + lastName + ", username=" + userName
				+ ", password=" + password + "]";
	}
	
	

}