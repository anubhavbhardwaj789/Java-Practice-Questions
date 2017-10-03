//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*


AUTHOR: Anubhav Bhardwaj
Difficulty Level : Medium

*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        
        //First Sort the array so that we can scan the city line sequentially
        Arrays.sort(x);
        
        //Variables
            //For traversing array
        int i=0;
            //Number of Transmitters placed
        int res=1;
     
        int start=x[0];
        int place=x[0];
        
        // Determines wether we are looking for placement of the transmitter or range of transmitter in forward direction
            //true-> looking for placement
            //false-> looking for range
        boolean flag=true; 
        for(i=0;i<n;i++)
        {
            //Looking to place a transmitter           
            if(flag==true )
            {
                if(x[i]>start+k)
                {
                    place=x[i-1];
                    flag=false;
                    //Below is the case if the encountered house is even beyond the range of the transmitter in forward direction
                    if(x[i]>place+k)
                    {
                        start=x[i];
                        flag=true;
                        res++;
                    }
                }
                
                
            }
            //Checking for the forward range of previously placed transmitter transmitter
            else
            {
                if(x[i]>place+k)
                {
                    start=x[i];
                    flag=true;
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
