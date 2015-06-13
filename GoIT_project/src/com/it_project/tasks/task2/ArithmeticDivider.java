package com.it_project.tasks.task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArithmeticDivider {
	
	private List<Integer> multiplicationProducts = new ArrayList<Integer>();
	private List<Integer> interimResults = new ArrayList<Integer>();
	private List<Integer> particles = new LinkedList<Integer>(); 
	private String drawing;
	
	public String getLongDivision (String number1, String number2) throws IndexOutOfBoundsException {
		
		int divisible = Integer.parseInt(number1.toString());
		int divisor = Integer.parseInt(number2.toString());
		int didvisionResult = divisible/divisor;
		
		char[] res = String.valueOf(didvisionResult).toCharArray();
		
		for (char c : res) {
			int n = (c-'0')*divisor;
			multiplicationProducts.add(n); 
		}
		
		char numbers[] = number1.toCharArray(); 
		
		for (char ch : numbers){
			int n = ch-'0';
			particles.add(n);
		}
		
		runDivision();
		
		
		return drawing;
	}
	
	private void runDivision() {
		
		for (int i = 0; i<getMultiplicationProducts().size(); i++) {
			
			String interimResult = "";
			int product = getMultiplicationProducts().get(i);
			int size = String.valueOf(product).length();
			
			if (i == 0) {
				for	(int j = 0; j<size; j++){
					interimResult += particles.get(0);
					particles.remove(0);
			 } 
			
			int number = Integer.parseInt(interimResult);
			int resultNumber = number - product;
			
			if (resultNumber>0) {
				StringBuilder builder = new StringBuilder();
				builder.append(resultNumber);
				char[] resNum = builder.reverse().toString().toCharArray();
				for (char ch : resNum){
					int c = ch-'0';
					particles.add(0, c);
				}
			  }
			}
			else if(product!=0){
			for	(int j = 0; j<size; j++){
					interimResult += particles.get(0);
				    particles.remove(0);
				} 

			int number = Integer.parseInt(interimResult);
			interimResults.add(number);
			int resultNumber = number - product;
			
			if (resultNumber>0) {
				StringBuilder builder = new StringBuilder();
				builder.append(resultNumber);
				char[] resNum = builder.reverse().toString().toCharArray();
				for (char ch : resNum) {
					int c = ch-'0';
					particles.add(0, c);
				}

		  }
		}
	  }
	}
	
	private void createDrawing() {
		
	}
	
	public List<Integer> getMultiplicationProducts() {
		return multiplicationProducts;
	}
	
	public List<Integer> getInterimResults() {
		return interimResults;
	}

}