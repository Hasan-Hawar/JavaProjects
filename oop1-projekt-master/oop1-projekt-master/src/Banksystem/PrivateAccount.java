package Banksystem;

public class PrivateAccount extends BankAccount 
{
/**
 * This class is inheritanced from BankAccount and have to implement the methods which wrote in BankAccount class 
 * @param accountNumer
 * @param balance
 * @param interest
 * @param creditLimit
 * @param dailyLimit
 * @param pin
 */
	
	public PrivateAccount(String accountNumer, double balance, double interest, double creditLimit, double dailyLimit, String pin)
	{
		super(accountNumer, balance, interest, creditLimit, dailyLimit, pin);
	}
	
	/*
	@Override
	public boolean removeMony(double withdrawal) throws BankLimitException {

		if (balance > DEFAULT_CREDIT_LIMIT) {
			balance -= withdrawal;
			return true;
		} else if (!(balance > DEFAULT_CREDIT_LIMIT)) {
			throw new BankLimitException("your balance is over");
		}
		// ------------------------------------------------------
		if (balance >= withdrawal && withdrawal <= DEFAULT_DAILY_LIMIT) {
			balance -= withdrawal;
		} else if (!(balance >= withdrawal && withdrawal <= DEFAULT_DAILY_LIMIT)) {
			throw new BankLimitException("your daily limit is over");
		}
		// ---------------Was wir von ATM abheben------------
		if (balance >= withdrawal && withdrawal > DEFAULT_CREDIT_LIMIT) {
			balance -= withdrawal;
			return true;

		} else if (!(balance >= withdrawal && withdrawal > DEFAULT_CREDIT_LIMIT)) {
			throw new BankLimitException("your balance is over");
		}
		return false;
	}

	@Override
	public boolean hitOverdarfLimit() throws BankLimitException {
		if (balance < DEFAULT_CREDIT_LIMIT) {
			throw new BankLimitException("your balance is Over");
		}
		return false;
	}

	@Override
	public void transferMonyFrom(double transferAmount) {
		if (balance > DEFAULT_CREDIT_LIMIT && (balance - transferAmount) > DEFAULT_CREDIT_LIMIT) {
			balance -= transferAmount;
		}
	}
	 */
}
