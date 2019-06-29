package member.mypage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.ReviewVO;

public class MemberReviewViewController implements Initializable {
	ImageView iv;
	ReviewVO rv;
	File file;
	IMemberService service = MemberServiceImpl.getInstance();

	@FXML
	private JFXTextField tfTitle;

    @FXML
    private JFXButton btnCommit;
    
    @FXML
    private JFXButton btnImg;
	
	@FXML
    private FlowPane fpCenterContainer;

	@FXML
	private Label lbDate;

	@FXML
	private JFXTextArea taContent;

	@FXML
	private VBox vbCenterContainer;

	@FXML
	void onImageClick(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"),
				new FileChooser.ExtensionFilter("PNG", "*.png"), new FileChooser.ExtensionFilter("GIF", "*.gif"));
		file = fileChooser.showOpenDialog(new Stage());
		if (file == null) {
			return;
		}
		if(iv == null) {
			iv = new ImageView();
			fpCenterContainer.getChildren().add(0, iv);
		}
		iv.setImage(new Image(file.toURI().toString()));
	}
	
	
	@FXML
    void onUpdateClick(ActionEvent event) {
		btnImg.setDisable(false);
		btnCommit.setDisable(false);
		taContent.setDisable(false);
		tfTitle.setDisable(false);
		taContent.setEditable(true);
		tfTitle.setEditable(true);
    }

    @FXML
    void onDeleteClick(ActionEvent event) {
    	service.deleteReview(rv.getReview_id());
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("니방내방");
		alert.setHeaderText("리뷰를 삭제합니다");
		alert.setContentText("성공적으로 게시된 리뷰를 삭제하였습니다.");
		alert.showAndWait();
		BoardDefaultController.getInstance().updateBoard();
		((Node)(event.getSource())).getScene().getWindow().hide();
    }


	@FXML
	void onCommitClick(ActionEvent event) {
		String title =  tfTitle.getText().trim();
		String content = taContent.getText().trim();
		StringBuffer sb = new StringBuffer("");
		if(title.isEmpty()) {
			sb.append("리뷰 제목\n");
		}
		if(content.isEmpty()) {
			sb.append("리뷰 내용\n");
		}
		
		
		if(sb.toString().isEmpty() == false) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("니방내방");
			alert.setHeaderText("Oops");
			alert.setContentText("입력하지 않은 내용이 있습니다!\n" + sb.toString());
			alert.showAndWait();
			return;
		}
		
		rv.setReview_title(title);
		rv.setReview_content(content);
		// 이미지 내부에 저장
		if(file!=null) {
			String a = file.getName();
			a = a.substring(a.lastIndexOf("."));
			
			try {
				String old_name = file.getAbsolutePath();
				String dbURI = "./src/res/review_img/img" + System.currentTimeMillis()+a;
				
				// src/aaa.txt 파일을 읽어서
				FileInputStream fin = new FileInputStream(old_name);
				// bbb.txt 파일로 복사합니다.
				FileOutputStream fout = new FileOutputStream(dbURI);
				
				int tmp = 0;
				while ((tmp = fin.read()) != -1) {
					fout.write(tmp);                
				}
				fin.close();
				fout.close();
				rv.setReview_img("file:"+dbURI);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		
		
		// DB에 리뷰를 저장
		service.updateReview(rv);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("니방내방");
		alert.setHeaderText("리뷰를 수정하였습니다.");
		alert.setContentText("니방내방에 리뷰를 달아주셔서 감사합니다.");
		alert.showAndWait();
		BoardDefaultController.getInstance().updateBoard();
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

	@FXML
	void onExitClick(ActionEvent event) {
		((Node)(event.getSource())).getScene().getWindow().hide();
	}
	
	public void setReviewVO(ReviewVO rv){
		this.rv=rv;
		lbDate.setText(rv.getReview_date().toString());
		tfTitle.setText(rv.getReview_title());
		taContent.setText(rv.getReview_content());
		if(rv.getReview_img() != null) {
			file = new File(rv.getReview_img());
			if(iv == null) {
				iv = new ImageView();
				fpCenterContainer.getChildren().add(0, iv);
			}
			iv.setImage(new Image(rv.getReview_img()));
		}
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
