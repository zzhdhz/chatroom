package com.client.listener;

import com.client.ClientMain;
import com.client.window.WindowController;
import io.netty.channel.Channel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by form on 2017-07-20.
 */
public class ChatListener implements KeyListener {
    private String message;

    public void keyPressed(KeyEvent event){
        if(KeyEvent.VK_ENTER == event.getKeyCode()){
            try{
                JPanel panel = WindowController.getPanel();
                for(Component component : panel.getComponents()){
                    String name = component.getName();
                    if("message".equals(name)){
                        JTextField message = (JTextField)component;
                        this.message = message.getText();
                        message.setText("");
                        break;
                    }
                }

                ClientMain client = ClientMain.getInstance();
                Channel channel = client.getChannel();
                if(!"".equals(message) && message != null){
                    channel.writeAndFlush(message);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void keyTyped(KeyEvent e){

    }
    public void keyReleased(KeyEvent e){

    }
}
