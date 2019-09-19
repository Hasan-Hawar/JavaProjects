package Library.data;

public class Writer extends Person {

	public Writer(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Writer) {
			Writer w = (Writer) obj;
			if (w.firstName != firstName)
				return false;
			if (w.lastName != lastName)
				return false;
			else
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Writer:" + super.toString();
	}

}
