package siteInfo.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.view.MainViewController;
import vo.MemberVO;

public class MultiChatClientMain extends Application implements Initializable{
	
	private Label lbName;
	private TextArea taContent;
	private TextField taMessage;
	private Button btnSend;
	
	private Socket socket;
	private DataOutputStream dout;
	private String name = "대화명";

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("MultichatClient.fxml"));
		
		lbName = (Label) root.lookup("#lbname");
		btnSend = (Button) root.lookup("#btnSend");
		taContent = (TextArea) root.lookup("#taContent");
		taMessage = (TextField) root.lookup("#tfMessage");
		
		taMessage.setOnAction(e->{
			
			Thread serverThread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					try {
						dout = new DataOutputStream(socket.getOutputStream());
						
						if( dout != null) {
							//  메시지를 서버로 전송
							dout.writeUTF(name+"^"+taMessage.getText() );
							taMessage.clear();
						}
						
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
			});
			serverThread.start();
		});
		
		btnSend.setOnAction(e->{
			
			Thread serverThread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					try {
						dout = new DataOutputStream(socket.getOutputStream());
						if( dout != null) {
							//  메시지를 서버로 전송
							dout.writeUTF(name+"^"+taMessage.getText() );
							taMessage.clear();
						}
						
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
			});
			serverThread.start();
		});
		Scene scene = new Scene(root);

		primaryStage.setTitle("JavaFx MultiChatClient 프로그램");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		new Thread(new Runnable() { // 클라이언트 쓰레드 생성 및 스타트
			
			@Override
			public void run() {
				
				clientStart();  // 클라이언트 시작
			}
		}).start();
	}
	
	// 비지니스 로직 처리
	public void clientStart() {
		
		try {
			String serverIp = "127.0.0.1";
			socket = new Socket(serverIp, 7777);
			
			displayMessage("서버에 연결되었습니다.");
			
			// 대화명 전송하기
			dout = new DataOutputStream(socket.getOutputStream());
			if(dout != null) {
				dout.writeUTF(name);
			}
			
			// 수신용 쓰레드 생성
			ClientReceiver receiver = new ClientReceiver(socket);
			
			// 쓰레드 실행
			receiver.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 메시지를 전송하는 Thread
	class ClientSender extends Thread{
		Socket socket;
		DataOutputStream dout;
		String name;
		Scanner scan = new Scanner(System.in);
		
		public ClientSender(Socket socket, String name) {
			this.name = name;
			this.socket = socket;
			try {
				dout = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				// 시작하자 마자 자신의 대화명을 서버로 전송
				MemberVO currentMember = MainViewController.getCurrentMember();
				if(currentMember!=null) {
					name = currentMember.getMem_id();
				}else {
					name = "고객";
				}
				if(dout!=null) {
					dout.writeUTF(name);
				}
				while( dout != null) {
					// 키보드로 입력받은 메시지를 서버로 전송
					dout.writeUTF(name+"^"+scan.nextLine() );
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}  // 송신용 쓰레드 끝...,
	
	// 수신용 Thread 클래스 정의
	class ClientReceiver extends Thread{
		Socket socket;
		DataInputStream din;
		
		// 생성자
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				din = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(din!=null) {
				try {
					// 서버로부터 수신한 메시지 출력하기
					String msg = din.readUTF();
					
					displayMessage(msg);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Platform.runLater 를 이용한 메시지 처리
	 * @param msg
	 */
	public void displayMessage(final String msg) {
		Platform.runLater(()->{
			taContent.appendText(msg + "\n");
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
