package com.example.pk;
import java.util.*;
public class ListToArray {
  public static  double[][] convertInput(List<Double>list){
	  double[][] x=new double[list.size()][2];
      for(int i=0;i<list.size();i++) {
      	x[i][0]=1;
      	x[i][1]= list.get(i);
      	
      }
      return x;
  }
  
  public static double[][] convertOutput(List<Long>list){
	  double[][] y=new double[list.size()][1];
      for(int i=0;i<list.size();i++) {
      	y[i][0]=list.get(i);
      }
      return y;
  }
  
 
}
