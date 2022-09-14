package telran.chat.client.tasks;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver implements Runnable {
	Socket socket;

	public Receiver(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (Socket socket = this.socket) {
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			while (true) {
				String message = ois.readObject().toString();
				System.out.println(message);
			}
		} catch (IOException e) {
			System.out.println("Connection to server: " + socket.getInetAddress() + ":" + socket.getPort() + " closed");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
