package day0622;

public class Ex_18
{ 
    public static void main(String args[]){ 
         String str1 = "Hello! Java World"; 

         int index = str1.indexOf("Java");
         int size = "Java".length() ; 
         System.out.println(index);

         String str2 = str1.substring(index, index+size);
         str2 = str2.toLowerCase();
         str2 = str2.replace('a', 'A');

         System.out.println(str2);
    }
}