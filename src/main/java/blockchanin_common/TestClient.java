package blockchanin_common;

import bc.blockchain.udp.netty.UdpClient;

public class TestClient {

	public static void main(String[] args) {
		UdpClient server=new UdpClient();
		server.run(12118);
	}

}
