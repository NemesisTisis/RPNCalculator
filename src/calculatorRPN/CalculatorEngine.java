package calculatorRPN;
import java.util.Stack;

public class CalculatorEngine {
	
	public static Stack<Double> st=new Stack<Double>();
	static CalculatorGui gui;
    public static void main(String[] args) {
    	
	    gui=new CalculatorGui();
	   
	    	
	    }
      public static void removeAllElements(){
    	  while(!st.isEmpty()){ 
			   st.pop();
		  }
	  }  
 }
	

