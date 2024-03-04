package student.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class UpdateStudent extends JFrame implements ActionListener {
    JButton details, back;
    JTextField tfeducation,tffather,tfphone,tfaddress;
    String id;

    UpdateStudent(String id){

        this.id=id;
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(180,20,400,40);
        heading.setFont(new Font("serif",Font.BOLD,25));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel name=new JLabel("Student Name");
        name.setBounds(50,100,200,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        name.setForeground(Color.BLACK);
        add(name);

        JLabel lblname= new JLabel();
        lblname.setBounds(250,100,200,30);
        add(lblname);

        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(50,140,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        dob.setForeground(Color.BLACK);
        add(dob);

        JLabel lbldob= new JLabel();
        lbldob.setBounds(250,140,200,30);
        add(lbldob);

        JLabel edu=new JLabel("Class");
        edu.setBounds(50,180,200,30);
        edu.setFont(new Font("serif",Font.BOLD,20));
        edu.setForeground(Color.BLACK);
        add(edu);

        tfeducation= new JTextField();
        tfeducation.setBounds(250,180,200,30);
        add(tfeducation);

        JLabel aadhar=new JLabel("Aadhar No");
        aadhar.setBounds(50,220,200,30);
        aadhar.setFont(new Font("serif",Font.BOLD,20));
        aadhar.setForeground(Color.BLACK);
        add(aadhar);

        JLabel lblaadhar= new JLabel();
        lblaadhar.setBounds(250,220,200,30);
        add(lblaadhar);

        JLabel father=new JLabel("Father Name");
        father.setBounds(50,260,200,30);
        father.setFont(new Font("serif",Font.BOLD,20));
        father.setForeground(Color.BLACK);
        add(father);

        tffather= new JTextField();
        tffather.setBounds(250,260,200,30);
        add(tffather);

        JLabel address=new JLabel("Address");
        address.setBounds(50,300,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        address.setForeground(Color.BLACK);
        add(address);

        tfaddress= new JTextField();
        tfaddress.setBounds(250,300,200,30);
        add(tfaddress);

        JLabel phone=new JLabel("Mobile No");
        phone.setBounds(50,340,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        phone.setForeground(Color.BLACK);
        add(phone);

        tfphone= new JTextField();
        tfphone.setBounds(250,340,200,30);
        add(tfphone);

        JLabel stuid=new JLabel("Student ID");
        stuid.setBounds(50,380,200,30);
        stuid.setFont(new Font("serif",Font.BOLD,20));
        stuid.setForeground(Color.BLACK);
        add(stuid);

        JLabel lblid=new JLabel();
        lblid.setBounds(250,380,200,30);
        lblid.setFont(new Font("serif",Font.BOLD,20));
        lblid.setForeground(Color.BLACK);
        add(lblid);

        try{
            JdbcConn conn = new JdbcConn();
            String query= "select * from student where id='"+id+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lbldob.setText(rs.getString("dob"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                tffather.setText(rs.getString("fname"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                lblid.setText(rs.getString("id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        details = new JButton("Update Details");
        details.setBounds(50,420,150,30);
        details.setFont(new Font("serif",Font.PLAIN,15));
        details.setBackground(Color.GREEN);
        details.setForeground(Color.BLACK);
        details.addActionListener(this);
        add(details);

        back = new JButton("Back");
        back.setBounds(230,420,150,30);
        back.setFont(new Font("serif",Font.PLAIN,15));
        back.setBackground(Color.GREEN);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);



        setSize(600,530);
        setLocation(300,100);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==details){
            String education=(String)tfeducation.getText();
            String fname=tffather.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            try{
                JdbcConn conn=new JdbcConn();
                String query="update student set education='"+education+"',fname='"+fname+"',address='"+address+"',phone='"+phone+"' where id='"+id+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "student details updated successfully");
                setVisible(false);
                new ViewStudents();
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Home();
        }

    }

    public static void main(String[] args) {
        new UpdateStudent("");
    }
}
