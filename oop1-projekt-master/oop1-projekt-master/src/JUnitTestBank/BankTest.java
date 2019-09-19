package JUnitTestBank;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Banksystem.BankAccount;
import Banksystem.BankLimitException;
import Banksystem.Customer;
import Banksystem.CustomerManager;
import Banksystem.PrivateAccount;

class BankTest {
	private static Customer customer;
	private static BankAccount[] BankAccount;
	private static Customer[] customer_1;
	private static String number1 = "0010000";
	private static String number2 = "0010001";
	private static String number3 = "0010002";
	private static String number4 = "0020003";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		BankAccount[0] = new PrivateAccount(number1, 1000, 0.5, -500, 1000, "1234");
		BankAccount[1] = new PrivateAccount(number2, 1100, 0.5, -500, 1000, "1235");
		BankAccount[2] = new PrivateAccount(number3, 1110, 0.5, -500, 1000, "1236");
		customer.addAccount(number1);
		customer.addAccount(number2);
		customer.addAccount(number3);
		customer_1[0] = new Customer("01", "john", "M", "123456");
		customer_1[1] = new Customer("02", "Kurt", "H", "654123");
		customer_1[2] = new Customer("03", "lukas", "D", "010101");

		customer.deleteAccount(number1);

	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void getAccountTest() {
		assertEquals(3, customer.getAccounts());

	}

	@Test
	void closeAccountTest() {
		customer.addAccount(number1);
		customer.addAccount(number2);
		customer.addAccount(number3);
		customer.deleteAccount(number1);
		assertEquals(customer.getAccountLength(), 2);
	}

	@Test
	void removeMonyTest() throws BankLimitException {
		BankAccount BankAccount = new PrivateAccount(number1, 1000, 0.05, -500, 1000, "1234");

		BankAccount.removeMoney(100);
		assertEquals(BankAccount.getBalance(), 900);
	}

	@Test
	void addMonyTest() {
		BankAccount BankAccount = new PrivateAccount(number2, 1100, 0.05, -500, 1000, "1235");
		BankAccount.addMony(200);
		assertEquals(BankAccount.getBalance(), 1300);
	}

	@Test
	void addInterest() {
		BankAccount BankAccount = new PrivateAccount(number3, 1110, 0.05, -500, 1000, "1236");
		BankAccount.addInterest();
		assertEquals(BankAccount.getBalance(), 1165.5);

	}

	@Test
	void changePasswordTest() throws IOException {

		CustomerManager customerManager = new CustomerManager();
		String UN = "01";
		String PW = "123456";
		Customer customer = new Customer(UN, "john", "M", PW);
		customerManager.changePassword(customer.getUsernumber(), "010101");
		assertNotEquals(UN, "010101");
	}

	@Test
	void removeAccountTest() throws IOException {
		customer.addAccount(number4);
		CustomerManager customerManager = new CustomerManager();
		customerManager.removeAccount(number4);
	}

}
