package com.example.pk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LoadData {
	String fileName;
	List<List<String>> lines = new ArrayList<>();
	
	public LoadData(String fileName) {
		super();
		this.fileName = fileName;
	}
	public List<List<String>> loaddata(){
		File file=new File(fileName);
		Scanner inputStream;
		
		try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(",");
                lines.add(Arrays.asList(values));
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		return lines;
	}
	
	

}
