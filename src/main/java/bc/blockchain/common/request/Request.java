package bc.blockchain.common.request;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import bc.blockchain.message.BcConstrant;
import bc.blockchain.util.PcWifiMac;

public class Request {
	
	private final Map<String, Object> header=new HashMap();
	
	private String requestId;
	
	
	private final Map<String,Object> data =new HashMap();
	private String clientId;
	
	private String code;
	
	private String content;
	
	private Date time;
	
	private String sign;
	
	private String targetId;
	
	private RequestType requestType;
	public Request() {
	}
	public Request(RequestType requestType) {
		this.setrequestType(requestType);
		this.putHeader(requestType);
		PcWifiMac mac=new PcWifiMac();
		clientId=mac.getLocalMac();
	}

	public String getClientId() {
		return new PcWifiMac().getLocalMac();
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Map<String, Object> getHeader() {
		return header;
	}

	public RequestType getrequestType() {
		return RequestType.getByCode((String)header.get(BcConstrant.HEADER_CODE));
	}

	public void setrequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public void putHeader(RequestType refreshclient) {
		header.put("code", refreshclient);
	}
	public String toString(){
		return JSONObject.toJSONString(this);
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Map<String, Object> getData() {
		return data;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	
	
	
}
