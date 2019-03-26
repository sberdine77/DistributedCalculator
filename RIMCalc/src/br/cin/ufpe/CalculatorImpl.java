package br.cin.ufpe;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements ICalculator {
	
	protected CalculatorImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public float sum (float a, float b) {
		return a + b;
	}
	@Override
	public float sub (float a, float b) {
		return a - b;
	}
	@Override
	public float div (float a, float b) {
		return a / b;
	}
	@Override
	public float mul (float a, float b) {
		return a * b;
	}
}
