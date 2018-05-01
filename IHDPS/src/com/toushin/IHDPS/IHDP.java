package com.toushin.IHDPS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class IHDP extends JFrame implements ActionListener{
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    ImageIcon img = new ImageIcon("image/IHDP.jpg");
    JLabel lblimg = new JLabel(img);
    JLabel lblname = new JLabel("Intelligent Heart Disease Prediction System");
    JPanel panel = new JPanel();
    JButton btnquick_test = new JButton("", new ImageIcon("image/Test.jpg"));
    JButton btnadd_patient = new JButton("Add Patient", new ImageIcon("image/patient.jpg"));
    JButton btntest_report = new JButton("", new ImageIcon("image/Report.jpg"));
    JButton btndetails = new JButton("", new ImageIcon("image/Details.jpg"));
    Connection con=null;
    Statement st;
    ResultSet rs;
    
    JMenu Patient,Reports,Help,Exit;
    JMenuItem itm_add,Quick_test,Patient_Report;
    JMenuItem itm_allowance,itm_deduction,itm_usalary,itm_payment,itm_upslr;
    JMenuItem itm_empdetails,itm_paids,itm_nets;
    JMenuItem itm_manual,itm_logout;
    
    JMenuBar mb;
    IHDP(){
        super("Intelligent Heart Disease Prediction System");
        this.con=con;
        panel.setLayout(null);
        add(panel);
        setSize(dim);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        addcomp();
        
        con=DB.getConnection();
        panel.setBackground(Color.WHITE);
        addmenu();
    }
    void addmenu(){
        mb=new JMenuBar();
        Patient=new JMenu("Patient");
        
        itm_add=new JMenuItem("Add Patient",new ImageIcon("images/Regis.png"));
        itm_add.setAccelerator(KeyStroke.getKeyStroke('A',Event.CTRL_MASK));
        itm_add.addActionListener(this);
        Patient.add(itm_add);
        Patient.addSeparator();
        
        Quick_test=new JMenuItem("Quick Test",new ImageIcon("images/Regis.png"));
        Quick_test.setAccelerator(KeyStroke.getKeyStroke('Q',Event.CTRL_MASK));
        Quick_test.addActionListener(this);
        Patient.add(Quick_test);
        Patient.addSeparator();
        
        Patient_Report=new JMenuItem("Patient Report",new ImageIcon("images/Regis.png"));
        Patient_Report.setAccelerator(KeyStroke.getKeyStroke('R',Event.CTRL_MASK));
        Patient_Report.addActionListener(this);
        Patient.add(Patient_Report);
        Patient.addSeparator();
        
        /*m_payroll.add(itm_allowance);
        m_payroll.add(itm_deduction);
        m_payroll.add(itm_usalary);
        m_payroll.add(itm_payment);
        m_payroll.add(itm_upslr);*/
        
        
        Help=new JMenu("Help");
        itm_manual=new JMenuItem("User manual",new ImageIcon("images/Regis.png"));
        itm_manual.addActionListener(this);
        
        
        Help.add(itm_manual);
        
        
        Exit=new JMenu("Exit");
        itm_logout=new JMenuItem("logout",new ImageIcon("images/Regis.png"));
        itm_logout.addActionListener(this);
        
        Exit.add(itm_logout);
        
        mb.add(Patient);
        mb.add(Help);
        mb.add(Exit);
        setJMenuBar(mb);
         

    }

    private void addcomp() {
        
        lblname.setBounds(400, 0, 950, 45);
        panel.add(lblname);
        lblname.setFont(lblname.getFont().deriveFont(38f));
        
        btnquick_test.setBounds(1000, 150, 210, 70);
        panel.add(btnquick_test);
        btnquick_test.addActionListener(this);

        btnadd_patient.setBounds(1000, 280, 210, 70);
        panel.add(btnadd_patient);
        btnadd_patient.addActionListener(this);

        btntest_report.setBounds(1000, 410, 210, 70);
        panel.add(btntest_report);
        btntest_report.addActionListener(this);

        btndetails.setBounds(1000, 540, 210, 70);
        panel.add(btndetails);
        btndetails.addActionListener(this);
        
        lblimg.setBounds(0, 0, 950, 740);
        panel.add(lblimg);
    }

    
    
    public void actionPerformed(ActionEvent che){
        if (che.getSource() == itm_add) {
            new Add_Patient();
        }

        if (che.getSource() ==Quick_test) {
             new QuickTest();
        }
        if (che.getSource() ==Patient_Report) {
             new Find_patient();
        }

        if (che.getSource() == btnquick_test) {
            new QuickTest();
            
        }
        if (che.getSource() ==btnadd_patient) {
            new Add_Patient();
             
        }
        if (che.getSource() ==btntest_report) {
             new Find_patient();
        }
        if (che.getSource() ==btndetails) {
             new Report_Details();
        }
        if (che.getSource() ==itm_manual) {
             try{
                 Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"image\\1A.pdf");
             }
             catch(Exception em){
                 JOptionPane.showMessageDialog(null, em.toString());
             }
        }
        if (che.getSource() ==itm_logout) {
             new Login();
             dispose();
        }
        
    }
    
    
    
    
    
}
