package com.client.window;

import com.client.listener.LoginListener;

import javax.swing.*;

import static java.awt.Component.RIGHT_ALIGNMENT;

/**
 * Created by form on 2017-07-20.
 */
public class LoginWindow {

    public void open(){
        JFrame frame = WindowController.getFrame();
        frame.setTitle("Login");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = WindowController.getPanel();
        panel.setName("panel");
        // 添加面板
        frame.add(panel);
        // 调用用户定义的方法并添加组件到面板
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /*
         * 设置布局为 null
         */
        panel.setLayout(null);

        JLabel ipLabel = new JLabel("ip:");
        ipLabel.setBounds(10,20,80,25);
        ipLabel.setAlignmentX(RIGHT_ALIGNMENT);
        panel.add(ipLabel);

        JTextField ipText = new JTextField(20);
        ipText.setBounds(100,20,165,25);
        ipText.setName("ip");
        ipText.setText("127.0.0.1");
        panel.add(ipText);

        JLabel portLabel = new JLabel("port:");
        portLabel.setBounds(10,50,80,25);
        portLabel.setAlignmentX(RIGHT_ALIGNMENT);
        panel.add(portLabel);

        JTextField portText = new JTextField(20);
        portText.setBounds(100,50,165,25);
        portText.setName("port");
        portText.setText("80");
        panel.add(portText);

        // 创建登录按钮
        JButton loginButton = new JButton("确定");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new LoginListener());
        loginButton.setAlignmentX(RIGHT_ALIGNMENT);
        panel.add(loginButton);
    }
}
