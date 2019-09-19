package Banksystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Starts the bank and binds the RMI to the registry.
 * @author Dmytriy Pelts
 * @version 1.0
 */

public class BankServer 
{	
	static int port = 1099;
	
	public static void main(String[] args) throws IOException, Exception
	{
		Bank bank = new Bank();
		UnicastRemoteObject.exportObject(bank, 0);
		Registry registry = LocateRegistry.createRegistry(port);
		registry.bind("IATM", bank);
		registry.bind("IEBanking", bank);
		registry.bind("ICustomerService", bank);

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		while(!br.readLine().equals("quit"))
		{
			continue;
        }
	}
}