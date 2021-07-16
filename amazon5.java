/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.finalproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author owner
 */
public class amazon5 {
     public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException, IOException {
        // TODO code application logic here
          int helpful=0,totals=0;
           int y =0;
           HashMap<String,Integer> finalCat = new HashMap<>();
            float de=0F;
           
        File readFile = new File("D:\\amzn");
        int verified=0,nonVerified=0;
        if(readFile.isDirectory()) {
    for(File file : readFile.listFiles()) {
        //process all files in the directory
    y++;
     HashMap<String,Integer> topFive  = new HashMap<>();
             HashMap<String,Integer> ratings  = new HashMap<>();
        FileReader fileReader = new FileReader(file);
         BufferedReader br1 = new BufferedReader(fileReader);
          File myObj = new File("D:\\amzntext\\asw"+y+".txt");
//          System.out.println(file.getName());
    if (myObj.delete()) {  
//      System.out.println("Deleted the file: " + myObj.getName());
    } else {
//      System.out.println("Failed to delete the file.");
    } 
          FileWriter myWriter = new FileWriter("D:\\amzntext\\asw"+y+".txt");
             BufferedWriter bw = new BufferedWriter(myWriter);
       br1.readLine();
        String[] ax;
//        HashMap<String,Float[]> validCustomer = new HashMap<>();
        Float[] temp;
        String line;
        int totalr = 0,rate=0;
        ArrayList<Integer> al = new ArrayList<>();
           
            Double[] temps = new Double[2];
            HashMap<String,Double[]> reviewUniq = new HashMap<>();
         while((line=br1.readLine())!=null){
           ax = line.split("\t");
          
           if(Integer.parseInt(ax[14].split("-")[0])<2015){continue;}
           if(Integer.parseInt(ax[7])!=5){continue;}
//            String[] y12= ax[13].split("[ .,\"]");
            bw.write(ax[13]+"\n");
            
    }
         bw.flush();
         myWriter.close();
         HashMap<String,Integer> counts  = new HashMap<>();
      try (BufferedReader br = new BufferedReader(new FileReader("D:\\amzntext\\asw"+y+".txt"))) {
    String line1;
    while ((line1 = br.readLine()) != null) {
       String[] po  = line1.split("[ .,\"]");
       
       for(String fer: po){
           fer = fer.toLowerCase().strip();
           if(fer.length()<4){continue;}
           String[] listToRemove = {"this","that","it's","more","have","with","product","just","very","when","they","your","these","would","from","will"
           ,"after","like","them","back","only","/><br","what"};
       boolean check = false;
       for(String grt:listToRemove){
           if(fer.equals(grt)){
               check = true;
               
           }
       }
           if(check){
               continue;
                   }
       if(!counts.containsKey(fer)){
           counts.put(fer, 1);
       }
       else{
       int tempest = counts.get(fer);
       counts.replace(fer, tempest+1);
       }
       
       }
    }
    counts = sortByValue(counts);
    int yup=0;
    for (Map.Entry<String,Integer> entry : counts.entrySet())  {
             yup++;
             if(yup>5){break;}
             
              if(!finalCat.containsKey(entry.getKey())){
                  finalCat.put(entry.getKey(),entry.getValue());
              }
              else{
                  int tpo = finalCat.get(entry.getKey());
                  tpo += entry.getValue();
                  finalCat.replace(entry.getKey(), tpo);
              }
             
    }
  
//    System.out.println();
}  
}
    }
          for (Map.Entry<String,Integer> entry : finalCat.entrySet()){
        System.out.println(entry.getKey()+"\t"+entry.getValue());
    } 
}
}
