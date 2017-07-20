package com.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author JamH
 * Created by form on 2017-07-20.
 */
public class ClientMain {

    private static ClientMain client = new ClientMain();
    private String ip;
    private int port;
    private Channel channel;

    public static ClientMain getInstance() {
        return client;
    }

    public void config(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public Channel getChannel() {
        return channel;
    }

    public void run(){
        EventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ClientInitHandler());
        try {
            this.channel = bootstrap.connect(ip, port).sync().channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
