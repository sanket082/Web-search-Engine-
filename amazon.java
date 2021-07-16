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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author owner
 */
public class amazon {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int y =0;
        File readFile = new File("D:\\amzn");
        int verified=0,nonVerified=0;
         Float[] temp;
        HashMap<String,Float[]> validCustomer = new HashMap<>();
        if(readFile.isDirectory()) {
    for(File file : readFile.listFiles()) {
        //process all files in the directory
    y++;
//    System.out.println(file.getName());
        FileReader fileReader = new FileReader(file);
          BufferedReader br1 = new BufferedReader(fileReader);
            int i=0;
        String line;
          FileWriter myWriter = new FileWriter("D:\\amzntext\\names"+y+".txt");
       BufferedWriter bw = new BufferedWriter(myWriter);
       br1.readLine();
        String[] ax;
        
       
         while((line=br1.readLine())!=null){
           ax = line.split("\t");
            if(Integer.parseInt(ax[14].split("-")[0])<2005){continue;}
           if(!validCustomer.containsKey(ax[3])){
               if(ax[11].equalsIgnoreCase("Y")){
                   temp=new Float[4];
                   temp[0] = Float.parseFloat(ax[7]);
                   temp[1] = 0F;
                   temp[2]  =1F;
                   temp[3] = 0F;
                   validCustomer.put(ax[3], temp);
               }
               else{
                    temp=new Float[4];
                   temp[0] = 0F;
                   temp[1] = Float.parseFloat(ax[7]);
                   temp[2]  =0F;
                   temp[3] = 1F;
                   validCustomer.put(ax[3], temp);
               }
           }
           else{
           if(ax[11].equalsIgnoreCase("Y")){
                   temp=validCustomer.get(ax[3]);
                   temp[0] += Float.parseFloat(ax[7]);
                   temp[2] +=1F;
                   validCustomer.replace(ax[3], temp);
               }
               else{
                   temp=validCustomer.get(ax[3]);
                   temp[1] += Float.parseFloat(ax[7]);
                   temp[3] +=1F;
                   validCustomer.replace(ax[3], temp);
               }
           }
         }
         
            
        
         bw.flush();
         bw.close();
    }
}
        int pop =0;
         for (Map.Entry<String, Float[]> entry : validCustomer.entrySet()) {
                 temp  =entry.getValue();
//                 bw.write(entry.getKey()+"\t"+temp[0]/temp[2]+" "+temp[1]/temp[3]+"\n");
                 if(temp[0]==0 || temp[1]==0){continue;}
                 float t1 = temp[0]/temp[2];
                 pop++;
                 float t2 = temp[1]/temp[3];
                 if(t1>t2){verified++;}
                 if(t2>t1){nonVerified++;}
             }
         System.out.println("verified:  "+verified+"  non verified:  "+nonVerified);
         System.out.println("average verified:  "+verified/(float)pop+"  average non verified:  "+nonVerified/(float)pop);
         if(verified>nonVerified){
         System.out.println("verified customers gives average more output for the same product");
         
         }
         else{
         System.out.println("verified customers gives average more output for the same product");
         }
         
    }
}