package analisadorlexico;

public class AnaliseLexica {
    private String s;
    private int i;
    
    public AnaliseLexica(String s){
        this.s = s;
        this.i = 0;
    }
    
    public char cabecote(){
        if((i < s.length()) && (s.length() > 0)){
            return s.charAt(i);
        }else{
            return '?';
        }
    }
    
    public Boolean analisador(){
        char c;
        c = cabecote();
        i++;
        
        if(Character.isLetter(c)){
            while(Character.isDigit(c) && (i<= s.length())){
                c = cabecote();
                i++;
            }
            if(i > s.length()){
                return true;
            }else{
                return false;
            }
        }else if(Character.isDigit(c)){
            while(((Character.isDigit(c)) && (i <= s.length()))){
                c = cabecote();
                i++;
            }
            if(i > s.length()){
                return true;
            }else{
                return false;
            }
        }else if(c == 'C'){
            c = cabecote();
            i++;
            if(c == '*'){
                while(i < (s.length() -2)){
                    c = cabecote();
                    i++;
                }
                
                c = cabecote();
                i++;
                if(c == '*'){
                    c = cabecote();
                    i++;
                    if(c == ')'){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
                
            }else{
                return false;
            }
        }else{
            return false;
        }   
    }
    
}
