package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatController extends Thread {

	private Socket socket;
	private List<Socket> list = new ArrayList<Socket>();
	
	//					접속된 소켓			모든 소켓	
	public void ServerThread(Socket socket, List<Socket> list) {
		this.socket = socket;
		this.list = list;
	}	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			
			while(true) {
				// recv
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String msg = reader.readLine();	// recv
				
				System.out.println("클라이언트로부터 메시지:" + msg);
				
				Thread.sleep(100);				
			}		
		
		} catch (IOException e) {			
			System.out.println("연결끊김 IP:" + socket.getInetAddress()
					+ " Port:" + socket.getPort());
			
			list.remove(this.socket);
			
			// 남은 접속 클라이언트 확인
			for (Socket s: list) {
				System.out.println("-남은 클라이언트 IP:" + s.getInetAddress()
						+ " Port:" + s.getPort());
			}
			
			// 자신의 소켓을 해방
			try {
				socket.close();
			} catch (IOException e1) {				
				e1.printStackTrace();
			}	
			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
	}
	
	public void sendmsg(Socket sock,String textF) {
		// send					
				PrintWriter writer;
				try {
					writer = new PrintWriter(sock.getOutputStream());
					writer.println(textF);	// send
					writer.flush();	
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
}
