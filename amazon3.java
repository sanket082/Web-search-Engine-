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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author owner
 */
public class amazon3 {
   public static double getMedian(ArrayList<Integer> sets){
    Collections.sort(sets);

    double middle = sets.size()/2;
        if (sets.size()%2 == 1) {
          middle = (sets.get(sets.size()/2) + sets.get(sets.size()/2 - 1))/2;
        } else {
            middle = sets.get(sets.size()/2) ;
        }
      return middle;
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException, IOException {
        // TODO code application logic here
         int helpful=0,totals=0;
           int y =0;
            double avg ;
            float de=0F;
        File readFile = new File("D:\\amzn");
        int verified=0,nonVerified=0;
        if(readFile.isDirectory()) {
    for(File file : readFile.listFiles()) {
        //process all files in the directory
    y++;
        FileReader fileReader = new FileReader(file);
         BufferedReader br1 = new BufferedReader(fileReader);
          FileWriter myWriter = new FileWriter("D:\\amzntext\\ex"+y+".txt");
             BufferedWriter bw = new BufferedWriter(myWriter);
       br1.readLine();
        String[] ax;
        HashMap<String,Float[]> validCustomer = new HashMap<>();
        Float[] temp;
        String line;
        ArrayList<Integer> al = new ArrayList<>();
           
            Double[] temps = new Double[2];
            HashMap<String,Double[]> reviewUniq = new HashMap<>();
         while((line=br1.readLine())!=null){
           ax = line.split("\t");
          
           if(Integer.parseInt(ax[14].split("-")[0])<2005){continue;}
            bw.write(ax[14]+"\n");
            int y12= ax[13].split("[ .,\"]").length;
            
            al.add(y12);
            temps = new Double[2];
            temps[0] = (double)y12;
            if(Integer.parseInt(ax[8])==0 ||Integer.parseInt(ax[9])==0){continue;}
            temps[1] = ((double)Integer.parseInt(ax[8])/Integer.parseInt(ax[9]))*100;
            
            reviewUniq.put(ax[2], temps);
            helpful += Integer.parseInt(ax[8]);
            totals += Integer.parseInt(ax[9]);
         }
         
         de = (float) (((double)helpful/totals)*100);
//          System.out.println(de);
//         System.out.println(helpful/totals);
        avg = getMedian(al);
        int counter=0;
          for (Map.Entry<String, Double[]> entry : reviewUniq.entrySet()) {
                temps = entry.getValue();
                if(temps[0]>=avg){
                    if(temps[1]>=de){
                        counter++;
//                        System.out.println("helll");
                    }
                    else{
//                         System.out.println("helll");
                        counter--;
                    }
                }
               
          }

         bw.flush();
         bw.close();
         System.out.println(counter);
          System.out.println(avg);
         if(counter>0){
         System.out.println("Yes");
         }
         else{
         System.out.println("No");
         }
//         System.out.println(t_len);
//         System.out.println("helpful:  "+ helpful+"\nTotal: "+ totals+"\n percentage helpful:  "+de+"%");
         
    }}
         
    }
    }

