package calculator;


public class CalculatorImpl implements Calculator{


	@Override
	public double add(double x, double y){
		// TODO Auto-generated method stub
		System.out.println("Adding" + x + "and "+ y);
		return x+y;
	}

}
