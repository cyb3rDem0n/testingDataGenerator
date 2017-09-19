package it.senseisrl.mitiga.survey;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonModel {
	
	final static String path = "C://Developer//eclipse-workspace//questionarioCONTROMISURE_schema.txt";
    final static String arrayArrtibutesName = "probabilities";
	
	private String processId;
	private String state;
	private long createdOn;
	private String createdById;
	private String ownerId;
	private String ownerName;
	private String systemOwnerName;
	private String assetName;
	private JSONArray valueList;
	private String assetTypeName;
	
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedById() {
		return createdById;
	}
	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getSystemOwnerName() {
		return systemOwnerName;
	}
	public void setSystemOwnerName(String systemOwnerName) {
		this.systemOwnerName = systemOwnerName;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public JSONArray getValueList() {
		return valueList;
	}
	public void setValueList(JSONArray valueList) {
		this.valueList = valueList;
	}
	public String getAssetTypeName() {
		return assetTypeName;
	}
	public void setAssetTypeName(String assetTypeName) {
		this.assetTypeName = assetTypeName;
	}
	
	public JsonModel(String processId, String state, long createdOn, String createdById, String ownerId,
			String ownerName, String systemOwnerName, String assetName, JSONArray valueList, String assetTypeName) {
		this.processId = processId;
		this.state = state;
		this.createdOn = createdOn;
		this.createdById = createdById;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.systemOwnerName = systemOwnerName;
		this.assetName = assetName;
		this.valueList = valueList;
		this.assetTypeName = assetTypeName;
	}
	
	public JsonModel() {}

	@Override
	public String toString() {
		return "JsonModel" + ":" + "\n" +"- processId=" + processId  + "\n" + "- state=" + state  + "\n" + "- createdOn=" + createdOn  + "\n" + "- createdById="
				+ createdById  + "\n" + "- ownerId=" + ownerId  + "\n" + "- ownerName=" + ownerName  + "\n" + "- systemOwnerName="
				+ systemOwnerName  + "\n" + "- assetName=" + assetName  + "\n" + "- valueListsize=" + valueList.size()  + "\n" +"- assetTypeName=" + assetTypeName  +"\n";
	}
	
	public static JsonModel getJsonDetails(){
		JSONParser jsonParser = new JSONParser();
		JsonModel jsonModel = new JsonModel();
		try {
			Object jsonFromPath = jsonParser.parse(new FileReader(path));
			JSONObject jsonObject = (JSONObject) jsonFromPath;
				jsonModel.setProcessId((String) jsonObject.get("processId"));
				jsonModel.setState((String) jsonObject.get("state"));
				jsonModel.setCreatedOn((long) jsonObject.get("createdOn"));
				jsonModel.setCreatedById((String) jsonObject.get("createdById"));
				jsonModel.setOwnerId((String) jsonObject.get("ownerId"));
				jsonModel.setOwnerName((String) jsonObject.get("ownerName"));
				jsonModel.setSystemOwnerName((String) jsonObject.get("systemOwnerName"));
				jsonModel.setAssetName((String) jsonObject.get("assetName"));
				jsonModel.setValueList((JSONArray) jsonObject.get(arrayArrtibutesName));
				jsonModel.setAssetTypeName((String) jsonObject.get("assetTypeName"));
		}
			catch (Exception e) {
				e.printStackTrace();
		}
		
		return jsonModel;
	}

	public void checkState(JsonModel jsonModel) {
				if(jsonModel.getAssetTypeName().contentEquals("Software")) {
					System.out.println("actual type");
				}else if(jsonModel.getAssetTypeName().contentEquals("Hardware")) {
										System.out.println("other type -");
				}else if(jsonModel.getAssetTypeName().contentEquals("Hardware")) {
										System.out.println("other type *");
				}
	}
	
	public static JSONObject jsonFromModel(JsonModel jsonModel) {
		HashMap<String, Object> map= new HashMap<String, Object>();		
		
		map.put("processId", jsonModel.getProcessId());
		map.put("state",  jsonModel.getState());
		map.put("createdOn",  jsonModel.getCreatedOn());
		map.put("createdById",  jsonModel.getCreatedById());
		map.put("ownerId",  jsonModel.getOwnerId());
		map.put("ownerName",  jsonModel.getOwnerId());
		map.put("systemOwnerName", jsonModel.getSystemOwnerName());
		map.put("assetName",  jsonModel.getAssetName());
		map.put("arrayArrtibutesName",  jsonModel.getValueList());
		map.put("assetTypeName",  jsonModel.getAssetTypeName());
		
		JSONObject jsonObject = (JSONObject) map; 
		return jsonObject;
	}
	
	@SuppressWarnings("unchecked")
	public static FileWriter customJson(JsonModel jsonModel, int val1, String val2) throws IOException {
				
		JSONObject jsonObject = new JSONObject();
		
		final String editedTag = " -- edited" + val1 + val2;
		
		jsonObject.put("processId", jsonModel.getProcessId().toString() + editedTag);
		jsonObject.put("assetTypeName", jsonModel.getAssetTypeName() + editedTag);
		jsonObject.put("processId", jsonModel.getProcessId());
		jsonObject.put("state",  jsonModel.getState());
		jsonObject.put("createdOn",  jsonModel.getCreatedOn());
		jsonObject.put("createdById",  jsonModel.getCreatedById());
		jsonObject.put("ownerId",  jsonModel.getOwnerId());
		jsonObject.put("ownerName",  jsonModel.getOwnerId());
		jsonObject.put("systemOwnerName", jsonModel.getSystemOwnerName());
		jsonObject.put("assetName",  jsonModel.getAssetName());
		//jsonObject.put("arrayArrtibutesName",  jsonModel.getValueList());
		jsonObject.put("assetTypeName",  jsonModel.getAssetTypeName());
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(val1);
		jsonArray.add(val2);
		
		//jsonObject.put("aray", jsonArray);
		
			FileWriter file = new FileWriter("C://Developer//eclipse-workspace//testingDataGenerator//output.txt");
			
				try {
					file.write(jsonObject.toString());
					System.out.println("File writing completed \n");
		} catch (IOException e) {
			e.printStackTrace();
		}
			finally {
				file.flush();
				file.close();
			}
				
		return file;
	}
}
