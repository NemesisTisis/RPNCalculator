package operatingPackage;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calculatorRPN.CalculatorEngine;
import calculatorRPN.GuiInterface;

public abstract class Operator implements ActionListener {
	protected GuiInterface gui;
	
	public Operator(GuiInterface g){
		gui=g;		
	}
	 
	public abstract void operate(String s);
	
     public void actionPerformed(ActionEvent event){
	      
		   Button button =(Button)(event.getSource());
		   String s = button.getLabel();
			   
		   if(s=="="){
			try{
			    gui.display(Double.toString(CalculatorEngine.st.peek()));
				 
		       }
		        catch(Exception EmptyStackException){
		        
		        	gui.display("");
		        }	
				 
		   } else {
		      operate(s);
			  // gui.display(" "+s+" ");
				   
		  }
	   }	
	  
			
	}

	
		

              

	




