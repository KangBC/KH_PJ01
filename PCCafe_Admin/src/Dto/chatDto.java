package Dto;

import java.net.Socket;

public class chatDto {
	private Socket sock;
	private int seatNum;

	public chatDto(Socket sock, int seatNum) {
		super();
		this.sock = sock;
		this.seatNum = seatNum;
	}

	public Socket getSock() {
		return sock;
	}

	public void setSock(Socket sock) {
		this.sock = sock;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public chatDto() {

	}
}