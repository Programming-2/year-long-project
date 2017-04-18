package com.winfirst.graphics;

import com.winfirst.logging.Logger;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;
    private WindowListener exitListener;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        exitListener = new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {
                Logger.getInstance().close();
            }
        };
        createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.addWindowListener(exitListener);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }
}
