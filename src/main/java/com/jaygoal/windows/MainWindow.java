/*
 * Created by JFormDesigner on Tue Aug 04 15:27:41 CST 2020
 */

package com.jaygoal.windows;

import java.awt.event.*;
import org.springframework.stereotype.Component;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
@Component
public class MainWindow extends JFrame {
    public MainWindow() {
        initComponents();
    }

    private void thisWindowClosing(WindowEvent e) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        label1 = new JLabel();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout());
        }
        contentPane.add(panel2, BorderLayout.WEST);

        //======== panel3 ========
        {
            panel3.setLayout(new BorderLayout());
        }
        contentPane.add(panel3, BorderLayout.EAST);

        //======== panel4 ========
        {
            panel4.setLayout(new BorderLayout());
        }
        contentPane.add(panel4, BorderLayout.SOUTH);

        //======== panel5 ========
        {
            panel5.setLayout(new BorderLayout());

            //---- label1 ----
            label1.setText("Personal Tool");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel5.add(label1, BorderLayout.NORTH);
        }
        contentPane.add(panel5, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
