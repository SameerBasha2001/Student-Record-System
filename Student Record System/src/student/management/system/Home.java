package student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton add,view,update,remove;
    Home(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2= i1.getImage().getScaledInstance(700,530, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,700,530);
        add(image);

        JLabel heading= new JLabel("Student Management System");
        heading.setBounds(250,15,400,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        heading.setForeground(Color.BLACK);
        image.add(heading);

        add = new JButton("Add Students");
        add.setBounds(700,100,150,50);
        add.setFont(new Font("serif",Font.PLAIN,15));
        add.setBackground(Color.GREEN);
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        add(add);

        view = new JButton("View Students");
        view.setBounds(700,180,150,50);
        view.setFont(new Font("serif",Font.PLAIN,15));
        view.setBackground(Color.GREEN);
        view.setForeground(Color.BLACK);
        view.addActionListener(this);
        add(view);

        update = new JButton("Update Students");
        update.setBounds(700,260,150,50);
        update.setFont(new Font("serif",Font.PLAIN,15));
        update.setBackground(Color.GREEN);
        update.setForeground(Color.BLACK);
        update.addActionListener(this);
        add(update);

        remove = new JButton("Remove Students");
        remove.setBounds(700,340,150,50);
        remove.setFont(new Font("serif",Font.PLAIN,15));
        remove.setBackground(Color.GREEN);
        remove.setForeground(Color.BLACK);
        remove.addActionListener(this);
        add(remove);





        setSize(900,530);
        setLocation(200,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==add){
            setVisible(false);
            new AddStudent();

        }
        else if(ae.getSource()==view){
            setVisible(false);
            new ViewStudents();

        }else if(ae.getSource()==update){
            setVisible(false);
            new ViewStudents();
        }else{
            setVisible(false);
            new RemoveStudent();
        }
    }
    public static void main(String[] args) {
        new Home();
    }
}
