
public class BankAccount {

	int accountNumber;
	int pin;
	String IbanAccount;
	String content;

	public BankAccount(int accountNumber, int pin, String IbanAccount) {
		// TODO Auto-generated constructor stub
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.IbanAccount = IbanAccount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public int getPin() {
		return pin;
	}

	public String getIbanAccount() {
		return IbanAccount;
	}

	public String getContent() {
		return getAccountNumber() + " " + getPin() + " " + getIbanAccount();
	}

}
