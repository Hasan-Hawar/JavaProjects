package calculator;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote{

	double add(double x, double y)throws RemoteException;
}
