package bc.blockchain.common.response;

import java.util.HashMap;
import java.util.Map;

import bc.blockchain.common.request.RequestType;

import com.alibaba.fastjson.JSONObject;

public class Response {
	private String code;
	private final Map<String, Object> header=new HashMap();
	private String content;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String toString(){
		return JSONObject.toJSONString(this);
	}
	public Map<String, Object> getHeader() {
		return header;
	}
	public void putHeader(RequestType refreshclient) {
		header.put("code", refreshclient);
	}
	
}
