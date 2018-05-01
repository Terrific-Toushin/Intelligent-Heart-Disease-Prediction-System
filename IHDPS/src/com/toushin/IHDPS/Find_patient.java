package com.toushin.IHDPS;

import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Find_patient extends JFrame implements ActionListener,Printable{
    
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        JPanel panel = new JPanel();

	
	JLabel lblPatientId=new JLabel("Patient ID :");
	JLabel lblPaitentName=new JLabel("Patient Name :");
	JLabel lblage=new JLabel("Age :");
	JLabel lblGender=new JLabel("Gender :");
	JLabel lblChestPaintype=new JLabel("Chest Pain Type :");
	JLabel lblFastingBloodsugger=new JLabel("Fasting Blood Sugger :");
	JLabel lblRestecg=new JLabel("Rest E C G :");
	JLabel lblExang=new JLabel("Exang :");
	JLabel lblSlop=new JLabel("Slop :");
	JLabel lblThal=new JLabel("Thal :");
	JLabel lblTrestBloodPressure=new JLabel("Trest Blood Pressure :");
	JLabel lblSerumCholesterol=new JLabel("Serum Cholesterol :");
	JLabel lblThalach=new JLabel("Thalach :");
	JLabel lblOldpeak=new JLabel("Oldpeak :");
	JLabel lblSmoking=new JLabel("Smoking :");
	JLabel lblObesity=new JLabel("Obesity :");
	JLabel lblDisease=new JLabel("Disease :");
	JLabel lblProbability=new JLabel("Probability :");
        JLabel lblBestClass=new JLabel("Best Class Label :");
	
	JLabel lbltxtProbability=new JLabel();
	JLabel lbltxtBestClass=new JLabel();

	JTextField txtPatientId=new JTextField();
        JLabel lbltxtPatientId=new JLabel();
	JLabel lbltxtPatientName=new JLabel();

	String age[]={"","Young","Mid","Old","Very Old"};
        JLabel cmbage=new JLabel();
	
        String gender[]={"","Male","Female"};
        JLabel cmbgender=new JLabel();
        
	String ChestPaintype[]={"","Typical Angina","Atypical Angina","Non-angina pain","Asymptomatic"};
        JLabel cmbChestPaintype=new JLabel();
	
	String FastingBloodsugger[]={"","Yes","No"};
	JLabel cmbFastingBloodsugger=new JLabel();

	String Restecg[]={"","Normal","ST_T abnormal","Hypertrophy"};
	JLabel cmbRestecg=new JLabel();

	String Exang[]={"","Yes","No"};
	JLabel cmbExang=new JLabel();

	String Slop[]={"","Unsloping","Flat","Downsloping"};
	JLabel cmbSlop=new JLabel();


	String Thal[]={"","Normal","Fixed Defect","Reversible Defect"};
	JLabel cmbThal=new JLabel();

	String TrestBloodPressure[]={"","Low","Medium","High","Very High"};
	JLabel cmbTrestBloodPressure=new JLabel();

	String SerumCholesterol[]={"","Low","Medium","High","Very High"};
	JLabel cmbSerumCholesterol=new JLabel();

	String Thalach[]={"","Low","Medium","High"};
	JLabel cmbThalach=new JLabel();

	String Oldpeak[]={"","Low","Risk","Terrible"};
	JLabel cmbOldpeak=new JLabel();

	String Smoking[]={"","Past","Current","Never"};
	JLabel cmbSmoking=new JLabel();

	String Obesity[]={"","Yes","No"};
	JLabel cmbObesity=new JLabel();

	String Disease[]={"","Positive","Negative"};
	JLabel cmbDisease=new JLabel();

	JLabel lblLine=new JLabel("============================================================================================================================================================");

	JLabel lblfind=new JLabel();

	JButton btnfind=new JButton("Find");
        JButton btnrefresh = new JButton("Refresh");
	JButton btntest=new JButton("Print");
	
	double CAge=0,CGender=0,CChest=0,CFasting=0,CRest=0,Cexang=0,Cslop=0,Cthal=0,Ctrest=0,Cserum=0,Cthalach=0,Coldpeak=0,Csmoking=0,Cobesity=0;
	double Cagecount=0,CPositiveCount=0,Cgendercount=0,CgenderPositiveCount=0,Cchestcount=0,CchestPositiveCount=0,CFastingcount=0,CFastingPositiveCount=0,CRestcount=0,CRestPositiveCount=0,CExangcount=0,CExangPositiveCount=0,
			CSlopcount=0,CSlopPositiveCount=0,Cthalcount=0,CthalPositiveCount=0,Ctrestcount=0,CtrestPositiveCount=0,Cserumcount=0,CserumPositiveCount=0,Cthalachcount=0,CthalachPositiveCount=0,Coldpeakcount=0,ColdpeakPositiveCount=0,
			Csmokingcount=0,CsmokingPositiveCount=0,Cobesitycount=0,CobesityPositiveCount=0;
	
	DecimalFormat df=new DecimalFormat("#.##");
        Connection conn=null;
        Statement st;
        ResultSet rs;
        PreparedStatement pst;
	
	
	public Find_patient()
	{
            super("Intelligent Heart Disease Prediction System ::: Report");
            panel.setLayout(null);
            setVisible(true);
            setSize(600,700);
            panel.setBackground(Color.LIGHT_GRAY);
            setLocation(60, 60);
            setResizable(false);
            add(panel);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            add(panel);
            ComponentAdd();
            conn=DB.getConnection();
	}
	
	
	public void FindValueSet() 
	{
            try {
                st = conn.createStatement();
                ResultSet find = st.executeQuery("select patientId,patientName,Age,Gender,ChestPainType,FastingBloodsugger,Restecg,Exang,Slop,Thal,TrestBloodPressure,SerumCholesterol,Thalach,Oldpeak,Smoking,Obesity,Disease,Probabilty,BestClassName from tbtrainingdataset where PatientId like'" +txtPatientId.getText()+ "'");
                while (find.next()) {
                    lbltxtPatientId.setText(find.getString("patientId"));
                    lbltxtPatientName.setText(find.getString("patientName"));
                    cmbage.setText(find.getString("Age"));
                    cmbgender.setText(find.getString("Gender"));
                    cmbChestPaintype.setText(find.getString("ChestPainType"));
                    cmbFastingBloodsugger.setText(find.getString("FastingBloodsugger"));
                    cmbRestecg.setText(find.getString("Restecg"));
                    cmbExang.setText(find.getString("Exang"));
                    cmbSlop.setText(find.getString("Slop"));
                    cmbThal.setText(find.getString("Thal"));
                    cmbTrestBloodPressure.setText(find.getString("TrestBloodPressure"));
                    cmbSerumCholesterol.setText(find.getString("SerumCholesterol"));
                    cmbThalach.setText(find.getString("Thalach"));
                    cmbOldpeak.setText(find.getString("Oldpeak"));
                    cmbSmoking.setText(find.getString("Smoking"));
                    cmbObesity.setText(find.getString("Obesity"));
                    cmbDisease.setText(find.getString("Disease"));
                    lbltxtProbability.setText(find.getString("Probabilty"));
                    lbltxtBestClass.setText(find.getString("BestClassName"));
                    
                }
            } catch (Exception find) {
                System.out.println(find.toString());
            }
	}
	
	
	private void ComponentAdd() 
	{

            lblPatientId.setBounds(40, 60, 120, 30);
            panel.add(lblPatientId);
            
            txtPatientId.setBounds(180, 60, 190, 30);
            panel.add(txtPatientId);
            
            lbltxtPatientId.setBounds(180, 60, 190, 30);
            panel.add(lbltxtPatientId);
            lbltxtPatientId.show(false);
            
            lblPaitentName.setBounds(40, 110, 120, 30);
            panel.add(lblPaitentName);
            
            lbltxtPatientName.setBounds(180, 110, 190, 30);
            panel.add(lbltxtPatientName);
                        
            lblGender.setBounds(340, 110, 120, 30);
            panel.add(lblGender);
            
            cmbgender.setBounds(480, 110, 190, 30);
            panel.add(cmbgender);
            
            lblage.setBounds(40, 160, 120, 30);
            panel.add(lblage);
            
            cmbage.setBounds(180, 160, 190, 30);
            panel.add(cmbage);
            
            lblFastingBloodsugger.setBounds(340, 160, 130, 30);
            panel.add(lblFastingBloodsugger);
            
            cmbFastingBloodsugger.setBounds(480, 160, 190, 30);
            panel.add(cmbFastingBloodsugger);
            
            lblChestPaintype.setBounds(40, 210, 120, 30);
            panel.add(lblChestPaintype);
            
            cmbChestPaintype.setBounds(180, 210, 190, 30);
            panel.add(cmbChestPaintype);
            
            lblExang.setBounds(340, 210, 130, 30);
            panel.add(lblExang);
            
            cmbExang.setBounds(480, 210, 190, 30);
            panel.add(cmbExang);
            
            lblRestecg.setBounds(40, 260, 130, 30);
            panel.add(lblRestecg);
            
            cmbRestecg.setBounds(180, 260, 190, 30);
            panel.add(cmbRestecg);
            
            lblThal.setBounds(340, 260, 130, 30);
            panel.add(lblThal);
            
            cmbThal.setBounds(480, 260, 190, 30);
            panel.add(cmbThal);
            
            lblSlop.setBounds(40, 310, 130, 30);
            panel.add(lblSlop);
            
            cmbSlop.setBounds(180, 310, 190, 30);
            panel.add(cmbSlop);
            
            lblSerumCholesterol.setBounds(340, 310, 130, 30);
            panel.add(lblSerumCholesterol);
            
            cmbSerumCholesterol.setBounds(480, 310, 190, 30);
            panel.add(cmbSerumCholesterol);
            
            lblTrestBloodPressure.setBounds(40, 360, 130, 30);
            panel.add(lblTrestBloodPressure);
            
            cmbTrestBloodPressure.setBounds(180, 360, 190, 30);
            panel.add(cmbTrestBloodPressure);
            
            lblOldpeak.setBounds(340, 360, 130, 30);
            panel.add(lblOldpeak);
            
            cmbOldpeak.setBounds(480, 360, 190, 30);
            panel.add(cmbOldpeak);
            
            lblThalach.setBounds(40, 410, 130, 30);
            panel.add(lblThalach);
            
            cmbThalach.setBounds(180, 410, 190, 30);
            panel.add(cmbThalach);
            
            lblObesity.setBounds(340, 410, 130, 30);
            panel.add(lblObesity);
            
            cmbObesity.setBounds(480, 410, 190, 30);
            panel.add(cmbObesity);
            
            lblSmoking.setBounds(40, 460, 130, 30);
            panel.add(lblSmoking);
            
            cmbSmoking.setBounds(180, 460, 190, 30);
            panel.add(cmbSmoking);
            
            lblDisease.setBounds(340, 460, 130, 30);
            panel.add(lblDisease);
            
            cmbDisease.setBounds(480, 460, 190, 30);
            panel.add(cmbDisease);
            
            lblProbability.setBounds(40, 510, 130, 30);
            panel.add(lblProbability);
            
            lbltxtProbability.setBounds(180, 510, 190, 30);
            panel.add(lbltxtProbability);
            
            lblBestClass.setBounds(340, 510, 130, 30);
            panel.add(lblBestClass);
            
            lbltxtBestClass.setBounds(480, 510, 190, 30);
            panel.add(lbltxtBestClass);
            
            btnrefresh.setBounds(60, 580, 130, 35);
            btnrefresh.addActionListener(this);
            btnrefresh.setFont(btnrefresh.getFont().deriveFont(15f));
            panel.add(btnrefresh);
            
            btnfind.setBounds(200, 580, 130, 35);
            btnfind.addActionListener(this);
            btnfind.setFont(btnfind.getFont().deriveFont(15f));
            panel.add(btnfind);
            
            btntest.setBounds(340, 580, 130, 35);
            btntest.addActionListener(this);
            btntest.setFont(btntest.getFont().deriveFont(15f));
            panel.add(btntest);
            
	}
        private void ClearMethod() 
	{
		txtPatientId.setText("");
		lbltxtPatientName.setText("");
		cmbage.setText("");
		cmbgender.setText("");
		cmbChestPaintype.setText("");
		cmbFastingBloodsugger.setText("");
		cmbRestecg.setText("");
		cmbExang.setText("");
		cmbSlop.setText("");
		cmbThal.setText("");
		cmbTrestBloodPressure.setText("");
		cmbSerumCholesterol.setText("");
		cmbThalach.setText("");
		cmbOldpeak.setText("");
		cmbSmoking.setText("");
		cmbObesity.setText("");	
		cmbDisease.setText("");
		lbltxtProbability.setText(" ");
                lbltxtBestClass.setText(" ");
	}
        @Override
        public void actionPerformed(ActionEvent ce){
        
            
            if(ce.getSource() == btnfind){
                txtPatientId.show(false);
                lbltxtPatientId.show(true);
            FindValueSet();
        }
            if(ce.getSource() == btntest){
               PrinterJob printJob = PrinterJob.getPrinterJob();
               printJob.setPrintable(this);
               if(printJob.printDialog())
                {
                   try
                     {
                          printJob.print();
                      }
                   catch(Exception ex)
                      {
                         throw new RuntimeException(ex);
                      }
                                  
                  }
                   
            }
            if(ce.getSource() == btnrefresh){
                txtPatientId.show(true);
                lbltxtPatientId.show(false);
            ClearMethod();
        }
                
    }
        public int print(Graphics g, PageFormat pf, int index) throws PrinterException
      {
        Graphics2D g2 = (Graphics2D)g;
        if (index >= 1)
           {
             return Printable.NO_SUCH_PAGE;
           }
       else     
          {
              //ok.printAll(g2);
        this.printAll(g2);
        return Printable.PAGE_EXISTS;
          }
    }

}

