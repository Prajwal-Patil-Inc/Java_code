class CipherDecipher{
  
    public String ciphering(String normal){
        String res = "";
        char ch[] = normal.toCharArray();
        //Swapping
        for(int i=0; i < ch.length; i++){
            //if any character is not in upper case
            if(Character.isUpperCase(ch[i])){
                ch[i] = Character.toLowerCase(ch[i]);
            }
            else{
                ch[i] = Character.toUpperCase(ch[i]);
            }
        }
        String upca = String.valueOf(ch); 
        
        StringBuilder str = new StringBuilder(upca); 
        
        // reverse the string 
        StringBuilder reverseStr = str.reverse(); 
        res = reverseStr.toString();
        
        //Replace whitespaces
        String replaceString = res.replace(' ','*');  
        
        //Ascii conversion
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<replaceString.length(); i++){
            if(i%2!=0){
                int m = replaceString.charAt(i);
                sb.append(m);
            }
            else{
                sb.append(replaceString.charAt(i));
            }
        }
        //Append
        sb.append("3");
        res = sb.toString();
        
        return res;
    }
    /**
     * This method is used to get the normal text by the reverse process of ciphering.
     * 
     * @param ciphered
     * @return the deciphered message
     */
    public String deciphering(String ciphered){
        String res = "";
        //Remove
        res = ciphered.substring(0, ciphered.length()-1);
        
        //Normal conversion
        int num = 0;
	    char c[] = res.toCharArray();
 	    StringBuilder sb = new StringBuilder();
         for (int i = 0; i <res.length(); i++) { 
            if(Character.isDigit(res.charAt(i))){
                num = num * 10 + (res.charAt(i) - '0'); 
                if (num >= 32 && num <= 122) { 
                    char ch = (char)num; 
                    sb.append(ch);
                    //System.out.print(ch); 
                    num = 0; 
                } 
            }
            else{
                sb.append(res.charAt(i));
                //System.out.print(str.charAt(i));
            }
        }
        res = sb.toString();
        res = res.replace('*',' ');
        
        
        StringBuilder str = new StringBuilder(res); 
        StringBuilder reverseStr = str.reverse(); 
        res = reverseStr.toString();
        
        
        char ch[] = res.toCharArray();
        //Swapping
        for(int i=0; i < ch.length; i++){
            //if any character is not in upper case
            if(Character.isUpperCase(ch[i])){
                ch[i] = Character.toLowerCase(ch[i]);
            }
            else{
                ch[i] = Character.toUpperCase(ch[i]);
            }
        }
        res = String.valueOf(ch);
        
        return res;
    }
}
