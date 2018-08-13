package searchanagram;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class searchAnagram {

	//search anagram
	public static boolean isAnagram(String str1, String str2) 
	{
                   boolean flag;
                   String s1=str1;
                   String s2=str2;
            
                     if(s1.length() != s2.length())
                     	{
                          flag = false;
                       }
                     else
                       {
                      //form character array          
                   	  char[] s1Char = s1.toLowerCase().toCharArray();

                   	  char[] s2Char = s2.toLowerCase().toCharArray();

                      //sort and equate
                   	  Arrays.sort(s1Char);

                   	  Arrays.sort(s2Char);

                   	  flag = Arrays.equals(s1Char, s2Char);
                   	 
                      }
     
                     	return flag;
    }

	//main class
	public static void main(String [] args) throws IOException 
    
    {
    		int count=0;
    		int i,j;
			String longAnag=null;
            int maxlength=0;
        	boolean result,status;
            Scanner s = new Scanner(new File("C:/Users/POOJA VYAS/Documents/Fall'16 Sem1 SMU/Cloud 7346/AnagramInputD.txt"));
            ArrayList<String> list = new ArrayList<String>();
            ArrayList<String> anag= new ArrayList<String>();
            
            while (s.hasNext()) 
            { 
                list.add(s.next());
      
                
            }
            s.close();
           
            for (i = 0; i< list.size();i++)
             { for (j=i+1; j < list.size();j++)
             		 { String str1 = list.get(i);
                     
                       String str2 = list.get(j);
                       
                      
                       
                       	status=isAnagram(str1,str2 );
                       if(status)
                       {
                    	   anag.add(str1);
                       }
             	     }
              
             }
            
            //find unique anagrams
            for (i = 0; i< anag.size();i++)
            { 
         	   for (j=i+1; j < anag.size();j++)
            		 {  String stra1 = anag.get(i);
                   
            		 	String stra2 = anag.get(j);
            
            		 	char[] st1Array = stra1.toLowerCase().toCharArray();
            		 	 
                  	  char[] st2Array = stra2.toLowerCase().toCharArray();

          
                  	  Arrays.sort(st1Array);

                  	  Arrays.sort(st2Array);
                  	  

                  	  result = Arrays.equals(st1Array, st2Array);
                
                  	  	if(result)
                      {
                      	anag.remove(stra2);
                      	
                     }
                  	 
            		 }
            }
         	  for (i = 0; i< anag.size();i++)
              { 
           	   for (j=i+1; j < anag.size();j++)
              		 {  String stra1 = anag.get(i);
                     
              		 	String stra2 = anag.get(j);
              		 	char[] st1Array = stra1.toLowerCase().toCharArray();
              		 	 
                    	  char[] st2Array = stra2.toLowerCase().toCharArray();

            
                    	  Arrays.sort(st1Array);

                    	  Arrays.sort(st2Array);
                    	  

                    	  result = Arrays.equals(st1Array, st2Array);
                    	  
                    	  if (result)
                    	  {
                    		  anag.remove(stra2);
                    	  }
              		 }
            }
            
            for (i=0;i< anag.size();i++)
            {
            		count++;
  		 	}
            //find longest anagram and its length
            for(i=0; i < anag.size();i++)
     	   {
              String strA = anag.get(i);
             
              if(strA.length()>maxlength)
              { maxlength = strA.length();
              longAnag = strA;
              }		
              
     	   }
            //print outputs

             System.out.println("Anagrams in the list are: ");
             System.out.println(anag);
             System.out.println("Count of Unique anagrams: ");
             System.out.println(count);
             System.out.println("The longest Anagram is " + longAnag);
             System.out.println("length of longest anagram is: " + maxlength);
             
                 
    }
             
}
	

