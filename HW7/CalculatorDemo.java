package HW7;

import javax.swing.*;
import java.awt.event.*;
/** Homework 7 due date on Canvas
  * Add javadoc to your new calculator java file(s) 
  * add all team contributors with @author tag */
class CalculatorDemo implements ActionListener{
	
	JFrame f;
	JTextField t;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdiv,bmul,bsub,badd,bdec,beq,bdel,bclr, inv, squ, sqrt;
 
	static double a=0,b=0,result=0;
	static int operator=0;
 
	CalculatorDemo(){
		f=new JFrame("Calculator");
		t=new JTextField();
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		b5=new JButton("5");
		b6=new JButton("6");
		b7=new JButton("7");
		b8=new JButton("8");
		b9=new JButton("9");
		b0=new JButton("0");
		bdiv=new JButton("/");
		bmul=new JButton("*");
		bsub=new JButton("-");
		badd=new JButton("+");
		bdec=new JButton(".");
		beq=new JButton("=");
		bdel=new JButton("Delete");
		bclr=new JButton("Clear");
		/** 
		 * @author Anthony Torns II
		 *  Inverse, Square and Square Root added below
		*/
    inv = new JButton("1/x");
    squ = new JButton("x^2");
    sqrt = new JButton("sqrt");

		/** @author Anthony Torns II 
		 * Frame, textfield, and button's have been shrunk and placed close together for compactness and mimics the mac calculator. 
		 
		 */


		t.setBounds(30,30,280,30);

    bclr.setBounds(30,55,60,40);
		bdel.setBounds(85,55,60,40);
    inv.setBounds(140, 55, 60, 40);
    squ.setBounds(195,55,60,40);
    sqrt.setBounds(250,55,60,40);

		b7.setBounds(30,90,85,40);
		b8.setBounds(110,90,85,40);
		b9.setBounds(190,90,85,40);
		bdiv.setBounds(270,90,40,40);
		
		b4.setBounds(30,120,85,40);
		b5.setBounds(110,120,85,40);
		b6.setBounds(190,120,85,40);
		bmul.setBounds(270,120,40,40);
		
		b1.setBounds(30,150,85,40);
		b2.setBounds(110,150,85,40);
		b3.setBounds(190,150,85,40);
		bsub.setBounds(270,150,40,40);
		
		bdec.setBounds(30,180,85,40);
		b0.setBounds(110,180,85,40);
		beq.setBounds(190,180,85,40);
		badd.setBounds(270,180,40,40);

	
   // inv.setBounds();
    //squ.setBounds();
   // sqrt.setBounds();
		
		f.add(t);
		f.add(b7);
		f.add(b8);
		f.add(b9);
		f.add(bdiv);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(bmul);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(bsub);
		f.add(bdec);
		f.add(b0);
		f.add(beq);
		f.add(badd);
		f.add(bdel);
		f.add(bclr);

		/** @author Anthony Torns
		 * new buttons added to frame
		*/

    f.add(inv);
    f.add(squ);
    f.add(sqrt);
		
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(350,310);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		badd.addActionListener(this);
		bdiv.addActionListener(this);
		bmul.addActionListener(this);
		bsub.addActionListener(this);
		bdec.addActionListener(this);
		beq.addActionListener(this);
		bdel.addActionListener(this);
		bclr.addActionListener(this);
    inv.addActionListener(this);
    squ.addActionListener(this);
    sqrt.addActionListener(this);

	}

	/** @author Anthony Torns II
	 * new buttons added to actionPerformed
	 */
 
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
			t.setText(t.getText().concat("1"));
		
		if(e.getSource()==b2)
			t.setText(t.getText().concat("2"));
		
		if(e.getSource()==b3)
			t.setText(t.getText().concat("3"));
		
		if(e.getSource()==b4)
			t.setText(t.getText().concat("4"));
		
		if(e.getSource()==b5)
			t.setText(t.getText().concat("5"));
		
		if(e.getSource()==b6)
			t.setText(t.getText().concat("6"));
		
		if(e.getSource()==b7)
			t.setText(t.getText().concat("7"));
		
		if(e.getSource()==b8)
			t.setText(t.getText().concat("8"));
		
		if(e.getSource()==b9)
			t.setText(t.getText().concat("9"));
		
		if(e.getSource()==b0)
			t.setText(t.getText().concat("0"));
		
		if(e.getSource()==bdec)
			t.setText(t.getText().concat("."));
		
		if(e.getSource()==badd)
		{
			a=Double.parseDouble(t.getText());
			operator=1;
			t.setText("");
		} 
		
		if(e.getSource()==bsub)
		{
			a=Double.parseDouble(t.getText());
			operator=2;
			t.setText("");
		}
		
		if(e.getSource()==bmul)
		{
			a=Double.parseDouble(t.getText());
			operator=3;
			t.setText("");
		}
		
		if(e.getSource()==bdiv)
		{
			a=Double.parseDouble(t.getText());
			operator=4;
			t.setText("");
		}
    
    if(e.getSource()== inv) {
      a = Double.parseDouble(t.getText());
      operator = 5;
    }

    if(e.getSource()== squ) {
      a = Double.parseDouble(t.getText());
      operator = 6;
    } 

    if(e.getSource()==sqrt) {
      a = Double.parseDouble(t.getText());
      operator = 7;
    }
		
		if(e.getSource()==beq)
		{
			b=Double.parseDouble(t.getText());
		
			switch(operator)
			{
				case 1: result=a+b;
					break;
		
				case 2: result=a-b;
					break;
		
				case 3: result=a*b;
					break;
		
				case 4: result=a/b;
					break;

        case 5: result = 1/a; 
          break;

        case 6: result = a * a;
          break;

        case 7: result = Math.sqrt(a);
          break;

		
				default: result=0;
			}
		
			t.setText(""+result);
		}
		
		if(e.getSource()==bclr)
			t.setText("");
		
		if(e.getSource()==bdel)
		{
			String s=t.getText();
			t.setText("");
			for(int i=0;i<s.length()-1;i++)
			t.setText(t.getText()+s.charAt(i));
		}		
	}
 
	public static void main(String[] args){
		new CalculatorDemo();
	}
}