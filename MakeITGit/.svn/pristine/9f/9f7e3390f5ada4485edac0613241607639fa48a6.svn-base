package siteInfo.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class MultiChatServerMain extends Application {

	// 대화명, 클라이언트의 Socket을 저장하기 위한 Map 변수 선언
	private Map<String, Socket> clients = Collections.synchronizedMap(new HashMap<String, Socket>()); // 동기화 처리가 가능하도록 Map객체 생성
	
	private Button btnStart;
	private TextArea taContent;
	private boolean isServerStopped;
	private ServerSocket serverSocket;

	@Override
	public void start(Stage primaryStage) throws Exception {


		Parent root = FXMLLoader.load(getClass().getResource("MultichatServer.fxml"));

		btnStart = (Button) root.lookup("#btnStart");
		taContent = (TextArea) root.lookup("#taContent");
		
		btnStart.setOnAction(e->{
			
			if(btnStart.getText().equals("서버시작")) {	
				
				Thread serverThread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						serverStart();
					}
				});
				
				serverThread.start();

				btnStart.setText("서버중지");
				
				isServerStopped = false;
				
			}else if(btnStart.getText().equals("서버중지")) {
				
				stopServer();
				
				btnStart.setText("서버시작");
				
				isServerStopped = true;
			}
		});

		Scene scene = new Scene(root);

		primaryStage.setTitle("JavaFx MultiChatServer 프로그램");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	
	// 비지니스 로직을 처리하는 메서드
	public void serverStart() {
		
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(7777);

			displayMessage("서버가 시작되었습니다.");

			while (!isServerStopped) {
				// 클라이언트의 접속을 대기한다.
				socket = serverSocket.accept();

				displayMessage("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속하였습니다.");

				// 메시지 전송 처리를 하는 쓰레드 생성 및 실행
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 서버소켓 닫기
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * 서버 중지
	 */
	public void stopServer() {
		
		// Map에 저장된 유저의 대화명 리스트 추출(key값 구하기)
		Iterator<String> it = clients.keySet().iterator();
		while (it.hasNext()) {
			try {
				String name = it.next(); // 대화명(key값) 구하기
				
				clients.get(name).close(); // 소켓닫기
				clients.remove(name); // 맵에서 삭제

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		if(serverSocket != null && !serverSocket.isClosed()) {
			try {
				serverSocket.close(); // 서버 소켓 닫기
				
				displayMessage("서버가 중지되었습니다.");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	// 서버에서 클라이언트로 메시지를 전송할 Thread를 Inner클래스로 정의
	// Inner클래스에서는 부모 클래스의 멤버들을 직접 사용할 수 있다.
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream din;
		DataOutputStream dout;

		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				// 수신용
				din = new DataInputStream(socket.getInputStream());
				// 송신용
				dout = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			String name = "";
			try {
				// 서버에서는 클라이언트가 보내는 최초의 메시지 즉, 대화명을
				// 수신해야 한다.
				name = din.readUTF();

				// 대화명을 받아서 다른 모든 클라이언트에게 대화방
				// 참여 메시지를 보낸다.
				sendToAll("#" + name + "님이 입장했습니다.");

				// 대화명과 소켓정보를 Map에 저장한다.
				clients.put(name, socket);
				displayMessage("#" + name + "님이 입장했습니다.");
				displayMessage("현재 서버 접속자 수는 " + clients.size() + "명 입니다." );
				
				// 이 후의 메시지 처리는 반복문으로 처리한다.
				// 한 클라이언트가 보낸 메시지를 다른 모든 클라이언트에게
				// 보내준다.
				while (din != null) {
					sendToAll(din.readUTF());
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// 이 finally영역이 실행된다는 것은 클라이언트의 접속이
				// 종료되었다는 의미이다.
				
				sendToAll(name + "님이 나가셨습니다.");
				
				// Map에서 해당 대화명을 삭제한다.
				clients.remove(name);
				
				displayMessage("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속을 종료했습니다.");
				displayMessage("현재 접속자 수는 " + clients.size() + "명 입니다.");
			}
		}
	}
	
	// 대화방 즉, Map에 저장된 전체 유저에게 메시지를 전송하는 메서드
	public void sendToAll(String msg) {
		// Map에 저장된 유저의 대화명 리스트 추출(key값 구하기)
		Iterator<String> it = clients.keySet().iterator();
		while (it.hasNext()) {
			try {
				String name = it.next(); // 대화명(key값) 구하기

				// 대화명에 해당하는 Socket의 OutputStream객체 구하기
				DataOutputStream out = new DataOutputStream(clients.get(name).getOutputStream());
				out.writeUTF(msg); // 메시지 보내기

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void displayMessage(final String msg) {
		Platform.runLater(()->{
			taContent.appendText(msg + "\n");
		});
	}
}
