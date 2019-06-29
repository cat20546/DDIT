package owner.myRoom;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import owner.service.IRegistRoomService;
import owner.service.RegistRoomServiceImpl;
import roomInfo.service.RoomInfoServiceImpl;
import searchRoom.service.SearchRoomServiceImpl;
import vo.ContractVO;
import vo.RoomImgVO;
import vo.RoomVO;

public class OwnerRoomCellController implements Initializable {
	RoomVO currentRoom;
	
	IRegistRoomService service = RegistRoomServiceImpl.getInstance();
	
	// 기본, 계약대기, 계약완료 의 종류가 있다
	String contractInfo = "기본";
	
	
	@FXML
	private JFXCheckBox cbRoom;

	@FXML
	private Label lbRoomId;

	@FXML
	private ImageView ivRoomImg;

	@FXML
	private Text lbRoomAddr;

	@FXML
	private Label lbRoomTitle;

	@FXML
	private Label lbRoomTransacrtion;

	@FXML
	private Label lbRoomPrice;

	@FXML
	private Label lbViewCount;
	
    @FXML
    private Label lbContractInfo;

	@FXML
	private FlowPane fpRoomOptContainer;

	public void setRoomVO(RoomVO rv) {
		currentRoom = rv;
		setValue();
	}

	public RoomVO getCurrentRoom() {
		return currentRoom;
	}
	
	public boolean isChecked() {
		return cbRoom.isSelected();
	}
	
	/**
	 * 공실의 기본 정보를 세팅한다
	 */
	public void setValue() {
		lbRoomId.setText(currentRoom.getRoom_id() + "");
		RoomImgVO roomImg = SearchRoomServiceImpl.getInstance().getRoomImg(currentRoom.getRoom_id());
		ivRoomImg.setImage(new Image(roomImg.getImg_uri()));
		lbRoomAddr.setText(currentRoom.getRoom_addr1());
		lbRoomTitle.setText(currentRoom.getRoom_name());
		lbRoomTransacrtion.setText(currentRoom.getRoom_transaction());
		lbRoomPrice.setText(currentRoom.getRoom_price() + "/" + currentRoom.getRoom_deposit());
		lbViewCount.setText(RoomInfoServiceImpl.getInstance().getRoomView(currentRoom.getRoom_id()) + "");
		// 에어컨
		if (currentRoom.getOpt_airconditioner() == 1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(40);
			iv.setFitWidth(40);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_aircon.png"));
			fpRoomOptContainer.getChildren().add(iv);
		}
		// 침대
		if (currentRoom.getOpt_bed() == 1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(40);
			iv.setFitWidth(40);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_bed.png"));
			fpRoomOptContainer.getChildren().add(iv);
		}
		// 옷장
		if (currentRoom.getOpt_closet() == 1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(40);
			iv.setFitWidth(40);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_closet.png"));
			fpRoomOptContainer.getChildren().add(iv);
		}
		// 책상
		if (currentRoom.getOpt_desk() == 1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(40);
			iv.setFitWidth(40);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_desk.png"));
			fpRoomOptContainer.getChildren().add(iv);
		}
		// 주차여부
		if (currentRoom.getOpt_parking_lot() == 1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(40);
			iv.setFitWidth(40);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_parking.png"));
			fpRoomOptContainer.getChildren().add(iv);
		}
		// 냉장고
		if (currentRoom.getOpt_refregerator() == 1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(40);
			iv.setFitWidth(40);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_refrigerator.png"));
			fpRoomOptContainer.getChildren().add(iv);
		}
		// 가스레인지
		if (currentRoom.getOpt_stove() == 1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(40);
			iv.setFitWidth(40);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_stove.png"));
			fpRoomOptContainer.getChildren().add(iv);
		}

		// TV
		if (currentRoom.getOpt_tv() == 1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(40);
			iv.setFitWidth(40);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_tv.png"));
			fpRoomOptContainer.getChildren().add(iv);
		}
		// 베란다
		if (currentRoom.getOpt_veranda() == 1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(40);
			iv.setFitWidth(40);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_veranda.png"));
			fpRoomOptContainer.getChildren().add(iv);
		}
		
		// 계약 상태를 확인한다
		ContractVO cv = service.isContract(currentRoom.getRoom_id());
		
		
		// null이면 계약요청 없음
		if(cv == null) {
			lbContractInfo.setText("  ");
			return;
		}else if(cv.getContract_moving_in() == null){
			// 계약 대기중
			lbContractInfo.setText("  계약 대기중");
			lbContractInfo.setVisible(true);
			lbContractInfo.getStylesheets().add("-fx-background-color: #FAAC58");
			contractInfo = "계약대기";
		}else {
			// 계약 완료
			lbContractInfo.setText("  계약 완료");
			lbContractInfo.setVisible(true);
			lbContractInfo.setStyle("-fx-background-color: #0080FF; -fx-text-fill: #FFFFFF");
			contractInfo = "계약완료";
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
