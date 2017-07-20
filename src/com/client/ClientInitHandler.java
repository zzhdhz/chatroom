package com.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import javax.swing.*;

/**
 * @Author JamH
 * Created by form on 2017-07-20.
 */
public class ClientInitHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void ClientInitHandler(SocketChannel socketChannel) throws Exception{
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("stringD", new StringDecoder());
        pipeline.addLast("stringC", new StringEncoder());
        pipeline.addLast("http", new HttpClientCodec());
        pipeline.addLast("chat", new ChatHandler());
    }
}
