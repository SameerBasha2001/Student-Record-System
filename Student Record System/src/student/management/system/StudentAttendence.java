package student.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentAttendence extends JFrame implements ActionListener {
    JDateChooser date;
    JComboBox<String> cstatus;
    JButton submit, back;
    JLabel lblname,lblid;
    String id;
    StudentAttendence(String id){
        this.id=id;
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("Attendance Details");
        heading.setBounds(130,50,300,30);
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

        JLabel dob=new JLabel("Date");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        dob.setForeground(Color.BLACK);
        add(dob);

        date= new JDateChooser();
        date.setBounds(220,200,150,30);
        add(date);

        JLabel staus=new JLabel("Status");
        staus.setBounds(50,250,150,30);
        staus.setFont(new Font("serif",Font.BOLD,20));
        staus.setForeground(Color.BLACK);
        add(staus);

        String sam[]={"Present","Absent"};
        cstatus= new JComboBox<>(sam);
        cstatus.setBounds(220,250,150,30);
        cstatus.setFont(new Font("serif",Font.BOLD,20));
        cstatus.setForeground(Color.BLACK);
        add(cstatus);
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
        submit.setBounds(50,320,150,30);
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("serif",Font.PLAIN,15));
        submit.addActionListener(this);
        add(submit);

        back= new JButton("Back");
        back.setBounds(220,320,150,30);
        back.setBackground(Color.GREEN);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("serif",Font.PLAIN,15));
        back.addActionListener(this);
        add(back);


        setSize(500,450);
        setLocation(350,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String id=lblid.getText();
            String stuname=lblname.getText();
            String day=((JTextField)date.getDateEditor().getUiComponent()).getText();
            String status=(String) cstatus.getSelectedItem();

            try{
                JdbcConn conn= new JdbcConn();
                String query="insert into attendence values ('"+id+"','"+stuname+"','"+day+"','"+status+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Attendance submitted Successfully");
                setVisible(false);
                new ViewStudents();
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        else{
            setVisible(false);
            new ViewStudents();
        }
    }
    public static void main(String[] args) {
        new StudentAttendence("");

    }
}
