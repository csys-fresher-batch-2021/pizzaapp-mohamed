package in.sikkandar.model;

public class User {
	private String name;
	private String email;
	private String mobile;
	private String address;
	private String password;
	private String confrimPassword;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfrimPassword() {
		return confrimPassword;
	}

	public void setConfrimPassword(String confrimPassword) {
		this.confrimPassword = confrimPassword;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", mobile=" + mobile + ", address=" + address + ", password="
				+ password + ", confrimPassword=" + confrimPassword + "]";
	}

	public User(String name, String email, String mobile, String address, String password, String confirmPassword) {

		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.password = password;
		this.password = confirmPassword;
	}

}
