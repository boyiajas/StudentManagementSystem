
package finalprojrct;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class StudentRegister extends javax.swing.JFrame {
    
    Connection con = null;
    PreparedStatement pst1, pst2 = null;
    Statement st = null;
    ResultSet rs = null;
    String url = "jdbc:mysql://localhost:3306/studentmanagement_db";
    String user = "root";
    String pass = "";
    
    public StudentRegister(){
        
    }
    public StudentRegister(String staffName) {
        
        //System.out.println(staffName + " staff name");
        
       
        initComponents();
        moduleFillData();
        this.setSize(780,600);
        jLabel3.setText(staffName);
        
        
        jComboBox1.addActionListener(new ActionListener(){
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                JComboBox comboBox = (JComboBox) evt.getSource();
                String selectedProgramme = comboBox.getSelectedItem().toString();
               //here we getting the only the id for the module selected
                int ModuleID = Integer.parseInt(stringSeperator(selectedProgramme)[0]);  // System.out.println(ModuleID);
                
                //here we clear the Jtable first before populating it
                
                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                model.setRowCount(0);
                try{
                    //here we going to connect to the database and search for student offerring the module selected using the module id
                     Class.forName("com.mysql.jdbc.Driver");
                    //System.out.println(selectedProgramme);
                    //get connection
                    con = DriverManager.getConnection(url,user,pass);
                    //create statement
                    char active = 'A';
                    //here we are selecting the student id
                    Statement st = con.createStatement();
                    Statement st2 = con.createStatement();
                    String query4 = "Select StudentID from module_reg_tb where ModuleID = '"+ModuleID+"' and Status = '"+active+"'";
                    ResultSet rs = st.executeQuery(query4);
                    int StudentNo = 0;
                    StudentTable StudentTableData;
                     ArrayList<StudentTable>  usersList = new ArrayList<>();
                    String Signed = "";
                    
                    while(rs.next()){ //this loops runs through each student to get there information 
                        //here we get all the student offering the selected module from the combobox
                        StudentNo = rs.getInt("StudentID"); System.out.println(StudentNo);
                        //here we want to use the student no to get the student full information from the studnet_tb
                        String query5 = "Select * from student_tb where StudentID = '"+StudentNo+"'";
                        ResultSet rs2 = st2.executeQuery(query5);
                        
                        //String Query8 = "select * from courses_tb where Progrmme";
                        //String Programme = rs.getString("Programme");
                        //jLabel7.getText();

                        if(rs2.next()){
                            //here we going to populate a table the the student information
                           System.out.println(rs2.getString("Firstname"));
                           StudentTableData = new StudentTable(rs2.getString("Firstname"),rs2.getString("Lastname"),rs2.getString("DOB"),rs2.getString("Gender"),rs2.getString("ID_NO"),Signed,rs2.getInt("StudentID"),rs2.getInt("StudentCell"),rs2.getInt("ParentCell"));
                           usersList.add(StudentTableData);
                        }
                    }
                    
                    ArrayList<StudentTable> list = usersList;
                    
                    Object[] row = new Object [8];
                    for(int i= 0;i<list.size();i++){

                        row[0]=list.get(i).getStudentID();
                        row[1]=list.get(i).getFirstName();
                        row[2]=list.get(i).getLastName();
                        row[3]=list.get(i).getID_NO();
                        row[4]=list.get(i).getSigned();
                        //row[5]=list.get(i).getStudentCell();
                        //row[6]=list.get(i).getParentCell();
                        //row[7]=list.get(i).getModule();


                         model.addRow(row);

                    }
                    
                }catch(Exception e){
                    System.err.println(e);
                }

            }
        });
        
      
    }
    
    
     public void moduleFillData()
    {
    
         
        try{
           
            int StaffID = 8;
            String StaffType = "N";
           Class.forName("com.mysql.jdbc.Driver");
           String selectQuery = null;
           if(StaffType.compareTo("N") == 0){
               //query
                selectQuery = "select  * from modules_tb where StaffID = '"+StaffID+"'";
           }else{
               //query
                selectQuery = "select  * from modules_tb";
           }
          //here we are selecting the Module name
          
          //get connection
          Connection con = DriverManager.getConnection(url,user,pass);
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(selectQuery);

           while(rs.next()){
           //jComboBox1.addItem(rs.getString("ModuleName")); 
           jComboBox1.addItem(rs.getInt("ModuleID")+"_"+rs.getString("ModuleName")+"_"+rs.getString("ModuleCode")); 
                //jComboBox1.addItem(rs.getInt("ModuleID"));
           }
        }catch(Exception e){

        }
}

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        StudentTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(780, 500));
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student No", "Firstname", "Lastname", "ID Number", "Signature"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(57, 197, 516, 130);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(182, 166, 190, 22);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Select a Module");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(57, 166, 107, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Staff Name: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(63, 91, 96, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Login Time: ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(63, 142, 84, 17);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("16:00");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(157, 142, 41, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Date");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(63, 114, 51, 17);

        jLabel3.setText("jLabel3");

        jButton1.setText("Student Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Number of Students");

        StudentTotal.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel4)
                        .addGap(42, 42, 42)
                        .addComponent(StudentTotal)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(StudentTotal))
                .addGap(54, 54, 54))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 20, 630, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        System.out.println(jComboBox1.getSelectedItem().toString());
        //System.exit(0);
        
        try{
            
             //here we want to get the module lecture number
             
              //here we need to get the module id
              int ModuleID = Integer.parseInt(stringSeperator(jComboBox1.getSelectedItem().toString())[0]);  // System.out.println(ModuleID);
            con = DriverManager.getConnection(url,user,pass);
             Class.forName("com.mysql.jdbc.Driver");
             //here we are selecting the student id
             Statement st = con.createStatement();
              //get connection
              
            String sql = "select MAX(LectureNo) from  class_register_tb where ModuleID =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,ModuleID);
            ResultSet rs = pst.executeQuery();
            int lectureNo = 0;
           // System.out.println(rs);
            if(rs.next()){
                lectureNo = rs.getInt(1);
            }
            final int LecNo = lectureNo;
            this.setVisible(false);
                
            
              java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                         StudentSignForm Info = new StudentSignForm(jComboBox1.getSelectedItem().toString(), LecNo);
                          Info.setVisible(true);
                    }
                });
            
            }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

   /* 
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentRegister().setVisible(true);
            }
        });
    }
 */
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
    private javax.swing.JLabel StudentTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
