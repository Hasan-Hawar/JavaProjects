package calculator;

import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Calculator calculator = new CalculatorImpl();
		Calculator stub = (Calculator) UnicastRemoteObject.exportObject(calculator, 0);
		LocateRegistry.createRegistry(1234).bind("Calculator", stub);;
		
		}

}
