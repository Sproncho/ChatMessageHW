package telran.chat.model;

import java.io.Serializable;
import java.time.LocalTime;

public class Message implements Serializable {

	private static final long serialVersionUID = 1757165535067914638L;
	String nickName;
	LocalTime time;
	String message;

	public String getNickName() {
		return nickName;
	}

	public LocalTime getTime() {
		return time;
	}

	public String getMessage() {
		return message;
	}

	public Message(String nickName, LocalTime time, String message) {
		this.nickName = nickName;
		this.time = time;
		this.message = message;
	}

	@Override
	public String toString() {
		return  nickName + " [" + time + "] " + message;
	}
}
