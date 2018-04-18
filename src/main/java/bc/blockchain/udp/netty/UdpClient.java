package bc.blockchain.udp.netty;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bc.blockchain.udp.netty.handler.UdpClientHandler;
/**
 * 
 * @author mqb
 *
 */
public class UdpClient {

	private Logger logger=LoggerFactory.getLogger(getClass());
    public void run(int port) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                    .handler(new UdpClientHandler());


            Channel channel = bootstrap.bind(0).sync().channel();
            //向网段内的所有机器广播
            channel.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("谚语字典查询?", CharsetUtil.UTF_8), new InetSocketAddress("localhost", port))).sync();
            logger.info("发送完成");
            if (!channel.closeFuture().await(15000)) {
                logger.debug("查询超时");
            }



        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}