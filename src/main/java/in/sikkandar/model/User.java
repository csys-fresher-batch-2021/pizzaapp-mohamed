package in.sikkandar.model;

public class User {

	public User() {
		// Default Constructor
	}

	/**
	 * set a all thing in in private
	 */
	private String name;
	private String email;
	private long mobile;
	private String address;
	private String password;
	private String confrimPassword;
	private Integer userid;

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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * set all variables in to-string method
	 */

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", address="
				+ address + ", password=" + password + ", confrimPassword=" + confrimPassword + "]";
	}

}
