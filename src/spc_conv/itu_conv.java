/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spc_conv;

import java.util.Scanner;

/**
 * Klasa zawiera metody konwersji SPC w formacie 3-8-3 ITU-T
 * @author dudadam1
 */
public class itu_conv {
    
    // 
    /**
     * Method checks if SPC is valid ITU-T formatted string.
     * 
     * The ITU-T format is "3-8-3" bits textual string.
     * 1. Check if string is dash-separated.
     * 2. Check if numbers are in range 0-7 first and last, 0-255 middle.
     * package scoped, private is not visible in the JUnit class.
     * 
     * @param SPC
     * @return 
     */
    boolean is_valid_383(String SPC, Integer result){
        
        String[] numbers_tab = SPC.split("-");
        int spc_tab[] = new int[3];
        
        Scanner sc; 
        
        // First - are there three numbers?
        if(numbers_tab.length != 3){
            // the count of numbers is not valid
            return false;
        }
            
        // Second - are all elements valid integers?
        
        for (int i=0; i<3; i++){
            sc = new Scanner(numbers_tab[i]);
            if (sc.hasNextInt()){
                spc_tab[i] = sc.nextInt();
            }
            else {
                // some element is not a number
                return false;
            }
                

        }
        
        
        System.out.println("numbers_tab:");
        for(String spce : numbers_tab){
            System.out.println(spce);            
        }
        for(int i=0; i<3; i++)
            System.out.println("value: " + numbers_tab[i]);
        //Integer.valueOf(SPC);
        
        result = spc_tab[2] * 2048 + spc_tab[1]*8 + spc_tab[0];
        
        return true;
    }
    
    /**
     * Przelicza string 3-8-3 na wartość numeryczną.
     * 
     * TODO Ma wywoływać is_383_valid, a z programu głównego tylko ta ma być.
     * 
     * @param SPC
     * @return 
     */
    int countItuValue(String SPC){
        return 0;
    }
}
