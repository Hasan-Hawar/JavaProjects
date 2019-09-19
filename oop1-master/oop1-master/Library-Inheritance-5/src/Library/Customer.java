package Library;


public class Customer {

	private String firstName;
	private String lastName;
	private String Email;
	private String account;

	public Customer(String firstName, String lastName, String Email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.account = account;
		this.Email = Email;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	

}
