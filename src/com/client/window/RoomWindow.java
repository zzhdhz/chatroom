package com.client.window;

import com.client.ClientMain;
import com.client.listener.ChatListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by form on 2017-07-20.
 */
public class RoomWindow {

    public void open(){
        WindowController.dispose();
        JFrame frame = WindowController.getFrame();
        frame.setTitle("Chat Room");
        // Setting the width and height of frame
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = WindowController.getPanel();
        // 添加面板
        frame.add(panel);
        // 调用用户定义的方法并添加组件到面板
        placeComponents(panel);
        ClientMain client = ClientMain.getInstance();
        client.run();
        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JTextArea area = new JTextArea();
        area.setName("area");
        area.setForeground(Color.BLACK);
        area.setBounds(10,10,460,500);
        area.setEnabled(false);
        panel.add(area);

        JLabel label = new JLabel("输入:");
        label.setBounds(10,525,30,25);
        panel.add(label);

        JTextField message = new JTextField(20);
        message.setName("message");
        message.setBounds(50,525,400,25);
        message.addKeyListener(new ChatListener());
        panel.add(message);
    }
}
