package student.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {
    Random ran= new Random();
    int no =ran.nextInt(999);

    JButton details, back;
    JComboBox<String> standard;
    JTextField tfname,tfaadhar,tffather,tfphone,tfaddress;
    JDateChooser date;
    JLabel number;

    AddStudent(){
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(180,20,400,40);
        heading.setFont(new Font("serif",Font.BOLD,25));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel name=new JLabel("Student Name");
        name.setBounds(50,100,200,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        name.setForeground(Color.BLACK);
        add(name);

        tfname= new JTextField();
        tfname.setBounds(250,100,200,30);
        add(tfname);

        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(50,140,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        dob.setForeground(Color.BLACK);
        add(dob);

        date= new JDateChooser();
        date.setBounds(250,140,200,30);
        add(date);

        JLabel edu=new JLabel("Class");
        edu.setBounds(50,180,200,30);
        edu.setFont(new Font("serif",Font.BOLD,20));
        edu.setForeground(Color.BLACK);
        add(edu);

        String classes[]={"1st Class","2nd Class","3rd Class","4th Class","5th Class","6th Class","7th Class","8th Class","9th Class","10th Class"};
        standard=new JComboBox<>(classes);
        standard.setBounds(250,180,200,30);
        add(standard);

        JLabel aadhar=new JLabel("Aadhar No");
        aadhar.setBounds(50,220,200,30);
        aadhar.setFont(new Font("serif",Font.BOLD,20));
        aadhar.setForeground(Color.BLACK);
        add(aadhar);

        tfaadhar= new JTextField();
        tfaadhar.setBounds(250,220,200,30);
        add(tfaadhar);

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

        JLabel id=new JLabel("Student ID");
        id.setBounds(50,380,200,30);
        id.setFont(new Font("serif",Font.BOLD,20));
        id.setForeground(Color.BLACK);
        add(id);

        number=new JLabel(""+no);
        number.setBounds(250,380,200,30);
        number.setFont(new Font("serif",Font.BOLD,20));
        number.setForeground(Color.BLACK);
        add(number);

        details = new JButton("Add Details");
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
            String name=tfname.getText();
            String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
            String education=(String)standard.getSelectedItem();
            String aadhar=tfaadhar.getText();
            String fname=tffather.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String id=number.getText();

            try{
                JdbcConn conn=new JdbcConn();
                String query="insert into student values('"+name+"','"+dob+"','"+education+"','"+aadhar+"','"+fname+"','"+address+"','"+phone+"','"+id+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New student details added successfully");
                setVisible(false);
                new Home();
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
        new AddStudent();
    }
}
