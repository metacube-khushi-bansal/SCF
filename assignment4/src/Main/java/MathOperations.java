package Main.java;

public class MathOperations {

   public int calculateHcfOfTwoNumbers(int num1, int num2)
   {
    if(num1 <0 || num2 < 0)
    throw new IllegalArgumentException("Input must be positive : Enter valid!");

    if(num1 ==0 && num2 ==0)
    throw new ArithmeticException("Cant Find the HCF of 0 and 0! Enter valid");

    if(num2 == 0)
    return num1;

    else{
        return calculateHcfOfTwoNumbers(num2, num1% num2);
    }
    
   }

   public int calculateLCMOfTwoNumbers(int num1, int num2)
   {      
          if(num1 <0 ||num2 <0)
          throw new IllegalArgumentException("Input must be positive : Enter valid!");


          int ans =( num1 * num2) / calculateHcfOfTwoNumbers(num1, num2);
          return ans;
   }




}
