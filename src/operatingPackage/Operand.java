package operatingPackage;
import java.awt.*;
import java.awt.event.*;

import calculatorRPN.CalculatorEngine;
import calculatorRPN.GuiInterface;

public class Operand implements ActionListener{
	protected StringBuffer op;
	protected GuiInterface guiInter;
	
	public Operand(GuiInterface gi){
		op=new StringBuffer();
		guiInter=gi;
	}

	
	public void addDigit(char ch){
		op.append(ch);
		
	}
	public void deleteLastDigit(){
		if(op.length()!=0){
		op.deleteCharAt((op.length()-1));}
		
		
	}
	
	public void complete() {
		String tel=op.toString();
		reset();
		try{
		CalculatorEngine.st.push(Double.parseDouble(tel));
		System.out.println("push("+ Double.parseDouble(tel) +")");
		guiInter.display("");
		}catch(NumberFormatException ex){
			guiInter.display("Error");
		}
		
	}
	
	public void reset(){
		op.delete(0, op.length());
		
}

	
   public void actionPerformed(ActionEvent event){
      
	   Button button =(Button)(event.getSource());
	   String s = button.getLabel();
	   boolean isNumeric = s.chars().allMatch( Character::isDigit );
  		 
	//NUMBER HANDLERS
	   
	   if (isNumeric) {
		for(int i=0;i<10;i++){
			 if(Integer.valueOf(s)==i) {
		       addDigit((s.charAt(0)));
		       guiInter.display(s);  
	 	     }	  
        }
	   }
	   
		// .	 
		if(s=="."){
		  addDigit('.');
		  guiInter.display(s);
			 
		}
		//ENTER
		if(s=="ENTER"){
		
			complete();

		}
		
			 
	  
		//BACKSPACE
		if(s=="BACKSPACE"){
			 deleteLastDigit();
			 guiInter.backspace();
			}
	//CE
	  if(s=="CE"){
		  guiInter.display("");
		  reset();
		  CalculatorEngine.removeAllElements();
	  }
	 //C
	  if(s=="C"){
		  reset();
		  guiInter.display("");
		}
		
   }
    }
