package Banksystem;

public class BankAccount 
{
	protected String accountNumber;
	protected double balance;
	protected double interest;
	protected double creditLimit;
	protected double dailyLimit;
	protected double currentDailyLimit;
	protected String pin;
/**
 * Bank Constructor 
 * @param accountNumber
 * @param balance
 * @param interest
 * @param creditLimit
 * @param dailyLimit
 * @param pin
 */
	public BankAccount(String accountNumber, double balance, double interest, double creditLimit, double dailyLimit , String pin)
	{
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interest = interest;
		this.creditLimit = creditLimit;
		this.dailyLimit = dailyLimit;
		this.currentDailyLimit = dailyLimit;
		this.pin = pin;
	}
/**
 * This method is implemented to add mony on the account
 * @param deposit
 */
	public void addMony(double deposit) 
	{
		balance += deposit;
	}
/**
 * This method is implemented to remove mony from the account by withdrawal 
 * but we can just with Daily Limit 
 * @param withtdrawal
 * @throws BankLimitException
 */
	public void removeMoney(double withtdrawal) throws BankLimitException
	{
		if(withtdrawal > currentDailyLimit)
			throw new BankLimitException("You hit your daily limit");
		else if((balance - withtdrawal) < creditLimit)
			throw new BankLimitException("You hit your credit limit");
		else
		{
			balance -= withtdrawal;
			currentDailyLimit -= withtdrawal;
		}
	}
/**
 * This method is implemented to calculate the Interest which will added on the account after a while (period)	
 */
	public void addInterest()
	{
		balance += (balance * interest);
	}
	
	/*
	public boolean hitOverdarfLimit() throws BankLimitException {
		if (balance < creditLimit) {
			throw new BankLimitException("your balance is Over");
		}
		return false;
	}

	public boolean hitDailyPayoutLimite(double payout, double payoff) throws BankLimitException {
		// pauout (was wir von der karte gerade beyahlen)
		if (balance >= DEFAULT_DAILY_LIMIT && payout <= DEFAULT_DAILY_LIMIT) {
			balance -= payout;
			return true;
		} else if (!(balance >= DEFAULT_DAILY_LIMIT && payout <= DEFAULT_DAILY_LIMIT)) {
			throw new BankLimitException("your daily limit is over");
		}
		// ------------------------------------------------------------
		// payoff (was wir von ATM abheben)
		else if (balance >= payoff && payoff >= DEFAULT_DAILY_LIMIT) {
			balance -= payoff;
			return true;
		} else if (!(balance >= payoff && payoff >= DEFAULT_DAILY_LIMIT)) {
			throw new BankLimitException("your balance is over");
		}
		return false;
	}
	
	public void transferMonyFrom(double transferAmount) {
		if (balance > creditLimit && (balance - transferAmount) > creditLimit) {
			balance -= transferAmount;
		}
	}
	
	public void tranferMonyTo(double transferAmount) {
		balance += transferAmount;
	}
	*/

	public String getNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}
	
	public double getDailyLimit()
	{
		return dailyLimit;
	}
	
	public double getCreditLimit()
	{
		return creditLimit;
	}

	public String getPin() {
		return pin;
	}
	
	public double getInterest()
	{
		return interest;
	}
	
	public void setPin(String pin)
	{
		this.pin = pin;
	}
}
