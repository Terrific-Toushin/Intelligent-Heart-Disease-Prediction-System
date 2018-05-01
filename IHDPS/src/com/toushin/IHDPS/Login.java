package com.toushin.IHDPS;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    
    ImageIcon img = new ImageIcon("image/background.jpg");
    JLabel JBG = new JLabel(img);
    String color500_ = " #9e9e9e";
    JPanel panel = new JPanel();
    JLabel usr_name = new JLabel("User Name :");
    JTextField usrtext = new JTextField(25);
    JLabel password = new JLabel("Password :");
    JPasswordField passf = new JPasswordField(25);
    JButton loginb = new JButton("Login");
    Connection con=null;
    Statement st;
    ResultSet rs;

    Login() {
        super("Admin Login");
        panel.setBackground(Color.white);
        panel.setLayout(null);
        setSize(466, 438);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setLocationRelativeTo(null);
        setResizable(false);
        addcomp();
        con=DB.getConnection();
    }

    private void addcomp() {

        
        usr_name.setBounds(17, 100, 120, 30);
        panel.add(usr_name);
        usr_name.setFont(usr_name.getFont().deriveFont(15f));

        usrtext.setBounds(110, 100, 160, 30);
        panel.add(usrtext);
        usrtext.setFont(usrtext.getFont().deriveFont(15f));

        password.setBounds(25, 160, 120, 30);
        panel.add(password);
        password.setFont(password.getFont().deriveFont(15f));

        passf.setBounds(110, 160, 160, 30);
        panel.add(passf);
        passf.setFont(passf.getFont().deriveFont(15f));

        loginb.setBounds(150, 220, 90, 30);
        panel.add(loginb);
        loginb.setFont(loginb.getFont().deriveFont(15f));
        loginb.addActionListener(this);
        
        JBG.setBounds(0, 0, 466, 438);
        panel.add(JBG);

    }

    public static void main(String[] args) {
        Login ob = new Login();

    }

        public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginb) {
            boolean c = false;
            if (usrtext.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Provide User Name");

            } else if (passf.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Provide User Password");

            } else {

                
                try {
                    
                    String query="select * from login where username='"+usrtext.getText()+"'"
                      +"&& password='"+passf.getText()+"'";
                    st = con.createStatement();
                    rs = st.executeQuery(query);
                    rs.next();
                    String name = rs.getString("username");
                    String password = rs.getString("password");

                    if (usrtext.getText().equals(name) && passf.getText().equals(password)) {
                        c = true;
                            new IHDP();
                            dispose();

                    } 
                    else {

                            JOptionPane.showMessageDialog(null, "Provide correct Name and password");

                    }
                    

                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }

            }

        }
    }
    
}
