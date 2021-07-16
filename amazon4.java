/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.finalproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author owner
 */
public class amazon4 {
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
    public static void main(String args[]) throws IOException {
        // TODO code application logic here
         int helpful=0,totals=0;
           int y =0;
            float de=0F;
           
        File readFile = new File("D:\\amzn");
        int verified=0,nonVerified=0;
        if(readFile.isDirectory()) {
    for(File file : readFile.listFiles()) {
        //process all files in the directory
    y++;
        FileReader fileReader = new FileReader(file);
//        System.out.println(file.getName());
         BufferedReader br1 = new BufferedReader(fileReader);
          FileWriter myWriter = new FileWriter("D:\\amzntext\\et"+y+".txt");
             BufferedWriter bw = new BufferedWriter(myWriter);
       br1.readLine();
        String[] ax;
//        HashMap<String,Float[]> validCustomer = new HashMap<>();
        Float[] temp;
        String line;
         HashMap<String,Integer> topFive  = new HashMap<>();
             HashMap<String,Integer> ratings  = new HashMap<>();
        int totalr = 0,rate=0;
        ArrayList<Integer> al = new ArrayList<>();
           
            Double[] temps = new Double[2];
            HashMap<String,Double[]> reviewUniq = new HashMap<>();
         while((line=br1.readLine())!=null){
           ax = line.split("\t");
          
           if(Integer.parseInt(ax[14].split("-")[0])<2005){continue;}
           totalr++;
           rate = rate+ Integer.parseInt(ax[7]);
           if(!topFive.containsKey(ax[4])){
               topFive.put(ax[4], 1);
               ratings.put(ax[4], Integer.parseInt(ax[7]));
           }
           else{
               int u = topFive.get(ax[4]);
//               System.out.println(u);
               topFive.replace(ax[4], u+1);
               int ew = ratings.get(ax[4]);
               ratings.put(ax[4],ew+Integer.parseInt(ax[7]) );
           }
         }
         topFive = sortByValue(topFive);
         int yup = 0;
         int sum_for_five=0;
         int denominator_for_five=0;
         for (Map.Entry<String,Integer> entry : topFive.entrySet())  {
             yup++;
             if(yup>5){break;}
//             System.out.println(entry.getKey()+"\t"+entry.getValue());
//             System.out.println(entry.getKey()+"\t"+ratings.get(entry.getKey()));
             sum_for_five  += ratings.get(entry.getKey());
             denominator_for_five += entry.getValue();
         }
         float average_for_five = (sum_for_five/(float)denominator_for_five);
        float average_for_total = (rate/(float)totalr);
        System.out.print(average_for_five+"\t");
        System.out.println(average_for_total);
        if(average_for_five>average_for_total){
        System.out.println("yes more reviewed products are rated higher");
        }
        else{
            System.out.println("no more reviewed products are  not rated higher");
        }
    }
}
    }
}
