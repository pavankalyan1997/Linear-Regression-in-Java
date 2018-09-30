package com.example.pk;
import java.util.*;

public class ConvertToArrays {
   private List<List<String>>lines;
   
   private List<Double>X=new ArrayList<Double>();
   private List<Long>Y=new ArrayList<Long>();
   
   public ConvertToArrays(List<List<String>> lines) {
		super();
		this.lines = lines;
	}
	
	public List<Double> getX() {
		return X;
	}
	public List<Long> getY() {
		return Y;
	}
	public void convert() {
		for(List<String> line: lines) {
			X.add(Double.valueOf(line.get(0)));
			Y.add(Long.valueOf(line.get(1)));
       }
	}
	    
   
   
   
}
