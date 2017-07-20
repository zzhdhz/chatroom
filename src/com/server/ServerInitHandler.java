package com.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by form on 2017-07-20.
 */
public class ServerInitHandler extends ChannelInitializer<SocketChannel>{
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("docode",new StringDecoder());
        pipeline.addLast("encode",new StringEncoder());
        pipeline.addLast("chat",new ServerChatHandler());

    }
}
