//Java program to create a simple calculator 
//with basic operations using swing elements.

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class calculator extends JFrame implements ActionListener{
    //create a frame
    static JFrame f;

    //create a textfield
    static JTextField l;

    //store operands;
    String s1,s2,s0;

    //default constructor
    calculator(){
        s0 = s1 = s2 = "";
        System.out.println("calculator stated s0.s1.s2 are "+s0 +s1 +s2+ "null");
    }

    //main function
    public static void main(String args[])
    {
        //create a frame
        f = new JFrame("Calculator");

        //set look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            // TODO: handle exception
        }

        //create object of the class
        calculator c = new calculator();

        //create a text field
        l = new JTextField(16);

        //set the text field to non editable
        l.setEditable(false);

        //create buttons
        JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ba,bs,bm,bd,bdot,bc,beql;

        b0 =  new JButton("0");
        b1 =  new JButton("1");
        b2 =  new JButton("2");
        b3 =  new JButton("3");
        b4 =  new JButton("4");
        b5 =  new JButton("5");
        b6 =  new JButton("6");
        b7 =  new JButton("7");
        b8 =  new JButton("8");
        b9 =  new JButton("9");

        //equal button
        beql = new JButton("=");

        //operators
        ba =  new JButton("+");
        bs =  new JButton("-");
        bm =  new JButton("*");
        bd =  new JButton("/");
        bc =  new JButton("C");

        //create . botton
        bdot = new JButton(".");

        //create a panel
        JPanel p = new JPanel();

        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        bc.addActionListener(c);
        bdot.addActionListener(c);
        beql.addActionListener(c);



        //add elements to panel
        p.add(l);
        p.add(ba);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(bdot);
        p.add(b0);
        p.add(bc);
        p.add(beql);

        p.setBackground(Color.blue);

        //add panel to frame
        f.add(p);

        //set size
        f.setSize(200,200);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        //if the value is number
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9' || s.charAt(0) == '.')
        {
            //if operand is present then add to second number
            if(!s1.equals("")){
                s2 = s2 + s;
                System.out.println("if operand is present then add to second number");

            }
            else{
                s0 = s0 + s;
                System.out.println("else if operand is present then add to first number");
            }

            l.setText(s0 + s1 + s2);
            //set the value of text
        }
        else if(s.charAt(0) == 'C'){
            //clear the one letter
            s0 = s1 = s2 = "";

           //set the value of text
           l.setText(s0 + s1 + s2);
           System.out.println("else if(s.charAt(0) == 'C'){");

        }   
        else if(s.charAt(0) == '='){

            double te = 0;

            //store the value in first
            if(s1.equals("+")){
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            }
            else if(s1.equals("-")){
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            }
            else if(s1.equals("*")){
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));
            }
            else if(s1.equals("/")){
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            }

            l.setText(s0 + s1 + s2 + "=" + te);

            //convert it to string
            s0 = Double.toString(te);

            s1 = s2 = "";
            System.out.println("if(s.charAt(0) == '=')");

        }
        else{
            //if there was no operand
            if(s1.equals("") || s2.equals("")){
                s1 = s;
                System.out.println(" //if there was no operand");

                //else evaluate
            }
            else{
                double te = 0;

                //store the value in first
                if(s1.equals("+")){
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                }
                else if(s1.equals("-")){
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                }
                else if(s1.equals("*")){
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
                }
                else if(s1.equals("/")){
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                }

                s0 = Double.toString(te);

                s1 = s;

                s2 = "";
                System.out.println(" //else if there was no operand");

            }
            System.out.println(" last l.setText(s0 + s1 + s2);"+ "s0="+s0+ "s1=\n"+s1+"s2=\n"+s2);

            l.setText(s0 + s1 + s2);
        }
    }
}