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
import java.util.*;
import javax.management.Notification;
import javax.swing.*;

public class NaiveBayes extends JFrame implements ActionListener{
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
	
	
	JTextField txtPatientId=new JTextField();
	JTextField txtPatientName=new JTextField();
	
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
	
	JButton btnsave=new JButton("Test");
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
        Connection conn=null;
        Statement st;
        ResultSet rs;
        PreparedStatement pst;
	
	NaiveBayes(){
            super("Intelligent Heart Disease Prediction System ::: Naive Bayes.");
            panel.setLayout(null);
            setVisible(true);
            setSize(940,730);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel.setBackground(Color.LIGHT_GRAY);
            setLocationRelativeTo(null);
            setResizable(false);
            add(panel);
            ComponentAdd();
            conn=DB.getConnection();
	}
	protected void InsertDataWork()
	{
            /*Session session=null;
            Transaction tran=null;
            try
            {
            session=SessionFactoryUtil.getInstance().openSession();
            tran=session.beginTransaction();
            String sql="insert into TbTrainingDataSet(PatientId,patientName,Age,Gender,ChestPainType,FastingBloodsugger,Restecg,Exang,Slop,Thal,TrestBloodPressure,SerumCholesterol,Thalach,Oldpeak,Smoking,Obesity,Disease)values" +
            "('"+txtPatientId.getValue()+"','"+txtPatientName.getValue()+"','"+cmbage.getValue()+"','"+cmbgender.getValue()+"','"+cmbChestPaintype.getValue()+"','"+cmbFastingBloodsugger.getValue()+"','"+cmbRestecg.getValue()+"'," +
            "'"+cmbExang.getValue()+"','"+cmbSlop.getValue()+"','"+cmbThal.getValue()+"','"+cmbTrestBloodPressure.getValue()+"','"+cmbSerumCholesterol.getValue()+"','"+cmbThalach.getValue()+"','"+cmbOldpeak.getValue()+"','"+cmbSmoking.getValue()+"','"+cmbObesity.getValue()+"','"+txtDisease.getValue()+"')";
            
            session.createSQLQuery(sql).executeUpdate();
            }
            catch (Exception exp)
            {
            tran.rollback();
            getWindow().showNotification(""+exp,Notification.TYPE_ERROR_MESSAGE);
            
            }
            finally
            {
            if(session!=null||tran!=null)
            {
            tran.commit();
            session.close();
            getWindow().showNotification("All Information Successfully Save",Notification.TYPE_HUMANIZED_MESSAGE);
            
            }
            }*/
	}
        private void ClearMethod() 
	{
		txtPatientId.setText("");
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
	
        /*private void AutoidLoad()
        {
        Iterator iter=DbCommonService("select isnull(max(cast(SUBSTRING (PatientId,CHARINDEX('-',PatientId)+1,LEN(PatientId)-CHARINDEX('-',PatientId)) as int )),0)+1 from TbTrainingDataSet");
        while(iter.hasNext())
        {
        Object element=iter.next();
        txtPatientId.setValue("PI-"+element);
        
        }
        }*/
	
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
			txtDisease.setText("Positive");
			JOptionPane.showMessageDialog(null,"Heart Disease Result is Positive");
		}
		else
		{
			txtDisease.setText("Negative");
			JOptionPane.showMessageDialog(null,"Heart Disease Result is Negative");
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
            lblPatientId.setBounds(40, 120, 120, 30);
            panel.add(lblPatientId);
            
            txtPatientId.setBounds(180, 120, 190, 30);
            panel.add(txtPatientId);
            
            lblPaitentName.setBounds(540, 120, 120, 30);
            panel.add(lblPaitentName);
            
            txtPatientName.setBounds(680, 120, 190, 30);
            panel.add(txtPatientName);
            
            lblage.setBounds(40, 180, 120, 30);
            panel.add(lblage);
            
            cmbage.setBounds(180, 180, 190, 30);
            panel.add(cmbage);
            
            lblGender.setBounds(540, 180, 120, 30);
            panel.add(lblGender);
            
            cmbgender.setBounds(680, 180, 190, 30);
            panel.add(cmbgender);
            
            lblChestPaintype.setBounds(40, 240, 120, 30);
            panel.add(lblChestPaintype);
            
            cmbChestPaintype.setBounds(180, 240, 190, 30);
            panel.add(cmbChestPaintype);
            
            lblFastingBloodsugger.setBounds(540, 240, 130, 30);
            panel.add(lblFastingBloodsugger);
            
            cmbFastingBloodsugger.setBounds(680, 240, 190, 30);
            panel.add(cmbFastingBloodsugger);
            
            lblRestecg.setBounds(40, 300, 130, 30);
            panel.add(lblRestecg);
            
            cmbRestecg.setBounds(180, 300, 190, 30);
            panel.add(cmbRestecg);
            
            lblExang.setBounds(540, 300, 130, 30);
            panel.add(lblExang);
            
            cmbExang.setBounds(680, 300, 190, 30);
            panel.add(cmbExang);
            
            lblSlop.setBounds(40, 360, 130, 30);
            panel.add(lblSlop);
            
            cmbSlop.setBounds(180, 360, 190, 30);
            panel.add(cmbSlop);
            
            lblThal.setBounds(540, 360, 130, 30);
            panel.add(lblThal);
            
            cmbThal.setBounds(680, 360, 190, 30);
            panel.add(cmbThal);
            
            lblTrestBloodPressure.setBounds(40, 420, 130, 30);
            panel.add(lblTrestBloodPressure);
            
            cmbTrestBloodPressure.setBounds(180, 420, 190, 30);
            panel.add(cmbTrestBloodPressure);
            
            lblSerumCholesterol.setBounds(540, 420, 130, 30);
            panel.add(lblSerumCholesterol);
            
            cmbSerumCholesterol.setBounds(680, 420, 190, 30);
            panel.add(cmbSerumCholesterol);
            
            lblThalach.setBounds(40, 480, 130, 30);
            panel.add(lblThalach);
            
            cmbThalach.setBounds(180, 480, 190, 30);
            panel.add(cmbThalach);
            
            lblOldpeak.setBounds(540, 480, 130, 30);
            panel.add(lblOldpeak);
            
            cmbOldpeak.setBounds(680, 480, 190, 30);
            panel.add(cmbOldpeak);
            
            lblSmoking.setBounds(40, 540, 130, 30);
            panel.add(lblSmoking);
            
            cmbSmoking.setBounds(180, 540, 190, 30);
            panel.add(cmbSmoking);
            
            lblObesity.setBounds(540, 540, 130, 30);
            panel.add(lblObesity);
            
            cmbObesity.setBounds(680, 540, 190, 30);
            panel.add(cmbObesity);
            
            btnsave.setBounds(280, 600, 130, 35);
            btnsave.addActionListener(this);
            btnsave.setFont(btnsave.getFont().deriveFont(15f));
            panel.add(btnsave);
            
            btnrefresh.setBounds(520, 600, 130, 35);
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
            }
        }
    }


    
}
