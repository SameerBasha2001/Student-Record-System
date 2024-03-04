package student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentPerformance extends JFrame implements ActionListener {
    String id;
    JLabel lblname,lblid;
    JTextField tfenglish, tfmaths, tfscience, tftotal;
    JButton submit,back;
    StudentPerformance(String id){
        this.id=id;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("Student Performance Details");
        heading.setBounds(80,50,400,30);
        heading.setFont(new Font("serif",Font.BOLD,30));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel stuid=new JLabel("Student ID");
        stuid.setBounds(50,100,150,30);
        stuid.setFont(new Font("serif",Font.BOLD,20));
        stuid.setForeground(Color.BLACK);
        add(stuid);

        lblid=new JLabel();
        lblid.setBounds(220,100,150,30);
        lblid.setFont(new Font("serif",Font.BOLD,20));
        lblid.setForeground(Color.BLACK);
        add(lblid);

        JLabel name=new JLabel("Student Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        name.setForeground(Color.BLACK);
        add(name);

        lblname= new JLabel();
        lblname.setBounds(220,150,150,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        lblname.setForeground(Color.BLACK);
        add(lblname);

        JLabel english=new JLabel("English Marks");
        english.setBounds(50,200,150,30);
        english.setFont(new Font("serif",Font.BOLD,20));
        english.setForeground(Color.BLACK);
        add(english);

        tfenglish = new JTextField();
        tfenglish.setBounds(220,200,150,30);
        add(tfenglish);

        JLabel maths=new JLabel("Maths Marks");
        maths.setBounds(50,250,150,30);
        maths.setFont(new Font("serif",Font.BOLD,20));
        maths.setForeground(Color.BLACK);
        add(maths);

        tfmaths = new JTextField();
        tfmaths.setBounds(220,250,150,30);
        add(tfmaths);

        JLabel science=new JLabel("Science Marks");
        science.setBounds(50,300,150,30);
        science.setFont(new Font("serif",Font.BOLD,20));
        science.setForeground(Color.BLACK);
        add(science);

        tfscience = new JTextField();
        tfscience.setBounds(220,300,150,30);
        add(tfscience);

        JLabel total=new JLabel("Total Marks");
        total.setBounds(50,350,150,30);
        total.setFont(new Font("serif",Font.BOLD,20));
        total.setForeground(Color.BLACK);
        add(total);

        tftotal = new JTextField();
        tftotal.setBounds(220,350,150,30);
        add(tftotal);

        try{
            JdbcConn conn = new JdbcConn();
            String query="select * from student where id='"+id+"'";
            ResultSet rs =conn.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblid.setText(rs.getString("id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        submit= new JButton("Submit");
        submit.setBounds(50,400,150,30);
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("serif",Font.PLAIN,15));
        submit.addActionListener(this);
        add(submit);

        back= new JButton("Back");
        back.setBounds(220,400,150,30);
        back.setBackground(Color.GREEN);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("serif",Font.PLAIN,15));
        back.addActionListener(this);
        add(back);

        setSize(600,500);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String id=lblid.getText();
            String stuname=lblname.getText();
            String english=tfenglish.getText();
            String maths=tfmaths.getText();
            String science=tfscience.getText();
            String total= tftotal.getText();

            try{
                JdbcConn conn = new JdbcConn();
                String query= "insert into performnace values('"+id+"','"+stuname+"',"+english+","+maths+","+science+","+total+")";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Performance added successfully");
                setVisible(false);
                new ViewStudents();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new ViewStudents();
        }
    }
    public static void main(String[] args) {
        new StudentPerformance("");
    }
}
