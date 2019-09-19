package Banksystem;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Provides the basic remote functions for the CustomerService
 * 
 * @author Dmytriy Pelts
 *
 */

public interface ICustomerService extends Remote
{
	public String createCustomer(String firstname, String lastname, String password) throws RemoteException;
	public String createAccount(String userNumber, String accountData) throws IOException, RemoteException;
	public String changeCustomerPassword(String userNumber, String newPassword) throws IOException, RemoteException;
	public String changeAccountPin(String accountNumber) throws IOException, RemoteException;
	public String getCustomer(String userNumber) throws RemoteException;
	public String[] getAllCustomer() throws RemoteException;
	public void closeAccount(String accountNumber) throws IOException, RemoteException;
	public String depositMoney(String accountNumber, String amount) throws RemoteException;
	public String payoffMoney(String accountNumber, String amount) throws BankLimitException, RemoteException;
	public String getAccount(String accountNumber) throws RemoteException;
	public String[] getTransfers(String accountNumber) throws IOException, RemoteException;
	public void transferMoney(String accountFrom, String accountTo, String amount) throws BankLimitException, RemoteException;
}