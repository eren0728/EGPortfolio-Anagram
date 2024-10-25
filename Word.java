import java.util.*;
/**The Word class program implements Comparable interface. Represented by 
 * the original word and canonical form. 
 * This program allows you to create Word objects that will get their original word 
 * and canonical form, and compare Word object based on their canonical form. 
 * @author EG
 * @version 05/15/2023
 */
public class Word implements Comparable<Word> { 
   private String originalWord;
   private String canonicalForm;
   
   private String canonicalForm(String word) {
   char[] s = word.toCharArray();   
   //java.util.Arrays.sort sorts increasing order 
   //java.util.Arrays.sort() needs element type of array that needs to 
   //implement in the Comparable interferace 
   java.util.Arrays.sort(s); 
   return new String(s); 
   }
   
/** Constructor to store the original word and canonical form 
 * kept the original word and canonical form to lowercase 
 * @param x is the original word for the Word object 
 */   
   public Word(String x) { 
   this.originalWord = x.toLowerCase();
   this.canonicalForm = canonicalForm(this.originalWord); 
   }
   
/** A method that returns the original word 
 * @return returns the original word that is unmodified 
 */
   public String getWord() {
      return this.originalWord; 
   }
/** A method that returns the canonical form word 
 * @return returns the canonical form of the word 
 */
   public String getForm() { 
      return this.canonicalForm; 
   }
/**  @override
 * @return return the original word and canonical form in format "[word = dorw]"
 */  
   public String toString() { 
      return ( "[" + this.originalWord +  "=" + this.canonicalForm + "]" ); 
   }
/** Method that compares 
 * @param x is the Word object that is being compared to canonical form
 * @returns either a positive, negative or 0 integer when comparing canonical form with the 
 * Word object 
 */
   public int compareTo (Word x) { 
      return this.canonicalForm.compareTo(x.getForm()); 
   }
   
}