package student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    Splash(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading= new JLabel("STUDENT MANAGEMENT SYSTEM");
        heading.setBounds(130,30,1200,60);
        heading.setFont(new Font("serif",Font.BOLD,45));
        heading.setForeground(Color.BLUE);
        add(heading);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/frontpage.png"));
        Image i2=i1.getImage().getScaledInstance(900,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(70,100,900,350);
        add(image);

        JButton click=new JButton("CLICK HERE TO CONTINUE ");
        click.setBounds(670,300,200,40);
        click.setBackground(Color.GREEN);
        click.setForeground(Color.BLACK);
        click.addActionListener(this);
        image.add(click);

        setSize(1050,550);
        setLocation(100,100);
        setVisible(true);

        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){

            }
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){

            }
        }
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new LoginPage();
    }
    public static void main(String[] args) {
        new Splash();
    }
}
