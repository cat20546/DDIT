package member.mypage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import main.view.MainViewController;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.MemberVO;

public class MyReceiveContractController implements Initializable {
	List<ReceiveContractCellController> controllers;
	List<Map<String, Object>> receiveContractList;
	IMemberService service = MemberServiceImpl.getInstance();
	MemberVO currentMember;
	
	@FXML
    private VBox myContractReiciveContainer;

    @FXML
    private VBox vbCenterContainer;
    
    @FXML
    private VBox vbCenterContainer2;
    
    
    /**
     * 계약 삭제를 클릭
     * @param event
     */
    @FXML
    void onContractDeleteClick(ActionEvent event) {
    	StringBuffer sb = new StringBuffer();
    	for(int i = controllers.size()-1; i >= 0; i--) {
    		ReceiveContractCellController controller = controllers.get(i);
    		if(controller.isSelected()) {
    			// 체크박스를 클릭하였으면...
    			service.deleteContract(controller.getRoomId());
    			sb.append("방 : " +receiveContractList.get(i).get("room_name") + "\n");
    		}else {
    			continue;
    		}
    		if(sb.toString().isEmpty()) {
    			break;
    		}else {
    			sb.append("계약이 취소되었습니다.\n");
    			sb.append("니방내방을 이용해주셔서 감사합니다");
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("니방내방");
    			alert.setHeaderText("계약 결과");
    			alert.setContentText(sb.toString());
    			alert.showAndWait();
    			vbCenterContainer.getChildren().remove(i);
    			controllers.remove(i);
    			receiveContractList.remove(i);
    		}
    	}
    	
    	update();
    }
    
    
    @FXML
    void onContractClick(ActionEvent event) {
    	StringBuffer sb = new StringBuffer();
    	for(int i = controllers.size()-1; i >= 0; i--) {
    		ReceiveContractCellController controller = controllers.get(i);
    		if(controller.isSelected()) {
    			// 체크박스를 클릭하였으면...
    			Map<String, Object> param = new HashMap<>();
    			param.put("contract_id", (int) receiveContractList.get(i).get("contract_id"));
    			param.put("contract_period", 24);
    			param.put("contract_moving_in", new Date(Calendar.getInstance().getTime().getTime()));
    			param.put("contract_date", new Date(Calendar.getInstance().getTime().getTime()));
    			service.newContract(param);
    			
    			sb.append("방 : " +receiveContractList.get(i).get("room_name") + "\n");
    		}else {
    			continue;
    		}
    		if(sb.toString().isEmpty()) {
    			break;
    		}else {
    			sb.append("계약이 완료되었습니다.\n");
    			sb.append("니방내방을 이용해주셔서 감사합니다");
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("니방내방");
    			alert.setHeaderText("계약 결과");
    			alert.setContentText(sb.toString());
    			alert.showAndWait();
    			vbCenterContainer.getChildren().remove(i);
    			controllers.remove(i);
    			receiveContractList.remove(i);
    		}
    	}
    	
    	
    	update();
    }
    
    public void update() {
    	vbCenterContainer.getChildren().clear();
    	vbCenterContainer2.getChildren().clear();
    	receiveContractList = service.getReceiveContrace(currentMember.getMem_id());
		receiveContractAdapter(receiveContractList);
    }
    
    public VBox getCenterContainer() {
    	return vbCenterContainer;
    }
    
    public void receiveContractAdapter(List<Map<String, Object>> list) {
    	controllers = new ArrayList<>();
		try {
	    	for(Map<String, Object> map : list) {
	    		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("member/mypage/receiveContractCell.fxml"));
				Parent parent = loader.load();
				ReceiveContractCellController controller = loader.getController();
				
				Map param = new HashMap();
				param.put("realtorName", map.get("realtor_name"));
				param.put("roomName", map.get("room_name"));
				param.put("roomType", map.get("room_type"));
				param.put("roomPrice", map.get("room_price") + " 만원");
				param.put("img_uri", map.get("img_uri"));
				param.put("room_id", map.get("room_id"));
				controller.setCell(param);
				controllers.add(controller);
				vbCenterContainer.getChildren().add(parent);
	    	}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
		contractAdapter();
    }
    
    public void contractAdapter() {
    	List<Map<String, Object>> cList = service.getContract(currentMember.getMem_id());
    	try {
	    	for(Map<String, Object> map : cList) {
	    		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("member/mypage/receiveContractCell.fxml"));
				Parent parent = loader.load();
				ReceiveContractCellController controller = loader.getController();
				controller.setCbInvisible();
				Map param = new HashMap();
				param.put("realtorName", map.get("realtor_name"));
				param.put("roomName", map.get("room_name"));
				param.put("roomType", map.get("room_type"));
				param.put("roomPrice", map.get("room_price") + " 만원");
				param.put("img_uri", map.get("img_uri"));
				param.put("room_id", map.get("room_id"));
				controller.setCell(param);
				controller.setMap(map);
				vbCenterContainer2.getChildren().add(parent);
	    	}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		currentMember = MainViewController.getCurrentMember();
		receiveContractList = service.getReceiveContrace(currentMember.getMem_id());
		receiveContractAdapter(receiveContractList);
	}
}
