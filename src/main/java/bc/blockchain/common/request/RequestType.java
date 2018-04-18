package bc.blockchain.common.request;

import io.netty.util.internal.StringUtil;

public enum RequestType {
	REG("REG"),HI("HI"),DISTORY("DISTORY"),HEARTBEAT("HEARTBEAT"),WRITE("WRITE"),CHECK("CHECK"), COMMON("COMMON"), EXCEPTION("EXCEPTION"), SETLOCALREMOTE("SETLOCALREMOTE"), REFRESHCLIENT("REFRESHCLIENT");
	private String type;

	RequestType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static RequestType getByCode(String code) {
		if (StringUtil.isNullOrEmpty(code)) {
			return getByCode("COMMON");
		}
		for (RequestType type : RequestType.values()) {
			if (type.getType().equals(code)) {
				return type;
			}
		}
		throw new IllegalArgumentException("非法的枚举参数：" + code);
	}

}
