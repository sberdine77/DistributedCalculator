import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientCalc {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Socket clientSocket = new Socket("localhost", 1313);
		ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
		ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
		
		outToServer.writeObject("div(6,3)");
		outToServer.flush();
		
		String repMsg = null;
		repMsg = (String) inFromServer.readObject();
		
		System.out.println(">>>" + repMsg);
		
		clientSocket.close();
		outToServer.close();
		inFromServer.close();
	}
}
