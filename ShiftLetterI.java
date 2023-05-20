/* You are given a string s of lowercase English letters and an integer array shifts of the same length. Call the 
shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a'). For example, 
shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'. Now for each shifts[i] = x, we want to shift the first 
i + 1 letters of s, x times. Return the final string after all such shifts to s are applied.
* Eg 1 :  word = "abc"          shifts = [3,5,9]                 Output = "rpl"
* Eg 2 :  word = "aaa"          shifts = [1,2,3]                 Output = "gfd"
*/
import java.util.*;
public class ShiftLetterI
{
      public String ShiftingLetters(int shifts[], String word)
      {
            int DPshift[] = new int[word.length()];       //*  DP Array -> O(N)
            DPshift[DPshift.length - 1] = shifts[shifts.length - 1] % 26;    // Reducing the sum to 26 range...
            for(int i = DPshift.length - 2; i > -1; i--)     //! Evaluation -> O(N)
                  DPshift[i] = (DPshift[i + 1] + shifts[i]) % 26;     // Reducing sum to 26 range...
            char ch[] = word.toCharArray();     //* Character Array Conversion -> O(N)
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < ch.length; i++)     //! Evaluation -> O(N)
            {
                  int ASCII = (int)(ch[i]);
                  ASCII = ASCII + DPshift[i];
                  ch[i] = (char)(ASCII);
                  builder.append(ch[i]);    // String builder append technique...
            }
            return builder.toString();    // Returning the shifted string...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            String s;
            System.out.print("Enter the String : ");
            s = sc.next();
            int array[] = new int[s.length()];
            for(int i = 0; i < array.length; i++)
            {
                  System.out.print("Enter shifts at "+i+" th index : ");
                  array[i] = sc.nextInt();
            }
            ShiftLetterI shiftletterI = new ShiftLetterI();     // Objecr creation...
            System.out.println("The Word after Shifting letters : "+shiftletterI.ShiftingLetters(array, s));
            sc.close();
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(N)
/** //? DEDUCTIONS -
 * ? We use a DP arrya to check the number of shits each index requires dynamically...
 */