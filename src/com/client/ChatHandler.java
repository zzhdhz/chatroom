package com.chatroom.io.client;

import com.chatroom.swing.window.WindowController;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import javax.swing.*;
import java.awt.*;

/**
 * @Author JamH
 * Created by form on 2017-07-20.
 */
public class ClientChatHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String str) throws Exception{
        JPanel panel = WindowController.getPanel();
        Component[] components = panel.getComponents();
        for(Component component : components){
            if("area".equals(component.getName())){
                JTextArea area = (JTextArea)component;
                area.setText(area.getText() + str);
            }
        }
    }
}
