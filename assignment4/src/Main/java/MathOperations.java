package Main.java;

public class MathOperations {

   /**
    * To calculate HCF of Two numbers num1, num2
    * 
    * @param num1  - First number to be taken as input
    * @param num2- Second number to be taken as input
    * @return int- The HCF of the numbers
    */
   public int calculateHcfOfTwoNumbers(int num1, int num2) {
      if (num1 < 0 || num2 < 0)
         throw new IllegalArgumentException("Input must be positive : Enter valid!");

      if (num1 == 0 && num2 == 0)
         throw new ArithmeticException("Cant Find the HCF of 0 and 0! Enter valid");

      // Base case
      if (num2 == 0)
         return num1; // if one of the number is zero, HCF is the remaining non-zero number

      else {
         return calculateHcfOfTwoNumbers(num2, num1 % num2); // recursively call the HCF method
      }

   }

   /**
    * To calculate LCM of Two numbers num1, num2
    * 
    * @param num1  - First number to be taken as input
    * @param num2- Second number to be taken as input
    * @return int- The LCM of the numbers
    */
   public int calculateLCMOfTwoNumbers(int num1, int num2) {
      if (num1 < 0 || num2 < 0) 
         throw new IllegalArgumentException("Input must be positive : Enter valid!");

      // finding LCM of two numbers by euclidean formula
      int ans = (num1 * num2) / calculateHcfOfTwoNumbers(num1, num2);
      return ans; 
   }

}
