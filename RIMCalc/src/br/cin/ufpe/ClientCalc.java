package br.cin.ufpe;

import java.rmi.*;
import java.rmi.server.*;

public class ClientCalc {
	public static void main(String args[]) throws Exception {
		ICalculator calc = null;
		try {
			calc = (ICalculator) Naming.lookup("localhost/MyCalc");
			float res = calc.sum(3, 5);
			System.out.println("OI");
			System.out.println(res);
		} catch (RemoteException e){
			System.out.println(e.getMessage());
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
