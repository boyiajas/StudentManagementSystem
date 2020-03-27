
package finalprojrct;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.fazecast.jSerialComm.*;
import com.sun.prism.paint.Color;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class student_registration extends javax.swing.JFrame {
    
    Connection con = null;
    PreparedStatement pst1, pst2 = null;
    Statement st = null;
    ResultSet rs = null;
    String url = "jdbc:mysql://localhost:3306/studentmanagement_db";
    String user = "root";
    String pass = "";
    int comPortNumber = 0;
    Thread t2 = null;
    int doneEnroll = 0;
    int doneVerify = 0;
    int returnVerifyId = 0;
     String input_todo = null;
     
    public student_registration() {
        initComponents();
        moduleFillData();
        cmbCourse.addActionListener(new ActionListener(){
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                JComboBox comboBox = (JComboBox) evt.getSource();
                String selectedProgramme = comboBox.getSelectedItem().toString();
                list1.clear();
                try{
                     Class.forName("com.mysql.jdbc.Driver");
                    //System.out.println(selectedProgramme);
                    //get connection
                    con = DriverManager.getConnection(url,user,pass);
                    //create statement
                    //here we are selecting the student id
                    Statement st = con.createStatement();
                    String query4 = "Select * from courses_tb where Programme = '"+selectedProgramme+"'";
                    ResultSet rs = st.executeQuery(query4);
                  
                    int CourseID = 0;
                    if(rs.next()){
                         CourseID = rs.getInt("CourseID");
                    }
                    System.out.println("CourseID is "+CourseID);
                    String selectQuery = "select * from modules_tb where CourseID =" + CourseID;
                    ResultSet rs2 = st.executeQuery(selectQuery);

                    while(rs2.next()){
                        list1.add(rs2.getInt("ModuleID")+"_"+rs2.getString("ModuleName")+"_"+rs2.getString("ModuleCode"));     
                    }
                    
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null, e);
                }
            }
        });
        
        list1.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
               //JOptionPane.showMessageDialog(null, list1.getSelectedItem());
                list2.add(list1.getSelectedItem());
            }
        });
        
        list2.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
               //JOptionPane.showMessageDialog(null, list1.getSelectedItem());
                list2.remove(list2.getSelectedItem());
            }
        });
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        sCell = new javax.swing.JTextField();
        dob = new javax.swing.JTextField();
        pCell = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        studentID_label = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbCourse = new javax.swing.JComboBox();
        cmbGender = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        ID_NO = new javax.swing.JTextField();
        list1 = new java.awt.List();
        list2 = new java.awt.List();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmbYear = new javax.swing.JComboBox();
        btnsearch = new javax.swing.JButton();
        SearchData = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "STUDENT REGISTRATION FORM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 18))); // NOI18N

        jLabel1.setText("FirstName");

        jLabel2.setText("LastName");

        jLabel3.setText("Date Of Birth");

        jLabel4.setText("Gender");

        jLabel5.setText("StudentCell");

        jLabel6.setText("ParentCell");

        sCell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sCellActionPerformed(evt);
            }
        });
        sCell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sCellKeyReleased(evt);
            }
        });

        pCell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCellActionPerformed(evt);
            }
        });
        pCell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pCellKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("CLEAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("ENROLL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("RESET");

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("CONFIRM");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setText("Verify Finger");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Student ID: ");

        studentID_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        studentID_label.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(studentID_label))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(studentID_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jLabel7.setText("Programme");

        cmbCourse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCourseItemStateChanged(evt);
            }
        });

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        cmbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGenderActionPerformed(evt);
            }
        });

        jLabel9.setText("ID Number");

        ID_NO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_NOActionPerformed(evt);
            }
        });
        ID_NO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ID_NOKeyReleased(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setText("ADD ALL MODULES");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton9.setText("REMOVE ALL MODULES");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel8.setText("Year");

        cmbYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2018", "2019" }));

        btnsearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnsearch.setText("SEARCH");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(75, 75, 75)
                        .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(16, 16, 16)))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pCell, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(sCell, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(cmbYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbCourse, 0, 252, Short.MAX_VALUE)
                            .addComponent(ID_NO)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(SearchData, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9))
                        .addComponent(list2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(sCell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton9)
                                            .addComponent(pCell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(ID_NO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cmbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SearchData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnsearch))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)))
                            .addComponent(list2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //this is the submit button
        
        try{
          //string query session
          String query1 = "INSERT INTO student_tb (`Firstname`,`Lastname`,`DOB`,`Gender`,`StudentCell`,`ParentCell`, `ID_NO`) VALUES (?,?,?,?,?,?,?)";
          String query2 = "INSERT INTO course_reg_tb (`StudentID`,`CourseID`,`Status`,`Year`) VALUES (?,?,?,?)";
          String query3 = "Select * from student_tb where `ID_NO` = '"+ID_NO.getText()+"'";
          String query4 = "Select * from courses_tb where `Programme` = '"+cmbCourse.getSelectedItem().toString()+"'";
          String query5 = "Select * from student_tb where ID_NO = '"+ID_NO.getText()+"'";
          String query6 = null;
          String query7 = null;
          String query8 = null;
          
          String url = "jdbc:mysql://localhost:3306/studentmanagement_db";
          String user = "root";
          String pass = "";
          Class.forName("com.mysql.jdbc.Driver");
           //here we are selecting the student id
          Statement st = con.createStatement();
           //get connection
          con = DriverManager.getConnection(url,user,pass);
          //check if the student is already in the database
          rs = st.executeQuery(query5);
          String ID_Number = null;
          int StudentNo = 0;
          if(rs.next()){
               ID_Number = rs.getString("ID_NO");
               StudentNo = rs.getInt("StudentID");
               studentID_label.setText(String.valueOf(StudentNo));
          }
          int RegYear = Integer.parseInt(cmbYear.getSelectedItem().toString());
          int PreviousYear = RegYear - 1; //here we are getting the previous year
          
          if(ID_Number != null){
              try{                  
                //if student is already in the database go ahead and update the modules only
                  //first all the previous modules to in-active
                  query6 = "Update module_reg_tb SET Status = 'I' where StudentID = '"+StudentNo+"' and Year = '"+PreviousYear+"'";
                   st.executeUpdate(query6);
                   Statement st1 = con.createStatement();
                    String active = "A";
                   //loop through each modules and update the module_reg_tb table
                  for(int numOfModules = 0; numOfModules < list2.getItemCount(); numOfModules++){
                    //second update the new modules and set them to active
                    //here we want to get the module id
                     // System.out.println(list2.getItemCount());
                     // System.out.println(list2.getItem(numOfModules));
                      //System.out.println("value in index "+stringSeperator(list2.getItem(numOfModules))[0]);
                    int ModuleID = Integer.parseInt(stringSeperator(list2.getItem(numOfModules))[0]);  // System.out.println(ModuleID);
                    query8 = "INSERT into module_reg_tb (`StudentID`,`ModuleID`,`Marks`,`Year`,`Status`) values"
                            + " ('"+StudentNo+"','"+ModuleID+"','0','"+RegYear+"','"+active+"')";
                     st1.executeUpdate(query8);
                    
                  }
                   //here we need to update the course table as well 
                   //here we are slelect the course id
                    rs = st.executeQuery(query4);
                   int CourseID = 0;
                   if(rs.next()){
                        CourseID = rs.getInt("CourseID");
                   }
                  //`````````````````````````` st.close();
                   RegYear = Integer.parseInt(cmbYear.getSelectedItem().toString());
                   active = "A";
                   pst2 = con.prepareStatement(query2);
                   pst2.setInt(1, StudentNo);
                   pst2.setInt(2,CourseID);
                   pst2.setString(3,active);
                   pst2.setInt(4, RegYear);
                   pst2.executeUpdate();
          
                  
                   JOptionPane.showMessageDialog(null, "Inserted successfully");
                   
              }catch(Exception e){
                  JOptionPane.showMessageDialog(null, "Failed to update student module \n"+e);
              }
              
          }else{
               //if student is not found in the database do this
          
          //execute Query
          
          pst1 = con.prepareStatement(query1);
          pst1.setString(1, fname.getText());
          pst1.setString(2, lname.getText());
          pst1.setString(3, dob.getText());
          pst1.setString(4,cmbGender.getSelectedItem().toString());
          pst1.setString(5, sCell.getText());
          pst1.setString(6, pCell.getText());
          pst1.setString(7,ID_NO.getText());
          pst1.executeUpdate();
         
        
         
         
          rs = st.executeQuery(query3);
          StudentNo = 0;
          if(rs.next()){
               StudentNo = rs.getInt("StudentID");
          }
          //here we are slelect the course id
           rs = st.executeQuery(query4);
          int CourseID = 0;
          if(rs.next()){
               CourseID = rs.getInt("CourseID");
          }
         //`````````````````````````` st.close();
          RegYear = Integer.parseInt(cmbYear.getSelectedItem().toString());
          String active = "A";
          pst2 = con.prepareStatement(query2);
          pst2.setInt(1, StudentNo);
          pst2.setInt(2,CourseID);
          pst2.setString(3,active);
          pst2.setInt(4, RegYear);
          pst2.executeUpdate();
          
           
            //loop through each modules and update the module_reg_tb table
           for(int numOfModules = 0; numOfModules < list2.getItemCount(); numOfModules++){
             //second update the new modules and set them to active
             //here we want to get the module id
             int ModuleID = Integer.parseInt(stringSeperator(list2.getItem(numOfModules))[0]);
             query7 = "INSERT into module_reg_tb (`StudentID`,`ModuleID`,`Marks`,`Year`,`Status`) values"
                     + " ('"+StudentNo+"','"+ModuleID+"','0','"+RegYear+"','"+active+"')";
              st.executeUpdate(query7);
           }
        
           JOptionPane.showMessageDialog(null, "Inserted successfully");
        }
         
       }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
           
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pCellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pCellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pCellActionPerformed

    private void ID_NOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_NOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_NOActionPerformed

    private void cmbCourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCourseItemStateChanged
       
        //String selectedProgramme = evt.getItemSelectable().toString();
        //connect to the database a select the programme selected
        //list1.add(evt.getItemSelectable().toString());
    }//GEN-LAST:event_cmbCourseItemStateChanged

    private void cmbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGenderActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        for(int i= 0; i < list1.getItemCount(); i++){
             list2.add(list1.getItem(i));
        }
       
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        list2.removeAll();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
          
        try{
            
          con = DriverManager.getConnection(url,user,pass);
          Class.forName("com.mysql.jdbc.Driver");
          //here we are selecting the student id
          Statement st = con.createStatement();
           //get connection
         
         String sql = "select * from  student_tb where ID_NO =?";
         PreparedStatement pst = con.prepareStatement(sql);
         pst.setString(1,SearchData.getText());
         ResultSet rs = pst.executeQuery();
         
         if(rs.next()){
             String setid = rs.getString("ID_NO");
             ID_NO.setText(setid);
             fname.setText(rs.getString("FirstName"));
             lname.setText(rs.getString("LastName"));
             dob.setText(rs.getString("DOB"));
             cmbGender.setSelectedIndex((rs.getString("Gender").compareTo("Male") == 0)? 0 : 1);
           
             sCell.setText(rs.getString("StudentCell"));
             pCell.setText(rs.getString("ParentCell"));
             ID_NO.setText(rs.getString("ID_NO"));
             lname.setText(rs.getString("LastName"));
             this.studentID_label.setText(rs.getString("StudentID"));
            // String Programme = rs.getString("Programme");
             //cmbCourse.getSelectedItem().toString();
             //cmbYear.getSelectedItem().toString();
             

         }else{
             JOptionPane.showMessageDialog(null,"student not found!");
         }
   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
          
    }//GEN-LAST:event_btnsearchActionPerformed

    private void sCellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sCellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sCellActionPerformed

    private void sCellKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sCellKeyReleased
        String SCell = sCell.getText();
        //get length of string 
        
        int length =  SCell.length();
        char c = evt.getKeyChar();
        //check for 0 -9
        
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            //check for length not more than 10 digit
            if(length<10){
                
                //editable true
                sCell.setEditable(true);
                
            }else{
                      //not editable length more than 10 digit 
                      sCell.setEditable(false);
            }  
        }else
        {
            
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ){
                // than allow editable
                 sCell.setEditable(true);
                
        }else{
             
                sCell.setEditable(false);
            }       
        }    
    }//GEN-LAST:event_sCellKeyReleased

    private void pCellKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pCellKeyReleased
          String PCell = pCell.getText();
        //get length of string 
        
        int length =  
                PCell.length();
        char c = evt.getKeyChar();
        //check for 0 -9
        
        if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9'){
            //check for length not more than 10 digit
            if(length<10){
                
                //editable true
                pCell.setEditable(true);
                
            }else{
                      //not editable length more than 10 digit 
                      pCell.setEditable(false);
            }  
        }else
        {
            
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ){
                // than allow editable
                 pCell.setEditable(true);
                
        }else{
             
                pCell.setEditable(false);
                   
        }    
    }                                 

    }//GEN-LAST:event_pCellKeyReleased

    private void ID_NOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ID_NOKeyReleased
      
        
          
                                    
    }//GEN-LAST:event_ID_NOKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         
           
            
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       fname.setText("");
       lname.setText("");
       dob.setText("");
       sCell.setText("");
       pCell.setText("");
       ID_NO.setText("");
       SearchData.setText("");
       cmbGender.removeAll();
       cmbCourse.removeAll();
       list1.removeAll();
       list2.removeAll();
                   
          
         
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          this.hide();
        RegistrationForms frm = new  RegistrationForms();
        frm.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // this is the finger print enrollment button code
        //here we get the serial communication port id number
        comPortNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Input the Port Number"));
        final SerialPort comPort = SerialPort.getCommPort("COM"+comPortNumber);
        //here we a trying to initializing the port
        comPort.openPort();
       
        if(comPort.isOpen() == true) {
            
            Thread t5 = new Thread(){
                @Override
                public void run(){
                    
                    jPanel3.setBackground(java.awt.Color.white);
                        System.out.println("Port opened successfully: " + comPort.openPort());
                        comPort.setComPortParameters(9600,8,1,SerialPort.NO_PARITY);
                        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 4000, 0);

                          try{

                              if(studentID_label.getText().compareTo("0") == 0){
                                  JOptionPane.showMessageDialog(null, "Invalid Student Number");
                              }else{
                                  //method to read message from the serial comm port
                                  readMessageFromArduino(comPort); 

                                  input_todo = "1";
                                  char todo = input_todo.toCharArray()[0];
                                  //method to send message to the arduino using the serial comm port
                                  sendCharacterMessageToArduino(todo, comPort);

                                   //if input option is '1' do this
                                  if(todo == '1'){
                                      //method to read message from the serial comm port
                                       readMessageFromArduino(comPort); 

                                      //input_todo = input.next();
                                      //here we are going to connect to the database and get the student Id
                                      input_todo = studentID_label.getText(); ///this is where we get the student id which will be used to enroll the finger print

                                      todo = input_todo.toCharArray()[0];
                                      //method to send message to the arduino using the serial comm port
                                      sendCharacterMessageToArduino(todo, comPort);

                                       //displaying recieved message out
                                       //readMessageFromArduino(comPort);

                                        int count = 0;
                                          //method to read message from the serial comm port
                                          while(true){
                                              System.out.println(count++);
                                             t2 = new Thread(){

                                                  @Override
                                                  public void run(){
                                                      try {
              
                                                          readMessageFromArduino(comPort);
                                                          
                                                      } catch (Exception ex) {
                                                          Logger.getLogger(student_registration.class.getName()).log(Level.SEVERE, null, ex);
                                                      }
                                                  }
                                              };
                                              t2.start();
                                              //readMessageFromArduino(comPort);
                                              Thread.sleep(1000);
                                               //t2.stop();
                                              if(doneEnroll == 1){
                                                 // System.out.println("Here we need to break");
                                                  break;
                                              }
                                          }

                                  }
                              }
                          }catch(Exception e){
                               e.printStackTrace();
                          }



                              }
                     };
            
            t5.start();
            
        }else {
           //Update the status/console if the Arduino hasn't been connected.
            JOptionPane.showMessageDialog(null,"SORRY! FINGER PRINT READER IS NOT CONNECTED ON THIS PORT!");
            jPanel3.setBackground(java.awt.Color.RED);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        //this is the button to verify 
           //here we get the serial communication port id number
        comPortNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Input the Port Number"));
        final SerialPort comPort = SerialPort.getCommPort("COM"+comPortNumber);
        //here we a trying to initializing the port
        comPort.openPort();
       
        if(comPort.isOpen() == true) {
            
            Thread t5 = new Thread(){
                @Override
                public void run(){
                    
                    jPanel3.setBackground(java.awt.Color.white);
                        System.out.println("Port opened successfully: " + comPort.openPort());
                        comPort.setComPortParameters(9600,8,1,SerialPort.NO_PARITY);
                        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 4000, 0);

                          try{

                              
                                  //method to read message from the serial comm port
                                  readMessageFromArduino(comPort); 

                                  input_todo = "2";
                                  char todo = input_todo.toCharArray()[0];
                                  //method to send message to the arduino using the serial comm port
                                  sendCharacterMessageToArduino(todo, comPort);

                                   //if input option is '1' do this
                                  if(todo == '2'){
                                      //method to read message from the serial comm port
                                       readMessageFromArduino(comPort); 

                                      //input_todo = input.next();
                                      //here we are going to connect to the database and get the student Id
                                      input_todo = studentID_label.getText(); ///this is where we get the student id which will be used to enroll the finger print

                                      todo = input_todo.toCharArray()[0];
                                      //method to send message to the arduino using the serial comm port
                                      sendCharacterMessageToArduino(todo, comPort);

                                       //displaying recieved message out
                                       //readMessageFromArduino(comPort);

                                        int count = 0;
                                          //method to read message from the serial comm port
                                          while(true){
                                              //System.out.println(count++);
                                             t2 = new Thread(){

                                                  @Override
                                                  public void run(){
                                                      try {
              
                                                          readMessageFromArduino(comPort);
                                                          
                                                      } catch (Exception ex) {
                                                          Logger.getLogger(student_registration.class.getName()).log(Level.SEVERE, null, ex);
                                                      }
                                                  }
                                              };
                                              t2.start();
                                              //readMessageFromArduino(comPort);
                                              Thread.sleep(1000);
                                               //t2.stop();
                                              if(doneVerify == 1){
                                                 // System.out.println("Here we need to break");
                                                  break;
                                              }
                                          }

                                  }
                                  
                                  //here we want to connect to the database and search for student with the verify id
                                   con = DriverManager.getConnection(url,user,pass);
                                    Class.forName("com.mysql.jdbc.Driver");
                                    //here we are selecting the student id
                                    Statement st = con.createStatement();
                                     //get connection

                                   String sql = "select * from  student_tb where StudentID =?";
                                   PreparedStatement pst = con.prepareStatement(sql);
                                   pst.setInt(1,returnVerifyId);
                                   ResultSet rs = pst.executeQuery();

                                   if(rs.next()){
                                       String setid = rs.getString("ID_NO");
                                       ID_NO.setText(setid);
                                       fname.setText(rs.getString("FirstName"));
                                       lname.setText(rs.getString("LastName"));
                                       dob.setText(rs.getString("DOB"));
                                       cmbGender.setSelectedIndex((rs.getString("Gender").compareTo("Male") == 0)? 0 : 1);

                                       sCell.setText(rs.getString("StudentCell"));
                                       pCell.setText(rs.getString("ParentCell"));
                                       ID_NO.setText(rs.getString("ID_NO"));
                                       lname.setText(rs.getString("LastName"));
                                       studentID_label.setText(rs.getString("StudentID"));
                                 
                                      jPanel3.setBackground(java.awt.Color.GREEN);
                                  }else{
                                      jPanel3.setBackground(java.awt.Color.RED);
                                  }
                              
                          }catch(Exception e){
                               e.printStackTrace();
                          }

            
                    }

                };
                t5.start();
        
            }else {
       //Update the status/console if the Arduino hasn't been connected.
        JOptionPane.showMessageDialog(null,"SORRY! FINGER PRINT READER IS NOT CONNECTED ON THIS PORT!");
        jPanel3.setBackground(java.awt.Color.RED);
        }
      
            
    }//GEN-LAST:event_jButton10ActionPerformed
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new student_registration().setVisible(true);
            }
        });
    }
    
    
     public void moduleFillData()
    {
        try{
            String url = "jdbc:mysql://localhost:3306/studentmanagement_db";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            //get connection
            con = DriverManager.getConnection(url,user,pass);
            //create statement
            //here we are selecting the student id
            Statement st = con.createStatement();
            String selectQuery = "select * from courses_tb";
            ResultSet rs = st.executeQuery(selectQuery);
            
            while(rs.next()){
                cmbCourse.addItem(rs.getString("Programme"));    
            }
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
     
    private String[] stringSeperator(String para){
        String buffer = "";
        String stringArray[] = new String[para.length()];
        int slitCount = 0;
        for(int i = 0; i < para.length(); i++){
            if(para.charAt(i) != '_'){
                buffer += para.charAt(i);
            }else{
                stringArray[slitCount++] = buffer;
            }
            //System.out.println(stringArray[0]);
        }
        
        return stringArray;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID_NO;
    private javax.swing.JTextField SearchData;
    private javax.swing.JButton btnsearch;
    private javax.swing.JComboBox cmbCourse;
    private javax.swing.JComboBox cmbGender;
    private javax.swing.JComboBox cmbYear;
    private javax.swing.JTextField dob;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private java.awt.List list1;
    private java.awt.List list2;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField pCell;
    private javax.swing.JTextField sCell;
    private javax.swing.JLabel studentID_label;
    // End of variables declaration//GEN-END:variables

    /*@Override
    public void itemStateChanged(ItemEvent e) {
        
        //list1.add("testing 2");
        
    }*/


     public String readMessageFromArduino(SerialPort comPort) throws Exception {
         //displaying recieved message out
          
        while (true)
        {
           InputStream dataIn = comPort.getInputStream();

           while (comPort.bytesAvailable() == 0)
           Thread.sleep(100);

           byte[] readBuffer = new byte[1024];
           //int numRead = comPort.readBytes(readBuffer, readBuffer.length);
           //System.out.println("Read " + numRead + " bytes." + readBuffer.toString());
           String message = "";

           int len = dataIn.read(readBuffer);
           if (len > 0) {
               
               
               message = new String(readBuffer);
               System.out.println(message);
               if(searchStr(message,"sensor_notfound") == true){
                   JOptionPane.showMessageDialog(null, "Error - Finger Print Reader Not Connected");
               }else if(searchStr(message,"Done") == true) {
                   //JOptionPane.showMessageDialog(null, "Done");
                   Thread t3  = new Thread(){
                       
                    @Override
                        public void run(){
                            try {

                                jPanel3.setBackground(java.awt.Color.GREEN);
                                
                            } catch (Exception ex) {
                                Logger.getLogger(student_registration.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    };
                    t3.start();
                    
                    //doneVerify = 1;
                    //System.out.println(doneEnroll + " its done now");
                   //System.out.println("...........Program should be done now............");
                    break;//System.exit(0); //if match found exit
               }else if(searchStr(message,"Failed") == true){
                    this.jPanel3.setBackground(java.awt.Color.RED);
                   System.exit(0); //if match found exit
               }else if(input_todo == "2"){
                  
                    try{
                        returnVerifyId =  Integer.parseInt(message.trim().toString());
                       doneVerify = 1;
                       System.out.println("We getting the id only "+returnVerifyId);
                       break;
                    }catch(Exception e){
                        doneVerify = 1;
                        returnVerifyId = 0;
                        break;
                    }
               }
               break;
           }
           //comPort.addDataListener((SerialPortDataListener) this);
          
        }
        return null;
    }
     
    public void sendCharacterMessageToArduino(char cMsg, SerialPort comPort) throws Exception {
        Thread.sleep(100);
        comPort.getOutputStream();
        PrintWriter output = new PrintWriter(comPort.getOutputStream());  
        //char todo = '2';
        output.write(cMsg);
        output.flush();
    }
    
    public boolean searchStr(String search, String what) {
        if(!search.replaceAll(what,"_").equals(search)) {
            return true;
        }
        return false;
    }
}
