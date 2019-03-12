import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCalc {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket welcomeSocket = new ServerSocket(1313);
		Socket connectionSocket = welcomeSocket.accept();
		ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
		ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
		
		String recvMsg = null;
		recvMsg = (String) inFromClient.readObject();
		
		CalcImplementation calculator = new CalcImplementation();
		float r = 0;
		String opName = recvMsg.substring(0, 3);
		String[] pars = recvMsg.substring(recvMsg.indexOf("(") + 1, recvMsg.indexOf(")")).split(",");
		float a = Float.parseFloat(pars[0]);
		float b = Float.parseFloat(pars[1]);
		
		if (opName.equals("sub")) {
			r = calculator.sub(a, b);
		} else if (opName.equals("sum")) {
			r = calculator.sum(a, b);
		} else if (opName.equals("div")) {
			r = calculator.div(a, b);
		} else if (opName.equals("mul")) {
			r = calculator.mul(a, b);
		}
		
		String respMsg = Float.toString(r);
		outToClient.writeObject(respMsg);
		outToClient.flush();
		
		connectionSocket.close();
		welcomeSocket.close();
		outToClient.close();
		inFromClient.close();
	}
}
