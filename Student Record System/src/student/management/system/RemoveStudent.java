package student.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveStudent extends JFrame implements ActionListener {
    Choice cstuid;
    JButton delete, back;
    RemoveStudent(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading= new JLabel("Remove Student Details");
        heading.setBounds(100,30,400,30);
        heading.setFont(new Font("serif",Font.BOLD,30));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel stuid=new JLabel("Student ID");
        stuid.setBounds(30,80,150,30);
        stuid.setFont(new Font("serif",Font.BOLD,20));
        stuid.setForeground(Color.BLACK);
        add(stuid);

        cstuid = new Choice();
        cstuid.setBounds(200,80,150,30);
        add(cstuid);
        try{
            JdbcConn conn = new JdbcConn();
            String query="select * from student";
            ResultSet rs =conn.s.executeQuery(query);
            while(rs.next()){
                cstuid.add(rs.getString("id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name=new JLabel("Student Name");
        name.setBounds(30,130,150,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        name.setForeground(Color.BLACK);
        add(name);

        JLabel lblname= new JLabel();
        lblname.setBounds(200,130,150,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        lblname.setForeground(Color.BLACK);
        add(lblname);

        JLabel phone=new JLabel("Phone No");
        phone.setBounds(30,180,150,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        phone.setForeground(Color.BLACK);
        add(phone);

        JLabel lblphone= new JLabel();
        lblphone.setBounds(200,180,150,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        lblphone.setForeground(Color.BLACK);
        add(lblphone);

        JLabel aadhar=new JLabel("Aadhar No");
        aadhar.setBounds(30,230,150,30);
        aadhar.setFont(new Font("serif",Font.BOLD,20));
        aadhar.setForeground(Color.BLACK);
        add(aadhar);

        JLabel lblaadhar= new JLabel();
        lblaadhar.setBounds(200,230,150,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        lblaadhar.setForeground(Color.BLACK);
        add(lblaadhar);

        try{
            JdbcConn conn = new JdbcConn();
            String query="select * from student where id='"+ cstuid.getSelectedItem()+"'";
            ResultSet rs =conn.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblaadhar.setText(rs.getString("aadhar"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        cstuid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    JdbcConn conn = new JdbcConn();
                    String query="select * from student where id='"+ cstuid.getSelectedItem()+"'";
                    ResultSet rs =conn.s.executeQuery(query);
                    while(rs.next()){
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblaadhar.setText(rs.getString("aadhar"));

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        delete= new JButton("Delete");
        delete.setBounds(100,280,150,30);
        delete.setBackground(Color.GREEN);
        delete.setForeground(Color.BLACK);
        delete.setFont(new Font("serif",Font.PLAIN,15));
        delete.addActionListener(this);
        add(delete);

        back= new JButton("Back");
        back.setBounds(280,280,150,30);
        back.setBackground(Color.GREEN);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("serif",Font.PLAIN,15));
        back.addActionListener(this);
        add(back);

        setSize(550,400);
        setLocation(330,150);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                JdbcConn conn = new JdbcConn();
                String query= "delete from student where id='"+cstuid.getSelectedItem()+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Deleted Sucessfully");
                setVisible(false);
                new Home();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new RemoveStudent();

    }
}
