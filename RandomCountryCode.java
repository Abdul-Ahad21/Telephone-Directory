package Project;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Random;

/**
 *
 * @author User
 */
public class RandomCountryCode {
    // function to generate a random country code
    static String getCode()
    {
        int n=0;
        String[] Codes = {"+92" , "+861" , "+44", "+61" , "+33" , "+34" , "+55" ,"+54", "+1"};// pak , china, uk , australia , france , spain , brazil , argentina , USA
        String code;
        Random r= new Random();
        int i=r.nextInt(9);
        code=Codes[i];
        
        return code;
    }
}
