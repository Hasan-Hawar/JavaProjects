package calculator;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class CalculatorClient {

	public static void main(String[] args) throws Exception {
		
		Registry registry = LocateRegistry.getRegistry("localhost", 1234);
		Calculator stub = (Calculator) registry.lookup("Calculator");
		double result = stub.add(3.4, 2.7);
		System.out.println(result);
		}

}
