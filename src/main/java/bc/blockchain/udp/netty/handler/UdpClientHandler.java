package bc.blockchain.udp.netty.handler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sherry on 16/11/7.
 */
public class UdpClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {

	private Logger logger=LoggerFactory.getLogger(getClass());
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable e) throws Exception {
        logger.error(e.getMessage(),e);
        ctx.close();
    }

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg)
			throws Exception {
		String resp = msg.content().toString(CharsetUtil.UTF_8);
        if (resp.startsWith("谚语查询结果:")){
            logger.debug(resp);
            ctx.close();
        }
		
	}
}
