package br.cin.ufpe;
import java.rmi.Remote;

public interface ICalculator extends Remote{
	float sum (float a, float b) throws Exception;
	float sub (float a, float b) throws Exception;
	float div (float a, float b) throws Exception;
	float mul (float a, float b) throws Exception;
}
