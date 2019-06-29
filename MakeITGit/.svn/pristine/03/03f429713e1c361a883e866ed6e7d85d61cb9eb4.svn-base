package searchRoom.view;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleNode;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

public class OptRoomFilterController implements Initializable {

	@FXML
	private JFXButton btnClose;

	@FXML
	private JFXToggleNode tnBed;

	@FXML
	private JFXToggleNode tnDesk;

	@FXML
	private JFXToggleNode tnTV;

	@FXML
	private JFXToggleNode tbAir;

	@FXML
	private JFXToggleNode tnRef;

	@FXML
	private JFXToggleNode tnStove;

	@FXML
	private JFXToggleNode tnWasher;

	@FXML
	private JFXToggleNode tbCloset;


	public void setOption(Map<String, Boolean> param) {
		tnBed.setSelected(param.get("bed"));
		tnDesk.setSelected(param.get("desk"));
		tnTV.setSelected(param.get("tv"));
		tbAir.setSelected(param.get("air"));
		tnRef.setSelected(param.get("ref"));
		tnStove.setSelected(param.get("stove"));
		tnWasher.setSelected(param.get("washer"));
		tbCloset.setSelected(param.get("closet"));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnClose.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				Map<String, Boolean> param = new HashMap<>();
				param.put("bed", tnBed.isSelected());
				param.put("desk", tnDesk.isSelected());
				param.put("tv", tnTV.isSelected());
				param.put("air", tbAir.isSelected());
				param.put("ref", tnRef.isSelected());
				param.put("stove", tnStove.isSelected());
				param.put("washer", tnWasher.isSelected());
				param.put("closet", tbCloset.isSelected());
				SearchRoomViewController.getInstance().setRoomFilter(param);;
				((Node) (event.getSource())).getScene().getWindow().hide();
			};
		});
	}
}
