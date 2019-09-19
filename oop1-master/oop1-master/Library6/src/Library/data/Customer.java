package Library.data;

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
		return "Customer [Email: " + Email + ", firstName: " + firstName + ", lastNam: " + lastName + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		return true;
	}


}
