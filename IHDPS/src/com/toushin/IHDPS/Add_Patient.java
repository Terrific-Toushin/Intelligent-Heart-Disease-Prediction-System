package com.toushin.IHDPS;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.*;
import javax.management.Notification;
import javax.swing.*;

public class Add_Patient extends JFrame implements ActionListener{
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel panel = new JPanel();
	
	JTextField txtSearch=new JTextField(25);

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
	
	JLabel lblfind=new JLabel();
	
	
	JLabel lbltxtPatientId=new JLabel();
	JTextField txtPatientName=new JTextField();
        JTextField txtPatientId=new JTextField();
        JTextField txtProbability=new JTextField();
	
	JTextField txtAgelimit=new JTextField();
	JTextField txtAge=new JTextField();
	public int a;
	
	
	String age[]={"","Young","Mid","Old","Very Old"};
        JComboBox cmbage=new JComboBox(age);
	
	String gender[]={"","Male","Female"};
        JComboBox cmbgender=new JComboBox(gender);
	
	String ChestPaintype[]={"","Typical Angina","Atypical Angina","Non-angina pain","Asymptomatic"};
	JComboBox cmbChestPaintype=new JComboBox(ChestPaintype);
	
	String FastingBloodsugger[]={"","Yes","No"};
	JComboBox cmbFastingBloodsugger=new JComboBox(FastingBloodsugger);
	
	String Restecg[]={"","Normal","ST_T abnormal","Hypertrophy"};
	JComboBox cmbRestecg=new JComboBox(Restecg);
	
	String Exang[]={"","Yes","No"};
	JComboBox cmbExang=new JComboBox(Exang);
	
	String Slop[]={"","Unsloping","Flat","Downsloping"};
	JComboBox cmbSlop=new JComboBox(Slop);
	
	
	String Thal[]={"","Normal","Fixed Defect","Reversible Defect"};
	JComboBox cmbThal=new JComboBox(Thal);
	
	String TrestBloodPressure[]={"","Low","Medium","High","Very High"};
	JComboBox cmbTrestBloodPressure=new JComboBox(TrestBloodPressure);
	
	String SerumCholesterol[]={"","Low","Medium","High","Very High"};
	JComboBox cmbSerumCholesterol=new JComboBox(SerumCholesterol);
	
	String Thalach[]={"","Low","Medium","High"};
	JComboBox cmbThalach=new JComboBox(Thalach);
	
	String Oldpeak[]={"","Low","Risk","Terrible"};
	JComboBox cmbOldpeak=new JComboBox(Oldpeak);
	
	String Smoking[]={"","Past","Current","Never"};
	JComboBox cmbSmoking=new JComboBox(Smoking);
	
	String Obesity[]={"","Yes","No"};
	JComboBox cmbObesity=new JComboBox(Obesity);
	
	JTextField txtDisease=new JTextField();
	//static String b;
	
	JButton btnsave=new JButton("Save");
	JButton btnrefresh=new JButton("Refresh");
	
	double Totalcount=0,PositiveCount=0,NegativeCount=0,TotalPositive=0,TotalNegative=0;
	double AgePositiveCount=0,TotalPositiveAge=0,AgeNegativeCount=0,TotalNegativeAge=0;
	double GenderPositiveCount=0,TotalPositiveGender=0,GenderNegativeCount=0,TotalNegativeGender=0;
	double ChestPainTypePositiveCount=0,TotalPositiveChestPainType=0,ChestPainTypeNegativeCount=0,TotalNegativeChestPainType=0;
	double FustingBloodSugerPositiveCount=0,TotalPositiveFustingBloodSuger=0,FustingBloodSugerNegativeCount=0,TotalNegativeFustingBloodSuger=0;
	double RestecgPositiveCount=0,TotalPositiveRestecg=0,RestecgNegativeCount=0,TotalNegativeRestecg=0;
	double ExangPositiveCount=0,TotalPositiveExang=0,ExangNegativeCount=0,TotalNegativeExang=0;
	double SlopPositiveCount=0,TotalPositiveSlop=0,SlopNegativeCount=0,TotalNegativeSlop=0;
	double ThalPositiveCount=0,TotalPositiveThal=0,ThalNegativeCount=0,TotalNegativeThal=0;
	double TrestBloodPresurePositiveCount=0,TotalPositiveTrestBloodPresure=0,TrestBloodPresureNegativeCount=0,TotalNegativeTrestBloodPresure=0;
	double SerumCholesterolPositiveCount=0,TotalPositiveSerumCholesterol=0,SerumCholesterolNegativeCount=0,TotalNegativeSerumCholesterol=0;
	double ThalachPositiveCount=0,TotalPositiveThalach=0,ThalachNegativeCount=0,TotalNegativeThalach=0;
	double OldPeakPositiveCount=0,TotalPositiveOldPeak=0,OldPeakNegativeCount=0,TotalNegativeOldPeak=0;
	double SmokingPositiveCount=0,TotalPositiveSmoking=0,SmokingNegativeCount=0,TotalNegativeSmoking=0;
	double ObesityPositiveCount=0,TotalPositiveObesity=0,ObesityNegativeCount=0,TotalNegativeObesity=0;
	double AllPositiveCalculation=0,AllNegativeCalculation=0;
	double DiseasePositiveCalculation=0,DiseaseNegativeCalculation=0;
        double CAge=0,CGender=0,CChest=0,CFasting=0,CRest=0,Cexang=0,Cslop=0,Cthal=0,Ctrest=0,Cserum=0,Cthalach=0,Coldpeak=0,Csmoking=0,Cobesity=0;
	double Cagecount=0,CPositiveCount=0,Cgendercount=0,CgenderPositiveCount=0,Cchestcount=0,CchestPositiveCount=0,CFastingcount=0,CFastingPositiveCount=0,CRestcount=0,CRestPositiveCount=0,CExangcount=0,CExangPositiveCount=0,
			CSlopcount=0,CSlopPositiveCount=0,Cthalcount=0,CthalPositiveCount=0,Ctrestcount=0,CtrestPositiveCount=0,Cserumcount=0,CserumPositiveCount=0,Cthalachcount=0,CthalachPositiveCount=0,Coldpeakcount=0,ColdpeakPositiveCount=0,
			Csmokingcount=0,CsmokingPositiveCount=0,Cobesitycount=0,CobesityPositiveCount=0;
        double TotalId;
        int Total;
        String result;
        String ID;
        DecimalFormat df=new DecimalFormat("#.##");
        Connection conn=null;
        Statement st;
        ResultSet rs;
        PreparedStatement pst;
	
	Add_Patient(){
            super("Intelligent Heart Disease Prediction System ::: Add_Patient");
            panel.setLayout(null);
            setVisible(true);
            setSize(940,700);
            panel.setBackground(Color.LIGHT_GRAY);
            setLocation(60, 60);
            setResizable(false);
            add(panel);
            conn=DB.getConnection();
            AutoLoad();
            ComponentAdd();
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            
            
	}
        private void AutoLoad(){
            try {
                st = conn.createStatement();
                ResultSet Iditer = st.executeQuery("select count(patientId) as Totalid from tbTrainingDataSet");
                while (Iditer.next()) {
                   TotalId = Double.parseDouble(Iditer.getString(1));
                   Total = (int) (TotalId+1701001);
                   lbltxtPatientId.setText(Integer.toString(Total));
                   System.out.println("TotalCount " + TotalId);
                }
            } catch (Exception IDexception) {
                System.out.println(IDexception.toString());
            }
        }
        private void ClearMethod() 
	{
		lbltxtPatientId.setText("");
		txtPatientName.setText("");
		cmbage.setSelectedIndex(0);
		cmbgender.setSelectedIndex(0);
		cmbChestPaintype.setSelectedIndex(0);
		cmbFastingBloodsugger.setSelectedIndex(0);
		cmbRestecg.setSelectedIndex(0);
		cmbExang.setSelectedIndex(0);
		cmbSlop.setSelectedIndex(0);
		cmbThal.setSelectedIndex(0);
		cmbTrestBloodPressure.setSelectedIndex(0);
		cmbSerumCholesterol.setSelectedIndex(0);
		cmbThalach.setSelectedIndex(0);
		cmbOldpeak.setSelectedIndex(0);
		cmbSmoking.setSelectedIndex(0);
		cmbObesity.setSelectedIndex(0);
		txtDisease.setName(" ");	
	}
	private boolean CheckValidation()
	{
		if(!txtPatientName.getText().isEmpty())
		{
			if(cmbage.getSelectedItem()!="")
			{
				if(cmbgender.getSelectedItem()!="")
				{
					if(cmbChestPaintype.getSelectedItem()!="")
					{
						if(cmbFastingBloodsugger.getSelectedItem()!="")
						{
							if(cmbRestecg.getSelectedItem()!="")
							{
								if(cmbExang.getSelectedItem()!="")
								{
									if(cmbSlop.getSelectedItem()!="")
									{
										if(cmbThal.getSelectedItem()!="")
										{
											if(cmbTrestBloodPressure.getSelectedItem()!="")
											{
												if(cmbSerumCholesterol.getSelectedItem()!="")
												{
													if(cmbThalach.getSelectedItem()!="")
													{
														if(cmbOldpeak.getSelectedItem()!="")
														{
															if(cmbSmoking.getSelectedItem()!="")
															{
																if(cmbObesity.getSelectedItem()!="")
																{
																		return true;
																}
																else
																{
																	JOptionPane.showMessageDialog(null, "Pleace Select Obesity Category ");
																}
															}
															else
															{
                                                                                                                                JOptionPane.showMessageDialog(null, "Pleace Select Smoking Category ");
															}
														}
														else
														{
															JOptionPane.showMessageDialog(null, "Pleace Select Oldpeak Category ");
														}
													}
													else
													{
														JOptionPane.showMessageDialog(null, "Pleace Select Thalach Category ");
													}
												}
												else
												{
													JOptionPane.showMessageDialog(null, "Pleace Select Serum Cholesterol Category ");
												}
												
											}
											else
											{
												JOptionPane.showMessageDialog(null, "Pleace Select Trest Blood Pressure Category ");
											}
										}
										else
										{
											JOptionPane.showMessageDialog(null, "Pleace Select Thal Category ");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Pleace Select Slop Category ");
									}
								}	
								else
								{
									JOptionPane.showMessageDialog(null, "Pleace Select Exang Category ");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Pleace Select Rest ECG Category ");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Pleace Select Fasting Blood Sugger Category ");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Pleace Select Chest Pain Type Category ");

					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Pleace Select Gender Category ");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Pleace Select Age Category ");
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Pleace insert Patient Name ");
		}

		
		return false;
	}
        private void inserdata(){
            int status=0;
            try {
                st = conn.createStatement();      
                PreparedStatement ps=conn.prepareStatement("insert into TbTrainingDataSet(PatientId,patientName,Age,Gender,ChestPainType,FastingBloodsugger,Restecg,Exang,Slop,Thal,TrestBloodPressure,SerumCholesterol,Thalach,Oldpeak,Smoking,Obesity,Disease,Probabilty,BestClassName)values('"+lbltxtPatientId.getText()+"','"+txtPatientName.getText()+"','"+cmbage.getSelectedItem().toString()+"','"+cmbgender.getSelectedItem().toString()+"','"+cmbChestPaintype.getSelectedItem().toString()+"','"+cmbFastingBloodsugger.getSelectedItem().toString()+"','"+cmbRestecg.getSelectedItem().toString()+"','"+cmbExang.getSelectedItem().toString()+"','"+cmbSlop.getSelectedItem().toString()+"','"+cmbThal.getSelectedItem().toString()+"','"+cmbTrestBloodPressure.getSelectedItem().toString()+"','"+cmbSerumCholesterol.getSelectedItem().toString()+"','"+cmbThalach.getSelectedItem().toString()+"','"+cmbOldpeak.getSelectedItem().toString()+"','"+cmbSmoking.getSelectedItem().toString()+"','"+cmbObesity.getSelectedItem().toString()+"','"+txtDisease.getText()+"','"+txtProbability.getText()+"','')");
                status=ps.executeUpdate();
                if (status > 0) {
                    JOptionPane.showMessageDialog(null, "Welcome!!! your records have successfully inserted!!!");
                }
                
                   
                
            } catch (Exception exception) {
                System.out.println(exception.toString());
            } 
        }
	

	
	private void PCiAndPXCiCalculation()
	{
		TotalCount();
		PositiveCount();
		NegativeCount();
		AgePositiveCount();
		AgeNegativeCount();
		GenderPositiveCount();
		GenderNegativeCount();
		ChestPainTypePositiveCount();
		ChestPainTypeNegativeCount();
		FustingBloodSugerPositiveCount();
		FustingBloodSugerNegativeCount();
		RestecgPositiveCount();
		RestecgNegativeCount();
		ExangPositiveCount();
		ExangNegativeCount();
		SlopPositiveCount();
		SlopNegativeCount();
		ThalPositiveCount();
		ThalNegativeCount();
		TrestBloodPresurePositiveCount();
		TrestBloodPresureNegativeCount();
		SerumCholesterolPositiveCount();
		SerumCholesterolNegativeCount();
		ThalachPositiveCount();
		ThalachNegativeCount();
		OldpeakPositiveCount();
		OldpeakNegativeCount();
		SmokingPositiveCount();
		SmokingNegativeCount();
		ObesityPositiveCount();
		ObesityNegativeCount();
		AllPositiveCalculation();
		AllNegativeCalculation();
		DiseasePositiveCalculation();
		DiseaseNegativeCalculation();
		
		if(DiseasePositiveCalculation>DiseaseNegativeCalculation)
		{
			result="Positive";
                        txtDisease.setText(result);
			//JOptionPane.showMessageDialog(null,"Heart Disease Result is Positive");
		}
		else
		{
			result="Negative";
                        txtDisease.setText(result);
			//JOptionPane.showMessageDialog(null,"Heart Disease Result is Negative");
		}
	}
        private void CARTValueCalculation() 
	{
            if(result == "Positive"){
		          try {
                st = conn.createStatement();      
                ResultSet iterTage = st.executeQuery("select count(Age)as age from tbTrainingDataSet where Age='" + cmbage.getSelectedItem().toString() + "' ");
                while (iterTage.next()) {
                    //Object element = iterage.next();
                    Cagecount = Double.parseDouble(iterTage.getString(1));
                    System.out.println("agecount" + Cagecount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();              
                ResultSet iteragepositive = st.executeQuery("select count(Age)as age from tbTrainingDataSet where Age='" + cmbage.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (iteragepositive.next()) {
                    //Object element = iteragepositive.next();
                    CPositiveCount = Double.parseDouble(iteragepositive.getString(1));
                    System.out.println("PositiveCount " + CPositiveCount);
                }
            } catch (Exception exception) {
            } 
		CAge=CPositiveCount/Cagecount;
                CAge=Double.parseDouble(df.format(CAge));
		System.out.println("Age "+CAge);
		/////////////////////////////////
		          try {
                st = conn.createStatement();     
                ResultSet itergender = st.executeQuery("select count(Gender)as gender from tbTrainingDataSet where Gender='" + cmbgender.getSelectedItem().toString() + "' ");
                while (itergender.next()) {
                    //Object element = itergender.next();
                    Cgendercount = Double.parseDouble(itergender.getString(1));
                    System.out.println("gendercount" + Cgendercount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();             
                ResultSet itergenderpositive = st.executeQuery("select count(Gender)as Gender from tbTrainingDataSet where Gender='" + cmbgender.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (itergenderpositive.next()) {
                    //Object element = itergenderpositive.next();
                    CgenderPositiveCount = Double.parseDouble(itergenderpositive.getString(1));
                    System.out.println("genderPositiveCount " + CgenderPositiveCount);
                }
                
            } catch (Exception exception) {
            }
                CGender=CgenderPositiveCount/Cgendercount;
                CGender=Double.parseDouble(df.format(CGender));
		System.out.println("gender "+CGender);
		
		////////////////////////////////
		          try {
                st = conn.createStatement();       
                ResultSet iterchest = st.executeQuery("select count(ChestPainType)as ChestPainType from tbTrainingDataSet where ChestPainType='" + cmbChestPaintype.getSelectedItem().toString() + "' ");
                while (iterchest.next()) {
                    //Object element = iterchest.next();
                    Cchestcount = Double.parseDouble(iterchest.getString(1));
                    System.out.println("chestcount" + Cchestcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();                
                ResultSet iterchestpositive = st.executeQuery("select count(ChestPainType)as ChestPainType from tbTrainingDataSet where ChestPainType='" + cmbChestPaintype.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (iterchestpositive.next()) {
                    //Object element = iterchestpositive.next();
                    CchestPositiveCount = Double.parseDouble(iterchestpositive.getString(1));
                    System.out.println("chestPositiveCount " + CchestPositiveCount);
                }
            } catch (Exception exception) {
            } 
		CChest=CchestPositiveCount/Cchestcount;
                CChest=Double.parseDouble(df.format(CChest));
		System.out.println("Chest "+CChest);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();           
                ResultSet iterFasting = st.executeQuery("select count(FastingBloodsugger)as FastingBloodsugger from tbTrainingDataSet where FastingBloodsugger='" + cmbFastingBloodsugger.getSelectedItem().toString() + "' ");
                while (iterFasting.next()) {
                    //Object element = iterFasting.next();
                    CFastingcount = Double.parseDouble(iterFasting.getString(1));
                    System.out.println("Fastingcount" + CFastingcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();           
                ResultSet iterFastingpositive = st.executeQuery("select count(FastingBloodsugger)as FastingBloodsugger from tbTrainingDataSet where FastingBloodsugger='" + cmbFastingBloodsugger.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (iterFastingpositive.next()) {
                    //Object element = iterFastingpositive.next();
                    CFastingPositiveCount = Double.parseDouble(iterFastingpositive.getString(1));
                    System.out.println("FastingPositiveCount " + CFastingPositiveCount);
                }
            } catch (Exception exception) {
            } 
		CFasting=CFastingPositiveCount/CFastingcount;
                CFasting=Double.parseDouble(df.format(CFasting));
		System.out.println("Fasting "+CFasting);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();             
                ResultSet iterRest = st.executeQuery("select count(Restecg)as Restecg from tbTrainingDataSet where Restecg='" + cmbRestecg.getSelectedItem().toString() + "' ");
                while (iterRest.next()) {
                    //Object element = iterRest.next();
                    CRestcount = Double.parseDouble(iterRest.getString(1));
                    System.out.println("Restcount" + CRestcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();               
                ResultSet iterRestpositive = st.executeQuery("select count(Restecg)as Restecg from tbTrainingDataSet where Restecg='" + cmbRestecg.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (iterRestpositive.next()) {
                    //Object element = iterRestpositive.next();
                    CRestPositiveCount = Double.parseDouble(iterRestpositive.getString(1));
                    System.out.println("RestPositiveCount " + CRestPositiveCount);
                }
            } catch (Exception exception) {
            } 
		CRest=CRestPositiveCount/CRestcount;
                CRest=Double.parseDouble(df.format(CRest));
		System.out.println("Rest "+CRest);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();           
                ResultSet iterExang = st.executeQuery("select count(Exang)as Exang from tbTrainingDataSet where Exang='" + cmbExang.getSelectedItem().toString() + "' ");
                while (iterExang.next()) {
                    //Object element = iterExang.next();
                    CExangcount = Double.parseDouble(iterExang.getString(1));
                    System.out.println("Exangcount" + CExangcount);
                }
                
            } catch (Exception exception) {
            } 
		          try {
                st = conn.createStatement();             
                ResultSet iterExangpositive = st.executeQuery("select count(Exang)as Exang from tbTrainingDataSet where Exang='" + cmbExang.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (iterExangpositive.next()) {
                    //Object element = iterExangpositive.next();
                    CExangPositiveCount = Double.parseDouble(iterExangpositive.getString(1));
                    System.out.println("ExangPositiveCount " + CExangPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Cexang=CExangPositiveCount/CExangcount;
		System.out.println("Exang "+Cexang);
		/////////////////////////////////
		

		          try {
                st = conn.createStatement();          
                ResultSet iterSlop = st.executeQuery("select count(Slop)as Slop from tbTrainingDataSet where Slop='" + cmbSlop.getSelectedItem().toString() + "' ");
                while (iterSlop.next()) {
                    //Object element = iterSlop.next();
                    CSlopcount = Double.parseDouble(iterSlop.getString(1));
                    System.out.println("Slopcount" + CSlopcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();               
                ResultSet iterSloppositive = st.executeQuery("select count(Slop)as Slop from tbTrainingDataSet where Slop='" + cmbSlop.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (iterSloppositive.next()) {
                    //Object element = iterSloppositive.next();
                    CSlopPositiveCount = Double.parseDouble(iterSloppositive.getString(1));
                    System.out.println("SlopPositiveCount " + CSlopPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Cslop=CSlopPositiveCount/CSlopcount;
                Cslop=Double.parseDouble(df.format(Cslop));
		System.out.println("Slop "+Cslop);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();       
                ResultSet iterthal = st.executeQuery("select count(thal)as thal from tbTrainingDataSet where thal='" + cmbThal.getSelectedItem().toString() + "' ");
                while (iterthal.next()) {
                    //Object element = iterthal.next();
                    Cthalcount = Double.parseDouble(iterthal.getString(1));
                    System.out.println("thalcount" + Cthalcount);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();               
                ResultSet iterthalpositive = st.executeQuery("select count(thal)as thal from tbTrainingDataSet where thal='" + cmbThal.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (iterthalpositive.next()) {
                    //Object element = iterthalpositive.next();
                    CthalPositiveCount = Double.parseDouble(iterthalpositive.getString(1));
                    System.out.println("thalPositiveCount " + CthalPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Cthal=CthalPositiveCount/Cthalcount;
                Cthal=Double.parseDouble(df.format(Cthal));
		System.out.println("thal "+Cthal);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();          
                ResultSet itertrest = st.executeQuery("select count(TrestBloodPressure)as TrestBloodPressure from tbTrainingDataSet where TrestBloodPressure='" + cmbTrestBloodPressure.getSelectedItem().toString() + "' ");
                while (itertrest.next()) {
                    //Object element = itertrest.next();
                    Ctrestcount = Double.parseDouble(itertrest.getString(1));
                    System.out.println("trestcount" + Ctrestcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();            
                ResultSet itertrestpositive = st.executeQuery("select count(TrestBloodPressure)as TrestBloodPressure from tbTrainingDataSet where TrestBloodPressure='" + cmbTrestBloodPressure.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (itertrestpositive.next()) {
                    //Object element = itertrestpositive.next();
                    CtrestPositiveCount = Double.parseDouble(itertrestpositive.getString(1));
                    System.out.println("trestPositiveCount " + CtrestPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Ctrest=CtrestPositiveCount/Ctrestcount;
                Ctrest=Double.parseDouble(df.format(Ctrest));
		System.out.println("trest "+Ctrest);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();              
                ResultSet iterserum = st.executeQuery("select count(SerumCholesterol)as SerumCholesterol from tbTrainingDataSet where SerumCholesterol='" + cmbSerumCholesterol.getSelectedItem().toString() + "' ");
                while (iterserum.next()) {
                    //Object element = iterserum.next();
                    Cserumcount = Double.parseDouble(iterserum.getString(1));
                    System.out.println("serumcount" + Cserumcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();                
                ResultSet iterserumpositive = st.executeQuery("select count(SerumCholesterol)as SerumCholesterol from tbTrainingDataSet where SerumCholesterol='" + cmbSerumCholesterol.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (iterserumpositive.next()) {
                    //Object element = iterserumpositive.next();
                    CserumPositiveCount = Double.parseDouble(iterserumpositive.getString(1));
                    System.out.println("serumPositiveCount " + CserumPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Cserum=CserumPositiveCount/Cserumcount;
                Cserum=Double.parseDouble(df.format(Cserum));
		System.out.println("serum "+Cserum);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();            
                ResultSet iterthalach = st.executeQuery("select count(Thalach)as Thalach from tbTrainingDataSet where Thalach='" + cmbThalach.getSelectedItem().toString() + "' ");
                while (iterthalach.next()) {
                    //Object element = iterthalach.next();
                    Cthalachcount = Double.parseDouble(iterthalach.getString(1));
                    System.out.println("thalachcount" + Cthalachcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();           
                ResultSet iterthalachpositive = st.executeQuery("select count(Thalach)as Thalach from tbTrainingDataSet where Thalach='" + cmbThalach.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (iterthalachpositive.next()) {
                    //Object element = iterthalachpositive.next();
                    CthalachPositiveCount = Double.parseDouble(iterthalachpositive.getString(1));
                    System.out.println("thalachPositiveCount " + CthalachPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Cthalach=CthalachPositiveCount/Cthalachcount;
                Cthalach=Double.parseDouble(df.format(Cthalach));
		System.out.println("thalach "+Cthalach);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();             
                ResultSet iteroldpeak = st.executeQuery("select count(Oldpeak)as Oldpeak from tbTrainingDataSet where Oldpeak='" + cmbOldpeak.getSelectedItem().toString() + "' ");
                while (iteroldpeak.next()) {
                    //Object element = iteroldpeak.next();
                    Coldpeakcount = Double.parseDouble(iteroldpeak.getString(1));
                    System.out.println("oldpeakcount" + Coldpeakcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();            
                ResultSet iteroldpeakpositive = st.executeQuery("select count(Oldpeak)as Oldpeak from tbTrainingDataSet where Oldpeak='" + cmbOldpeak.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (iteroldpeakpositive.next()) {
                    //Object element = iteroldpeakpositive.next();
                    ColdpeakPositiveCount = Double.parseDouble(iteroldpeakpositive.getString(1));
                    System.out.println("oldpeakPositiveCount " + ColdpeakPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Coldpeak=ColdpeakPositiveCount/Coldpeakcount;
                Coldpeak=Double.parseDouble(df.format(Coldpeak));
		System.out.println("oldpeak "+Coldpeak);
		/////////////////////////////////////////
		
		          try {
                st = conn.createStatement();          
                ResultSet itersmoking = st.executeQuery("select count(Smoking)as Smoking from tbTrainingDataSet where Smoking='" + cmbSmoking.getSelectedItem().toString() + "' ");
                while (itersmoking.next()) {
                    //Object element = itersmoking.next();
                    Csmokingcount = Double.parseDouble(itersmoking.getString(1));
                    System.out.println("smokingcount" + Csmokingcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();     
                ResultSet itersmokingpositive = st.executeQuery("select count(Smoking)as Smoking from tbTrainingDataSet where Smoking='" + cmbSmoking.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (itersmokingpositive.next()) {
                    //Object element = itersmokingpositive.next();
                    CsmokingPositiveCount = Double.parseDouble(itersmokingpositive.getString(1));
                    System.out.println("smokingPositiveCount " + CsmokingPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Csmoking=CsmokingPositiveCount/Csmokingcount;
                Csmoking=Double.parseDouble(df.format(Csmoking));
		System.out.println("smoking "+Csmoking);
		//////////////////////////////////////////////
		          try {
                st = conn.createStatement();         
                ResultSet iterobesity = st.executeQuery("select count(Obesity)as Obesity from tbTrainingDataSet where Obesity='" + cmbObesity.getSelectedItem().toString() + "' ");
                while (iterobesity.next()) {
                    //Object element = iterobesity.next();
                    Cobesitycount = Double.parseDouble(iterobesity.getString(1));
                    System.out.println("obesitycount" + Cobesitycount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();          
                ResultSet iterobesitypositive = st.executeQuery("select count(Obesity)as Obesity from tbTrainingDataSet where Obesity='" + cmbObesity.getSelectedItem().toString() + "'and Disease='Positive' ");
                while (iterobesitypositive.next()) {
                    //Object element = iterobesitypositive.next();
                    CobesityPositiveCount = Double.parseDouble(iterobesitypositive.getString(1));
                    System.out.println("obesityPositiveCount " + CobesityPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Cobesity=CobesityPositiveCount/Cobesitycount;
                Cobesity=Double.parseDouble(df.format(Cobesity));
		System.out.println("obesity "+Cobesity);
		
		
		System.out.println("==========================================================================");
		
		double Totalprobability=Cagecount*Cgendercount*Cchestcount*CFastingcount*CRestcount*CExangcount*CSlopcount*Cthalcount*Ctrestcount*Cserumcount*Cthalachcount*Coldpeakcount*Csmokingcount*Cobesitycount;
                double probability=CAge*CGender*CChest*CFasting*CRest*Cexang*Cslop*Cthal*Ctrest*Cserum*Cthalach*Coldpeak*Csmoking*Cobesity*100000;
                System.out.println("probability"+probability);
		probability =Double.parseDouble(df.format(probability));
		System.out.println("probability"+probability);
                //JOptionPane.showMessageDialog(lbltxtPatientId, "probability = "+probability+"%");
		//txtProbability.setValue(probability);
		txtProbability.setText(df.format(probability)+"%");
        }
        else if(result == "Negative"){
            	          try {
                st = conn.createStatement();      
                ResultSet iterTage = st.executeQuery("select count(Age)as age from tbTrainingDataSet where Age='" + cmbage.getSelectedItem().toString() + "' ");
                while (iterTage.next()) {
                    //Object element = iterage.next();
                    Cagecount = Double.parseDouble(iterTage.getString(1));
                    System.out.println("agecount" + Cagecount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();              
                ResultSet iteragepositive = st.executeQuery("select count(Age)as age from tbTrainingDataSet where Age='" + cmbage.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (iteragepositive.next()) {
                    //Object element = iteragepositive.next();
                    CPositiveCount = Double.parseDouble(iteragepositive.getString(1));
                    System.out.println("PositiveCount " + CPositiveCount);
                }
            } catch (Exception exception) {
            } 
		CAge=CPositiveCount/Cagecount;
                CAge=Double.parseDouble(df.format(CAge));
		System.out.println("Age "+CAge);
		/////////////////////////////////
		          try {
                st = conn.createStatement();     
                ResultSet itergender = st.executeQuery("select count(Gender)as gender from tbTrainingDataSet where Gender='" + cmbgender.getSelectedItem().toString() + "' ");
                while (itergender.next()) {
                    //Object element = itergender.next();
                    Cgendercount = Double.parseDouble(itergender.getString(1));
                    System.out.println("gendercount" + Cgendercount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();             
                ResultSet itergenderpositive = st.executeQuery("select count(Gender)as Gender from tbTrainingDataSet where Gender='" + cmbgender.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (itergenderpositive.next()) {
                    //Object element = itergenderpositive.next();
                    CgenderPositiveCount = Double.parseDouble(itergenderpositive.getString(1));
                    System.out.println("genderPositiveCount " + CgenderPositiveCount);
                }
                
            } catch (Exception exception) {
            }
                CGender=CgenderPositiveCount/Cgendercount;
                CGender=Double.parseDouble(df.format(CGender));
		System.out.println("gender "+CGender);
		
		////////////////////////////////
		          try {
                st = conn.createStatement();       
                ResultSet iterchest = st.executeQuery("select count(ChestPainType)as ChestPainType from tbTrainingDataSet where ChestPainType='" + cmbChestPaintype.getSelectedItem().toString() + "' ");
                while (iterchest.next()) {
                    //Object element = iterchest.next();
                    Cchestcount = Double.parseDouble(iterchest.getString(1));
                    System.out.println("chestcount" + Cchestcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();                
                ResultSet iterchestpositive = st.executeQuery("select count(ChestPainType)as ChestPainType from tbTrainingDataSet where ChestPainType='" + cmbChestPaintype.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (iterchestpositive.next()) {
                    //Object element = iterchestpositive.next();
                    CchestPositiveCount = Double.parseDouble(iterchestpositive.getString(1));
                    System.out.println("chestPositiveCount " + CchestPositiveCount);
                }
            } catch (Exception exception) {
            } 
		CChest=CchestPositiveCount/Cchestcount;
                CChest=Double.parseDouble(df.format(CChest));
		System.out.println("Chest "+CChest);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();           
                ResultSet iterFasting = st.executeQuery("select count(FastingBloodsugger)as FastingBloodsugger from tbTrainingDataSet where FastingBloodsugger='" + cmbFastingBloodsugger.getSelectedItem().toString() + "' ");
                while (iterFasting.next()) {
                    //Object element = iterFasting.next();
                    CFastingcount = Double.parseDouble(iterFasting.getString(1));
                    System.out.println("Fastingcount" + CFastingcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();           
                ResultSet iterFastingpositive = st.executeQuery("select count(FastingBloodsugger)as FastingBloodsugger from tbTrainingDataSet where FastingBloodsugger='" + cmbFastingBloodsugger.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (iterFastingpositive.next()) {
                    //Object element = iterFastingpositive.next();
                    CFastingPositiveCount = Double.parseDouble(iterFastingpositive.getString(1));
                    System.out.println("FastingPositiveCount " + CFastingPositiveCount);
                }
            } catch (Exception exception) {
            } 
		CFasting=CFastingPositiveCount/CFastingcount;
                CFasting=Double.parseDouble(df.format(CFasting));
		System.out.println("Fasting "+CFasting);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();             
                ResultSet iterRest = st.executeQuery("select count(Restecg)as Restecg from tbTrainingDataSet where Restecg='" + cmbRestecg.getSelectedItem().toString() + "' ");
                while (iterRest.next()) {
                    //Object element = iterRest.next();
                    CRestcount = Double.parseDouble(iterRest.getString(1));
                    System.out.println("Restcount" + CRestcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();               
                ResultSet iterRestpositive = st.executeQuery("select count(Restecg)as Restecg from tbTrainingDataSet where Restecg='" + cmbRestecg.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (iterRestpositive.next()) {
                    //Object element = iterRestpositive.next();
                    CRestPositiveCount = Double.parseDouble(iterRestpositive.getString(1));
                    System.out.println("RestPositiveCount " + CRestPositiveCount);
                }
            } catch (Exception exception) {
            } 
		CRest=CRestPositiveCount/CRestcount;
                CRest=Double.parseDouble(df.format(CRest));
		System.out.println("Rest "+CRest);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();           
                ResultSet iterExang = st.executeQuery("select count(Exang)as Exang from tbTrainingDataSet where Exang='" + cmbExang.getSelectedItem().toString() + "' ");
                while (iterExang.next()) {
                    //Object element = iterExang.next();
                    CExangcount = Double.parseDouble(iterExang.getString(1));
                    System.out.println("Exangcount" + CExangcount);
                }
                
            } catch (Exception exception) {
            } 
		          try {
                st = conn.createStatement();             
                ResultSet iterExangpositive = st.executeQuery("select count(Exang)as Exang from tbTrainingDataSet where Exang='" + cmbExang.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (iterExangpositive.next()) {
                    //Object element = iterExangpositive.next();
                    CExangPositiveCount = Double.parseDouble(iterExangpositive.getString(1));
                    System.out.println("ExangPositiveCount " + CExangPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Cexang=CExangPositiveCount/CExangcount;
		System.out.println("Exang "+Cexang);
		/////////////////////////////////
		

		          try {
                st = conn.createStatement();          
                ResultSet iterSlop = st.executeQuery("select count(Slop)as Slop from tbTrainingDataSet where Slop='" + cmbSlop.getSelectedItem().toString() + "' ");
                while (iterSlop.next()) {
                    //Object element = iterSlop.next();
                    CSlopcount = Double.parseDouble(iterSlop.getString(1));
                    System.out.println("Slopcount" + CSlopcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();               
                ResultSet iterSloppositive = st.executeQuery("select count(Slop)as Slop from tbTrainingDataSet where Slop='" + cmbSlop.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (iterSloppositive.next()) {
                    //Object element = iterSloppositive.next();
                    CSlopPositiveCount = Double.parseDouble(iterSloppositive.getString(1));
                    System.out.println("SlopPositiveCount " + CSlopPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Cslop=CSlopPositiveCount/CSlopcount;
                Cslop=Double.parseDouble(df.format(Cslop));
		System.out.println("Slop "+Cslop);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();       
                ResultSet iterthal = st.executeQuery("select count(thal)as thal from tbTrainingDataSet where thal='" + cmbThal.getSelectedItem().toString() + "' ");
                while (iterthal.next()) {
                    //Object element = iterthal.next();
                    Cthalcount = Double.parseDouble(iterthal.getString(1));
                    System.out.println("thalcount" + Cthalcount);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();               
                ResultSet iterthalpositive = st.executeQuery("select count(thal)as thal from tbTrainingDataSet where thal='" + cmbThal.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (iterthalpositive.next()) {
                    //Object element = iterthalpositive.next();
                    CthalPositiveCount = Double.parseDouble(iterthalpositive.getString(1));
                    System.out.println("thalPositiveCount " + CthalPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Cthal=CthalPositiveCount/Cthalcount;
                Cthal=Double.parseDouble(df.format(Cthal));
		System.out.println("thal "+Cthal);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();          
                ResultSet itertrest = st.executeQuery("select count(TrestBloodPressure)as TrestBloodPressure from tbTrainingDataSet where TrestBloodPressure='" + cmbTrestBloodPressure.getSelectedItem().toString() + "' ");
                while (itertrest.next()) {
                    //Object element = itertrest.next();
                    Ctrestcount = Double.parseDouble(itertrest.getString(1));
                    System.out.println("trestcount" + Ctrestcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();            
                ResultSet itertrestpositive = st.executeQuery("select count(TrestBloodPressure)as TrestBloodPressure from tbTrainingDataSet where TrestBloodPressure='" + cmbTrestBloodPressure.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (itertrestpositive.next()) {
                    //Object element = itertrestpositive.next();
                    CtrestPositiveCount = Double.parseDouble(itertrestpositive.getString(1));
                    System.out.println("trestPositiveCount " + CtrestPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Ctrest=CtrestPositiveCount/Ctrestcount;
                Ctrest=Double.parseDouble(df.format(Ctrest));
		System.out.println("trest "+Ctrest);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();              
                ResultSet iterserum = st.executeQuery("select count(SerumCholesterol)as SerumCholesterol from tbTrainingDataSet where SerumCholesterol='" + cmbSerumCholesterol.getSelectedItem().toString() + "' ");
                while (iterserum.next()) {
                    //Object element = iterserum.next();
                    Cserumcount = Double.parseDouble(iterserum.getString(1));
                    System.out.println("serumcount" + Cserumcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();                
                ResultSet iterserumpositive = st.executeQuery("select count(SerumCholesterol)as SerumCholesterol from tbTrainingDataSet where SerumCholesterol='" + cmbSerumCholesterol.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (iterserumpositive.next()) {
                    //Object element = iterserumpositive.next();
                    CserumPositiveCount = Double.parseDouble(iterserumpositive.getString(1));
                    System.out.println("serumPositiveCount " + CserumPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Cserum=CserumPositiveCount/Cserumcount;
                Cserum=Double.parseDouble(df.format(Cserum));
		System.out.println("serum "+Cserum);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();            
                ResultSet iterthalach = st.executeQuery("select count(Thalach)as Thalach from tbTrainingDataSet where Thalach='" + cmbThalach.getSelectedItem().toString() + "' ");
                while (iterthalach.next()) {
                    //Object element = iterthalach.next();
                    Cthalachcount = Double.parseDouble(iterthalach.getString(1));
                    System.out.println("thalachcount" + Cthalachcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();           
                ResultSet iterthalachpositive = st.executeQuery("select count(Thalach)as Thalach from tbTrainingDataSet where Thalach='" + cmbThalach.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (iterthalachpositive.next()) {
                    //Object element = iterthalachpositive.next();
                    CthalachPositiveCount = Double.parseDouble(iterthalachpositive.getString(1));
                    System.out.println("thalachPositiveCount " + CthalachPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Cthalach=CthalachPositiveCount/Cthalachcount;
                Cthalach=Double.parseDouble(df.format(Cthalach));
		System.out.println("thalach "+Cthalach);
		/////////////////////////////////
		
		          try {
                st = conn.createStatement();             
                ResultSet iteroldpeak = st.executeQuery("select count(Oldpeak)as Oldpeak from tbTrainingDataSet where Oldpeak='" + cmbOldpeak.getSelectedItem().toString() + "' ");
                while (iteroldpeak.next()) {
                    //Object element = iteroldpeak.next();
                    Coldpeakcount = Double.parseDouble(iteroldpeak.getString(1));
                    System.out.println("oldpeakcount" + Coldpeakcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();            
                ResultSet iteroldpeakpositive = st.executeQuery("select count(Oldpeak)as Oldpeak from tbTrainingDataSet where Oldpeak='" + cmbOldpeak.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (iteroldpeakpositive.next()) {
                    //Object element = iteroldpeakpositive.next();
                    ColdpeakPositiveCount = Double.parseDouble(iteroldpeakpositive.getString(1));
                    System.out.println("oldpeakPositiveCount " + ColdpeakPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Coldpeak=ColdpeakPositiveCount/Coldpeakcount;
                Coldpeak=Double.parseDouble(df.format(Coldpeak));
		System.out.println("oldpeak "+Coldpeak);
		/////////////////////////////////////////
		
		          try {
                st = conn.createStatement();          
                ResultSet itersmoking = st.executeQuery("select count(Smoking)as Smoking from tbTrainingDataSet where Smoking='" + cmbSmoking.getSelectedItem().toString() + "' ");
                while (itersmoking.next()) {
                    //Object element = itersmoking.next();
                    Csmokingcount = Double.parseDouble(itersmoking.getString(1));
                    System.out.println("smokingcount" + Csmokingcount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();     
                ResultSet itersmokingpositive = st.executeQuery("select count(Smoking)as Smoking from tbTrainingDataSet where Smoking='" + cmbSmoking.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (itersmokingpositive.next()) {
                    //Object element = itersmokingpositive.next();
                    CsmokingPositiveCount = Double.parseDouble(itersmokingpositive.getString(1));
                    System.out.println("smokingPositiveCount " + CsmokingPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Csmoking=CsmokingPositiveCount/Csmokingcount;
                Csmoking=Double.parseDouble(df.format(Csmoking));
		System.out.println("smoking "+Csmoking);
		//////////////////////////////////////////////
		          try {
                st = conn.createStatement();         
                ResultSet iterobesity = st.executeQuery("select count(Obesity)as Obesity from tbTrainingDataSet where Obesity='" + cmbObesity.getSelectedItem().toString() + "' ");
                while (iterobesity.next()) {
                    //Object element = iterobesity.next();
                    Cobesitycount = Double.parseDouble(iterobesity.getString(1));
                    System.out.println("obesitycount" + Cobesitycount);
                }
            } catch (Exception exception) {
            } 
		
		          try {
                st = conn.createStatement();          
                ResultSet iterobesitypositive = st.executeQuery("select count(Obesity)as Obesity from tbTrainingDataSet where Obesity='" + cmbObesity.getSelectedItem().toString() + "'and Disease='Negative' ");
                while (iterobesitypositive.next()) {
                    //Object element = iterobesitypositive.next();
                    CobesityPositiveCount = Double.parseDouble(iterobesitypositive.getString(1));
                    System.out.println("obesityPositiveCount " + CobesityPositiveCount);
                }
            } catch (Exception exception) {
            } 
		Cobesity=CobesityPositiveCount/Cobesitycount;
                Cobesity=Double.parseDouble(df.format(Cobesity));
		System.out.println("obesity "+Cobesity);
		
		
		System.out.println("==========================================================================");
		
		double Totalprobability=Cagecount*Cgendercount*Cchestcount*CFastingcount*CRestcount*CExangcount*CSlopcount*Cthalcount*Ctrestcount*Cserumcount*Cthalachcount*Coldpeakcount*Csmokingcount*Cobesitycount;
                double probability=CAge*CGender*CChest*CFasting*CRest*Cexang*Cslop*Cthal*Ctrest*Cserum*Cthalach*Coldpeak*Csmoking*Cobesity*100000;
                System.out.println("probability"+probability);
		probability =Double.parseDouble(df.format(probability));
		System.out.println("probability"+probability);
                //JOptionPane.showMessageDialog(lbltxtPatientId, "probability = "+probability+"%");
		//txtProbability.setValue(probability);
		txtProbability.setText(df.format(probability)+"%");
	}
    }
	private void TotalCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet iter = st.executeQuery("select count(patientId) from tbTrainingDataSet");
                while (iter.next()) {
                    Totalcount = Double.parseDouble(iter.getString(1));
                    System.out.println("TotalCount " + Totalcount);
                }
            } catch (Exception Texception) {
                System.out.println(Texception.toString());
            } 
		
	}
	private void PositiveCount()
	{
		          try {
                String Query = ("select count(Disease)as Positive from tbTrainingDataSet where Disease='Positive'");
                st =conn.createStatement();
                rs = st.executeQuery(Query);
                while (rs.next()) {
                    PositiveCount = Double.parseDouble(rs.getString(1));
                    TotalPositive = PositiveCount / Totalcount;
                    System.out.println("PositiveCount =" + TotalPositive);
                }
            } catch (Exception TPexception) {
                System.out.println("TP = "+TPexception.toString());
            }
		
	}
	private void NegativeCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet it = st.executeQuery("select count(Disease)as Positive from tbTrainingDataSet where Disease='Negative'");
                while (it.next()) {
                   // Object element = iter.next();
                    NegativeCount = Double.parseDouble(it.getString(1));
                    TotalNegative = NegativeCount / Totalcount;
                    System.out.println("NegativeCount " + TotalNegative);
                }
            } catch (Exception TNexception) {
                System.out.println(TNexception.toString());
            }
		
	}
	private void AgePositiveCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet age = st.executeQuery("select count(Age)as age from tbTrainingDataSet where Age='" + cmbage.getSelectedItem().toString() + "' and Disease='Positive'");
                while (age.next()) {
                    AgePositiveCount = Double.parseDouble(age.getString(1));
                    TotalPositiveAge = AgePositiveCount / PositiveCount;
                    System.out.println("AgePositiveCount " + TotalPositiveAge);
                }
            } catch (Exception TPexception) {
                System.out.println(TPexception.toString());
            }
		
	}
	private void AgeNegativeCount() 
	{
                try {
                st = conn.createStatement();
                ResultSet agen = st.executeQuery("select count(Age)as age from tbTrainingDataSet where Age='" + cmbage.getSelectedItem().toString() + "' and Disease='Negative'");
                while (agen.next()) {
                    AgeNegativeCount = Double.parseDouble(agen.getString(1));
                    TotalNegativeAge = AgeNegativeCount / NegativeCount;
                    System.out.println("AgeNegativeCount " + TotalNegativeAge);
                }
            } catch (Exception TNexception) {
                System.out.println(TNexception.toString());
            }
		
	}
	private void GenderPositiveCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet GP = st.executeQuery("select count(Gender)as gender from tbTrainingDataSet where Gender='" + cmbgender.getSelectedItem().toString() + "' and Disease='Positive'");
                while (GP.next()) {
                     
                    GenderPositiveCount = Double.parseDouble(GP.getString(1));
                    TotalPositiveGender = GenderPositiveCount / PositiveCount;
                    System.out.println("GenderPositiveCount " + TotalPositiveGender);
                }
            } catch (Exception GPexception) {
                System.out.println(GPexception.toString());
            } 
		
	}
	private void GenderNegativeCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet GN = st.executeQuery("select count(Gender)as gender from tbTrainingDataSet where Gender='" + cmbgender.getSelectedItem().toString() + "' and Disease='Negative'");
                while (GN.next()) {
                     
                    GenderNegativeCount = Double.parseDouble(GN.getString(1));
                    TotalNegativeGender = GenderNegativeCount / NegativeCount;
                    System.out.println("GenderNegativeCount " + TotalNegativeGender);
                }
            } catch (Exception GNexception) {
                System.out.println(GNexception.toString());
            }
		
	}
	
	
	private void ChestPainTypePositiveCount() 
	{
		          try {
                ResultSet CPTP = st.executeQuery("select count(ChestPainType)as ChestPainType from tbTrainingDataSet where ChestPainType='" + cmbChestPaintype.getSelectedItem().toString() + "' and Disease='Positive'");
                while (CPTP.next()) {
                    //Object element = CPTP.next();
                    ChestPainTypePositiveCount = Double.parseDouble(CPTP.getString(1));
                    TotalPositiveChestPainType = ChestPainTypePositiveCount / PositiveCount;
                    System.out.println("ChestPainTypePositiveCount " + TotalPositiveChestPainType);
                }
            } catch (Exception CPTexception) {
                System.out.println("CPT = "+CPTexception.toString());
            }
		
	}
	private void ChestPainTypeNegativeCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet CPTN = st.executeQuery("select count(ChestPainType)as ChestPainType from tbTrainingDataSet where ChestPainType='" + cmbChestPaintype.getSelectedItem().toString() + "' and Disease='Negative'");
                while (CPTN.next()) {
                    //Object element = CPTN.next();
                    ChestPainTypeNegativeCount = Double.parseDouble(CPTN.getString(1));
                    TotalNegativeChestPainType = ChestPainTypeNegativeCount / NegativeCount;
                    System.out.println("ChestPainTypeNegativeCount " + TotalNegativeChestPainType);
                }
            } catch (SQLException sQLException) {
                System.out.println(sQLException.toString());
            } 
		
	}
	
	private void FustingBloodSugerPositiveCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet FBSP = st.executeQuery("select count(FastingBloodsugger)as FastingBloodsugger from tbTrainingDataSet where FastingBloodsugger='" + cmbFastingBloodsugger.getSelectedItem().toString() + "' and Disease='Positive'");
                while (FBSP.next()) {
                     
                    FustingBloodSugerPositiveCount = Double.parseDouble(FBSP.getString(1));
                    TotalPositiveFustingBloodSuger = FustingBloodSugerPositiveCount / PositiveCount;
                    System.out.println("FustingBloodSugerPositiveCount " + TotalPositiveFustingBloodSuger);
                }
            } catch (SQLException sQLException) {
                System.out.println(sQLException.toString());
            }
		
	}
	private void FustingBloodSugerNegativeCount() 
	{
            try {
                
            
		st = conn.createStatement();
                ResultSet FBSN = st.executeQuery("select count(FastingBloodsugger)as FastingBloodsugger from tbTrainingDataSet where FastingBloodsugger='"+cmbFastingBloodsugger.getSelectedItem().toString()+"' and Disease='Negative'");
		while(FBSN.next())
		{
			//Object element=iter.next();
			FustingBloodSugerNegativeCount=Double.parseDouble(FBSN.getString(1));
			TotalNegativeFustingBloodSuger=FustingBloodSugerNegativeCount/NegativeCount;
			System.out.println("ChestPainTypeNegativeCount "+TotalNegativeFustingBloodSuger);
		}
	} catch (Exception e) {
            System.out.println(e.toString());
            }	
	}
	
	
	private void RestecgPositiveCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet RP = st.executeQuery("select count(Restecg)as Restecg from tbTrainingDataSet where Restecg='" + cmbRestecg.getSelectedItem().toString() + "' and Disease='Positive'");
                while (RP.next()) {
                    //Object element = RP.next();
                    RestecgPositiveCount = Double.parseDouble(RP.getString(1));
                    TotalPositiveRestecg = RestecgPositiveCount / PositiveCount;
                    System.out.println("RestecgPositiveCount " + TotalPositiveRestecg);
                }
            } catch (Exception RPexception) {
                System.out.println(RPexception.toString());
            }
		
	}
	private void RestecgNegativeCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet RN = st.executeQuery("select count(Restecg)as Restecg from tbTrainingDataSet where Restecg='" + cmbRestecg.getSelectedItem().toString() + "' and Disease='Negative'");
                while (RN.next()) {
                    //Object element = RN.next();
                    RestecgNegativeCount = Double.parseDouble(RN.getString(1));
                    TotalNegativeRestecg = RestecgNegativeCount / NegativeCount;
                    System.out.println("RestecgNegativeCount " + TotalNegativeRestecg);
                }
            } catch (Exception RNexception) {
                System.out.println(RNexception.toString());
            }
		
	}
	
	
	private void ExangPositiveCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet EP = st.executeQuery("select count(Exang)as Exang from tbTrainingDataSet where Exang='" + cmbExang.getSelectedItem().toString() + "' and Disease='Positive'");
                while (EP.next()) {
                     
                    ExangPositiveCount = Double.parseDouble(EP.getString(1));
                    TotalPositiveExang = ExangPositiveCount / PositiveCount;
                    System.out.println("ExangPositiveCount " + TotalPositiveExang);
                }
            } catch (Exception EPexception) {
                System.out.println(EPexception.toString());
            }
		
	}
	private void ExangNegativeCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet EN = st.executeQuery("select count(Exang)as Exang from tbTrainingDataSet where Exang='" + cmbExang.getSelectedItem().toString() + "' and Disease='Negative'");
                while (EN.next()) {
                     
                    ExangNegativeCount = Double.parseDouble(EN.getString(1));
                    TotalNegativeExang = ExangNegativeCount / NegativeCount;
                    System.out.println("ExangNegativeCount " + TotalNegativeExang);
                }
            } catch (Exception ENexception) {
                System.out.println(ENexception.toString());
            }
		
	}
	
	
	private void SlopPositiveCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet SP1 = st.executeQuery("select count(Slop)as Slop from tbTrainingDataSet where Slop='" + cmbSlop.getSelectedItem().toString() + "' and Disease='Positive'");
                while (SP1.next()) {
                     
                    SlopPositiveCount = Double.parseDouble(SP1.getString(1));
                    TotalPositiveSlop = SlopPositiveCount / PositiveCount;
                    System.out.println("SlopPositiveCount " + TotalPositiveSlop);
                }
            } catch (Exception SPexception) {
                System.out.println(SPexception.toString());
            }
		
	}
	private void SlopNegativeCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet SN1 = st.executeQuery("select count(Slop)as Slop from tbTrainingDataSet where Slop='" + cmbSlop.getSelectedItem().toString() + "' and Disease='Negative'");
                while (SN1.next()) {
                     
                    SlopNegativeCount = Double.parseDouble(SN1.getString(1));
                    TotalNegativeSlop = SlopNegativeCount / NegativeCount;
                    System.out.println("SlopNegativeCount " + TotalNegativeSlop);
                }
            } catch (Exception SNexception) {
                System.out.println(SNexception.toString());
            }
		
	}
	
	private void ThalPositiveCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet TP1 = st.executeQuery("select count(Thal)as Thal from tbTrainingDataSet where Thal='" + cmbThal.getSelectedItem().toString() + "' and Disease='Positive'");
                while (TP1.next()) {
                     
                    ThalPositiveCount = Double.parseDouble(TP1.getString(1));
                    TotalPositiveThal = ThalPositiveCount / PositiveCount;
                    System.out.println("ThalPositiveCount " + TotalPositiveThal);
                }
            } catch (Exception TPexception) {
                System.out.println(TPexception.toString());
            }
		
	}
	private void ThalNegativeCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet TN1 = st.executeQuery("select count(Thal)as Thal from tbTrainingDataSet where Thal='" + cmbThal.getSelectedItem().toString() + "' and Disease='Negative'");
                while (TN1.next()) {
                     
                    ThalNegativeCount = Double.parseDouble(TN1.getString(1));
                    TotalNegativeThal = ThalNegativeCount / NegativeCount;
                    System.out.println("ThalNegativeCount =" + TotalNegativeThal);
                }
            } catch (Exception TNexception) {
                System.out.println(TNexception.toString());
            }
		
	}
	
	private void TrestBloodPresurePositiveCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet TBP = st.executeQuery("select count(TrestBloodPressure)as TrestBloodPresure from tbTrainingDataSet where TrestBloodPressure='" + cmbTrestBloodPressure.getSelectedItem().toString() + "' and Disease='Positive'");
                while (TBP.next()) {
                    TrestBloodPresurePositiveCount = Double.parseDouble(TBP.getString(1));
                    TotalPositiveTrestBloodPresure = TrestBloodPresurePositiveCount / PositiveCount;
                    System.out.println("TrestBloodPresurePositiveCount " + TotalPositiveTrestBloodPresure);
                }
            } catch (Exception TBPPException) {
                System.out.println(TBPPException.toString());
            } 
		
	}
	private void TrestBloodPresureNegativeCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet TBPN = st.executeQuery("select count(TrestBloodPressure)as TrestBloodPresure from tbTrainingDataSet where TrestBloodPressure='" + cmbTrestBloodPressure.getSelectedItem().toString() + "' and Disease='Negative'");
                while (TBPN.next()) {
                    
                    TrestBloodPresureNegativeCount = Double.parseDouble(TBPN.getString(1));
                    TotalNegativeTrestBloodPresure = TrestBloodPresureNegativeCount / NegativeCount;
                    System.out.println("TrestBloodPresureNegativeCount " + TotalNegativeTrestBloodPresure);
                }
            } catch (Exception TBNexception) {
                System.out.println(TBNexception.toString());
            }
		
	}
	
	private void SerumCholesterolPositiveCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet SCP = st.executeQuery("select count(SerumCholesterol)as SerumCholesterol from tbTrainingDataSet where SerumCholesterol='" + cmbSerumCholesterol.getSelectedItem().toString() + "' and Disease='Positive'");
                while (SCP.next()) {
                     
                    SerumCholesterolPositiveCount = Double.parseDouble(SCP.getString(1));
                    TotalPositiveSerumCholesterol = SerumCholesterolPositiveCount / PositiveCount;
                    System.out.println("SerumCholesterolPositiveCount " + TotalPositiveSerumCholesterol);
                }
            } catch (Exception SCPexception) {
                System.out.println(SCPexception.toString());
            }
		
	}
	private void SerumCholesterolNegativeCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet SCN = st.executeQuery("select count(SerumCholesterol)as SerumCholesterol from tbTrainingDataSet where SerumCholesterol='" + cmbSerumCholesterol.getSelectedItem().toString() + "' and Disease='Negative'");
                while (SCN.next()) {
                     
                    SerumCholesterolNegativeCount = Double.parseDouble(SCN.getString(1));
                    TotalNegativeSerumCholesterol = SerumCholesterolNegativeCount / NegativeCount;
                    System.out.println("SerumCholesterolNegativeCount " + TotalNegativeSerumCholesterol);
                }
            } catch (Exception SCNexception) {
                System.out.println(SCNexception.toString());
            }
		
	}
	
	
	private void ThalachPositiveCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet TP2 = st.executeQuery("select count(Thalach)as Thalach from tbTrainingDataSet where Thalach='" + cmbThalach.getSelectedItem().toString() + "' and Disease='Positive'");
                while (TP2.next()) {
                     
                    ThalachPositiveCount = Double.parseDouble(TP2.getString(1));
                    TotalPositiveThalach = ThalachPositiveCount / PositiveCount;
                    System.out.println("ThalachPositiveCount " + TotalPositiveThalach);
                }
            } catch (Exception TlcPexception) {
                System.out.println(TlcPexception.toString());
            }
		
	}
	private void ThalachNegativeCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet TN2 = st.executeQuery("select count(Thalach)as Thalach from tbTrainingDataSet where Thalach='" + cmbThalach.getSelectedItem().toString() + "' and Disease='Negative'");
                while (TN2.next()) {
                     
                    ThalachNegativeCount = Double.parseDouble(TN2.getString(1));
                    TotalNegativeThalach = ThalachNegativeCount / NegativeCount;
                    System.out.println("ThalachNegativeCount " + TotalNegativeThalach);
                }
            } catch (Exception TlcNexception) {
                System.out.println(TlcNexception.toString());
            }
		
	}
	
	private void OldpeakPositiveCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet OP1 = st.executeQuery("select count(OldPeak)as OldPeak from tbTrainingDataSet where OldPeak='" + cmbOldpeak.getSelectedItem().toString() + "' and Disease='Positive'");
                while (OP1.next()) {
                     
                    OldPeakPositiveCount = Double.parseDouble(OP1.getString(1));
                    TotalPositiveOldPeak = OldPeakPositiveCount / PositiveCount;
                    System.out.println("OldPeakPositiveCount " + TotalPositiveOldPeak);
                }
            } catch (Exception OpPexception) {
                System.out.println(OpPexception.toString());
            }
		
	}
	private void OldpeakNegativeCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet ON1 = st.executeQuery("select count(OldPeak)as OldPeak from tbTrainingDataSet where OldPeak='" + cmbOldpeak.getSelectedItem().toString() + "' and Disease='Negative'");
                while (ON1.next()) {
                     
                    OldPeakNegativeCount = Double.parseDouble(ON1.getString(1));
                    TotalNegativeOldPeak = OldPeakNegativeCount / NegativeCount;
                    System.out.println("OldPeakNegativeCount " + TotalNegativeOldPeak);
                }
            } catch (Exception OpNexception) {
                System.out.println(OpNexception.toString());
            }
		
	}
	
	
	private void SmokingPositiveCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet SP2 = st.executeQuery("select count(Smoking)as Smoking from tbTrainingDataSet where Smoking='" + cmbSmoking.getSelectedItem().toString() + "' and Disease='Positive'");
                while (SP2.next()) {
                     
                    SmokingPositiveCount = Double.parseDouble(SP2.getString(1));
                    TotalPositiveSmoking = SmokingPositiveCount / PositiveCount;
                    System.out.println("SmokingPositiveCount " + TotalPositiveSmoking);
                }
            } catch (Exception SPexception) {
                System.out.println(SPexception.toString());
            }
		
	}
	private void SmokingNegativeCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet SN2 = st.executeQuery("select count(Smoking)as Smoking from tbTrainingDataSet where Smoking='" + cmbSmoking.getSelectedItem().toString() + "' and Disease='Negative'");
                while (SN2.next()) {
                     
                    SmokingNegativeCount = Double.parseDouble(SN2.getString(1));
                    TotalNegativeSmoking = SmokingNegativeCount / NegativeCount;
                    System.out.println("SmokingNegativeCount " + TotalNegativeSmoking);
                }
            } catch (Exception SNexception) {
                System.out.println(SNexception.toString());
            }
		
	}
	
	
	private void ObesityPositiveCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet OP4 = st.executeQuery("select count(Obesity)as Obesity from tbTrainingDataSet where Obesity='" + cmbObesity.getSelectedItem().toString() + "' and Disease='Positive'");
                while (OP4.next()) {
                     
                    ObesityPositiveCount = Double.parseDouble(OP4.getString(1));
                    TotalPositiveObesity = ObesityPositiveCount / PositiveCount;
                    System.out.println("ObesityPositiveCount " + TotalPositiveObesity);
                }
            } catch (Exception OPexception) {
                System.out.println(OPexception.toString());
            }
		
	}
	private void ObesityNegativeCount() 
	{
		          try {
                st = conn.createStatement();
                ResultSet ON4 = st.executeQuery("select count(Obesity)as Obesity from tbTrainingDataSet where Obesity='" + cmbObesity.getSelectedItem().toString() + "' and Disease='Negative'");
                while (ON4.next()) {
                     
                    ObesityNegativeCount = Double.parseDouble(ON4.getString(1));
                    TotalNegativeObesity = ObesityNegativeCount / NegativeCount;
                    System.out.println("ObesityNegativeCount " + TotalNegativeObesity);
                }
            } catch (Exception ONException) {
                System.out.println(ONException.toString());
            }
		
	}
	private void AllPositiveCalculation()
	{
		AllPositiveCalculation=TotalPositiveAge*TotalPositiveGender*TotalPositiveChestPainType*TotalPositiveFustingBloodSuger*TotalPositiveRestecg*TotalPositiveExang*TotalPositiveSlop*TotalPositiveThal*TotalPositiveTrestBloodPresure*TotalPositiveSerumCholesterol*TotalPositiveThalach*TotalPositiveOldPeak*TotalPositiveSmoking*TotalPositiveObesity;
		System.out.println("AllPositiveCalculation= "+AllPositiveCalculation);
	}
	
	private void AllNegativeCalculation()
	{
		AllNegativeCalculation=TotalNegativeAge*TotalNegativeGender*TotalNegativeChestPainType*TotalNegativeFustingBloodSuger*TotalNegativeRestecg*TotalNegativeExang*TotalNegativeSlop*TotalNegativeThal*TotalNegativeTrestBloodPresure*TotalNegativeSerumCholesterol*TotalNegativeThalach*TotalNegativeOldPeak*TotalNegativeSmoking*TotalNegativeObesity;
		System.out.println("AllNegativeCalculation= "+AllNegativeCalculation);
	}
	
	private void DiseasePositiveCalculation()
	{
		DiseasePositiveCalculation=AllPositiveCalculation*TotalPositive;
		System.out.println("DiseasePositiveCalculation= "+DiseasePositiveCalculation);
	}
	
	private void DiseaseNegativeCalculation()
	{
		DiseaseNegativeCalculation=AllNegativeCalculation*TotalNegative;
		System.out.println("DiseaseNegativeCalculation= "+DiseaseNegativeCalculation);
	}
	
	
        private void ComponentAdd() 
	{
            lblPatientId.setBounds(40, 100, 120, 30);
            panel.add(lblPatientId);
            
            lbltxtPatientId.setBounds(180, 100, 190, 30);
            panel.add(lbltxtPatientId);
            lbltxtPatientId.setFont(lbltxtPatientId.getFont().deriveFont(15f));
            
            lblPaitentName.setBounds(540, 100, 120, 30);
            panel.add(lblPaitentName);
            
            txtPatientName.setBounds(680, 100, 190, 30);
            panel.add(txtPatientName);
            
            lblage.setBounds(40, 160, 120, 30);
            panel.add(lblage);
            
            cmbage.setBounds(180, 160, 190, 30);
            panel.add(cmbage);
            
            lblGender.setBounds(540, 160, 120, 30);
            panel.add(lblGender);
            
            cmbgender.setBounds(680, 160, 190, 30);
            panel.add(cmbgender);
            
            lblChestPaintype.setBounds(40, 220, 120, 30);
            panel.add(lblChestPaintype);
            
            cmbChestPaintype.setBounds(180, 220, 190, 30);
            panel.add(cmbChestPaintype);
            
            lblFastingBloodsugger.setBounds(540, 220, 130, 30);
            panel.add(lblFastingBloodsugger);
            
            cmbFastingBloodsugger.setBounds(680, 220, 190, 30);
            panel.add(cmbFastingBloodsugger);
            
            lblRestecg.setBounds(40, 280, 130, 30);
            panel.add(lblRestecg);
            
            cmbRestecg.setBounds(180, 280, 190, 30);
            panel.add(cmbRestecg);
            
            lblExang.setBounds(540, 280, 130, 30);
            panel.add(lblExang);
            
            cmbExang.setBounds(680, 280, 190, 30);
            panel.add(cmbExang);
            
            lblSlop.setBounds(40, 340, 130, 30);
            panel.add(lblSlop);
            
            cmbSlop.setBounds(180, 340, 190, 30);
            panel.add(cmbSlop);
            
            lblThal.setBounds(540, 340, 130, 30);
            panel.add(lblThal);
            
            cmbThal.setBounds(680, 340, 190, 30);
            panel.add(cmbThal);
            
            lblTrestBloodPressure.setBounds(40, 400, 130, 30);
            panel.add(lblTrestBloodPressure);
            
            cmbTrestBloodPressure.setBounds(180, 400, 190, 30);
            panel.add(cmbTrestBloodPressure);
            
            lblSerumCholesterol.setBounds(540, 400, 130, 30);
            panel.add(lblSerumCholesterol);
            
            cmbSerumCholesterol.setBounds(680, 400, 190, 30);
            panel.add(cmbSerumCholesterol);
            
            lblThalach.setBounds(40, 460, 130, 30);
            panel.add(lblThalach);
            
            cmbThalach.setBounds(180, 460, 190, 30);
            panel.add(cmbThalach);
            
            lblOldpeak.setBounds(540, 460, 130, 30);
            panel.add(lblOldpeak);
            
            cmbOldpeak.setBounds(680, 460, 190, 30);
            panel.add(cmbOldpeak);
            
            lblSmoking.setBounds(40, 520, 130, 30);
            panel.add(lblSmoking);
            
            cmbSmoking.setBounds(180, 520, 190, 30);
            panel.add(cmbSmoking);
            
            lblObesity.setBounds(540, 520, 130, 30);
            panel.add(lblObesity);
            
            cmbObesity.setBounds(680, 520, 190, 30);
            panel.add(cmbObesity);
            
            btnsave.setBounds(280, 580, 130, 35);
            btnsave.addActionListener(this);
            btnsave.setFont(btnsave.getFont().deriveFont(15f));
            panel.add(btnsave);
            
            btnrefresh.setBounds(520, 580, 130, 35);
            btnrefresh.addActionListener(this);
            btnrefresh.setFont(btnrefresh.getFont().deriveFont(15f));
            panel.add(btnrefresh);
	}
       
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnrefresh){
            ClearMethod();
        }
        if(ae.getSource() == btnsave){
            if(CheckValidation() == true){
            PCiAndPXCiCalculation();
            CARTValueCalculation();
            inserdata();
            Chi_Square cho= new Chi_Square();
            String Id = lbltxtPatientId.getText();
            cho.ChiValueCalculation(Id);
             }
        }
    }


    
}
