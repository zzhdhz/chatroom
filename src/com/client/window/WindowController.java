package com.client.window;

import javax.swing.*;

/**
 * Created by form on 2017-07-20.
 */
public class WindowController {
    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();

    public static JFrame getFrame(){
        return frame;
    }
    public static JPanel getPanel(){
        return panel;
    }
    public static void dispose() {
        frame.dispose();
        frame = new JFrame();
        panel = new JPanel();
    }
}
