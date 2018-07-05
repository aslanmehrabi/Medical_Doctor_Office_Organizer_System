

// Medical_Doctor_Office_Organizer_System
// A Software to organize Booking system of a Medical Doctor (Physician) Office 
// Design and Implemented by Aslan Mehrabi




/*
 * timeForm.java
 *
 * Created on May 17, 2011, 1:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


package drform_mehrabi876090;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.xml.soap.Detail;

/**
 *
 * @author pc01
 */
public class DrForm extends JFrame implements ActionListener,ItemListener,KeyListener,ChangeListener {
        
        JPanel docPnl=new JPanel();
        JPanel basicInf=new JPanel();
        JPanel moreInf=new JPanel();
        JPanel buttons=new JPanel();
        JPanel adrsInf=new JPanel();
        JLabel fname =new JLabel("            First name");
        JLabel lname=new JLabel("            Last name");
        JLabel age=new JLabel("            age");
        JLabel natioanalNum=new JLabel("            Natioanal number");
        JLabel fatherName=new JLabel("            Father's name");
        JTextField txtFName=new JTextField(12);
        JTextField txtLName=new JTextField(12);
        JTextField txtAge=new JTextField(3);
        JTextField txtNtnlNum=new JTextField(16);
        JTextField txtFatherName=new JTextField(12);
        
        
        JFrame frmError=new JFrame("Error1");
        JLabel lblError=new JLabel("                       Please enter the Document number first!");
        JFrame frmErDn=new JFrame("Error2");
        JLabel lblErDN=new JLabel("                            This document number is not valid! ");
        
        
        JLabel address=new JLabel("    Address      ");
        JLabel phoneNum=new JLabel("     Phone number  ");
        JTextField txtAdrs=new JTextField(30);
        JTextField txtPhone=new JTextField(28);
        
        JLabel numChild=new JLabel("                 Number of Childs") ;
        JLabel gndr=new JLabel("  Gender");
     
                
        JLabel dNum=new JLabel("Document number   ");
        JTextField txtDN=new JTextField(5);
        
        JCheckBox chkM=new JCheckBox("Male",false);
        JCheckBox chkF=new JCheckBox("Female",true);
        JComboBox cmb=new JComboBox();
        JLabel detail=new JLabel("   More Details  ");
        
        JButton btnExit =new JButton("Exit");
        JButton btnSave=new JButton("Save");
        JButton btnLoad=new JButton("Load");
        
        
        JTextArea areaDetails=new JTextArea(10,10);
        
        JSlider slider=new JSlider(0,255,50);
        
        JPanel tmp=new JPanel();
        
    /** Creates a new instance of timeForm */
    public DrForm() {
        super("Pationt Register");
        setBounds(400,30,450,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane=getContentPane();
        
        docPnl.setSize(400,400);
        docPnl.setLayout(new FlowLayout(FlowLayout.LEFT,50,50));
        docPnl.add(dNum);
        docPnl.add(txtDN);
        //docPnl.setVisible(false);
 
        basicInf.setSize(400,300);
        //basicInf.setLayout(new FlowLayout(FlowLayout.LEFT,9,20));
        basicInf.setLayout(new GridLayout(6,2));
        basicInf.add(fname);
        basicInf.add(txtFName);
        basicInf.add(lname);
        basicInf.add(txtLName);
        basicInf.add(age);
        basicInf.add(txtAge);
        basicInf.add(natioanalNum);
        basicInf.add(txtNtnlNum);
        basicInf.add(fatherName);
        basicInf.add(txtFatherName);
        //basicInf.setVisible(true);
        
        //adrsInf.setLayout(new GridLayout(2,2));
        adrsInf.setLayout(new FlowLayout());
        adrsInf.setSize(400,300);
        adrsInf.add(address);
        adrsInf.add(txtAdrs);
        adrsInf.add(phoneNum);
        adrsInf.add(txtPhone);
        
        //pane.add(docPnl,BorderLayout.NORTH);
        //pane.add(basicInf,BorderLayout.NORTH);
        
        pane.setLayout(new GridLayout(5,2));
        pane.add(docPnl);
        pane.add(basicInf);
        
        cmb.addItem("0");
        cmb.addItem("1");
        cmb.addItem("2");
        cmb.addItem("3");
        cmb.addItem("more than 3");
        
        moreInf.setSize(400,300);
        //moreInf.setLayout(new GridLayout(2,1));
        moreInf.setLayout(new FlowLayout());
        
        moreInf.add(gndr);
        moreInf.add(chkM);
        moreInf.add(chkF);
        moreInf.add(numChild);
        moreInf.add(cmb);
        
        //JScrollPane sc=new JScrollPane(areaDetails,
          //      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //moreInf.add(sc);
        
        ButtonGroup Gender=new ButtonGroup();
        Gender.add(chkM);
        Gender.add(chkF);
        
        buttons.setSize(400,300);
        buttons.setLayout(new FlowLayout(FlowLayout.RIGHT,10,20));
        
        buttons.add(btnSave);
        buttons.add(btnLoad);
        buttons.add(btnExit);
        
        btnExit.addActionListener(this);
        txtFName.addActionListener(this);
        txtFName.addKeyListener(this);
        
        chkM.addItemListener(this);
        cmb.addItemListener(this);
        btnSave.addActionListener(this);
        btnLoad.addActionListener(this);
        
        
        tmp.setLayout(new BorderLayout());
        //tmp.setLayout(new FlowLayout());
       tmp.add(moreInf,BorderLayout.NORTH);
       tmp.add(detail,BorderLayout.WEST);
       tmp.add(areaDetails);
        
        
        pane.add(tmp,BorderLayout.CENTER);
        
        pane.add(adrsInf);
        //JTextArea areaDetails=new JTextArea(4,20);
        
        //pane.add(areaDetails,BorderLayout.CENTER);
        pane.add(buttons);
        //pane.add(buttons,BorderLayout.SOUTH);
        
        
        
        setContentPane(pane);
        
        setVisible(true);
        frmError.setBounds(430,200,400,200);
        frmError.add(lblError);
        //frmError.setVisible(true);
        
        //frmErDn.setLayout(new FlowLayout());
        frmErDn.setBounds(430,200,400,200);
        frmErDn.add(lblErDN);
       // frmErDn.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnExit){
            /*
            if(txtFName.getText().equals(""))
                System.out.println("khali");
            else{
                System.out.println(txtFName.getText());
                System.out.println(txtLName.getText());
                System.out.println(txtFatherName.getText());
                System.out.println("jabe: "+areaDetails.getText());
                System.out.println("adrs: "+txtAdrs.getText());
                System.out.println("bache: "+ cmb.getSelectedItem());
            }
            */
            this.dispose();
        }                                                           
        else if(e.getSource()==btnSave){
            if(txtDN.getText().equals("")){
                System.out.println("frmError");
                frmError.setVisible(true);
                return;
            }
            else{
                try{
                    PrintWriter print=new PrintWriter(new File("pationt"+txtDN.getText()));
                    if(txtFName.getText().equals(""))
                        print.print("NotEntered\n");
                    else 
                        print.print(txtFName.getText()+"\n");
                    if(txtLName.getText().equals(""))
                        print.print("NotEntered\n");
                    else
                        print.print(txtLName.getText()+"\n");
                    if(txtAge.getText().equals(""))
                        print.print("NotEntered\n");
                    else
                        print.print(txtAge.getText()+"\n");
                    if(txtNtnlNum.getText().equals(""))
                        print.print("NotEntered\n");
                    else
                        print.print(txtNtnlNum.getText()+"\n");
                    if(txtFatherName.getText().equals(""))
                        print.print("NotEntered\n");
                    else
                        print.print(txtFatherName.getText()+"\n");//ta inja 5taye aval
                    
                    
                    
                    if(chkM.isSelected())
                        print.print("1\n");
                    else
                        print.print("0\n");//age zan bashe
                    
                    print.print(cmb.getSelectedIndex()+"\n"); //ye adad beine 1 ta 4
                    
                    
                    
                    if(txtAdrs.getText().equals(""))
                        print.print("NotEntered\n");
                    else
                        print.print(txtAdrs.getText()+"\n");
                    
                    if(txtPhone.getText().equals(""))
                        print.print("NotEntered\n");
                    else
                        print.print(txtPhone.getText()+"\n");
                    
                    if(areaDetails.getText().equals(""))//age enter dashte bashe baghie hazf.
                        print.print("NotEntered\n");
                    else
                        print.print(areaDetails.getText()+"\n");
                    
                    //chkM.setSelected()
                    
                    print.close();
                
                }
                catch(Exception ex){
                    System.out.println("Error: can not make the file!");
                    
                }
            }
        }
        else if(e.getSource()==btnLoad){
            if(txtDN.getText().equals("")){
                frmError.setVisible(true);
                return;
            }
            else{
                try{
                    Scanner sc=new Scanner(new File("pationt"+txtDN.getText()));     
                    //txtFName.setText(sc.next());
                    txtFName.setText(sc.nextLine());
                    txtLName.setText(sc.nextLine());
                    txtAge.setText(sc.nextLine());
                    txtNtnlNum.setText(sc.nextLine());
                    txtFatherName.setText(sc.nextLine());
                    if(sc.nextInt()==1)
                        chkM.setSelected(true);
                    else
                        chkF.setSelected(true);
                    cmb.setSelectedIndex(sc.nextInt());
                    sc.nextLine();
                    txtAdrs.setText(sc.nextLine());
                    txtPhone.setText(sc.nextLine());
                    areaDetails.setText(sc.nextLine());
                    
                }
                catch(Exception ex){
                    System.out.println("File not found!");
                    frmErDn.setVisible(true);///////@@@@@@  document not valid
                }
            }
        }
    }

    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==chkM)
        {
        if(e.getStateChange()==ItemEvent.SELECTED)
            cmb.setEnabled(false);
        else
            cmb.setEnabled(true);
        }
        else
        {
            
        }
        
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void stateChanged(ChangeEvent e) {
    }
    
}
