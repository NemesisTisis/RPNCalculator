package calculatorRPN;
import java.awt.*;
import java.awt.event.*;

import operatingPackage.Adder;
import operatingPackage.Divider;
import operatingPackage.Equalizer;
import operatingPackage.Multiplier;
import operatingPackage.Operand;
import operatingPackage.Operator;
import operatingPackage.Substructer;



public class CalculatorGui extends Frame{
	
    private static final long serialVersionUID = 1L;
	public static Operand op;
	public static Operator oper;
	
	public static Adder add;
	public static Substructer substruct;
	public static Multiplier multiply;
	public static Divider  divide;
	public static Equalizer equals;
	
	public static Boolean lastOperatorAction = false; 
	public  TextField display;
	
	
	
	public CalculatorGui(){
		super("RPN CALCULATOR");
		
		
		
		add = new Adder(new GuiInterface(){
			public void display(String s){
				display.setText(s);
				lastOperatorAction=true;
			}
			
			public void backspace(){
				
			}
		});
		
		substruct = new Substructer(new GuiInterface(){
			public void display(String s){
				display.setText(s);
				lastOperatorAction=true;
			}
			
			public void backspace(){
				
			}
		});
		
		multiply = new Multiplier(new GuiInterface(){
			public void display(String s){
				display.setText(s);
				lastOperatorAction=true;
			}
			
			public void backspace(){
				
			}
		});
		
		divide = new Divider(new GuiInterface(){
			public void display(String s){
				display.setText(s);
				lastOperatorAction=true;
			}
			
			public void backspace(){
				
			}
		});
		
		equals = new  Equalizer(new GuiInterface(){
			public void display(String s){
				display.setText(s);
				lastOperatorAction=true;
			}
			
			public void backspace(){
				
			}
		});
		
		
		 op=new Operand(new GuiInterface(){
			public void display(String s){
				
				if(lastOperatorAction){
					display.setText("");
					lastOperatorAction=false;					
				}
				
				if(s==""){
					display.setText(s);
				}
				else{
			       display.setText(display.getText()+s);	
				}
				
			}
			
			public void backspace(){
				 if(display.getText().length()!=0){
					 display.setText(display.getText().substring(0, display.getText().length()-1));
				 }
			}
		});
		 
	
		
		//Frame settings
		
		Font myfont= new Font("TimesRoman", Font.PLAIN, 12 );
		this.setFont(myfont);
		this.setLayout(null);
		this.setVisible(true);
		this.setBackground(Color.cyan);
		this.setSize(283, 297);
		this.setLocation(50, 100);
		this.toFront();
		this.setResizable(false);
		this.addWindowListener(new CloseWindowAndExit());
		
		//digit Buttons 
		this.add(digitButton(0,64,265,35,28));
		this.add(digitButton(1,64,232,35,28));
		this.add(digitButton(2,104,232,35,28));
		this.add(digitButton(3,144,232,35,28));
		this.add(digitButton(4,64,199,35,28));
		this.add(digitButton(5,104,199,35,28));
		this.add(digitButton(6,144,199,35,28));
		this.add(digitButton(7,64,166,35,28));
		this.add(digitButton(8,104,166,35,28));
		this.add(digitButton(9,144,166,35,28));
		
		
		//operator Buttons 

		this.add(operatorButton("+",195, 265,35,28,add));
		this.add(operatorButton("-",195,232,35,28, substruct));
		this.add(operatorButton("*",195,199, 35, 28, multiply ));
		this.add(operatorButton("/",195,166, 35, 28, divide));
		this.add(operatorButton("=",235,265, 35, 28, equals));
		
		//action Buttons

		this.add(actionButton("ENTER",204, 100, 56, 28));
		this.add(actionButton("CE",144, 133, 35, 28));
		this.add(actionButton("C",144, 100, 35, 28));
		this.add(actionButton("BACKSPACE",64, 100, 75, 28));
		this.add(actionButton(".",144, 265, 35, 28 ));
		
		//display settings 
	    display=new TextField("",14);
	    this.add(display);
	    display.setEditable(false);
	    display.setBackground(Color.white);
	    display.setForeground(Color.magenta);
	    display.setBounds(13,55,257,30);
	    
	}
	


private Button digitButton(int digit, int a, int b, int c, int d) {
	Button button = new Button(Integer.toString(digit));
	button.setBounds(a,b,c,d);
	button.setBackground(Color.white);
	button.setForeground(Color.magenta);
	button.addActionListener(op);
    return button;
		
	}

private Button actionButton(String label, int a, int b, int c, int d) {
	Button button =new Button(label);
	button.setBounds(a,b,c,d);
	button.setBackground(Color.white);
	button.setForeground(Color.gray);
	button.addActionListener(op);
    return button;

}

private Button operatorButton(String label, int a, int b, int c, int d, Operator operator) {
	Button button =new Button(label);
	button.setBounds(a,b,c,d);
	button.setBackground(Color.white);
	button.setForeground(Color.gray);
	button.addActionListener(operator);
    return button;
    
}






		 
		 
	 }

class CloseWindowAndExit extends WindowAdapter{
	 public void windowClosing (WindowEvent closeWindowAndExit){
	 System.exit(0);
	 }
} 




