package com.client.listener;

import com.client.ClientMain;
import com.client.window.RoomWindow;
import com.client.window.WindowController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by form on 2017-07-20.
 */
public class LoginListener implements ActionListener {

    private String ip;
    private String port;

    public void actionPerformed(ActionEvent event){
        ClientMain client = ClientMain.getInstance();
        JPanel panel = WindowController.getPanel();
        for(Component component : panel.getComponents()){
            String name = component.getName();
            if("ip".equals(name)){
                JTextField text = (JTextField)component;
                this.ip = text.getText();
            }else if("port".equals(name)){
                JTextField text = (JTextField)component;
                this.port = text.getText();
            }
        }

        client.config(ip, Integer.parseInt(port));
        new RoomWindow().open();
    }
}
