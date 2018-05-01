package com.toushin.IHDPS;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Report_Details extends JFrame{
        JPanel panel = new JPanel();
        JTable table = new JTable();
        //Object[] clms = {"Patient ID","Age","Gender","Chest Pain Type","Fasting Blood Sugger","Contact","Join","designation","salary"};
        DefaultTableModel mdl = new DefaultTableModel();
        com.mysql.jdbc.Connection conn=null;
        Statement st;
        ResultSet rs;
        PreparedStatement pst;
        
        Report_Details(){
            super("Patient Details");
            panel.setLayout(null);
            panel.setBackground(Color.LIGHT_GRAY);
            setVisible(true);
            setSize(1300, 610);
            setLocationRelativeTo(null);
            setResizable(false);
            add(panel);
            conn=DB.getConnection();
            addcomp();
            AutoLoad();
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            
            
            
        }
        private void addcomp(){
            JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 1300, 600);
        panel.add(pane);
        
        /*mdl.setColumnIdentifiers(clms);
        table.setModel(mdl);*/
        
        table.setBackground(Color.cyan);
        table.setForeground(Color.BLACK);
        table.setFont(table.getFont().deriveFont(10f));
        table.setRowHeight(50);
        }
    private void AutoLoad(){
        try{
                st = conn.createStatement();
                ResultSet Iditer = st.executeQuery("select * from tbTrainingDataSet");
                while (Iditer.next()) {
                   table.setModel(DbUtils.resultSetToTableModel(Iditer));
                }
                
            }
            catch(Exception efnm){
                JOptionPane.showMessageDialog(null, efnm.toString());
            }
    }

}
