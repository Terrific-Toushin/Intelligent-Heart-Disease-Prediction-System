package com.toushin.IHDPS;

import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import java.util.Iterator;
import java.math.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.*;


public class Chi_Square
{
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        JPanel panel = new JPanel();
	
	JLabel lblChiId=new JLabel("Chi ID :");
	JLabel lblAge=new JLabel("Age :");
	JLabel lblGender=new JLabel("Gender :");
	JLabel lblChestPainType=new JLabel("Chest Pain Type :");
	JLabel lblFasting=new JLabel("Fasting Blood Sugger :");
	JLabel lblRestecg=new JLabel("Rest ECG :");
	JLabel lblExang=new JLabel("Exang :");
	JLabel lblSlop=new JLabel("Slop :");
	JLabel lblThal=new JLabel("Thal :");
	JLabel lblTrest=new JLabel("Trest Blood Pressure :");
	JLabel lblSerum=new JLabel("Serum Cholesterol :");
	JLabel lblThalach=new JLabel("Thalach :");
	JLabel lblOldpeak=new JLabel("OldPeak :");
	JLabel lblSmoking=new JLabel("Smoking :");
	JLabel lblObesity=new JLabel("Obesity :");
	JLabel lblBestcalss=new JLabel("Best Class Level ");
	
	JTextField txtChiid=new JTextField();
	JTextField txtage=new JTextField();
	JTextField txtgender=new JTextField();
	JTextField txtchestpain=new JTextField();
	JTextField txtfasting=new JTextField();
	JTextField txtrestecg=new JTextField();
	JTextField txtexang=new JTextField();
	JTextField txtslop=new JTextField();
	JTextField txtthal=new JTextField();
	JTextField txttrest=new JTextField();
	JTextField txtserum=new JTextField();
	JTextField txtthalach=new JTextField();
	JTextField txtoldpeak=new JTextField();
	JTextField txtsmoking=new JTextField();
	JTextField txtobesity=new JTextField();
	JLabel lblbestclass=new JLabel();
	JLabel lblBestclassName=new JLabel();
	
	
	
	
	
	JButton btntest=new JButton("Test");
	JButton button=new JButton("Refresh");
        JButton btnfind = new JButton("Find");
	
	double ageyoungpositive=0,ageyoungNegative=0,ageMidpositive=0,ageMidNegative=0,ageOldpositive=0,ageOldNegative=0,ageVeryOldpositive=0,ageVeryOldNegative,Totalyoung=0,TotalMid=0,TotalOld=0,TotalVeryOld=0,TotalAgePositive=0,TotalAgeNegative=0,TotalAge=0;
	double Gendermalepositive=0,GendermaleNegative=0,GenderFemalepositive=0,GenderFemaleNegative=0,Totalmale=0,TotalFemale=0,TotalgenderPositive=0,TotalgenderNegative=0,TotalGender=0;	
	double ChestTypicalpositive=0,ChestTypicalNegative=0,ChestaTypicalpositive=0,ChestaTypicalNegative=0,Chestnonanginapositive=0,ChestnonanginaNegative=0,Chestasymptomaticpositive=0,ChestasymptomaticNegative,TotalTypical=0,Totalatypical=0,Totalnonnagina=0,Totalasymptomatic=0,TotalchestPositive=0,TotalchestNegative=0,Totalchest=0;
	double Fastingyespositive=0,FastingyesNegative=0,Fastingnopositive=0,FastingnoNegative=0,Totalyes=0,Totalno=0,TotalFastingPositive=0,TotalFastingNegative=0,TotalFasting=0;		
	double Restnormalpositive=0,RestnormalNegative=0,RestST_Tpositive=0,RestST_TNegative=0,RestHypertrophypositive=0,RestHypertrophyNegative=0,TotalNormal=0,TotalST_T=0,TotalHypertrophy=0,TotalRestPositive=0,TotalRestNegative=0,TotalRest=0;	
	double Exangyespositive=0,ExangyesNegative=0,Exangnopositive=0,ExangnoNegative=0,TotalYes=0,TotalNo=0,TotalExangPositive=0,TotalExangNegative=0,TotalExang=0;
	double SlopUnslopingpositive=0,SlopUnslopingNegative=0,SlopFlatpositive=0,SlopFlatNegative=0,SlopDownsloppositive=0,SlopDownslopNegative=0,TotalUnslop=0,TotalFalt=0,TotalDownslop=0,TotalSlopPositive=0,TotalSlopNegative=0,TotalSlop=0;
	double Thalnormalpositive=0,ThalnormalNegative=0,ThalFixedpositive=0,ThalFixedNegative=0,ThalReversiblepositive=0,ThalReversibleNegative=0,TotalthalNormal=0,TotalthalFixed=0,Totalthalreversible=0,TotalthalPositive=0,TotalthalNegative=0,Totalthal=0;	
	double TrestBloodlowpositive=0,TrestBloodlowNegative=0,TrestBloodmediumpositive=0,TrestBloodmediumNegative=0,TrestBloodhighpositive=0,TrestBloodhighNegative=0,TrestBloodveryhighpositive=0,TrestBloodverryhighNegative=0,TotalTrestBloodlow=0,TotalTrestBloodmedium=0,TotalTrestBloodhigh=0,TotalTrestBloodveryhigh=0,TotalTrestBloodpositive=0,TotalTrestBloodNegative=0,TotalTrestBlood=0;
	double SerumCholestorellowpositive=0,SerumCholestorellowNegative=0,SerumCholestorelmediumpositive=0,SerumCholestorelmediumNegative=0,SerumCholestorelhighpositive=0,SerumCholestorelhighNegative=0,SerumCholestorelveryhighpositive=0,SerumCholestorelverryhighNegative=0,TotalSerumCholestorellow=0,TotalSerumCholestorelmedium=0,TotalSerumCholestorelhigh=0,TotalSerumCholestorelveryhigh=0,TotalSerumCholestorelpositive=0,TotalSerumCholestorelNegative=0,TotalSerumCholestorel=0;
	double Thalachlowpositive=0,ThalachlowNegative=0,Thalachmediumpositive=0,ThalachmediumNegative=0,Thalachhighpositive=0,ThalachhighNegative=0,TotalThalachlow=0,TotalThalachmedium=0,TotalThalachhigh=0,TotalThalachpositive=0,TotalThalachNegative=0,TotalThalach=0;		
	double OldPeaklowpositive=0,OldPeaklowNegative=0,OldPeakRiskpositive=0,OldPeakRiskNegative=0,OldPeakTerriblepositive=0,OldPeakTerribleNegative=0,TotalOldPeaklow=0,TotalOldPeakRisk=0,TotalOldPeakTerrible=0,TotalOldPeakpositive=0,TotalOldPeakNegative=0,TotalOldPeak=0;
	double SmokingPastpositive=0,SmokingPastNegative=0,SmokingCurrentpositive=0,SmokingCurrentNegative=0,SmokingNeverpositive=0,SmokingNeverNegative=0,TotalSmokingpast=0,TotalSmokingcurrent=0,TotalSmokingnever=0,TotalSmokingpositive=0,TotalSmokingNegative=0,TotalSmoking=0;
	double Obesityyespositive=0,ObesityyesNegative=0,Obesitynopositive=0,ObesitynoNegative=0,TotalObesityyes=0,TotalObesityno=0,TotalObesityPositive=0,TotalObesityNegative=0,TotalObesity=0;		
	
	double Ageyoungpositive=0,AgeMidpositive=0,Ageoldpositive=0,Ageveryoldpositive=0, AgeyoungNegative=0,AgeMidNegative=0,AgeoldNegative=0,AgeveryoldNegative=0;
	double GENDERMALEPOSITIVE=0,GENDERFEMALEPOSITIVE=0,GENDERMALENEGATIVE=0,GENDERFEMALENEGATIVE=0;
	double CHESTTYPICALPOSITIVE=0,CHESTATYPICALPOSITIVE=0,CHESTNONPOSITIVE=0,CHESTASYMPTOMATICPOSITIVE=0,CHESTTYPICALNEGATIVE=0,CHESTATYPICALNEGATIVE=0,CHESTNONNEGATIVE=0,CHESTASYMPTOMATICNEGATIVE=0;
	double FASTINGYESPOSITIVE=0,FASTINGNOPOSITIVE=0,FASTINGYESNEGATIVE=0,FASTINGNONEGATIVE=0;
	double RESTNORMALEPOSITIVE=0,RESTST_TPOSITIVE=0,RESTHYPERTROPHYPOSITIVE=0,RESTNORMALNEGATIVE=0,RESTST_TNEGATIVE=0,RESTHYPERTROPHYNEGATIVE=0;
	double EXANGYESPOSITIVE=0,EXANGNOPOSITIVE=0,EXANGYESNEGATIVE=0,EXANGNONEGATIVE=0;
	double SLOPUNSLOPPOSITIVE=0,SLOPFLATPOSITIVE=0,SLOPDOWNPOSITIVE=0,SLOPUNSLOPNEGATIVE=0,SLOPFLATNEGATIVE=0,SLOPDOWNNEGATIVE=0;
	double THALNORMALPOSITIVE=0,THALFIXEDPOSITIVE=0,THALREVERSIBLEPOSITIVE=0,THALNORMALNEGATIVE=0,THALFIXEDNEGATIVE=0,THALREVERSIBLENEGATIVE=0;
	double TRESTLOWPOSITIVE=0,TRESTMEDIUMPOSITIVE=0,TRESTHIGHPOSITIVE=0,TRESTVERYHIGHPOSITIVE=0,TRESTLOWNEGATIVE=0,TRESTMEDIUMNEGATIVE=0,TRESTHIGHNEGATIVE=0,TRESTVERYHIGHNEGATIVE=0;	
	double SERUMLOWPOSITIVE=0,SERUMMEDIUMPOSITIVE=0,SERUMHIGHPOSITIVE=0,SERUMVERYHIGHPOSITIVE=0,SERUMLOWNEGATIVE=0,SERUMMEDIUMNEGATIVE=0,SERUMHIGHNEGATIVE=0,SERUMVERYHIGHNEGATIVE=0;
	double THALACHLOWPOSITIVE=0,THALACHMEDIUMPOSITIVE=0,THALACHHIGHPOSITIVE=0,THALACHLOWNEGATIVE=0,THALACHMEDIUMNEGATIVE=0,THALACHHIGHNEGATIVE=0;
	double OLDPEAKLOWPOSITIVE=0,OLDPEAKRISKPOSITIVE=0,OLDPEAKTERRIBLEPOSITIVE=0,OLDPEALLOWNEGATIVE=0,OLDPEAKRISKNEGATIVE=0,OLDPEAKTERRIBLENEGATIVE=0;
	double SMOKINGPASTPOSITIVE=0,SMOKINGCURRENTPOSITIVE=0,SMOKINGNEVERPOSITIVE=0,SMOKINGPASTNEGATIVE=0,SMOKINGCURRENTNEGATIVE=0,SMOKINGNEVERNEGATIVE=0;
	double OBESITYYESPOSITIVE=0,OBESITYNOTPOSITIVE=0,OBESITYYESNEGATIVE=0,OBESITYNONEGATIVE=0;
	
	JLabel lblfind=new JLabel();
	
	DecimalFormat df=new DecimalFormat("#0.0000");
        Connection conn=null;
        Statement st;
        ResultSet rs;
        PreparedStatement pst;
	
	public Chi_Square()
	{
            conn=DB.getConnection();	
	}
	private void ObserveValueCalculation() 
	{
		AgeObserveValue();
		GenderObserveValue();
		ChestpaintypeObservevalue();
		FastingBloodsuggerobserveValue();
		RestECGObsebveValue();
		ExangobserveValue();
		SlopObsebveValue();
		ThalObsebveValue();
		TrestBloodObsebveValue();
		SerumCholestorelObsebveValue();
		ThalachObsebveValue();
		OldPeakObsebveValue();
		SmokingObsebveValue();
		ObesityObsebveValue();
	}
	
	private void ExpectedValueCalculation() 
	{
		AgeExpectedValue();
		GenderExpectedValue();
		ChestpaintypeExpectedValue();
		FastingBloodSuggerExpectedValue();
		RestECGExpectedValue();
		ExangExpectedValue();
		SlopExpectedValue();
		ThalExpectedValue();
		TrestbloodpressureExpectedValue();
		SerumcholesterolExpectedValue();
		ThalachExpectedValue();
		OldpeakExpectedValue();
		SmokingExpectedValue();
		ObesityExpectedValue();
		
	}
	
	void ChiValueCalculation(String Id) 
	{
            ObserveValueCalculation();
            ExpectedValueCalculation();
		ChiValue();
                insert(Id);
		
	}
	private void insert(String chiId){
            try{
		PreparedStatement ps=conn.prepareStatement("update tbtrainingdataset set BestClassName='"+lblBestclassName.getText()+"' where patientId='"+chiId+"'");
		ps.executeUpdate();
		conn.close();
                System.out.println("Chi Class label Updated");
	}
        catch(Exception e){
            System.out.println(e.toString());
        }
        }
	private void AgeObserveValue() 
	{
		          try {
                st = conn.createStatement();
                ResultSet AOVYP= st.executeQuery("select count(Age)as young from tbTrainingDataSet where Disease='Positive'and Age='Young'");
                while (AOVYP.next()) {
                    //Object element = iteryoungpositive.next();
                    ageyoungpositive = Double.parseDouble(AOVYP.getString(1));
                    System.out.println("ageyoungpositive " + ageyoungpositive);
                }
            } catch (Exception Ageexception) {
                              System.out.println(Ageexception.toString());
            }
		
		          try {
                st = conn.createStatement();
                ResultSet iteryoungnegative = st.executeQuery("select count(Age)as young from tbTrainingDataSet where Disease='Negative'and Age='Young'");
                while (iteryoungnegative.next()) {
                    //Object element = iteryoungnegative.next();
                    ageyoungNegative = Double.parseDouble(iteryoungnegative.getString(1));
                    System.out.println("ageyoungNegative " + ageyoungNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();
                ResultSet iterMidpositive = st.executeQuery("select count(Age)as Mid from tbTrainingDataSet where Disease='Positive'and Age='Mid'");
                while (iterMidpositive.next()) {
                    //Object element = iterMidpositive.next();
                    ageMidpositive = Double.parseDouble(iterMidpositive.getString(1));
                    System.out.println("ageMidpositive " + ageMidpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();
                ResultSet iterMidnegative = st.executeQuery("select count(Age)as Mid from tbTrainingDataSet where Disease='Negative'and Age='Mid'");
                while (iterMidnegative.next()) {
                    //Object element = iterMidnegative.next();
                    ageMidNegative = Double.parseDouble(iterMidnegative.getString(1));
                    System.out.println("ageMidNegative " + ageMidNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();
                ResultSet iterOldpositive = st.executeQuery("select count(Age)as old from tbTrainingDataSet where Disease='Positive'and Age='Old'");
                while (iterOldpositive.next()) {
                    //Object element = iterOldpositive.next();
                    ageOldpositive = Double.parseDouble(iterOldpositive.getString(1));
                    System.out.println("ageOldpositive " + ageOldpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();
                ResultSet iterOldnegative = st.executeQuery("select count(Age)as old from tbTrainingDataSet where Disease='Negative'and Age='Old'");
                while (iterOldnegative.next()) {
                    //Object element = iterOldnegative.next();
                    ageOldNegative = Double.parseDouble(iterOldnegative.getString(1));
                    System.out.println("ageOldNegative " + ageOldNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();
                ResultSet iterVeryOldpositive = st.executeQuery("select count(Age)as veryold from tbTrainingDataSet where Disease='Positive'and Age='very old'");
                while (iterVeryOldpositive.next()) {
                    //Object element = iterVeryOldpositive.next();
                    ageVeryOldpositive = Double.parseDouble(iterVeryOldpositive.getString(1));
                    System.out.println("ageVeryOldpositive " + ageVeryOldpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();
                ResultSet iterVeryOldnegative = st.executeQuery("select count(Age)as veryold from tbTrainingDataSet where Disease='Negative'and Age='very old'");
                while (iterVeryOldnegative.next()) {
                    //Object element = iterVeryOldnegative.next();
                    ageVeryOldNegative = Double.parseDouble(iterVeryOldnegative.getString(1));
                    System.out.println("ageVeryOldNegative " + ageVeryOldNegative);
                }
            } catch (Exception exception) {
            }
		/////////
		Totalyoung=ageyoungpositive+ageyoungNegative;
		System.out.println("Totalyoung "+Totalyoung);
		TotalMid=ageMidpositive+ageMidNegative;
		System.out.println("TotalMid "+TotalMid);
		TotalOld=ageOldpositive+ageOldNegative;
		System.out.println("TotalOld "+TotalOld);
		TotalVeryOld=ageVeryOldpositive+ageVeryOldNegative;
		System.out.println("TotalVeryOld "+TotalVeryOld);
		
		
		TotalAgePositive=ageyoungpositive+ageMidpositive+ageOldpositive+ageVeryOldpositive;
		System.out.println("TotalAgePositive "+TotalAgePositive);
		TotalAgeNegative=ageyoungNegative+ageMidNegative+ageOldpositive+ageVeryOldpositive;
		System.out.println("TotalAgeNegative "+TotalAgeNegative);
		
		TotalAge=TotalAgePositive+TotalAgeNegative;
		System.out.println("TotalAge "+TotalAge);
	}
	///////////////////////       ///////////////////////
	private void GenderObserveValue() 
	{
		          try {
                st = conn.createStatement();
                ResultSet itermalepositive = st.executeQuery("select count(Gender)as male from tbTrainingDataSet where Disease='Positive'and Gender='male'");
                while (itermalepositive.next()) {
                    //Object element = itermalepositive.next();
                    Gendermalepositive = Double.parseDouble(itermalepositive.getString(1));
                    System.out.println("Gendermalepositive " + Gendermalepositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();
                ResultSet itermalenegative = st.executeQuery("select count(Gender)as male from tbTrainingDataSet where Disease='Negative'and Gender='male'");
                while (itermalenegative.next()) {
                    //Object element = itermalenegative.next();
                    GendermaleNegative = Double.parseDouble(itermalenegative.getString(1));
                    System.out.println("GendermaleNegative " + GendermaleNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();
                ResultSet iterfemalepositive = st.executeQuery("select count(Gender)as female from tbTrainingDataSet where Disease='Positive'and Gender='female'");
                while (iterfemalepositive.next()) {
                    //Object element = iterfemalepositive.next();
                    GenderFemalepositive = Double.parseDouble(iterfemalepositive.getString(1));
                    System.out.println("GenderFemalepositive " + GenderFemalepositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();
                ResultSet iterfemalenegative = st.executeQuery("select count(Gender)as female from tbTrainingDataSet where Disease='Negative'and Gender='female'");
                while (iterfemalenegative.next()) {
                    //Object element = iterfemalenegative.next();
                    GenderFemaleNegative = Double.parseDouble(iterfemalenegative.getString(1));
                    System.out.println("GenderFemaleNegative " + GenderFemaleNegative);
                }
            } catch (Exception exception) {
            }
		/////////
		Totalmale=Gendermalepositive+GendermaleNegative;
		System.out.println("Totalmale "+Totalmale);
		TotalFemale=GenderFemalepositive+GenderFemaleNegative;
		System.out.println("TotalFemale "+TotalFemale);
		
		TotalgenderPositive=Gendermalepositive+GenderFemalepositive;
		System.out.println("TotalgenderPositive "+TotalgenderPositive);
		TotalgenderNegative=GendermaleNegative+GenderFemaleNegative;
		System.out.println("TotalgenderNegative "+TotalgenderNegative);
		
		TotalGender=TotalgenderPositive+TotalgenderNegative;
		System.out.println("Totalgender "+TotalGender);
	}
	////////////////// /    ///////////////////
	private void ChestpaintypeObservevalue() 
	{
		          try {
                st = conn.createStatement();
                ResultSet itertypicalpositive = st.executeQuery("select count(ChestPainType)as typical from tbTrainingDataSet where Disease='Positive'and ChestPainType='Typical Angina'");
                while (itertypicalpositive.next()) {
                    //Object element = itertypicalpositive.next();
                    ChestTypicalpositive = Double.parseDouble(itertypicalpositive.getString(1));
                    System.out.println("ChestTypicalpositive " + ChestTypicalpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();
                ResultSet itertypicalnegative = st.executeQuery("select count(ChestPainType)as typical from tbTrainingDataSet where Disease='Negative'and ChestPainType='Typical Angina'");
                while (itertypicalnegative.next()) {
                    //Object element = itertypicalnegative.next();
                    ChestTypicalNegative = Double.parseDouble(itertypicalnegative.getString(1));
                    System.out.println("ChestTypicalNegative " + ChestTypicalNegative);
                }
            } catch (Exception exception) {
            }
		
		///////////////
		
		          try {
                st = conn.createStatement();    
                ResultSet iteratypicalpositive = st.executeQuery("select count(ChestPainType)as atypical from tbTrainingDataSet where Disease='Positive'and ChestPainType='Atypical Angina'");
                while (iteratypicalpositive.next()) {
                    //Object element = iteratypicalpositive.next();
                    ChestaTypicalpositive = Double.parseDouble(iteratypicalpositive.getString(1));
                    System.out.println("ChestaTypicalpositive " + ChestaTypicalpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();     
                ResultSet iteratypicalnegative = st.executeQuery("select count(ChestPainType)as atypical from tbTrainingDataSet where Disease='Negative'and ChestPainType='Atypical Angina'");
                while (iteratypicalnegative.next()) {
                    //Object element = iteratypicalnegative.next();
                    ChestaTypicalNegative = Double.parseDouble(iteratypicalnegative.getString(1));
                    System.out.println("ChestaTypicalNegative " + ChestaTypicalNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();     
                ResultSet iternonanginapositive = st.executeQuery("select count(ChestPainType)as nonangina from tbTrainingDataSet where Disease='Positive'and ChestPainType='Non-angina pain'");
                while (iternonanginapositive.next()) {
                    //Object element = iternonanginapositive.next();
                    Chestnonanginapositive = Double.parseDouble(iternonanginapositive.getString(1));
                    System.out.println("Chestnonanginapositive " + Chestnonanginapositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();        
                ResultSet iternonanginanegative = st.executeQuery("select count(ChestPainType)as nonangina from tbTrainingDataSet where Disease='Negative'and ChestPainType='Non-angina pain'");
                while (iternonanginanegative.next()) {
                    //Object element = iternonanginanegative.next();
                    ChestnonanginaNegative = Double.parseDouble(iternonanginanegative.getString(1));
                    System.out.println("ChestnonanginaNegative " + ChestnonanginaNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();        
                ResultSet iterasymptomaticpositive = st.executeQuery("select count(ChestPainType)as asymptomatic from tbTrainingDataSet where Disease='Positive'and ChestPainType='Asymptomatic'");
                while (iterasymptomaticpositive.next()) {
                    //Object element = iterasymptomaticpositive.next();
                    Chestasymptomaticpositive = Double.parseDouble(iterasymptomaticpositive.getString(1));
                    System.out.println("Chestasymptomaticpositive " + Chestasymptomaticpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();       
                ResultSet iterasymptomaticnegative = st.executeQuery("select count(ChestPainType)as asymptomatic from tbTrainingDataSet where Disease='Negative'and ChestPainType='Asymptomatic'");
                while (iterasymptomaticnegative.next()) {
                    //Object element = iterasymptomaticnegative.next();
                    ChestasymptomaticNegative = Double.parseDouble(iterasymptomaticnegative.getString(1));
                    System.out.println("ChestasymptomaticNegative " + ChestasymptomaticNegative);
                }
            } catch (Exception exception) {
            }
		/////////
		TotalTypical=ChestTypicalpositive+ChestTypicalNegative;
		System.out.println("TotalTypical "+TotalTypical);
		Totalatypical=ChestaTypicalpositive+ChestaTypicalNegative;
		System.out.println("Totalatypical "+Totalatypical);
		Totalnonnagina=Chestnonanginapositive+ChestnonanginaNegative;
		System.out.println("Totalnonnagina "+Totalnonnagina);
		Totalasymptomatic=Chestasymptomaticpositive+ChestasymptomaticNegative;
		System.out.println("Totalasymptomatic "+Totalasymptomatic);
		
		
		TotalchestPositive=ChestTypicalpositive+ChestaTypicalpositive+Chestnonanginapositive+Chestasymptomaticpositive;
		System.out.println("TotalchestPositive "+TotalchestPositive);
		TotalchestNegative=ChestTypicalNegative+ChestaTypicalNegative+ChestnonanginaNegative+ChestasymptomaticNegative;
		System.out.println("TotalchestNegative "+TotalchestNegative);
		
		Totalchest=TotalchestPositive+TotalchestNegative;
		System.out.println("Totalchest "+Totalchest);
	}
	///////////////////////       ///////////////////////
	private void FastingBloodsuggerobserveValue() 
	{
		          try {
                st = conn.createStatement();
                ResultSet iterFBSOV = st.executeQuery("select count(FastingBloodsugger)as yes from tbTrainingDataSet where Disease='Positive'and FastingBloodsugger='Yes'");
                while (iterFBSOV.next()) {
                    //Object element = iterFBSOV.next();
                    Fastingyespositive = Double.parseDouble(iterFBSOV.getString(1));
                    System.out.println("Fastingyespositive " + Fastingyespositive);
                }
            } catch (Exception e) {
            }
		
		          try {
                st = conn.createStatement();  
                ResultSet iterFBSOVN = st.executeQuery("select count(FastingBloodsugger)as yes from tbTrainingDataSet where Disease='Negative'and FastingBloodsugger='Yes'");
                while (iterFBSOVN.next()) {
                    //Object element = iterFBSOVN.next();
                    FastingyesNegative = Double.parseDouble(iterFBSOVN.getString(1));
                    System.out.println("FastingyesNegative " + FastingyesNegative);
                }
            } catch (Exception e) {
            }
		
		///////////////
		          try {
                st = conn.createStatement();        
                ResultSet iterFNP = st.executeQuery("select count(FastingBloodsugger)as No from tbTrainingDataSet where Disease='Positive'and FastingBloodsugger='No'");
                while (iterFNP.next()) {
                    //Object element = iterFNP.next();
                    Fastingnopositive = Double.parseDouble(iterFNP.getString(1));
                    System.out.println("Fastingnopositive " + Fastingnopositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();               
                ResultSet iterFBSNN = st.executeQuery("select count(FastingBloodsugger)as No from tbTrainingDataSet where Disease='Negative'and FastingBloodsugger='No'");
                while (iterFBSNN.next()) {
                    //Object element = iternonegative.next();
                    FastingnoNegative = Double.parseDouble(iterFBSNN.getString(1));
                    System.out.println("FastingnoNegative " + FastingnoNegative);
                }
            } catch (Exception exception) {
            }
		/////////
		Totalyes=Fastingyespositive+FastingyesNegative;
		System.out.println("TotalYes "+Totalyes);
		Totalno=Fastingnopositive+FastingnoNegative;
		System.out.println("Totalno "+Totalno);
		
		TotalFastingPositive=Fastingyespositive+Fastingnopositive;
		System.out.println("TotalFastingPositive "+TotalFastingPositive);
		TotalFastingNegative=FastingyesNegative+FastingnoNegative;
		System.out.println("TotalFastingNegative "+TotalFastingNegative);
		
		TotalFasting=TotalFastingPositive+TotalFastingNegative;
		System.out.println("TotalFasting "+TotalFasting);
		
	}
	/////////////////////
	private void RestECGObsebveValue() 
	{
		          try {
                st = conn.createStatement();                
                ResultSet iternormalpositive = st.executeQuery("select count(Restecg)as Normal from tbTrainingDataSet where Disease='Positive'and Restecg='Normal'");
                while (iternormalpositive.next()) {
                    //Object element = iternormalpositive.next();
                    Restnormalpositive = Double.parseDouble(iternormalpositive.getString(1));
                    System.out.println("Restnormalpositive " + Restnormalpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();         
                ResultSet iternormalnegative = st.executeQuery("select count(Restecg)as Normal from tbTrainingDataSet where Disease='Negative'and Restecg='Normal'");
                while (iternormalnegative.next()) {
                    //Object element = iternormalnegative.next();
                    RestnormalNegative = Double.parseDouble(iternormalnegative.getString(1));
                    System.out.println("RestnormalNegative " + RestnormalNegative);
                }
            } catch (Exception exception) {
            }
		
		///////////////
		
		          try {
                st = conn.createStatement();            
                ResultSet iterST_Tabnormalpositive = st.executeQuery("select count(Restecg)as ST_Tabnormal from tbTrainingDataSet where Disease='Positive'and Restecg='ST_T abnormal'");
                while (iterST_Tabnormalpositive.next()) {
                    //Object element = iterST_Tabnormalpositive.next();
                    RestST_Tpositive = Double.parseDouble(iterST_Tabnormalpositive.getString(1));
                    System.out.println("RestST_Tpositive " + RestST_Tpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();           
                ResultSet iterST_Tabnormalnegative = st.executeQuery("select count(Restecg)as ST_Tabnormal from tbTrainingDataSet where Disease='Negative'and Restecg='ST_T abnormal'");
                while (iterST_Tabnormalnegative.next()) {
                    //Object element = iterST_Tabnormalnegative.next();
                    RestST_TNegative = Double.parseDouble(iterST_Tabnormalnegative.getString(1));
                    System.out.println("RestST_TNegative " + RestST_TNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();           
                ResultSet iterHypertrophypositive = st.executeQuery("select count(Restecg)as Hypertrophy from tbTrainingDataSet where Disease='Positive'and Restecg='Hypertrophy'");
                while (iterHypertrophypositive.next()) {
                    //Object element = iterHypertrophypositive.next();
                    RestHypertrophypositive = Double.parseDouble(iterHypertrophypositive.getString(1));
                    System.out.println("RestHypertrophypositive " + RestHypertrophypositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();           
                ResultSet iterHypertrophynegative = st.executeQuery("select count(Restecg)as Hypertrophy from tbTrainingDataSet where Disease='Negative'and Restecg='Hypertrophy'");
                while (iterHypertrophynegative.next()) {
                    //Object element = iterHypertrophynegative.next();
                    RestHypertrophyNegative = Double.parseDouble(iterHypertrophynegative.getString(1));
                    System.out.println("RestHypertrophyNegative " + RestHypertrophyNegative);
                }
            } catch (Exception exception) {
            }
		//////////////	/////////
		TotalNormal=Restnormalpositive+RestnormalNegative;
		System.out.println("TotalNormal "+TotalNormal);
		TotalST_T=RestST_Tpositive+RestST_TNegative;
		System.out.println("TotalST_T "+TotalST_T);
		TotalHypertrophy=RestHypertrophypositive+RestHypertrophyNegative;
		System.out.println("TotalHypertrophy "+TotalHypertrophy);
		
		
		TotalRestPositive=Restnormalpositive+RestST_Tpositive+RestHypertrophypositive;
		System.out.println("TotalRestPositive "+TotalRestPositive);
		TotalRestNegative=RestnormalNegative+RestST_TNegative+RestHypertrophyNegative;
		System.out.println("TotalRestNegative "+TotalRestNegative);
		
		TotalRest=TotalRestPositive+TotalRestNegative;
		System.out.println("TotalRest "+TotalRest);
	}
	/////////////////
	private void ExangobserveValue() 
	{
		          try {
                st = conn.createStatement();       
                ResultSet iterEOVP = st.executeQuery("select count(Exang)as Yes from tbTrainingDataSet where Disease='Positive'and Exang='Yes'");
                while (iterEOVP.next()) {
                    //Object element = iterEOVP.next();
                    Exangyespositive = Double.parseDouble(iterEOVP.getString(1));
                    System.out.println("Exangyespositive " + Exangyespositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();              
                ResultSet iterEOVN = st.executeQuery("select count(Exang)as Yes from tbTrainingDataSet where Disease='Negative'and Exang='Yes'");
                while (iterEOVN.next()) {
                    //Object element = iterEOVN.next();
                    ExangyesNegative = Double.parseDouble(iterEOVN.getString(1));
                    System.out.println("ExangyesNegative " + ExangyesNegative);
                }
            } catch (Exception exception) {
            }
		
		///////////////
		          try {
                st = conn.createStatement();              
                ResultSet iterExNP = st.executeQuery("select count(Exang)as No from tbTrainingDataSet where Disease='Positive'and Exang='No'");
                while (iterExNP.next()) {
                    //Object element = iterExNP.next();
                    Exangnopositive = Double.parseDouble(iterExNP.getString(1));
                    System.out.println("Exangnopositive " + Exangnopositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();            
                ResultSet iterExNN = st.executeQuery("select count(Exang)as No from tbTrainingDataSet where Disease='Negative'and Exang='No'");
                while (iterExNN.next()) {
                    //Object element = iterExNN.next();
                    ExangnoNegative = Double.parseDouble(iterExNN.getString(1));
                    System.out.println("ExangnoNegative " + ExangnoNegative);
                }
            } catch (Exception exception) {
            }
		/////////
		TotalYes=Exangyespositive+ExangyesNegative;
		System.out.println("TotalYes "+TotalYes);
		TotalNo=Exangnopositive+ExangnoNegative;
		System.out.println("Totalno "+TotalNo);
		
		TotalExangPositive=Exangyespositive+Exangnopositive;
		System.out.println("TotalExangPositive "+TotalExangPositive);
		TotalExangNegative=ExangyesNegative+ExangnoNegative;
		System.out.println("TotalExangNegative "+TotalExangNegative);
		
		TotalExang=TotalExangPositive+TotalExangNegative;
		System.out.println("TotalExang "+TotalExang);
		
	}
	/////////////////////
	
	private void SlopObsebveValue() 
	{
		          try {
                st = conn.createStatement();       
                ResultSet iterUnslopingpositive = st.executeQuery("select count(Slop)as Unsloping from tbTrainingDataSet where Disease='Positive'and Slop='Unsloping'");
                while (iterUnslopingpositive.next()) {
                    //Object element = iterUnslopingpositive.next();
                    SlopUnslopingpositive = Double.parseDouble(iterUnslopingpositive.getString(1));
                    System.out.println("SlopUnslopingpositive " + SlopUnslopingpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();            
                ResultSet iterUnslopingnegative = st.executeQuery("select count(Slop)as Unsloping from tbTrainingDataSet where Disease='Negative'and Slop='Unsloping'");
                while (iterUnslopingnegative.next()) {
                    //Object element = iterUnslopingnegative.next();
                    SlopUnslopingNegative = Double.parseDouble(iterUnslopingnegative.getString(1));
                    System.out.println("SlopUnslopingNegative " + SlopUnslopingNegative);
                }
            } catch (Exception exception) {
            }
		
		///////////////
		
		          try {
                st = conn.createStatement();               
                ResultSet iterFlatpositive = st.executeQuery("select count(Slop)as Flat from tbTrainingDataSet where Disease='Positive'and Slop='Flat'");
                while (iterFlatpositive.next()) {
                    //Object element = iterFlatpositive.next();
                    SlopFlatpositive = Double.parseDouble(iterFlatpositive.getString(1));
                    System.out.println("SlopFlatpositive " + SlopFlatpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();        
                ResultSet iterFlatnegative = st.executeQuery("select count(Slop)as Flat from tbTrainingDataSet where Disease='Negative'and Slop='Flat'");
                while (iterFlatnegative.next()) {
                    //Object element = iterFlatnegative.next();
                    SlopFlatNegative = Double.parseDouble(iterFlatnegative.getString(1));
                    System.out.println("SlopFlatNegative " + SlopFlatNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();    
                ResultSet iterDownslopingpositive = st.executeQuery("select count(Slop)as Downsloping from tbTrainingDataSet where Disease='Positive'and Slop='Downsloping'");
                while (iterDownslopingpositive.next()) {
                    //Object element = iterDownslopingpositive.next();
                    SlopDownsloppositive = Double.parseDouble(iterDownslopingpositive.getString(1));
                    System.out.println("SlopDownsloppositive " + SlopDownsloppositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();            
                ResultSet iterDownslopingnegative = st.executeQuery("select count(Slop)as Downsloping from tbTrainingDataSet where Disease='Negative'and Slop='Downsloping'");
                while (iterDownslopingnegative.next()) {
                    //Object element = iterDownslopingnegative.next();
                    SlopDownslopNegative = Double.parseDouble(iterDownslopingnegative.getString(1));
                    System.out.println("SlopDownslopNegative " + SlopDownslopNegative);
                }
            } catch (Exception exception) {
            }
		//////////////	/////////
		TotalUnslop=SlopUnslopingpositive+SlopUnslopingNegative;
		System.out.println("TotalUnslop "+TotalUnslop);
		TotalFalt=SlopFlatpositive+SlopFlatNegative;
		System.out.println("TotalFalt "+TotalFalt);
		TotalDownslop=SlopDownsloppositive+SlopDownslopNegative;
		System.out.println("TotalDownslop "+TotalDownslop);
		
		
		TotalSlopPositive=SlopUnslopingpositive+SlopFlatpositive+SlopDownsloppositive;
		System.out.println("TotalSlopPositive "+TotalSlopPositive);
		TotalSlopNegative=SlopUnslopingNegative+SlopFlatNegative+SlopDownslopNegative;
		System.out.println("TotalSlopNegative "+TotalSlopNegative);
		
		TotalSlop=TotalSlopPositive+TotalSlopNegative;
		System.out.println("TotalSlop "+TotalSlop);
	}
	/////////////////
	
	/////////////////////
	
	private void ThalObsebveValue() 
	{
		          try {
                st = conn.createStatement();          
                ResultSet iterNormalpositive = st.executeQuery("select count(Thal)as normal from tbTrainingDataSet where Disease='Positive'and Thal='Normal'");
                while (iterNormalpositive.next()) {
                    //Object element = iterNormalpositive.next();
                    Thalnormalpositive = Double.parseDouble(iterNormalpositive.getString(1));
                    System.out.println("Thalnormalpositive " + Thalnormalpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();          
                ResultSet iterNormalnegative = st.executeQuery("select count(Thal)as normal from tbTrainingDataSet where Disease='Negative'and Thal='Normal'");
                while (iterNormalnegative.next()) {
                    //Object element = iterNormalnegative.next();
                    ThalnormalNegative = Double.parseDouble(iterNormalnegative.getString(1));
                    System.out.println("ThalnormalNegative " + ThalnormalNegative);
                }
            } catch (Exception exception) {
            }
		
		///////////////
		          try {
                st = conn.createStatement();             
                ResultSet iterFixedpositive = st.executeQuery("select count(Thal)as FixedDefect from tbTrainingDataSet where Disease='Positive'and Thal='Fixed Defect'");
                while (iterFixedpositive.next()) {
                    //Object element = iterFixedpositive.next();
                    ThalFixedpositive = Double.parseDouble(iterFixedpositive.getString(1));
                    System.out.println("ThalFixedpositive " + ThalFixedpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();            
                ResultSet iterFixednegative = st.executeQuery("select count(Thal)as FixedDefect from tbTrainingDataSet where Disease='Negative'and Thal='Fixed Defect'");
                while (iterFixednegative.next()) {
                    //Object element = iterFixednegative.next();
                    ThalFixedNegative = Double.parseDouble(iterFixednegative.getString(1));
                    System.out.println("ThalFixedNegative " + ThalFixedNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();          
                ResultSet iterReversiblepositive = st.executeQuery("select count(Thal)as ReversibleDefect from tbTrainingDataSet where Disease='Positive'and Thal='Reversible Defect'");
                while (iterReversiblepositive.next()) {
                    //Object element = iterReversiblepositive.next();
                    ThalReversiblepositive = Double.parseDouble(iterReversiblepositive.getString(1));
                    System.out.println("ThalReversiblepositive " + ThalReversiblepositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();            
                ResultSet iterReversiblenegative = st.executeQuery("select count(Thal)as ReversibleDefect from tbTrainingDataSet where Disease='Negative'and Thal='Reversible Defect'");
                while (iterReversiblenegative.next()) {
                    //Object element = iterReversiblenegative.next();
                    ThalReversibleNegative = Double.parseDouble(iterReversiblenegative.getString(1));
                    System.out.println("ThalReversibleNegative " + ThalReversibleNegative);
                }
            } catch (Exception exception) {
            }
		//////////////	/////////
		TotalthalNormal=Thalnormalpositive+ThalnormalNegative;
		System.out.println("TotalthalNormal "+TotalthalNormal);
		TotalthalFixed=ThalFixedpositive+ThalFixedNegative;
		System.out.println("TotalthalFixed "+TotalthalFixed);
		Totalthalreversible=ThalReversiblepositive+ThalReversibleNegative;
		System.out.println("Totalthalreversible "+Totalthalreversible);
		
		
		TotalthalPositive=Thalnormalpositive+ThalFixedpositive+ThalReversiblepositive;
		System.out.println("TotalthalPositive "+TotalthalPositive);
		TotalthalNegative=ThalnormalNegative+ThalFixedNegative+ThalReversibleNegative;
		System.out.println("TotalthalNegative "+TotalthalNegative);
		
		Totalthal=TotalthalPositive+TotalthalNegative;
		System.out.println("Totalthal "+Totalthal);
	}
	/////////////////
	private void TrestBloodObsebveValue() 
	{
		          try {
                st = conn.createStatement();    
                ResultSet iterTBLP = st.executeQuery("select count(TrestBloodPressure)as Low from tbTrainingDataSet where Disease='Positive'and TrestBloodPressure='Low'");
                while (iterTBLP.next()) {
                    
                    TrestBloodlowpositive = Double.parseDouble(iterTBLP.getString(1));
                    System.out.println("TrestBloodlowpositive " + TrestBloodlowpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();          
                ResultSet iterTBLN = st.executeQuery("select count(TrestBloodPressure)as Low from tbTrainingDataSet where Disease='Negative'and TrestBloodPressure='Low'");
                while (iterTBLN.next()) {
                    
                    TrestBloodlowNegative = Double.parseDouble(iterTBLN.getString(1));
                    System.out.println("TrestBloodlowNegative " + TrestBloodlowNegative);
                }
            } catch (Exception exception) {
            }
		
		///////////////
		
		          try {
                st = conn.createStatement();         
                ResultSet iterTBMP = st.executeQuery("select count(TrestBloodPressure)as Medium from tbTrainingDataSet where Disease='Positive'and TrestBloodPressure='Medium'");
                while (iterTBMP.next()) {
                    
                    TrestBloodmediumpositive = Double.parseDouble(iterTBMP.getString(1));
                    System.out.println("TrestBloodmediumpositive " + TrestBloodmediumpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();          
                ResultSet iterTBMN = st.executeQuery("select count(TrestBloodPressure)as Medium from tbTrainingDataSet where Disease='Negative'and TrestBloodPressure='Medium'");
                while (iterTBMN.next()) {
                    
                    TrestBloodmediumNegative = Double.parseDouble(iterTBMN.getString(1));
                    System.out.println("TrestBloodmediumNegative " + TrestBloodmediumNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();          
                ResultSet iterTBHP = st.executeQuery("select count(TrestBloodPressure)as High from tbTrainingDataSet where Disease='Positive'and TrestBloodPressure='High'");
                while (iterTBHP.next()) {
                    
                    TrestBloodhighpositive = Double.parseDouble(iterTBHP.getString(1));
                    System.out.println("TrestBloodhighpositive " + TrestBloodhighpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();           
                ResultSet iterTBHN = st.executeQuery("select count(TrestBloodPressure)as High from tbTrainingDataSet where Disease='Negative'and TrestBloodPressure='High'");
                while (iterTBHN.next()) {
                    
                    TrestBloodhighNegative = Double.parseDouble(iterTBHN.getString(1));
                    System.out.println("TrestBloodhighNegative " + TrestBloodhighNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();           
                ResultSet iterTBVHP = st.executeQuery("select count(TrestBloodPressure)as VeryHigh from tbTrainingDataSet where Disease='Positive'and TrestBloodPressure='Very High'");
                while (iterTBVHP.next()) {
                    
                    TrestBloodveryhighpositive = Double.parseDouble(iterTBVHP.getString(1));
                    System.out.println("TrestBloodveryhighpositive " + TrestBloodveryhighpositive);
                }
            } catch (Exception e) {
            }
		
		          try {
                st = conn.createStatement();         
                ResultSet iterTBVHN = st.executeQuery("select count(TrestBloodPressure)as VeryHigh from tbTrainingDataSet where Disease='Negative'and TrestBloodPressure='Very High'");
                while (iterTBVHN.next()) {
                    
                    TrestBloodverryhighNegative = Double.parseDouble(iterTBVHN.getString(1));
                    System.out.println("TrestBloodverryhighNegative " + TrestBloodverryhighNegative);
                }
            } catch (Exception exception) {
            }
		/////////
		TotalTrestBloodlow=TrestBloodlowpositive+TrestBloodlowNegative;
		System.out.println("TotalTrestBloodlow "+TotalTrestBloodlow);
		TotalTrestBloodmedium=TrestBloodmediumpositive+TrestBloodmediumNegative;
		System.out.println("TotalTrestBloodmedium "+TotalTrestBloodmedium);
		TotalTrestBloodhigh=TrestBloodhighpositive+TrestBloodhighNegative;
		System.out.println("TotalTrestBloodhigh "+TotalTrestBloodhigh);
		TotalTrestBloodveryhigh=TrestBloodveryhighpositive+TrestBloodverryhighNegative;
		System.out.println("TotalTrestBloodveryhigh "+TotalTrestBloodveryhigh);
		
		
		TotalTrestBloodpositive=TrestBloodlowpositive+TrestBloodmediumpositive+TrestBloodhighpositive+TrestBloodveryhighpositive;
		System.out.println("TotalTrestBloodpositive "+TotalTrestBloodpositive);
		TotalTrestBloodNegative=TrestBloodlowNegative+TrestBloodmediumNegative+TrestBloodhighNegative+TrestBloodverryhighNegative;
		System.out.println("TotalTrestBloodNegative "+TotalTrestBloodNegative);
		
		TotalTrestBlood=TotalTrestBloodpositive+TotalTrestBloodNegative;
		System.out.println("TotalTrestBlood "+TotalTrestBlood);
	}
	///////////////////////       ///////////////////////
	private void SerumCholestorelObsebveValue() 
	{
		          try {
                st = conn.createStatement();                ResultSet iterSCLP = st.executeQuery("select count(SerumCholesterol)as Low from tbTrainingDataSet where Disease='Positive'and SerumCholesterol='Low'");
                while (iterSCLP.next()) {
                    
                    SerumCholestorellowpositive = Double.parseDouble(iterSCLP.getString(1));
                    System.out.println("SerumCholestorellowpositive " + SerumCholestorellowpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();            
                ResultSet iterSCLN = st.executeQuery("select count(SerumCholesterol)as Low from tbTrainingDataSet where Disease='Negative'and SerumCholesterol='Low'");
                while (iterSCLN.next()) {
                    
                    SerumCholestorellowNegative = Double.parseDouble(iterSCLN.getString(1));
                    System.out.println("SerumCholestorellowNegative " + SerumCholestorellowNegative);
                }
            } catch (Exception exception) {
            }
		
		///////////////
		
		          try {
                st = conn.createStatement();           
                ResultSet iterSCMP = st.executeQuery("select count(SerumCholesterol)as Medium from tbTrainingDataSet where Disease='Positive'and SerumCholesterol='Medium'");
                while (iterSCMP.next()) {
                    
                    SerumCholestorelmediumpositive = Double.parseDouble(iterSCMP.getString(1));
                    System.out.println("SerumCholestorelmediumpositive " + SerumCholestorelmediumpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();                ResultSet iterSCMN = st.executeQuery("select count(SerumCholesterol)as Medium from tbTrainingDataSet where Disease='Negative'and SerumCholesterol='Medium'");
                while (iterSCMN.next()) {
                    
                    SerumCholestorelmediumNegative = Double.parseDouble(iterSCMN.getString(1));
                    System.out.println("SerumCholestorelmediumNegative " + SerumCholestorelmediumNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();           
                ResultSet iterSCHP = st.executeQuery("select count(SerumCholesterol)as High from tbTrainingDataSet where Disease='Positive'and SerumCholesterol='High'");
                while (iterSCHP.next()) {
                    
                    SerumCholestorelhighpositive = Double.parseDouble(iterSCHP.getString(1));
                    System.out.println("SerumCholestorelhighpositive " + SerumCholestorelhighpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();          
                ResultSet iterSCHN = st.executeQuery("select count(SerumCholesterol)as High from tbTrainingDataSet where Disease='Negative'and SerumCholesterol='High'");
                while (iterSCHN.next()) {
                    SerumCholestorelhighNegative = Double.parseDouble(iterSCHN.getString(1));
                    System.out.println("SerumCholestorelhighNegative " + SerumCholestorelhighNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();              
                ResultSet iterSCVHP = st.executeQuery("select count(SerumCholesterol)as VeryHigh from tbTrainingDataSet where Disease='Positive'and SerumCholesterol='Very High'");
                while (iterSCVHP.next()) {
                    
                    SerumCholestorelveryhighpositive = Double.parseDouble(iterSCVHP.getString(1));
                    System.out.println("SerumCholestorelveryhighpositive " + SerumCholestorelveryhighpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();            
                ResultSet iterSCVHN = st.executeQuery("select count(SerumCholesterol)as VeryHigh from tbTrainingDataSet where Disease='Negative'and SerumCholesterol='Very High'");
                while (iterSCVHN.next()) {
                    
                    SerumCholestorelverryhighNegative = Double.parseDouble(iterSCVHN.getString(1));
                    System.out.println("SerumCholestorelverryhighNegative " + SerumCholestorelverryhighNegative);
                }
            } catch (Exception exception) {
            }
		/////////
		TotalSerumCholestorellow=SerumCholestorellowpositive+SerumCholestorellowNegative;
		System.out.println("TotalSerumCholestorellow "+TotalSerumCholestorellow);
		TotalSerumCholestorelmedium=SerumCholestorelmediumpositive+SerumCholestorelmediumNegative;
		System.out.println("TotalSerumCholestorelmedium "+TotalSerumCholestorelmedium);
		TotalSerumCholestorelhigh=SerumCholestorelhighpositive+SerumCholestorelhighNegative;
		System.out.println("TotalSerumCholestorelhigh "+TotalSerumCholestorelhigh);
		TotalSerumCholestorelveryhigh=SerumCholestorelveryhighpositive+SerumCholestorelverryhighNegative;
		System.out.println("TotalSerumCholestorelveryhigh "+TotalSerumCholestorelveryhigh);
		
		
		TotalSerumCholestorelpositive=SerumCholestorellowpositive+SerumCholestorelmediumpositive+SerumCholestorelhighpositive+SerumCholestorelveryhighpositive;
		System.out.println("TotalSerumCholestorelpositive "+TotalSerumCholestorelpositive);
		TotalSerumCholestorelNegative=SerumCholestorellowNegative+SerumCholestorelmediumNegative+SerumCholestorelhighNegative+SerumCholestorelverryhighNegative;
		System.out.println("TotalSerumCholestorelNegative "+TotalSerumCholestorelNegative);
		
		TotalSerumCholestorel=TotalSerumCholestorelpositive+TotalSerumCholestorelNegative;
		System.out.println("TotalSerumCholestorel "+TotalSerumCholestorel);
	}
	///////////////////////       ///////////////////////
	
	private void ThalachObsebveValue() 
	{
		          try {
                st = conn.createStatement();         
                ResultSet iterTlcLP = st.executeQuery("select count(Thalach)as Low from tbTrainingDataSet where Disease='Positive'and Thalach='Low'");
                while (iterTlcLP.next()) {
                    
                    Thalachlowpositive = Double.parseDouble(iterTlcLP.getString(1));
                    System.out.println("Thalachlowpositive " + Thalachlowpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();           
                ResultSet iterTlcLN = st.executeQuery("select count(Thalach)as Low from tbTrainingDataSet where Disease='Negative'and Thalach='Low'");
                while (iterTlcLN.next()) {
                    
                    ThalachlowNegative = Double.parseDouble(iterTlcLN.getString(1));
                    System.out.println("ThalachlowNegative " + ThalachlowNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();        
                ResultSet iterTlcMP = st.executeQuery("select count(Thalach)as Medium from tbTrainingDataSet where Disease='Positive'and Thalach='Medium'");
                while (iterTlcMP.next()) {
                    
                    Thalachmediumpositive = Double.parseDouble(iterTlcMP.getString(1));
                    System.out.println("Thalachmediumpositive " + Thalachmediumpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();            
                ResultSet iterTlcMN = st.executeQuery("select count(Thalach)as Medium from tbTrainingDataSet where Disease='Negative'and Thalach='Medium'");
                while (iterTlcMN.next()) {
                    
                    ThalachmediumNegative = Double.parseDouble(iterTlcMN.getString(1));
                    System.out.println("ThalachmediumNegative " + ThalachmediumNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();             
                ResultSet iterTlcHP = st.executeQuery("select count(Thalach)as High from tbTrainingDataSet where Disease='Positive'and Thalach='High'");
                while (iterTlcHP.next()) {
                    
                    Thalachhighpositive = Double.parseDouble(iterTlcHP.getString(1));
                    System.out.println("Thalachhighpositive " + Thalachhighpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();          
                ResultSet iterTlcHN = st.executeQuery("select count(Thalach)as High from tbTrainingDataSet where Disease='Negative'and Thalach='High'");
                while (iterTlcHN.next()) {
                    
                    ThalachhighNegative = Double.parseDouble(iterTlcHN.getString(1));
                    System.out.println("ThalachhighNegative " + ThalachhighNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		TotalThalachlow=Thalachlowpositive+ThalachlowNegative;
		System.out.println("TotalThalachlow "+TotalThalachlow);
		TotalThalachmedium=Thalachmediumpositive+ThalachmediumNegative;
		System.out.println("TotalThalachmedium "+TotalThalachmedium);
		TotalThalachhigh=Thalachhighpositive+ThalachhighNegative;
		System.out.println("TotalThalachhigh "+TotalThalachhigh);
		
		
		TotalThalachpositive=Thalachlowpositive+Thalachmediumpositive+Thalachhighpositive;
		System.out.println("TotalThalachpositive "+TotalThalachpositive);
		TotalThalachNegative=ThalachlowNegative+ThalachmediumNegative+ThalachhighNegative;
		System.out.println("TotalThalachNegative "+TotalThalachNegative);
		
		TotalThalach=TotalThalachpositive+TotalThalachNegative;
		System.out.println("TotalThalach "+TotalThalach);
	}
	///////////////////////       ///////////////////////
	private void OldPeakObsebveValue() 
	{
		          try {
                st = conn.createStatement();       
                ResultSet iterOPLP = st.executeQuery("select count(Oldpeak)as Low from tbTrainingDataSet where Disease='Positive'and Oldpeak='Low'");
                while (iterOPLP.next()) {
                    
                    OldPeaklowpositive = Double.parseDouble(iterOPLP.getString(1));
                    System.out.println("OldPeaklowpositive " + OldPeaklowpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();        
                ResultSet iterOPLN = st.executeQuery("select count(Oldpeak)as Low from tbTrainingDataSet where Disease='Negative'and Oldpeak='Low'");
                while (iterOPLN.next()) {
                    
                    OldPeaklowNegative = Double.parseDouble(iterOPLN.getString(1));
                    System.out.println("OldPeaklowNegative " + OldPeaklowNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();          
                ResultSet iterOPRP = st.executeQuery("select count(Oldpeak)as Risk from tbTrainingDataSet where Disease='Positive'and Oldpeak='Risk'");
                while (iterOPRP.next()) {
                    
                    OldPeakRiskpositive = Double.parseDouble(iterOPRP.getString(1));
                    System.out.println("OldPeakRiskpositive " + OldPeakRiskpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();               
                ResultSet iterOPRN = st.executeQuery("select count(Oldpeak)as Risk from tbTrainingDataSet where Disease='Negative'and Oldpeak='Risk'");
                while (iterOPRN.next()) {
                    
                    OldPeakRiskNegative = Double.parseDouble(iterOPRN.getString(1));
                    System.out.println("OldPeakRiskNegative " + OldPeakRiskNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();         
                ResultSet iterTerriblepositive = st.executeQuery("select count(Oldpeak)as Terrible from tbTrainingDataSet where Disease='Positive'and Oldpeak='Terrible'");
                while (iterTerriblepositive.next()) {
                    
                    OldPeakTerriblepositive = Double.parseDouble(iterTerriblepositive.getString(1));
                    System.out.println("OldPeakTerriblepositive " + OldPeakTerriblepositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();            
                ResultSet iterTerriblenegative = st.executeQuery("select count(Oldpeak)as Terrible from tbTrainingDataSet where Disease='Negative'and Oldpeak='Terrible'");
                while (iterTerriblenegative.next()) {
                    
                    OldPeakTerribleNegative = Double.parseDouble(iterTerriblenegative.getString(1));
                    System.out.println("OldPeakTerribleNegative " + OldPeakTerribleNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		TotalOldPeaklow=OldPeaklowpositive+OldPeaklowNegative;
		System.out.println("TotalOldPeaklow "+TotalOldPeaklow);
		TotalOldPeakRisk=OldPeakRiskpositive+OldPeakRiskNegative;
		System.out.println("TotalOldPeakRisk "+TotalOldPeakRisk);
		TotalOldPeakTerrible=OldPeakTerriblepositive+OldPeakTerribleNegative;
		System.out.println("TotalOldPeakTerrible "+TotalOldPeakTerrible);
		
		
		TotalOldPeakpositive=OldPeaklowpositive+OldPeakRiskpositive+OldPeakTerriblepositive;
		System.out.println("TotalOldPeakpositive "+TotalOldPeakpositive);
		TotalOldPeakNegative=OldPeaklowNegative+OldPeakRiskNegative+OldPeakTerribleNegative;
		System.out.println("TotalOldPeakNegative "+TotalOldPeakNegative);
		
		TotalOldPeak=TotalOldPeakpositive+TotalOldPeakNegative;
		System.out.println("TotalOldPeak "+TotalOldPeak);
	}
	///////////////////////       ///////////////////////
	
	private void SmokingObsebveValue() 
	{
		          try {
                st = conn.createStatement();    
                ResultSet iterPastpositive = st.executeQuery("select count(Smoking)as Past from tbTrainingDataSet where Disease='Positive'and Smoking='Past'");
                while (iterPastpositive.next()) {
                    
                    SmokingPastpositive = Double.parseDouble(iterPastpositive.getString(1));
                    System.out.println("SmokingPastpositive " + SmokingPastpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();               
                ResultSet iterPastnegative = st.executeQuery("select count(Smoking)as Past from tbTrainingDataSet where Disease='Negative'and Smoking='Past'");
                while (iterPastnegative.next()) {
                    
                    SmokingPastNegative = Double.parseDouble(iterPastnegative.getString(1));
                    System.out.println("SmokingPastNegative " + SmokingPastNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();             
                ResultSet iterCurrentpositive = st.executeQuery("select count(Smoking)as Curent from tbTrainingDataSet where Disease='Positive'and Smoking='Current'");
                while (iterCurrentpositive.next()) {
                    
                    SmokingCurrentpositive = Double.parseDouble(iterCurrentpositive.getString(1));
                    System.out.println("SmokingCurrentpositive " + SmokingCurrentpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();             
                ResultSet iterCurrentnegative = st.executeQuery("select count(Smoking)as Curent from tbTrainingDataSet where Disease='Negative'and Smoking='Current'");
                while (iterCurrentnegative.next()) {
                    
                    SmokingCurrentNegative = Double.parseDouble(iterCurrentnegative.getString(1));
                    System.out.println("SmokingCurrentNegative " + SmokingCurrentNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		          try {
                st = conn.createStatement();            
                ResultSet iterneverpositive = st.executeQuery("select count(Smoking)as never from tbTrainingDataSet where Disease='Positive'and Smoking='Never'");
                while (iterneverpositive.next()) {
                    
                    SmokingNeverpositive = Double.parseDouble(iterneverpositive.getString(1));
                    System.out.println("SmokingNeverpositive " + SmokingNeverpositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();               
                ResultSet iternevernegative = st.executeQuery("select count(Smoking)as never from tbTrainingDataSet where Disease='Negative'and Smoking='Never'");
                while (iternevernegative.next()) {
                    
                    SmokingNeverNegative = Double.parseDouble(iternevernegative.getString(1));
                    System.out.println("SmokingNeverNegative " + SmokingNeverNegative);
                }
            } catch (Exception exception) {
            }
		///////////////
		TotalSmokingpast=SmokingPastpositive+SmokingPastNegative;
		System.out.println("TotalSmokingpast "+TotalSmokingpast);
		TotalSmokingcurrent=SmokingCurrentpositive+SmokingCurrentNegative;
		System.out.println("TotalSmokingcurrent "+TotalSmokingcurrent);
		TotalSmokingnever=SmokingNeverpositive+SmokingNeverNegative;
		System.out.println("TotalSmokingnever "+TotalSmokingnever);
		
		
		TotalSmokingpositive=SmokingPastpositive+SmokingCurrentpositive+SmokingNeverpositive;
		System.out.println("TotalSmokingpositive "+TotalSmokingpositive);
		TotalSmokingNegative=SmokingPastNegative+SmokingCurrentNegative+SmokingNeverNegative;
		System.out.println("TotalSmokingNegative "+TotalSmokingNegative);
		
		TotalSmoking=TotalSmokingpositive+TotalSmokingNegative;
		System.out.println("TotalSmoking "+TotalSmoking);
	}
	///////////////////////       ///////////////////////
	
	private void ObesityObsebveValue() 
	{
		          try {
                st = conn.createStatement();         
                ResultSet iterOOVP = st.executeQuery("select count(obesity)as Yes from tbTrainingDataSet where Disease='Positive'and obesity='Yes'");
                while (iterOOVP.next()) {
                    
                    Obesityyespositive = Double.parseDouble(iterOOVP.getString(1));
                    System.out.println("Obesityyespositive " + Obesityyespositive);
                }
            } catch (Exception exception) {
            }
		
		          try {
                st = conn.createStatement();       
                ResultSet iterOOVN = st.executeQuery("select count(obesity)as Yes from tbTrainingDataSet where Disease='Negative'and obesity='Yes'");
                while (iterOOVN.next()) {
                    
                    ObesityyesNegative = Double.parseDouble(iterOOVN.getString(1));
                    System.out.println("ObesityyesNegative " + ObesityyesNegative);
                }
            } catch (Exception exception) {
            }
		
		///////////////
		          try {
                st = conn.createStatement();             
                ResultSet iternopositive = st.executeQuery("select count(obesity)as No from tbTrainingDataSet where Disease='Positive'and obesity='No'");
                while (iternopositive.next()) {
                    
                    Obesitynopositive = Double.parseDouble(iternopositive.getString(1));
                    System.out.println("Obesitynopositive " + Obesitynopositive);
                }
            } catch (Exception e) {
            }
		          try {
                st = conn.createStatement();
                ResultSet iterONN = st.executeQuery("select count(obesity)as No from tbTrainingDataSet where Disease='Negative'and obesity='No'");
                while (iterONN.next()) {
                    
                    ObesitynoNegative = Double.parseDouble(iterONN.getString(1));
                    System.out.println("ObesitynoNegative " + ObesitynoNegative);
                }
            } catch (Exception sQLException) {
                
            } 
		/////////
		TotalObesityyes=Obesityyespositive+ObesityyesNegative;
		System.out.println("TotalObesityYes "+TotalObesityyes);
		TotalObesityno=Obesitynopositive+ObesitynoNegative;
		System.out.println("TotalObesityno "+TotalObesityno);
		
		TotalObesityPositive=Obesityyespositive+Obesitynopositive;
		System.out.println("TotalObesityPositive "+TotalObesityPositive);
		TotalObesityNegative=ObesityyesNegative+ObesitynoNegative;
		System.out.println("TotalObesityNegative "+TotalObesityNegative);
		
		TotalObesity=TotalObesityPositive+TotalObesityNegative;
		System.out.println("TotalObesity "+TotalObesity);
		System.out.println("=======================Expected value===============================");
		
	}
	private void AgeExpectedValue()
	{
		Ageyoungpositive=Totalyoung*TotalAgePositive/TotalAge;
		System.out.println("Ageyoungpositive.................. "+Ageyoungpositive);
		
		AgeMidpositive=TotalMid*TotalAgePositive/TotalAge;
		System.out.println("AgeMidpositive.................. "+AgeMidpositive);
		
		Ageoldpositive=TotalOld*TotalAgePositive/TotalAge;
		System.out.println("Ageoldpositive.................. "+Ageoldpositive);
		
		Ageveryoldpositive=TotalVeryOld*TotalAgePositive/TotalAge;
		System.out.println("Ageveryoldpositive.................. "+Ageveryoldpositive);
		
		AgeyoungNegative=Totalyoung*TotalAgeNegative/TotalAge;
		System.out.println("AgeyoungNegative.................. "+AgeyoungNegative);
		
		AgeMidNegative=TotalMid*TotalAgeNegative/TotalAge;
		System.out.println("AgeMidNegative.................. "+AgeMidNegative);
		
		AgeoldNegative=TotalOld*TotalAgeNegative/TotalAge;
		System.out.println("AgeoldNegative.................. "+AgeoldNegative);
		
		AgeveryoldNegative=TotalVeryOld*TotalAgeNegative/TotalAge;
		System.out.println("AgeveryoldNegative.................. "+AgeveryoldNegative);
		
		GENDERMALEPOSITIVE=Totalmale*TotalgenderPositive/TotalGender;
		System.out.println("GENDERMALEPOSITIVE.................. "+GENDERMALEPOSITIVE);
		
		GENDERFEMALEPOSITIVE=TotalFemale*TotalgenderPositive/TotalGender;
		System.out.println("GENDERFEMALEPOSITIVE.................. "+GENDERFEMALEPOSITIVE);
		
		GENDERMALENEGATIVE=Totalmale*TotalgenderNegative/TotalGender;
		System.out.println("GENDERMALENEGATIVE.................. "+GENDERMALENEGATIVE);
		
		GENDERFEMALENEGATIVE=TotalFemale*TotalgenderNegative/TotalGender;
		System.out.println("GENDERFEMALENEGATIVE.................. "+GENDERFEMALENEGATIVE);
		
	}
	private void GenderExpectedValue()
	{
		GENDERMALEPOSITIVE=Totalmale*TotalgenderPositive/TotalGender;
		System.out.println("GENDERMALEPOSITIVE.................. "+GENDERMALEPOSITIVE);
		
		GENDERFEMALEPOSITIVE=TotalFemale*TotalgenderPositive/TotalGender;
		System.out.println("GENDERFEMALEPOSITIVE.................. "+GENDERFEMALEPOSITIVE);
		
		GENDERMALENEGATIVE=Totalmale*TotalgenderNegative/TotalGender;
		System.out.println("GENDERMALENEGATIVE.................. "+GENDERMALENEGATIVE);
		
		GENDERFEMALENEGATIVE=TotalFemale*TotalgenderNegative/TotalGender;
		System.out.println("GENDERFEMALENEGATIVE.................. "+GENDERFEMALENEGATIVE);
		
	}
	private void ChestpaintypeExpectedValue()
	{
		CHESTTYPICALPOSITIVE=TotalTypical*TotalchestPositive/Totalchest;
		System.out.println("CHESTTYPICALPOSITIVE.................. "+CHESTTYPICALPOSITIVE);
		
		CHESTATYPICALPOSITIVE=Totalatypical*TotalchestPositive/Totalchest;
		System.out.println("CHESTATYPICALPOSITIVE.................. "+CHESTATYPICALPOSITIVE);
		
		CHESTNONPOSITIVE=Totalnonnagina*TotalchestPositive/Totalchest;
		System.out.println("CHESTNONPOSITIVE.................. "+CHESTNONPOSITIVE);
		
		CHESTASYMPTOMATICPOSITIVE=Totalasymptomatic*TotalchestPositive/Totalchest;
		System.out.println("CHESTASYMPTOMATICPOSITIVE.................. "+CHESTASYMPTOMATICPOSITIVE);
		////////////////////
		
		CHESTTYPICALNEGATIVE=TotalTypical*TotalchestNegative/Totalchest;
		System.out.println("CHESTTYPICALNEGATIVE.................. "+CHESTTYPICALNEGATIVE);
		
		CHESTATYPICALNEGATIVE=Totalatypical*TotalchestNegative/Totalchest;
		System.out.println("CHESTATYPICALNEGATIVE.................. "+CHESTATYPICALNEGATIVE);
		
		CHESTNONNEGATIVE=Totalnonnagina*TotalchestNegative/Totalchest;
		System.out.println("CHESTNONNEGATIVE.................. "+CHESTNONNEGATIVE);
		
		CHESTASYMPTOMATICNEGATIVE=Totalasymptomatic*TotalchestNegative/Totalchest;
		System.out.println("CHESTASYMPTOMATICNEGATIVE.................. "+CHESTASYMPTOMATICNEGATIVE);
		
	}
	
	private void FastingBloodSuggerExpectedValue()
	{
		FASTINGYESPOSITIVE=Totalyes*TotalFastingPositive/TotalFasting;
		System.out.println("FASTINGYESPOSITIVE.................. "+FASTINGYESPOSITIVE);
		
		FASTINGNOPOSITIVE=Totalno*TotalFastingPositive/TotalFasting;
		System.out.println("FASTINGNOPOSITIVE.................. "+FASTINGNOPOSITIVE);
		
		FASTINGYESNEGATIVE=Totalyes*TotalFastingNegative/TotalFasting;
		System.out.println("FASTINGYESNEGATIVE.................. "+FASTINGYESNEGATIVE);
		
		FASTINGNONEGATIVE=Totalno*TotalFastingNegative/TotalFasting;
		System.out.println("FASTINGNONEGATIVE.................. "+FASTINGNONEGATIVE);
	}
	
	private void RestECGExpectedValue()
	{
		RESTNORMALEPOSITIVE=TotalNormal*TotalRestPositive/TotalRest;
		System.out.println("RESTNORMALEPOSITIVE.................. "+RESTNORMALEPOSITIVE);
		
		RESTST_TPOSITIVE=TotalST_T*TotalRestPositive/TotalRest;
		System.out.println("RESTST_TPOSITIVE.................. "+RESTST_TPOSITIVE);
		
		RESTHYPERTROPHYPOSITIVE=TotalHypertrophy*TotalRestPositive/TotalRest;
		System.out.println("RESTHYPERTROPHYPOSITIVE.................. "+RESTHYPERTROPHYPOSITIVE);
		
		////////////////////
		
		RESTNORMALNEGATIVE=TotalNormal*TotalRestNegative/TotalRest;
		System.out.println("RESTNORMALNEGATIVE.................. "+RESTNORMALNEGATIVE);
		
		RESTST_TNEGATIVE=TotalST_T*TotalRestNegative/TotalRest;
		System.out.println("RESTST_TNEGATIVE.................. "+RESTST_TNEGATIVE);
		
		RESTHYPERTROPHYNEGATIVE=TotalHypertrophy*TotalRestNegative/TotalRest;
		System.out.println("RESTHYPERTROPHYNEGATIVE.................. "+RESTHYPERTROPHYNEGATIVE);
	}
	
	private void ExangExpectedValue()
	{
		EXANGYESPOSITIVE=TotalYes*TotalExangPositive/TotalExang;
		System.out.println("EXANGYESPOSITIVE.................. "+EXANGYESPOSITIVE);
		
		EXANGNOPOSITIVE=TotalNo*TotalExangPositive/TotalExang;
		System.out.println("EXANGNOPOSITIVE.................. "+EXANGNOPOSITIVE);
		
		////////////////////
		
		EXANGYESNEGATIVE=TotalYes*TotalExangNegative/TotalExang;
		System.out.println("EXANGYESNEGATIVE.................. "+EXANGYESNEGATIVE);
		
		EXANGNONEGATIVE=TotalNo*TotalExangNegative/TotalExang;
		System.out.println("EXANGNONEGATIVE.................. "+EXANGNONEGATIVE);
	}
	
	private void SlopExpectedValue()
	{
		SLOPUNSLOPPOSITIVE=TotalUnslop*TotalSlopPositive/TotalSlop;
		System.out.println("SLOPUNSLOPPOSITIVE.................. "+SLOPUNSLOPPOSITIVE);
		
		SLOPFLATPOSITIVE=TotalFalt*TotalSlopPositive/TotalSlop;
		System.out.println("SLOPFLATPOSITIVE.................. "+SLOPFLATPOSITIVE);
		
		SLOPDOWNPOSITIVE=TotalDownslop*TotalSlopPositive/TotalSlop;
		System.out.println("SLOPDOWNPOSITIVE.................. "+SLOPDOWNPOSITIVE);
		
		////////////////////
		
		SLOPUNSLOPNEGATIVE=TotalUnslop*TotalSlopNegative/TotalSlop;
		System.out.println("SLOPUNSLOPNEGATIVE.................. "+SLOPUNSLOPNEGATIVE);
		
		SLOPFLATNEGATIVE=TotalFalt*TotalSlopNegative/TotalSlop;
		System.out.println("SLOPFLATNEGATIVE.................. "+SLOPFLATNEGATIVE);
		
		SLOPDOWNNEGATIVE=TotalDownslop*TotalSlopNegative/TotalSlop;
		System.out.println("SLOPDOWNNEGATIVE.................. "+SLOPDOWNNEGATIVE);
		
	}
	private void ThalExpectedValue()
	{
		THALNORMALPOSITIVE=TotalthalNormal*TotalthalPositive/Totalthal;
		System.out.println("THALNORMALPOSITIVE.................. "+THALNORMALPOSITIVE);
		
		THALFIXEDPOSITIVE=TotalthalFixed*TotalthalPositive/Totalthal;
		System.out.println("THALFIXEDPOSITIVE.................. "+THALFIXEDPOSITIVE);
		
		THALREVERSIBLEPOSITIVE=Totalthalreversible*TotalthalPositive/Totalthal;
		System.out.println("THALREVERSIBLEPOSITIVE.................. "+THALREVERSIBLEPOSITIVE);
		
		////////////////////
		
		THALNORMALNEGATIVE=TotalthalNormal*TotalthalNegative/Totalthal;
		System.out.println("THALNORMALNEGATIVE.................. "+THALNORMALNEGATIVE);
		
		THALFIXEDNEGATIVE=TotalthalFixed*TotalthalNegative/Totalthal;
		System.out.println("THALFIXEDNEGATIVE.................. "+THALFIXEDNEGATIVE);
		
		THALREVERSIBLENEGATIVE=Totalthalreversible*TotalthalNegative/Totalthal;
		System.out.println("THALREVERSIBLENEGATIVE.................. "+THALREVERSIBLENEGATIVE);
		
	}
	
	
	private void TrestbloodpressureExpectedValue()
	{
		TRESTLOWPOSITIVE=TotalTrestBloodlow*TotalTrestBloodpositive/TotalTrestBlood;
		System.out.println("TRESTLOWPOSITIVE.................. "+TRESTLOWPOSITIVE);
		
		TRESTMEDIUMPOSITIVE=TotalTrestBloodmedium*TotalTrestBloodpositive/TotalTrestBlood;
		System.out.println("TRESTMEDIUMPOSITIVE.................. "+TRESTMEDIUMPOSITIVE);
		
		TRESTHIGHPOSITIVE=TotalTrestBloodhigh*TotalTrestBloodpositive/TotalTrestBlood;
		System.out.println("TRESTHIGHPOSITIVE.................. "+TRESTHIGHPOSITIVE);
		
		TRESTVERYHIGHPOSITIVE=TotalTrestBloodveryhigh*TotalTrestBloodpositive/TotalTrestBlood;
		System.out.println("TRESTVERYHIGHPOSITIVE.................. "+TRESTVERYHIGHPOSITIVE);
		
		
		////////////////////
		
		TRESTLOWNEGATIVE=TotalTrestBloodlow*TotalTrestBloodNegative/TotalTrestBlood;
		System.out.println("TRESTLOWNEGATIVE.................. "+TRESTLOWNEGATIVE);
		
		TRESTMEDIUMNEGATIVE=TotalTrestBloodmedium*TotalTrestBloodNegative/TotalTrestBlood;
		System.out.println("TRESTMEDIUMNEGATIVE.................. "+TRESTMEDIUMNEGATIVE);
		
		TRESTHIGHNEGATIVE=TotalTrestBloodhigh*TotalTrestBloodNegative/TotalTrestBlood;
		System.out.println("TRESTHIGHNEGATIVE.................. "+TRESTHIGHNEGATIVE);
		
		TRESTVERYHIGHNEGATIVE=TotalTrestBloodveryhigh*TotalTrestBloodNegative/TotalTrestBlood;
		System.out.println("TRESTVERYHIGHNEGATIVE.................. "+TRESTVERYHIGHNEGATIVE);
		
		
	}
	
	
	private void SerumcholesterolExpectedValue()
	{
		SERUMLOWPOSITIVE=TotalSerumCholestorellow*TotalSerumCholestorelpositive/TotalSerumCholestorel;
		System.out.println("SERUMLOWPOSITIVE.................. "+SERUMLOWPOSITIVE);
		
		SERUMMEDIUMPOSITIVE=TotalSerumCholestorelmedium*TotalSerumCholestorelpositive/TotalSerumCholestorel;
		System.out.println("SERUMMEDIUMPOSITIVE.................. "+SERUMMEDIUMPOSITIVE);
		
		SERUMHIGHPOSITIVE=TotalSerumCholestorelhigh*TotalSerumCholestorelpositive/TotalSerumCholestorel;
		System.out.println("SERUMHIGHPOSITIVE.................. "+SERUMHIGHPOSITIVE);
		
		SERUMVERYHIGHPOSITIVE=TotalSerumCholestorelveryhigh*TotalSerumCholestorelpositive/TotalSerumCholestorel;
		System.out.println("SERUMVERYHIGHPOSITIVE.................. "+SERUMVERYHIGHPOSITIVE);
		
		
		////////////////////
		
		SERUMLOWNEGATIVE=TotalSerumCholestorellow*TotalSerumCholestorelNegative/TotalSerumCholestorel;
		System.out.println("SERUMLOWNEGATIVE.................. "+SERUMLOWNEGATIVE);
		
		SERUMMEDIUMNEGATIVE=TotalSerumCholestorelmedium*TotalSerumCholestorelNegative/TotalSerumCholestorel;
		System.out.println("SERUMMEDIUMNEGATIVE.................. "+SERUMMEDIUMNEGATIVE);
		
		SERUMHIGHNEGATIVE=TotalSerumCholestorelhigh*TotalSerumCholestorelNegative/TotalSerumCholestorel;
		System.out.println("SERUMHIGHNEGATIVE.................. "+SERUMHIGHNEGATIVE);
		
		SERUMVERYHIGHNEGATIVE=TotalSerumCholestorelveryhigh*TotalSerumCholestorelNegative/TotalSerumCholestorel;
		System.out.println("SERUMVERYHIGHNEGATIVE.................. "+SERUMVERYHIGHNEGATIVE);
		
		
	}
	
	private void ThalachExpectedValue()
	{
		THALACHLOWPOSITIVE=TotalThalachlow*TotalThalachpositive/TotalThalach;
		System.out.println("THALACHLOWPOSITIVE.................. "+THALACHLOWPOSITIVE);
		
		THALACHMEDIUMPOSITIVE=TotalThalachmedium*TotalThalachpositive/TotalThalach;
		System.out.println("THALACHMEDIUMPOSITIVE.................. "+THALACHMEDIUMPOSITIVE);
		
		THALACHHIGHPOSITIVE=TotalThalachhigh*TotalThalachpositive/TotalThalach;
		System.out.println("THALACHHIGHPOSITIVE.................. "+THALACHHIGHPOSITIVE);
		
		////////////////////
		
		THALACHLOWNEGATIVE=TotalThalachlow*TotalThalachNegative/TotalThalach;
		System.out.println("THALACHLOWNEGATIVE.................. "+THALACHLOWNEGATIVE);
		
		THALACHMEDIUMNEGATIVE=TotalThalachmedium*TotalThalachNegative/TotalThalach;
		System.out.println("THALACHMEDIUMNEGATIVE.................. "+THALACHMEDIUMNEGATIVE);
		
		THALACHHIGHNEGATIVE=TotalThalachhigh*TotalThalachNegative/TotalThalach;
		System.out.println("THALACHHIGHNEGATIVE.................. "+THALACHHIGHNEGATIVE);
		
	}
	
	
	private void OldpeakExpectedValue()
	{
		OLDPEAKLOWPOSITIVE=TotalOldPeaklow*TotalOldPeakpositive/TotalOldPeak;
		System.out.println("OLDPEAKLOWPOSITIVE.................. "+OLDPEAKLOWPOSITIVE);
		
		OLDPEAKRISKPOSITIVE=TotalOldPeakRisk*TotalOldPeakpositive/TotalOldPeak;
		System.out.println("OLDPEAKRISKPOSITIVE.................. "+OLDPEAKRISKPOSITIVE);
		
		OLDPEAKTERRIBLEPOSITIVE=TotalOldPeakTerrible*TotalOldPeakpositive/TotalOldPeak;
		System.out.println("OLDPEAKTERRIBLEPOSITIVE.................. "+OLDPEAKTERRIBLEPOSITIVE);
		
		////////////////////
		
		OLDPEALLOWNEGATIVE=TotalOldPeaklow*TotalOldPeakNegative/TotalOldPeak;
		System.out.println("OLDPEALLOWNEGATIVE.................. "+OLDPEALLOWNEGATIVE);
		
		OLDPEAKRISKNEGATIVE=TotalOldPeakRisk*TotalOldPeakNegative/TotalOldPeak;
		System.out.println("OLDPEAKRISKNEGATIVE.................. "+OLDPEAKRISKNEGATIVE);
		
		OLDPEAKTERRIBLENEGATIVE=TotalOldPeakTerrible*TotalOldPeakNegative/TotalOldPeak;
		System.out.println("OLDPEAKTERRIBLENEGATIVE.................. "+OLDPEAKTERRIBLENEGATIVE);
		
	}
	
	private void SmokingExpectedValue()
	{
		SMOKINGPASTPOSITIVE=TotalSmokingpast*TotalSmokingpositive/TotalSmoking;
		System.out.println("SMOKINGPASTPOSITIVE.................. "+SMOKINGPASTPOSITIVE);
		
		SMOKINGCURRENTPOSITIVE=TotalSmokingcurrent*TotalSmokingpositive/TotalSmoking;
		System.out.println("SMOKINGCURRENTPOSITIVE.................. "+SMOKINGCURRENTPOSITIVE);
		
		SMOKINGNEVERPOSITIVE=TotalSmokingnever*TotalSmokingpositive/TotalSmoking;
		System.out.println("SMOKINGNEVERPOSITIVE.................. "+SMOKINGNEVERPOSITIVE);
		
		////////////////////
		
		SMOKINGPASTNEGATIVE=TotalSmokingpast*TotalSmokingNegative/TotalSmoking;
		System.out.println("SMOKINGPASTNEGATIVE.................. "+SMOKINGPASTNEGATIVE);
		
		SMOKINGCURRENTNEGATIVE=TotalSmokingcurrent*TotalSmokingNegative/TotalSmoking;
		System.out.println("SMOKINGCURRENTNEGATIVE.................. "+SMOKINGCURRENTNEGATIVE);
		
		SMOKINGNEVERNEGATIVE=TotalSmokingnever*TotalSmokingNegative/TotalSmoking;
		System.out.println("SMOKINGNEVERNEGATIVE.................. "+SMOKINGNEVERNEGATIVE);
		
	}
	
	private void ObesityExpectedValue()
	{
		OBESITYYESPOSITIVE=TotalObesityyes*TotalObesityPositive/TotalObesity;
		System.out.println("OBESITYYESPOSITIVE.................. "+OBESITYYESPOSITIVE);
		
		OBESITYNOTPOSITIVE=TotalObesityno*TotalObesityPositive/TotalObesity;
		System.out.println("OBESITYNOTPOSITIVE.................. "+OBESITYNOTPOSITIVE);
		
		////////////////////
		
		OBESITYYESNEGATIVE=TotalObesityyes*TotalObesityNegative/TotalObesity;
		System.out.println("OBESITYYESNEGATIVE.................. "+OBESITYYESNEGATIVE);
		
		OBESITYNONEGATIVE=TotalObesityno*TotalObesityNegative/TotalObesity;
		System.out.println("OBESITYNONEGATIVE.................. "+OBESITYNONEGATIVE);
		
		System.out.println("====================chi Value=====================");
		
	}
	private void ChiValue()
	{
            double chiageyoungNegative;
            double chiageyoungpositive;
            if(Ageyoungpositive !=0){
		 chiageyoungpositive=Math.pow(2,ageyoungpositive-Ageyoungpositive)/Ageyoungpositive;
		System.out.println("chiageyoungpositive.................. "+chiageyoungpositive);
            }
            else
            {
                 chiageyoungpositive=0;
		System.out.println("chiageyoungpositive..................= "+chiageyoungpositive);
            }
		if(AgeyoungNegative != 0){
		 chiageyoungNegative=Math.pow(2,ageyoungNegative-AgeyoungNegative)/AgeyoungNegative;
		System.out.println("chiageyoungNegative.................. "+chiageyoungNegative);
                }
                else{
                   chiageyoungNegative=0;
		System.out.println("chiageyoungNegative.................. "+chiageyoungNegative);
                }
		
		double chiageMidpositive=Math.pow(2,ageMidpositive-AgeMidpositive)/AgeMidpositive;
		System.out.println("chiageMidpositive.................. "+chiageMidpositive);
		
		double chiageMidNegative=Math.pow(2,ageMidNegative-AgeMidNegative)/AgeMidNegative;
		System.out.println("chiageMidNegative.................. "+chiageMidNegative);
		
		double chiageOldpositive=Math.pow(2,ageOldpositive-Ageoldpositive)/Ageoldpositive;
		System.out.println("chiageOldpositive.................. "+chiageOldpositive);
		
		double chiageOldNegative=Math.pow(2,ageOldNegative-AgeoldNegative)/AgeoldNegative;
		System.out.println("chiageOldNegative.................. "+chiageOldNegative);
		
		double chiageVeryOldpositive=Math.pow(2,ageVeryOldpositive-ageVeryOldpositive)/ageVeryOldpositive;
		System.out.println("chiageVeryOldpositive.................. "+chiageVeryOldpositive);
		
		double chiageVeryOldNegative=Math.pow(2,ageVeryOldNegative-AgeveryoldNegative)/AgeveryoldNegative;
		System.out.println("chiageVeryOldNegative.................. "+chiageVeryOldNegative);
		
		double TotalAgeCalculation=chiageyoungpositive+chiageyoungNegative+chiageMidpositive+chiageMidNegative+chiageOldpositive+chiageOldNegative+chiageVeryOldpositive+chiageVeryOldNegative;
		System.out.println("TotalAgeCalculation.................. "+TotalAgeCalculation);
		
		txtage.setText(df.format(TotalAgeCalculation));
		System.out.println("================================================");
		
		//////////////////////////////////////////////
		double chiGendermalepositive=Math.pow(2,Gendermalepositive-GENDERMALEPOSITIVE)/GENDERMALEPOSITIVE;
		System.out.println("chiGendermalepositive.................. "+chiGendermalepositive);
		
		double chiGendermaleNegative=Math.pow(2,GendermaleNegative-GENDERMALENEGATIVE)/GENDERMALENEGATIVE;
		System.out.println("chiGendermaleNegative.................. "+chiGendermaleNegative);
		
		double chiGenderFemalepositive=Math.pow(2,GenderFemalepositive-GENDERFEMALEPOSITIVE)/GENDERFEMALEPOSITIVE;
		System.out.println("chiGenderFemalepositive.................. "+chiGenderFemalepositive);
		
		double chiGenderFemaleNegative=Math.pow(2,GenderFemaleNegative-GENDERFEMALENEGATIVE)/GENDERFEMALENEGATIVE;
		System.out.println("chiGenderFemaleNegative.................. "+chiGenderFemaleNegative);
		
		double TotalGenderCalculation=chiGendermalepositive+chiGendermaleNegative+chiGenderFemalepositive+chiGenderFemaleNegative;
		System.out.println("TotalGenderCalculation.................. "+TotalGenderCalculation);
		
		txtgender.setText(df.format(TotalGenderCalculation));
		System.out.println("================================================");
		
		/////////////////////////////////////////////
                double chiChstTypicalpositive;
                if(CHESTTYPICALPOSITIVE !=0){
		chiChstTypicalpositive=Math.pow(2,ChestTypicalpositive-CHESTTYPICALPOSITIVE)/CHESTTYPICALPOSITIVE;
		System.out.println("chiChstTypicalpositive.................. "+chiChstTypicalpositive);
                }
                else{
                chiChstTypicalpositive=0;
		System.out.println("chiChstTypicalpositive..................= "+chiChstTypicalpositive);
                }
                double chiChstTypicalNegative;
                if(CHESTTYPICALNEGATIVE != 0){
		chiChstTypicalNegative=Math.pow(2,ChestTypicalNegative-CHESTTYPICALNEGATIVE)/CHESTTYPICALNEGATIVE;
		System.out.println("chiChstTypicalNegative.................. "+chiChstTypicalNegative);
                }
                else{
                chiChstTypicalNegative=0;
		System.out.println("chiChstTypicalNegative..................= "+chiChstTypicalNegative);
                }
                
		double chiChstTaypicalpositive=Math.pow(2,ChestaTypicalpositive-CHESTATYPICALPOSITIVE)/CHESTATYPICALPOSITIVE;
		System.out.println("chiChstTaypicalpositive.................. "+chiChstTaypicalpositive);
		
		double chiChstTaypicalNegative=Math.pow(2,ChestaTypicalNegative-CHESTATYPICALNEGATIVE)/CHESTATYPICALNEGATIVE;
		System.out.println("chiChstTaypicalNegative.................. "+chiChstTaypicalNegative);
		
		double chiChestnonpositive=Math.pow(2,Chestnonanginapositive-CHESTNONPOSITIVE)/CHESTNONPOSITIVE;
		System.out.println("chiChestnonpositive.................. "+chiChestnonpositive);
		
		double chiChestnonNegative=Math.pow(2,ChestnonanginaNegative-CHESTNONNEGATIVE)/CHESTNONNEGATIVE;
		System.out.println("chiChestnonNegative.................. "+chiChestnonNegative);
		
		double chiChestAsymptomaticpositive=Math.pow(2,Chestasymptomaticpositive-CHESTASYMPTOMATICPOSITIVE)/CHESTASYMPTOMATICPOSITIVE;
		System.out.println("chiChestAsymptomaticpositive.................. "+chiChestAsymptomaticpositive);
		
		double chiChestAsymptomaticNegative=Math.pow(2,ChestasymptomaticNegative-CHESTASYMPTOMATICNEGATIVE)/CHESTASYMPTOMATICNEGATIVE;
		System.out.println("chiChestAsymptomaticNegative.................. "+chiChestAsymptomaticNegative);
		
		double TotalChestCalculation=chiChstTypicalpositive+chiChstTypicalNegative+chiChstTaypicalpositive+chiChstTaypicalNegative+chiChestnonpositive+chiChestnonNegative+chiChestAsymptomaticpositive+chiChestAsymptomaticNegative;
		System.out.println("TotalChestCalculation.................. "+TotalChestCalculation);
		
		txtchestpain.setText(df.format(TotalChestCalculation));
		System.out.println("================================================");
		
		//////////////////////////////////////////////
		
		double chiFustingyespositive=Math.pow(2,Fastingyespositive-FASTINGYESPOSITIVE)/FASTINGYESPOSITIVE;
		System.out.println("chiFustingyespositive.................. "+chiFustingyespositive);
		
		double chiFustingyesNegative=Math.pow(2,FastingyesNegative-FASTINGYESNEGATIVE)/FASTINGYESNEGATIVE;
		System.out.println("chiFustingyesNegative.................. "+chiFustingyesNegative);
		
		double chiFustingnopositive=Math.pow(2,Fastingnopositive-FASTINGNOPOSITIVE)/FASTINGNOPOSITIVE;
		System.out.println("chiFustingnopositive.................. "+chiFustingnopositive);
		
		double chiFustingnoNegative=Math.pow(2,FastingnoNegative-FASTINGNONEGATIVE)/FASTINGNONEGATIVE;
		System.out.println("chiFustingnoNegative.................. "+chiFustingnoNegative);
		
		double TotalFastingCalculation=chiFustingyespositive+chiFustingyesNegative+chiFustingnopositive+chiFustingnoNegative;
		System.out.println("TotalFastingCalculation.................. "+TotalFastingCalculation);
		
		txtfasting.setText(df.format(TotalFastingCalculation));
		System.out.println("================================================");
		
		/////////////////////////////////////////////
		
		double chiRestnormalpositive=Math.pow(2,Restnormalpositive-RESTNORMALEPOSITIVE)/RESTNORMALEPOSITIVE;
		System.out.println("chiRestnormalpositive.................. "+chiRestnormalpositive);
		
		double chiRestnormalNegative=Math.pow(2,RestnormalNegative-RESTNORMALNEGATIVE)/RESTNORMALNEGATIVE;
		System.out.println("chiRestnormalNegative.................. "+chiRestnormalNegative);
		
		double chiReststtpositive=Math.pow(2,RestST_Tpositive-RESTST_TPOSITIVE)/RESTST_TPOSITIVE;
		System.out.println("chiReststtpositive.................. "+chiReststtpositive);
		
		double chiReststtNegative=Math.pow(2,RestST_TNegative-RESTST_TNEGATIVE)/RESTST_TNEGATIVE;
		System.out.println("chiReststtNegative.................. "+chiReststtNegative);
		
		double chiResthypertropypositive=Math.pow(2,RestHypertrophypositive-RESTHYPERTROPHYPOSITIVE)/RESTHYPERTROPHYPOSITIVE;
		System.out.println("chiResthypertropypositive.................. "+chiResthypertropypositive);
		
		double chiResthypertropyNegative=Math.pow(2,RestHypertrophyNegative-RESTHYPERTROPHYNEGATIVE)/RESTHYPERTROPHYNEGATIVE;
		System.out.println("chiResthypertropyNegative.................. "+chiResthypertropyNegative);
		
		double TotalRestCalculation=chiRestnormalpositive+chiRestnormalNegative+chiReststtpositive+chiReststtNegative+chiResthypertropypositive+chiResthypertropyNegative;
		System.out.println("TotalRestCalculation.................. "+TotalRestCalculation);
		
		txtrestecg.setText(df.format(TotalRestCalculation));
		System.out.println("================================================");
		
		//////////////////////////////////////////////
		
		double chiExangyespositive=Math.pow(2,Exangyespositive-EXANGYESPOSITIVE)/EXANGYESPOSITIVE;
		System.out.println("chiExangyespositive.................. "+chiExangyespositive);
		
		double chiExangyesNegative=Math.pow(2,ExangyesNegative-EXANGYESNEGATIVE)/EXANGYESNEGATIVE;
		System.out.println("chiExangyesNegative.................. "+chiExangyesNegative);
		
		double chiExangnopositive=Math.pow(2,Exangnopositive-EXANGNOPOSITIVE)/EXANGNOPOSITIVE;
		System.out.println("chiExangnopositive.................. "+chiExangnopositive);
		
		double chiExangnoNegative=Math.pow(2,ExangnoNegative-EXANGNONEGATIVE)/EXANGNONEGATIVE;
		System.out.println("chiExangnoNegative.................. "+chiExangnoNegative);
		
		double TotalExangCalculation=chiExangyespositive+chiExangyesNegative+chiExangnopositive+chiExangnoNegative;
		System.out.println("TotalExangCalculation.................. "+TotalExangCalculation);
		
		txtexang.setText(df.format(TotalExangCalculation));
		System.out.println("================================================");
		
		/////////////////////////////////////////////
		
		double chiSlopunsloppositive=Math.pow(2,SlopUnslopingpositive-SLOPUNSLOPPOSITIVE)/SLOPUNSLOPPOSITIVE;
		System.out.println("chiSlopunsloppositive.................. "+chiSlopunsloppositive);
		
		double chiSlopunslopNegative=Math.pow(2,SlopUnslopingNegative-SLOPUNSLOPNEGATIVE)/SLOPUNSLOPNEGATIVE;
		System.out.println("chiSlopunslopNegative.................. "+chiSlopunslopNegative);
		
		double chiSlopflatpositive=Math.pow(2,SlopFlatpositive-SLOPFLATPOSITIVE)/SLOPFLATPOSITIVE;
		System.out.println("chiSlopflatpositive.................. "+chiSlopflatpositive);
		
		double chiSlopflatNegative=Math.pow(2,SlopFlatNegative-SLOPFLATNEGATIVE)/SLOPFLATNEGATIVE;
		System.out.println("chiSlopflatNegative.................. "+chiSlopflatNegative);
		
		double chiSlopdownsloppositive=Math.pow(2,SlopDownsloppositive-SLOPDOWNPOSITIVE)/SLOPDOWNPOSITIVE;
		System.out.println("chiSlopdownsloppositive.................. "+chiSlopdownsloppositive);
		
		double chiSlopdownslopNegative=Math.pow(2,SlopDownslopNegative-SLOPDOWNNEGATIVE)/SLOPDOWNNEGATIVE;
		System.out.println("chiSlopdownslopNegative.................. "+chiSlopdownslopNegative);
		
		double TotalSlopCalculation=chiSlopunsloppositive+chiSlopunslopNegative+chiSlopflatpositive+chiSlopflatNegative+chiSlopdownsloppositive+chiSlopdownslopNegative;
		System.out.println("TotalSlopCalculation.................. "+TotalSlopCalculation);
		
		txtslop.setText(df.format(TotalSlopCalculation));
		System.out.println("================================================");
		
		//////////////////////////////////////////////
		

		double chiThalnormalpositive=Math.pow(2,Thalnormalpositive-THALNORMALPOSITIVE)/THALNORMALPOSITIVE;
		System.out.println("chiThalnormalpositive.................. "+chiThalnormalpositive);
		
		double chithalnormalNegative=Math.pow(2,ThalnormalNegative-THALNORMALNEGATIVE)/THALNORMALNEGATIVE;
		System.out.println("chithalnormalNegative.................. "+chithalnormalNegative);
		
		double chithalfisedpositive=Math.pow(2,ThalFixedpositive-THALFIXEDPOSITIVE)/THALFIXEDPOSITIVE;
		System.out.println("chithalfisedpositive.................. "+chithalfisedpositive);
		
		double chithalfisedNegative=Math.pow(2,ThalFixedNegative-THALFIXEDNEGATIVE)/THALFIXEDNEGATIVE;
		System.out.println("chithalfisedNegative.................. "+chithalfisedNegative);
		
		double chithalreversiblepositive=Math.pow(2,ThalReversiblepositive-THALREVERSIBLEPOSITIVE)/THALREVERSIBLEPOSITIVE;
		System.out.println("chithalreversiblepositive.................. "+chithalreversiblepositive);
		
		double chithalreversibleNegative=Math.pow(2,ThalReversibleNegative-THALREVERSIBLENEGATIVE)/THALREVERSIBLENEGATIVE;
		System.out.println("chithalreversibleNegative.................. "+chithalreversibleNegative);
		
		double TotalThalCalculation=chiThalnormalpositive+chithalnormalNegative+chithalfisedpositive+chithalfisedNegative+chithalreversiblepositive+chithalreversibleNegative;
		System.out.println("TotalThalCalculation.................. "+TotalThalCalculation);
		
		txtthal.setText(df.format(TotalThalCalculation));
		System.out.println("================================================");
		
		//////////////////////////////////////////////
		
		double chitrestbloodlowpositive=Math.pow(2,TrestBloodlowpositive-TRESTLOWPOSITIVE)/TRESTLOWPOSITIVE;
		System.out.println("chitrestbloodlowpositive.................. "+chitrestbloodlowpositive);
		
		double chitrestbloodlowNegative=Math.pow(2,TrestBloodlowNegative-TRESTLOWNEGATIVE)/TRESTLOWNEGATIVE;
		System.out.println("chitrestbloodlowNegative.................. "+chitrestbloodlowNegative);
		
		double chitrestbloodmediumpositive=Math.pow(2,TrestBloodmediumpositive-TRESTMEDIUMPOSITIVE)/TRESTMEDIUMPOSITIVE;
		System.out.println("chitrestbloodmediumpositive.................. "+chitrestbloodmediumpositive);
		
		double chitrestbloodmediumNegative=Math.pow(2,TrestBloodmediumNegative-TRESTMEDIUMNEGATIVE)/TRESTMEDIUMNEGATIVE;
		System.out.println("chitrestbloodmediumNegative.................. "+chitrestbloodmediumNegative);
		
		double chitrestbloodhighpositive=Math.pow(2,TrestBloodhighpositive-TRESTHIGHPOSITIVE)/TRESTHIGHPOSITIVE;
		System.out.println("chitrestbloodhighpositive.................. "+chitrestbloodhighpositive);
		
		double chitrestbloodhighNegative=Math.pow(2,TrestBloodhighNegative-TRESTHIGHNEGATIVE)/TRESTHIGHNEGATIVE;
		System.out.println("chitrestbloodhighNegative.................. "+chitrestbloodhighNegative);
		
		double chitrestbloodveryhighpositive=Math.pow(2,TrestBloodveryhighpositive-TRESTVERYHIGHPOSITIVE)/TRESTVERYHIGHPOSITIVE;
		System.out.println("chitrestbloodveryhighpositive.................. "+chitrestbloodveryhighpositive);
		
		double chitrestbloodveryhighNegative=Math.pow(2,TrestBloodverryhighNegative-TRESTVERYHIGHNEGATIVE)/TRESTVERYHIGHNEGATIVE;
		System.out.println("chitrestbloodveryhighNegative.................. "+chitrestbloodveryhighNegative);
		
		double TotaltrestbloodCalculation=chitrestbloodlowpositive+chitrestbloodlowNegative+chitrestbloodmediumpositive+chitrestbloodmediumNegative+chitrestbloodhighpositive+chitrestbloodhighNegative+chitrestbloodveryhighpositive+chitrestbloodveryhighNegative;
		System.out.println("TotaltrestbloodCalculation.................. "+TotaltrestbloodCalculation);
		
		txttrest.setText(df.format(TotaltrestbloodCalculation));
		System.out.println("================================================");
		
		//////////////////////////////////////////////
		
		double chiSerumlowpositive=Math.pow(2,SerumCholestorellowpositive-SERUMLOWPOSITIVE)/SERUMLOWPOSITIVE;
		System.out.println("chiSerumlowpositive.................. "+chiSerumlowpositive);
		
		double chiSerumlowNegative=Math.pow(2,SerumCholestorellowNegative-SERUMLOWNEGATIVE)/SERUMLOWNEGATIVE;
		System.out.println("chiSerumlowNegative.................. "+chiSerumlowNegative);
		
		double chiSerummediumpositive=Math.pow(2,SerumCholestorelmediumpositive-SERUMMEDIUMPOSITIVE)/SERUMMEDIUMPOSITIVE;
		System.out.println("chiSerummediumpositive.................. "+chiSerummediumpositive);
		
		double chiSerummediumNegative=Math.pow(2,SerumCholestorelmediumNegative-SERUMMEDIUMNEGATIVE)/SERUMMEDIUMNEGATIVE;
		System.out.println("chiSerummediumNegative.................. "+chiSerummediumNegative);
		
		double chiSerumhighpositive=Math.pow(2,SerumCholestorelhighpositive-SERUMHIGHPOSITIVE)/SERUMHIGHPOSITIVE;
		System.out.println("chiSerumhighpositive.................. "+chiSerumhighpositive);
		
		double chiSerumhighNegative=Math.pow(2,SerumCholestorelhighNegative-SERUMHIGHNEGATIVE)/SERUMHIGHNEGATIVE;
		System.out.println("chiSerumhighNegative.................. "+chiSerumhighNegative);
		
		double chiSerumveryhighpositive=Math.pow(2,SerumCholestorelveryhighpositive-SERUMVERYHIGHPOSITIVE)/SERUMVERYHIGHPOSITIVE;
		System.out.println("chiSerumveryhighpositive.................. "+chiSerumveryhighpositive);
		
		double chiSerumveryhighNegative=Math.pow(2,SerumCholestorelverryhighNegative-SERUMVERYHIGHNEGATIVE)/SERUMVERYHIGHNEGATIVE;
		System.out.println("chiSerumveryhighNegative.................. "+chiSerumveryhighNegative);
		
		double TotalSerumCalculation=chiSerumlowpositive+chiSerumlowNegative+chiSerummediumpositive+chiSerummediumNegative+chiSerumhighpositive+chiSerumhighNegative+chiSerumveryhighpositive+chiSerumveryhighNegative;
		System.out.println("TotalSerumCalculation.................. "+TotalSerumCalculation);
		
		txtserum.setText(df.format(TotalSerumCalculation));
		System.out.println("================================================");
		
		//////////////////////////////////////////////
		
		double chithalachlowpositive=Math.pow(2,Thalachlowpositive-THALACHLOWPOSITIVE)/THALACHLOWPOSITIVE;
		System.out.println("chithalachlowpositive.................. "+chithalachlowpositive);
		
		double chithalachlowNegative=Math.pow(2,ThalachlowNegative-THALACHLOWNEGATIVE)/THALACHLOWNEGATIVE;
		System.out.println("chithalachlowNegative.................. "+chithalachlowNegative);
		
		double chithalachmediumpositive=Math.pow(2,Thalachmediumpositive-THALACHMEDIUMPOSITIVE)/THALACHMEDIUMPOSITIVE;
		System.out.println("chithalachmediumpositive.................. "+chithalachmediumpositive);
		
		double chithalachmediumNegative=Math.pow(2,ThalachmediumNegative-THALACHMEDIUMNEGATIVE)/THALACHMEDIUMNEGATIVE;
		System.out.println("chithalachmediumNegative.................. "+chithalachmediumNegative);
		
		double chithalachhighpositive=Math.pow(2,Thalachhighpositive-THALACHHIGHPOSITIVE)/THALACHHIGHPOSITIVE;
		System.out.println("chivhighpositive.................. "+chithalachhighpositive);
		
		double chithalachhighNegative=Math.pow(2,ThalachhighNegative-THALACHHIGHNEGATIVE)/THALACHHIGHNEGATIVE;
		System.out.println("chithalachhighNegative.................. "+chithalachhighNegative);
		
		double TotalthalachCalculation=chithalachlowpositive+chithalachlowNegative+chithalachmediumpositive+chithalachmediumNegative+chithalachhighpositive+chithalachhighNegative;
		System.out.println("TotalthalachCalculation.................. "+TotalthalachCalculation);
		
		txtthalach.setText(df.format(TotalthalachCalculation));
		System.out.println("================================================");
		
		//////////////////////////////////////////////
		
		double chiOldpeaklowpositive=Math.pow(2,OldPeaklowpositive-OLDPEAKLOWPOSITIVE)/OLDPEAKLOWPOSITIVE;
		System.out.println("chiOldpeaklowpositive.................. "+chiOldpeaklowpositive);
		
		double chiOldpeaklowNegative=Math.pow(2,OldPeaklowNegative-OLDPEALLOWNEGATIVE)/OLDPEALLOWNEGATIVE;
		System.out.println("chiOldpeaklowNegative.................. "+chiOldpeaklowNegative);
		
		double chiOldpeakRiskpositive=Math.pow(2,OldPeakRiskpositive-OLDPEAKRISKPOSITIVE)/OLDPEAKRISKPOSITIVE;
		System.out.println("chiOldpeakRiskositive.................. "+chiOldpeakRiskpositive);
		
		double chiOldpeakRiskNegative=Math.pow(2,OldPeakRiskNegative-OLDPEAKRISKNEGATIVE)/OLDPEAKRISKNEGATIVE;
		System.out.println("chiOldpeakRiskNegative.................. "+chiOldpeakRiskNegative);
		
		double chiOldpeakterriblepositive=Math.pow(2,OldPeakTerriblepositive-OLDPEAKTERRIBLEPOSITIVE)/OLDPEAKTERRIBLEPOSITIVE;
		System.out.println("chiOldpeakterriblepositive.................. "+chiOldpeakterriblepositive);
		
		double chiOldpeakterribleNegative=Math.pow(2,OldPeakTerribleNegative-OLDPEAKTERRIBLENEGATIVE)/OLDPEAKTERRIBLENEGATIVE;
		System.out.println("chiOldpeakterribleNegative.................. "+chiOldpeakterribleNegative);
		
		double TotalOldpeakhCalculation=chiOldpeaklowpositive+chiOldpeaklowNegative+chiOldpeakRiskpositive+chiOldpeakRiskNegative+chiOldpeakterriblepositive+chiOldpeakterribleNegative;
		System.out.println("TotalOldpeakhCalculation.................. "+TotalOldpeakhCalculation);
		
		txtoldpeak.setText(df.format(TotalOldpeakhCalculation));
		System.out.println("================================================");
		
		//////////////////////////////////////////////
		
		double chiSmokingpastpositive=Math.pow(2,SmokingPastpositive-SMOKINGPASTPOSITIVE)/SMOKINGPASTPOSITIVE;
		System.out.println("chiSmokingpastpositive.................. "+chiSmokingpastpositive);
		
		double chiSmokingpastNegative=Math.pow(2,SmokingPastNegative-SMOKINGPASTNEGATIVE)/SMOKINGPASTNEGATIVE;
		System.out.println("chiSmokingpastNegative.................. "+chiSmokingpastNegative);
		
		double chiSmokingcurrentpositive=Math.pow(2,SmokingCurrentpositive-SMOKINGCURRENTPOSITIVE)/SMOKINGCURRENTPOSITIVE;
		System.out.println("chiSmokingcurrentkositive.................. "+chiSmokingcurrentpositive);
		
		double chiSmokingcurrentNegative=Math.pow(2,SmokingCurrentNegative-SMOKINGCURRENTNEGATIVE)/SMOKINGCURRENTNEGATIVE;
		System.out.println("chiSmokingcurrentNegative.................. "+chiSmokingcurrentNegative);
		
		double chiSmokingneverpositive=Math.pow(2,SmokingNeverpositive-SMOKINGNEVERPOSITIVE)/SMOKINGNEVERPOSITIVE;
		System.out.println("chiSmokingneverpositive.................. "+chiSmokingneverpositive);
		
		double chiSmokingneverNegative=Math.pow(2,SmokingNeverNegative-SMOKINGNEVERNEGATIVE)/SMOKINGNEVERNEGATIVE;
		System.out.println("chiSmokingneverNegative.................. "+chiSmokingneverNegative);
		
		double TotalSmokingCalculation=chiSmokingpastpositive+chiSmokingpastNegative+chiSmokingcurrentpositive+chiSmokingcurrentNegative+chiSmokingneverpositive+chiSmokingneverNegative;
		System.out.println("TotalSmokingCalculation.................. "+TotalSmokingCalculation);
		
		txtsmoking.setText(df.format(TotalSmokingCalculation));
		System.out.println("================================================");
		
		//////////////////////////////////////////////
		
		double chiObesityyespositive=Math.pow(2,Obesityyespositive-OBESITYYESPOSITIVE)/OBESITYYESPOSITIVE;
		System.out.println("chiObesityyespositive.................. "+chiObesityyespositive);
		
		double chiObesityyesNegative=Math.pow(2,ObesityyesNegative-OBESITYYESNEGATIVE)/OBESITYYESNEGATIVE;
		System.out.println("chiObesityyesNegative.................. "+chiObesityyesNegative);
		
		double chiObesitynopositive=Math.pow(2,Obesitynopositive-OBESITYNOTPOSITIVE)/OBESITYNOTPOSITIVE;
		System.out.println("chiObesitynopositive.................. "+chiObesitynopositive);
		
		double chiObesitynoNegative=Math.pow(2,ObesitynoNegative-OBESITYNONEGATIVE)/OBESITYNONEGATIVE;
		System.out.println("chiObesitynoNegative.................. "+chiObesitynoNegative);
		
		double TotalObesityCalculation=chiObesityyespositive+chiObesityyesNegative+chiObesitynopositive+chiObesitynoNegative;
		System.out.println("TotalObesityCalculation.................. "+TotalObesityCalculation);
		
		txtobesity.setText(df.format(TotalObesityCalculation));
		System.out.println("================================================");
		
		/////////////////////////////////////////////
		
		if(TotalAgeCalculation>TotalGenderCalculation&&TotalAgeCalculation>TotalChestCalculation&&TotalAgeCalculation>TotalFastingCalculation&&TotalAgeCalculation>TotalRestCalculation&&TotalAgeCalculation>TotalExangCalculation&&TotalAgeCalculation>TotalSlopCalculation&&TotalAgeCalculation>TotalThalCalculation&&TotalAgeCalculation>TotaltrestbloodCalculation&&TotalAgeCalculation>TotalSerumCalculation&&TotalAgeCalculation>TotalthalachCalculation&&TotalAgeCalculation>TotalOldpeakhCalculation&&TotalAgeCalculation>TotalSmokingCalculation&&TotalAgeCalculation>TotalObesityCalculation)
		{
			//getWindow().showNotification(,Notification.TYPE_HUMANIZED_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Age is the Best Class Level");
                        lblbestclass.setText(df.format(TotalAgeCalculation));
			lblBestclassName.setText("Age");
			
		}
		else if(TotalGenderCalculation>TotalAgeCalculation&&TotalGenderCalculation>TotalChestCalculation&&TotalGenderCalculation>TotalFastingCalculation&&TotalGenderCalculation>TotalRestCalculation&&TotalGenderCalculation>TotalExangCalculation&&TotalGenderCalculation>TotalSlopCalculation&&TotalGenderCalculation>TotalThalCalculation&&TotalGenderCalculation>TotaltrestbloodCalculation&&TotalGenderCalculation>TotalSerumCalculation&&TotalGenderCalculation>TotalthalachCalculation&&TotalGenderCalculation>TotalOldpeakhCalculation&&TotalGenderCalculation>TotalSmokingCalculation&&TotalGenderCalculation>TotalObesityCalculation)
		{
			//getWindow().showNotification("",Notification.TYPE_HUMANIZED_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Gender is the Best Class Level");
                        lblbestclass.setText(df.format(TotalGenderCalculation));
			lblBestclassName.setText("Gender");
			
		}
		else if(TotalChestCalculation>TotalAgeCalculation&&TotalChestCalculation>TotalGenderCalculation&&TotalChestCalculation>TotalFastingCalculation&&TotalChestCalculation>TotalRestCalculation&&TotalChestCalculation>TotalExangCalculation&&TotalChestCalculation>TotalSlopCalculation&&TotalChestCalculation>TotalThalCalculation&&TotalChestCalculation>TotaltrestbloodCalculation&&TotalChestCalculation>TotalSerumCalculation&&TotalChestCalculation>TotalthalachCalculation&&TotalChestCalculation>TotalOldpeakhCalculation&&TotalChestCalculation>TotalSmokingCalculation&&TotalChestCalculation>TotalObesityCalculation)
		{
			//getWindow().showNotification(,Notification.TYPE_HUMANIZED_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Chest Pain Type is the Best Class Level");
                        lblbestclass.setText(df.format(TotalChestCalculation));
			lblBestclassName.setText("Chest Pain Type");
			
		}
		else if(TotalFastingCalculation>TotalAgeCalculation&&TotalFastingCalculation>TotalGenderCalculation&&TotalFastingCalculation>TotalChestCalculation&&TotalFastingCalculation>TotalRestCalculation&&TotalFastingCalculation>TotalExangCalculation&&TotalFastingCalculation>TotalSlopCalculation&&TotalFastingCalculation>TotalThalCalculation&&TotalFastingCalculation>TotaltrestbloodCalculation&&TotalFastingCalculation>TotalSerumCalculation&&TotalFastingCalculation>TotalthalachCalculation&&TotalFastingCalculation>TotalOldpeakhCalculation&&TotalFastingCalculation>TotalSmokingCalculation&&TotalFastingCalculation>TotalObesityCalculation)
		{
			//getWindow().showNotification(,Notification.TYPE_HUMANIZED_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Fasting Blood Sugger is the Best Class Level");
                        lblbestclass.setText(df.format(TotalFastingCalculation));
			lblBestclassName.setText("Fasting Blood Sugger");
			
		}
		
		else if(TotalRestCalculation>TotalAgeCalculation&&TotalRestCalculation>TotalGenderCalculation&&TotalRestCalculation>TotalChestCalculation&&TotalRestCalculation>TotalFastingCalculation&&TotalRestCalculation>TotalExangCalculation&&TotalRestCalculation>TotalSlopCalculation&&TotalRestCalculation>TotalThalCalculation&&TotalRestCalculation>TotaltrestbloodCalculation&&TotalRestCalculation>TotalSerumCalculation&&TotalRestCalculation>TotalthalachCalculation&&TotalRestCalculation>TotalOldpeakhCalculation&&TotalRestCalculation>TotalSmokingCalculation&&TotalRestCalculation>TotalObesityCalculation)
		{
			//getWindow().showNotification(,Notification.TYPE_HUMANIZED_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Rest ECG is the Best Class Level");
                        lblbestclass.setText(df.format(TotalRestCalculation));
			lblBestclassName.setText("Rest ECG");
			
		}
		
		else if(TotalExangCalculation>TotalAgeCalculation&&TotalExangCalculation>TotalGenderCalculation&&TotalExangCalculation>TotalChestCalculation&&TotalExangCalculation>TotalFastingCalculation&&TotalExangCalculation>TotalRestCalculation&&TotalExangCalculation>TotalSlopCalculation&&TotalExangCalculation>TotalThalCalculation&&TotalExangCalculation>TotaltrestbloodCalculation&&TotalExangCalculation>TotalSerumCalculation&&TotalExangCalculation>TotalthalachCalculation&&TotalExangCalculation>TotalOldpeakhCalculation&&TotalExangCalculation>TotalSmokingCalculation&&TotalExangCalculation>TotalObesityCalculation)
		{
			//getWindow().showNotification(,Notification.TYPE_HUMANIZED_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Exang is the Best Class Level");
                        lblbestclass.setText(df.format(TotalExangCalculation));
			lblBestclassName.setText("Exang");
			
		}
		
		else if(TotalSlopCalculation>TotalAgeCalculation&&TotalSlopCalculation>TotalGenderCalculation&&TotalSlopCalculation>TotalChestCalculation&&TotalSlopCalculation>TotalFastingCalculation&&TotalSlopCalculation>TotalRestCalculation&&TotalSlopCalculation>TotalExangCalculation&&TotalSlopCalculation>TotalThalCalculation&&TotalSlopCalculation>TotaltrestbloodCalculation&&TotalSlopCalculation>TotalSerumCalculation&&TotalSlopCalculation>TotalthalachCalculation&&TotalSlopCalculation>TotalOldpeakhCalculation&&TotalSlopCalculation>TotalSmokingCalculation&&TotalSlopCalculation>TotalObesityCalculation)
		{
			//getWindow().showNotification(,Notification.TYPE_HUMANIZED_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Slop is the Best Class Level");
                        lblbestclass.setText(df.format(TotalSlopCalculation));
			lblBestclassName.setText("Slop");
			
		}
		
		else if(TotalThalCalculation>TotalAgeCalculation&&TotalThalCalculation>TotalGenderCalculation&&TotalThalCalculation>TotalChestCalculation&&TotalThalCalculation>TotalFastingCalculation&&TotalThalCalculation>TotalRestCalculation&&TotalThalCalculation>TotalExangCalculation&&TotalThalCalculation>TotalSlopCalculation&&TotalThalCalculation>TotaltrestbloodCalculation&&TotalThalCalculation>TotalSerumCalculation&&TotalThalCalculation>TotalthalachCalculation&&TotalThalCalculation>TotalOldpeakhCalculation&&TotalThalCalculation>TotalSmokingCalculation&&TotalThalCalculation>TotalObesityCalculation)
		{
			//getWindow().showNotification(,Notification.TYPE_HUMANIZED_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Thal is the Best Class Level");
                        lblbestclass.setText(df.format(TotalThalCalculation));
			lblBestclassName.setText("Thal");
			
		}
		
		else if(TotaltrestbloodCalculation>TotalAgeCalculation&&TotaltrestbloodCalculation>TotalGenderCalculation&&TotaltrestbloodCalculation>TotalChestCalculation&&TotaltrestbloodCalculation>TotalFastingCalculation&&TotaltrestbloodCalculation>TotalRestCalculation&&TotaltrestbloodCalculation>TotalExangCalculation&&TotaltrestbloodCalculation>TotalSlopCalculation&&TotaltrestbloodCalculation>TotalThalCalculation&&TotaltrestbloodCalculation>TotalSerumCalculation&&TotaltrestbloodCalculation>TotalthalachCalculation&&TotaltrestbloodCalculation>TotalOldpeakhCalculation&&TotaltrestbloodCalculation>TotalSmokingCalculation&&TotaltrestbloodCalculation>TotalObesityCalculation)
		{
			//getWindow().showNotification(,Notification.TYPE_HUMANIZED_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Trest Blood Pressure is the Best Class Level");
                        lblbestclass.setText(df.format(TotaltrestbloodCalculation));
			lblBestclassName.setText("Trest Blood Pressure");
			
		}
		
		else if(TotalSerumCalculation>TotalAgeCalculation&&TotalSerumCalculation>TotalGenderCalculation&&TotalSerumCalculation>TotalChestCalculation&&TotalSerumCalculation>TotalFastingCalculation&&TotalSerumCalculation>TotalRestCalculation&&TotalSerumCalculation>TotalExangCalculation&&TotalSerumCalculation>TotalSlopCalculation&&TotalSerumCalculation>TotalThalCalculation&&TotalSerumCalculation>TotaltrestbloodCalculation&&TotalSerumCalculation>TotalthalachCalculation&&TotalSerumCalculation>TotalOldpeakhCalculation&&TotalSerumCalculation>TotalSmokingCalculation&&TotalSerumCalculation>TotalObesityCalculation)
		{
			//getWindow().showNotification(,Notification.TYPE_HUMANIZED_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Serum Cholesterol is the Best Class Level");
                        lblbestclass.setText(df.format(TotalSerumCalculation));
			lblBestclassName.setText("Serum Cholesterol");
			
		}
		
		else if(TotalthalachCalculation>TotalAgeCalculation&&TotalthalachCalculation>TotalGenderCalculation&&TotalthalachCalculation>TotalChestCalculation&&TotalthalachCalculation>TotalFastingCalculation&&TotalthalachCalculation>TotalRestCalculation&&TotalthalachCalculation>TotalExangCalculation&&TotalthalachCalculation>TotalSlopCalculation&&TotalthalachCalculation>TotalThalCalculation&&TotalthalachCalculation>TotaltrestbloodCalculation&&TotalthalachCalculation>TotalSerumCalculation&&TotalthalachCalculation>TotalOldpeakhCalculation&&TotalthalachCalculation>TotalSmokingCalculation&&TotalthalachCalculation>TotalObesityCalculation)
		{
			//getWindow().showNotification(,Notification.TYPE_HUMANIZED_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Thalach is the Best Class Level");
                        lblbestclass.setText(df.format(TotalthalachCalculation));
			lblBestclassName.setText("Thalach");
			
		}
		else if(TotalOldpeakhCalculation>TotalAgeCalculation&&TotalOldpeakhCalculation>TotalGenderCalculation&&TotalOldpeakhCalculation>TotalChestCalculation&&TotalOldpeakhCalculation>TotalFastingCalculation&&TotalOldpeakhCalculation>TotalRestCalculation&&TotalOldpeakhCalculation>TotalExangCalculation&&TotalOldpeakhCalculation>TotalSlopCalculation&&TotalOldpeakhCalculation>TotalThalCalculation&&TotalOldpeakhCalculation>TotaltrestbloodCalculation&&TotalOldpeakhCalculation>TotalSerumCalculation&&TotalOldpeakhCalculation>TotalthalachCalculation&&TotalOldpeakhCalculation>TotalSmokingCalculation&&TotalOldpeakhCalculation>TotalObesityCalculation)
		{
			//getWindow().showNotification(,Notification.TYPE_HUMANIZED_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Old Peak is the Best Class Level");
                        lblbestclass.setText(df.format(TotalOldpeakhCalculation));
			lblBestclassName.setText("Old peak");
			
		}
		else if(TotalSmokingCalculation>TotalAgeCalculation&&TotalSmokingCalculation>TotalGenderCalculation&&TotalSmokingCalculation>TotalChestCalculation&&TotalSmokingCalculation>TotalFastingCalculation&&TotalSmokingCalculation>TotalRestCalculation&&TotalSmokingCalculation>TotalExangCalculation&&TotalSmokingCalculation>TotalSlopCalculation&&TotalSmokingCalculation>TotalThalCalculation&&TotalSmokingCalculation>TotaltrestbloodCalculation&&TotalSmokingCalculation>TotalSerumCalculation&&TotalSmokingCalculation>TotalthalachCalculation&&TotalSmokingCalculation>TotalOldpeakhCalculation&&TotalSmokingCalculation>TotalObesityCalculation)
		{
			//getWindow().showNotification("Smoking is the Best Class Level",Notification.TYPE_HUMANIZED_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Smoking is the Best Class Level");
                        lblbestclass.setText(df.format(TotalSmokingCalculation));
			lblBestclassName.setText("Smoking");
			
		}
		else 
		{
			//JOptionPane.showMessageDialog(null, "Obesity is the Best Class Level");
			lblbestclass.setText(df.format(TotalObesityCalculation));
			lblBestclassName.setText("Obesity");
			
		}
		
		
	}
        /*public static void main(String[] args) {
        new Chi_Square();
    }*/
        

}
