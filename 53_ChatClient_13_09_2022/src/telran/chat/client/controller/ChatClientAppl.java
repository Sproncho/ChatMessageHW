package telran.chat.client.controller;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import telran.chat.client.tasks.Receiver;
import telran.chat.client.tasks.Sender;

public class ChatClientAppl {

	public static void main(String[] args) {
		String serverAddres = "127.0.0.1";
		int port = 9000;
		try {
			Socket socket = new Socket(serverAddres, port);
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			Thread senderThread = new Thread(sender);
			Thread receiverThread = new Thread(receiver);
			receiverThread.setDaemon(true);
			receiverThread.start();
			senderThread.start();
//			senderThread.join();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
