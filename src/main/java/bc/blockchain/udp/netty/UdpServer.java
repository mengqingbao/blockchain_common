package bc.blockchain.udp.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bc.blockchain.udp.netty.handler.UdpServerHandler;

public class UdpServer {
	
	private Logger logger=LoggerFactory.getLogger(getClass());
    public void run(int port){
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST,true)
                    .handler(new UdpServerHandler());
            bootstrap.bind(port).sync().channel().closeFuture().await();
        } catch (InterruptedException e) {
            logger.error(e.getMessage(),e);
        }finally {
        	logger.info("管理服务器");
            eventLoopGroup.shutdownGracefully();
        }
    }
}
