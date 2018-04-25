package bc.blockchain.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class PcWifiMac {
	public String getLocalMac(){
		InetAddress ia;
		try {
			ia = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			return "";
		}
		// TODO Auto-generated method stub
		//获取网卡，获取地址
		byte[] mac;
		try {
			mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
		} catch (SocketException e) {
			return "";
		}
		//System.out.println("mac数组长度："+mac.length);
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<mac.length; i++) {
//			if(i!=0) {
//				sb.append("-");
//			}
			//字节转换为整数
			int temp = mac[i]&0xff;
			String str = Integer.toHexString(temp);
			//System.out.println("每8位:"+str);
			if(str.length()==1) {
				sb.append("0"+str);
			}else {
				sb.append(str);
			}
		}
		//System.out.println("本机MAC地址:"+sb.toString().toUpperCase());
		return sb.toString().toUpperCase();
	}
}
