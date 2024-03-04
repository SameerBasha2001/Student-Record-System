package student.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewStudents extends JFrame implements ActionListener {
    JTable table;
    Choice studentid;
    JButton search,update,attendance,performance,back;
    ViewStudents(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel searchsid= new JLabel("Search by student id");
        searchsid.setBounds(20,20,200,30);
        searchsid.setFont(new Font("serif",Font.BOLD,20));
        searchsid.setForeground(Color.BLACK);
        add(searchsid);

        studentid =new Choice();
        studentid.setBounds(240,20,200,30);
        studentid.setFont(new Font("serif",Font.BOLD,20));
        studentid.setForeground(Color.BLACK);
        add(studentid);


        try{
            JdbcConn conn=new JdbcConn();
            ResultSet rs=conn.s.executeQuery("select * from student");
            while (rs.next()){
                studentid.add(rs.getString("id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        table=new JTable();


        try{
            JdbcConn conn=new JdbcConn();
            ResultSet rs=conn.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()){
                studentid.add(rs.getString("id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp= new JScrollPane(table);
        jsp.setBounds(20,120,650,350);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20,70,120,30);
        search.setFont(new Font("serif",Font.PLAIN,15));
        search.setBackground(Color.GREEN);
        search.setForeground(Color.BLACK);
        search.addActionListener(this);
        add(search);

        update = new JButton("Update");
        update.setBounds(160,70,120,30);
        update.setFont(new Font("serif",Font.PLAIN,15));
        update.setBackground(Color.GREEN);
        update.setForeground(Color.BLACK);
        update.addActionListener(this);
        add(update);

        attendance = new JButton("Attendance");
        attendance.setBounds(300,70,120,30);
        attendance.setFont(new Font("serif",Font.PLAIN,15));
        attendance.setBackground(Color.GREEN);
        attendance.setForeground(Color.BLACK);
        attendance.addActionListener(this);
        add(attendance);

        performance = new JButton("Performance");
        performance.setBounds(440,70,120,30);
        performance.setFont(new Font("serif",Font.PLAIN,15));
        performance.setBackground(Color.GREEN);
        performance.setForeground(Color.BLACK);
        performance.addActionListener(this);
        add(performance);

        back = new JButton("Back");
        back.setBounds(580,70,90,30);
        back.setFont(new Font("serif",Font.PLAIN,15));
        back.setBackground(Color.GREEN);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);


        setSize(700,550);
        setLocation(250,100);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from student where id='"+studentid.getSelectedItem()+"'";
            try {
                JdbcConn conn = new JdbcConn();
                ResultSet rs=conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateStudent(studentid.getSelectedItem());

        }else if(ae.getSource()==attendance){
            setVisible(false);
            new StudentAttendence(studentid.getSelectedItem());

        } else if (ae.getSource()==performance) {
            setVisible(false);
            new StudentPerformance(studentid.getSelectedItem());

        }else {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {

        new ViewStudents();
    }
}
