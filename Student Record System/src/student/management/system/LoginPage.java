package student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener{
    JTextField userfield, passfield;
    LoginPage(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel user = new JLabel("User Name");
        user.setBounds(40,40,100,30);
        user.setFont(new Font("serif",Font.BOLD,20));
        add(user);

        userfield= new JTextField();
        userfield.setBounds(150,40,150,30);
        add(userfield);

        JLabel password = new JLabel("Password");
        password.setBounds(40,120,100,30);
        password.setFont(new Font("serif",Font.BOLD,20));
        add(password);

        passfield= new JTextField();
        passfield.setBounds(150,120,150,30);
        add(passfield);

        JButton login=new JButton("LOGIN");
        login.setBounds(170,180,100,30);
        login.setBackground(Color.GREEN);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2= i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);



        setSize(600,300);
        setLocation(350,200);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){

        try{
            String username = userfield.getText();
            String password = passfield.getText();
            JdbcConn c= new JdbcConn();
            String query ="select * from login where username='"+username+"' and password='"+password+"'";

            ResultSet rs=c.s.executeQuery(query);

            if(rs.next()){
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                //setVisible(false);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        new LoginPage();
    }
}
