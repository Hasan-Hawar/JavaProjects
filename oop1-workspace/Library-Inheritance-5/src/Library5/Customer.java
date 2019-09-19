package Library5;

public class Customer extends Person {

	private String Email;

	public Customer(String firstName, String lastName, String Email) {
		super(firstName, lastName);
		this.Email = Email;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	@Override
	public String toString() {
		return "Person:" + super.toString();
	}

}
