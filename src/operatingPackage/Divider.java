package operatingPackage;

import calculatorRPN.CalculatorEngine;
import calculatorRPN.GuiInterface;

public class Divider extends Operator {
	
 public Divider(GuiInterface g) {
		super(g);		
	}
 
 public void operate(String s) {
	 Double d1 = null;
 try {	
	 d1 = (Double)CalculatorEngine.st.pop();
	 Double d2 = (Double)CalculatorEngine.st.pop(); 
	 Double d3 = null;
	 if(d1==0.0){
		 System.out.println("vlaka");
		 gui.display("divide by zero");
		  
	  }
	  else{
		 d3 =new Double(d2.doubleValue() / d1.doubleValue());
		 CalculatorEngine.st.push(d3);
		 System.out.println("result push(" + d3+ ")");
		 gui.display(" "+s+" ");
	  } 
	 
	 
    } catch(Exception EmptyStackException){
       if(d1!=null){ 
    	  CalculatorEngine.st.push(d1);
    	}
    	 System.out.println("push(" + d1+ ")");
	     gui.display("Error");
       } 
      }
	

 }

