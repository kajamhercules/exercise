package com.dealer.keycounts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class KeyCount {
	private HashMap<String, Collection<Integer>> mapperResult = new HashMap<String, Collection<Integer>>();
	private HashMap<String, Integer> ruducerResult = new HashMap<String, Integer>();
	
	private String filePath;
	
	 private void writeMapResult(String key, Integer value){
		if (mapperResult.get(key)== null){
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(value);
			mapperResult.put(key, list);
		 }else{
			 mapperResult.get(key).add(value);
		 }
					 
	 }
	 
	 private void writeReduceResult(String key, Integer value){
		 if (ruducerResult.get(key)== null){
				
			ruducerResult.put(key, value);
		 }
	 }
	 
	 public void mapper(String key, Integer value){
		 this.writeMapResult(key, value);
	 }
	 
	 
	 
	 public void reducer(String key, Collection<Integer> values){
		 int total = 0;
		 for (Integer value : values) {
			total = total + value.intValue();
		}
		 this.writeReduceResult(key, Integer.valueOf(total));
	 }
	 
	 public void execute() throws IOException{
		 BufferedReader reader = this.readFile(this.filePath);
		 String txtLine = reader.readLine();
		 while (txtLine!= null && !txtLine.isEmpty()) {
			 String[] recordArray = txtLine.split(",");
			 	if(recordArray.length >= 2){
			 		String key = recordArray[0];
					String value = recordArray[1];
					this.mapper(key, new Integer(value.trim()));	
					}else{
						 System.out.println("Record is invalid, record discurded");
					 }
			 	
			 txtLine = reader.readLine();
		 }
		 Iterator<Entry<String, Collection<Integer>>> mapIterator = this.mapperResult.entrySet().iterator();
		    while (mapIterator.hasNext()) {
		        Map.Entry<String, Collection<Integer>> pair = (Map.Entry<String, Collection<Integer>>)mapIterator.next();
		        this.reducer(pair.getKey(),pair.getValue());
		    }
		    Iterator<Entry<String,Integer>> reducerIterator = this.ruducerResult.entrySet().iterator();
		    while (reducerIterator.hasNext()) {
		        Map.Entry<String, Integer> resultPair = (Map.Entry<String,Integer>)reducerIterator.next();
		        System.out.println("The total for "+resultPair.getKey() +" is " + resultPair.getValue());
		    }
		 
	 }
	 
	 private BufferedReader readFile(String filePath) throws IOException{
		 BufferedReader in = new BufferedReader(new FileReader(filePath));
		 return in;
	 } 
	 
	 public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
