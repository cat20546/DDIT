package member.mypage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import member.service.IMemberService;
import member.service.MemberServiceImpl;

public class ReceiveContractCellController implements Initializable {
	IMemberService service = MemberServiceImpl.getInstance();
	int room_id;
	
    @FXML
    private VBox vbCellContainer;
	
	@FXML
	private Label lbRealtorName;

	@FXML
	private JFXCheckBox cbContract;

	@FXML
	private Label lbRoomName;

	@FXML
	
	private Label lbRoomType;

	@FXML
	private Label lbRoomPrice;
	
	@FXML
	private ImageView ivRoom;
	
	private boolean sw = false;
	
	private Map<String, Object> map;
	
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	
	public VBox getContainer() {
		return vbCellContainer;
	}
	
	public void setCell(Map param) {
		lbRealtorName.setText(param.get("realtorName").toString());
		lbRoomName.setText(param.get("roomName").toString());
		lbRoomType.setText(param.get("roomType").toString());
		lbRoomPrice.setText(param.get("roomPrice").toString());
		ivRoom.setImage(new Image(param.get("img_uri").toString()));
		room_id = (int)param.get("room_id");
	}
	
	public int getRoomId() {
		return room_id;
	}
	
	public boolean isSelected() {
		return cbContract.isSelected();
	}
	
	public void setCbInvisible() {
		cbContract.setVisible(false);
		sw = true;
	}

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		vbCellContainer.setOnMouseClicked(e->{
			if(sw == false) {
				return;
			}
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("member/mypage/memberReview.fxml"));
				Parent parent = loader.load();
				MemberReviewController controller = loader.getController();
				controller.setRoomId(room_id);
				Stage stage = new Stage();
				stage.setScene(new Scene(parent));
				stage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
			
			
			
		});
	}
}
