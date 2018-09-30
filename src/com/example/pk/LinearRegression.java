package com.example.pk;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import com.example.pk.LoadData;
import Jama.Matrix;
import java.lang.Math;


public class LinearRegression {
	public static void main(String args[]) {
		//load the training data
		String trainingData="C:\\Users\\purandur\\Desktop\\LR in Java\\LRJava\\src\\com\\example\\trainingData.csv";
        LoadData load_train=new LoadData(trainingData);
        List<List<String>> lines_train=load_train.loaddata();
        ConvertToArrays convert_train=new ConvertToArrays(lines_train);
        convert_train.convert();
        List<Double>X_train_list=convert_train.getX();
        List<Long>Y_train_list=convert_train.getY();
        
        //load the testing data
        String testingData="C:\\Users\\purandur\\Desktop\\LR in Java\\LRJava\\src\\com\\example\\testData.csv";
        LoadData load_test=new LoadData(testingData);
        List<List<String>> lines_test=load_test.loaddata();
        ConvertToArrays convert_test=new ConvertToArrays(lines_test);
        convert_test.convert();
        List<Double>X_test_list=convert_test.getX();
        List<Long>Y_test_list=convert_test.getY();
        
        
        //input matrix
        
        double[][] X_train=ListToArray.convertInput(X_train_list);
        double[][] Y_train=ListToArray.convertOutput(Y_train_list);
        System.out.println("Input Training examples ");
        for(int i=0;i<X_train_list.size();i++) {
        	for(int j=0;j<2;j++) {
        		System.out.print(X_train[i][j]);
        		System.out.print(" ");
        	}
        	System.out.println(" ");
        }
        System.out.println("Output Training examples ");
        for(int i=0;i<Y_train_list.size();i++) {
        	Y_train[i][0]=Y_train_list.get(i);
        	System.out.println(Y_train[i][0]);
        }
       
        Matrix x=new Matrix(X_train);
        Matrix y=new Matrix(Y_train);
        
        Matrix theta=NormalEquation.run(x,y);
        
        double[][] theta_array=theta.getArray();
        
        double[][] X_test=ListToArray.convertInput(X_test_list);
        double[][] Y_test=ListToArray.convertOutput(Y_test_list);
        System.out.println("Input Testing Examples");
        for(int i=0;i<X_test.length;i++) {
        	for(int j=0;j<X_test[i].length;j++) {
        		System.out.print(X_test[i][j]);
        		System.out.print(" ");
        	}
        	System.out.println(" ");
        }
        
        System.out.println("Output Testing Examples");
        for(int i=0;i<Y_test.length;i++) {
        	for(int j=0;j<Y_test[i].length;j++) {
        		System.out.print(Y_test[i][j]);
        	}
        	System.out.println(" ");
        }
        
        System.out.println("Predicted Parameters");
        for(int i=0;i<theta_array.length;i++) {
        	for(int j = 0; j < theta_array[i].length; j++) {        
                System.out.print(theta_array[i][j]+" ");
            }
        	System.out.println(" ");
        }
        
        
        Matrix x_test=new Matrix(X_test);
        Matrix y_pred=x_test.times(theta);
        
        System.out.println("Predicted Output");
        double[][] y_pred_array=y_pred.getArray();
        for(int i=0;i<y_pred_array.length;i++) {
        	System.out.println(y_pred_array[i][0]);
        }
        
        Matrix error=y_pred.minus(new Matrix(Y_test));
        System.out.println("Error percentage array");
        double[][] error_array=error.getArray();
        for(int i=0;i<error_array.length;i++) {
        	double error_percentage=Math.abs(error_array[i][0]/Y_test[i][0])*100;
        	System.out.println(error_percentage+" %");
        }
	}
}
