package member.mypage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import vo.ReviewVO;

public class BoardCellController implements Initializable {
	@FXML
	private Label lbCategory;

	@FXML
	private Label lbName;

	@FXML
	private Label lbDate;

	@FXML
	private Label lbNo;

	@FXML
	private Label lbTitle;
	
	@FXML
    private AnchorPane boardCell;
	
	private ReviewVO rv;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		boardCell.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("member/mypage/memberReviewView.fxml"));
					Parent parent = loader.load();
					MemberReviewViewController controller = loader.getController();
					controller.setReviewVO(rv);
					Stage stage = new Stage();
					stage.setScene(new Scene(parent));
					stage.initStyle(StageStyle.UNDECORATED);
					stage.initModality(Modality.WINDOW_MODAL);
					stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				
			}
		});
	}
	
	public void setItem(ReviewVO rv, int no) {
		this.rv = rv;
		lbNo.setText(no+"");
		lbTitle.setText(rv.getReview_title());
		lbDate.setText(rv.getReview_date().toString());
		lbName.setText(rv.getMem_id());
		lbCategory.setText("리뷰");
	}
}
