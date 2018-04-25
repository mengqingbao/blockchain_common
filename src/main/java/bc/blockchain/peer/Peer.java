package bc.blockchain.peer;

import io.netty.channel.Channel;
import io.netty.util.internal.StringUtil;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

public class Peer {
	
	private String address;
	private String ip;
	private Integer port;
	private Date liveTime;
	private String domain;
	private Channel channel;
	private String clientId;
	public Peer(String ip2, Integer port2, Date time) {
		this.ip=ip2;
		this.port=port2;
		this.liveTime=time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public Date getLiveTime() {
		return liveTime;
	}
	public void setLiveTime(Date liveTime) {
		this.liveTime = liveTime;
	}
	
	public String genId(){
		if(StringUtil.isNullOrEmpty(domain)){
			return ip+port;
		}
		return domain;
	}
	
	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
}
