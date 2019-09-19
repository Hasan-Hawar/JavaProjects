package Banksystem;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConsoleManager {

  public static void main(String[] args) throws Exception {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    ICustomerService ics = (ICustomerService) registry.lookup("ICustomerService");
    Console admin = new Console(ics);
    admin.mainView();
  
    

  }


}


