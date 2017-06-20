public class StringIterator {

   private int number;
   private char letter;
   private int index;
   private String str;

   public StringIterator(String compressedString) {
       str = compressedString;
       index = 0;
       number = 0;
       letter = ' ';
   }

   public char next() {

       if(hasNext()) {
           if(number == 0) {
               // get character
               letter = str.charAt(index);

               // get number
               index ++;
               while(index < str.length() && Character.isDigit(str.charAt(index))) {
                   number = number * 10 + str.charAt(index) - '0';
                   index ++;
               }
           }

           number --;
           return letter;
       }
       else return ' ';

   }

   public boolean hasNext() {
       return (number != 0) || (index < str.length());
   }

}

/**
* Your StringIterator object will be instantiated and called as such:
* StringIterator obj = new StringIterator(compressedString);
* char param_1 = obj.next();
* boolean param_2 = obj.hasNext();
*/
