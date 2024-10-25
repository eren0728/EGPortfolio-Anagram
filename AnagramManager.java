import java.util.*;
/**AnagramManager class to manage your list of words and find the ncessary anagrams. 
 * this program sorts the words from either original word or canonifcal form
 * gets random anagrams or all anagrams for a given word and obtains a string representation of the object. 
 * @author EG
 * @version 05/15/2023
 */
public class AnagramManager { 
   private List<Word> wordList; 
   private Random rand = new Random(); 

/**Constructor for the word type object given the provided list 
 * @param incListWords the list of words managed by AnagramManager  
 * @throws IllegalArgumentException if the list is null, or empty (size 0)
 */  
   public AnagramManager(List<String> incListWords){
      if (incListWords == null || incListWords.isEmpty()) { // if incListWord equals null or if incListWord is empty 
         throw new IllegalArgumentException("The list of words is null or empty try again."); 
      }
      this.wordList = new ArrayList<>();
      for (String z : incListWords) {
         this.wordList.add(new Word(z));
      }   
   }
   
/**This method is to sort the internal array of words by the actual word value. 
 * Collections.sort is used to sort wordList by using a Comparator. 
 * Comparator compares the word values from getWord method on each Word object
 */ 
   public void sortByWord() {  
     Collections.sort(this.wordList, Comparator.comparing(Word::getWord) ); 
   }
   
/** This method sorts the word by the form of the word. 
 *  sorts the order in an alphabetical sequence
 */
   public void sortByForm() { 
      //sortByForm method sorts the wordList collection by the form of the word 
      //using getForm method of the Word class to compare. 
      Collections.sort(this.wordList, Comparator.comparing(Word::getForm) );  
   }
   
/**This method will return a random word from the container 
 * that has the same canonical form as the word you entered.  
 * @param String x is getting the word 
 * @return return either the input word, or an empty string. 
 */
   public String getAnagram(String x) { 
      Word inputWord = new Word(x); // uses the x in the constructor while store anagram in input word.
      List<String> sameWord = new ArrayList<>(); //create a new array list called sameWord to store anagram
      
      for (Word z : this.wordList){ // for each loop that goes through word for the object in wordList
          //if the compareto is equal 0 return the anagram 
         if (z.compareTo(inputWord) == 0){ 
             //adds the anagram into sameWord 
            sameWord.add(z.getWord());
         }
      }
      //no word is found return an empty string 
      if (sameWord.isEmpty()){
         return "";
     //returns a random selected anagram as the result
      } else { 
         return sameWord.get(rand.nextInt(sameWord.size()) );
      }
   }
   
/**Method is to get the anagram and return a set of all the words
 * that are canonically the same
 * @param String x is getting the word to get the anagram 
 * @return return a set of all the words that are canonically the same 
 */
   public Set<String> getAnagrams(String x) { 
      Word inputWord = new Word(x); 
      //TreeSet to store the anagram found
      Set<String> sameWord = new TreeSet<>(); 
      
      for (Word z: this.wordList) { 
         //if the compareto is equal 0 return the anagram 
         if (z.compareTo(inputWord) == 0) { 
         //adds the anagram into sameWord 
            sameWord.add(z.getWord()); 
         }
     } 
     return sameWord; 
   }
   
/** Method to store the result of an empty string
 * @return return a string of the first 5 and last 5 elements of the word list
 * if the word is greater than 10 it will return [...]
 */
   public String toString() {
   String result = "";  
   int size = wordList.size(); 
   //first 5 vocabulary 
   for (int i = 0; i < Math.min(5,size); i++) { 
      result += wordList.get(i).toString(); 
   }
   //printing of the words if size is greater than 10 
   if (size > 10) { 
      result += "[...]"; 
   }
   // prints the last 5 vocabulary 
   for (int i = Math.max(0, size - 5); i < size; i++) {
      result +=wordList.get(i).toString(); 
   }
   return result; 
   }  
    
}