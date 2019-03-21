import java.io.IOException;
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.StringTokenizer;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCalc {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DatagramSocket connectionSocket = new DatagramSocket(1313);
		//Socket connectionSocket = welcomeSocket.accept();
		//ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
		//ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
		
		byte[] buf = null; 
        DatagramPacket DpReceive = null; 
        DatagramPacket DpSend = null;
		
		//recvMsg = (String) inFromClient.readObject();
		
		buf = new byte[65535]; 
        DpReceive = new DatagramPacket(buf, buf.length); 
        connectionSocket.receive(DpReceive); 

        String recvMsg = new String(buf, 0, buf.length);
        recvMsg = recvMsg.trim();
		
		System.out.println(recvMsg);
		
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
		buf = respMsg.getBytes();
		
		int port = DpReceive.getPort(); 
		  
        DpSend = new DatagramPacket(buf, buf.length, 
                      InetAddress.getLocalHost(), port); 
        connectionSocket.send(DpSend);
		
	}
}
