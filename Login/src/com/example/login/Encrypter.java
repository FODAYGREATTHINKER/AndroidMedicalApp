// Done by Derek
package com.example.login;

/**
 *
 * @author DerekZhan
 */
public class Encrypter {
   static class CaesarCipher {
     private final String KEY = "aAbBc8CdD0eEfFgGh1HiI@4jJkKlL2mM nNoOpP3qQr6RsS5tTuUvV7wWxXy9YzZ";
     public String encrypt(String text,int shiftKey)
     {
           String output="";
           for(int i=0;i<text.length();i++)
           {
                int charPosition = KEY.indexOf(text.charAt(i));
                int keyVal = (shiftKey+charPosition)%62;
                char replaceVal = this.KEY.charAt(keyVal);
                output += replaceVal;
           }
           return output;
     }
     public String decrypt(String text, int shiftKey)
     {
           String output="";
           for(int i=0;i<text.length();i++)
           {
                int charPosition = this.KEY.indexOf(text.charAt(i));
                int keyVal = (charPosition-shiftKey)%62;
                if(keyVal<0)
                {
                      keyVal = this.KEY.length() + keyVal;
                }
                char replaceVal = this.KEY.charAt(keyVal);
                output += replaceVal;
           }
           return output;
     }
}

     public static void main(String args[])
     {
           String plainText = "@ stuSTU0123456789asdfashkowe0a7dg97sd6fg987sd09f8as70e9r8UYTG0 @";
           int shiftKey=4;
          
           CaesarCipher cc = new CaesarCipher();
          
           String cipherText = cc.encrypt(plainText,shiftKey);
           System.out.println(plainText);
           System.out.println(cipherText);
          
           String cPlainText = cc.decrypt(cipherText,shiftKey);
           System.out.println(cPlainText);
     }

}
