package telran.chat.client.tasks;

import telran.chat.model.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalTime;

public class Sender implements Runnable {
	Socket socket;

	public Sender(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (Socket socket = this.socket) {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter your name:");
			String name = br.readLine();
			System.out.println("Please enter your message, or type exit for quit");
			String message = br.readLine();
			while (!"exit".equalsIgnoreCase(message)) {
				Message msg = new Message(name,LocalTime.now(),message);
				oos.writeObject(msg);
				message = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
