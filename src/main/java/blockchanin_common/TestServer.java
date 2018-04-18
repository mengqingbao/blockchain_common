package blockchanin_common;

import bc.blockchain.udp.netty.UdpServer;

public class TestServer {

	public static void main(String[] args) {
		UdpServer server=new UdpServer();
		server.run(12118);
	}

}
