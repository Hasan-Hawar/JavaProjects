package Banksystem;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Provides the basic remote functions for the EBanking
 * 
 * @author Dmytriy Pelts
 *
 */

public interface IEBanking extends Remote {
	public String loginEBanking(String customerNumber, String password) throws RemoteException;
	public String getAccount(String accountNumber) throws RemoteException;
	public String[] getTransfers(String accountNumber) throws IOException, RemoteException;
	public void transferMoney(String accountFrom, String accountTo, String amount) throws BankLimitException, RemoteException;
}
