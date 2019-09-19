package Banksystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Provides the basic remote functions for the ATM
 * 
 * @author Dmytriy Pelts
 *
 */
public interface IATM extends Remote
{	
	public String payoffMoney(String accountNumber, String amount) throws BankLimitException, RemoteException;
	public String loginATM(String accountNumber, String pin) throws RemoteException;
}
