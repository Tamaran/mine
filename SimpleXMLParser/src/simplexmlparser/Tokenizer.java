/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplexmlparser;

/**
 *
 * @author Tamaran
 */
public class Tokenizer {
    
    private static final String STR_COMMENT = "<!--",
                                STR_LEFT_BRACKET = "<",
                                STR_RIGHT_BRACKET = ">",
                                STR_SLASH = "/",
                                STR_QUEST = "?";
    
    private final TokenFactory factory = new TokenFactory();
    private final String s;
    private Token next;
    private int i;

    public Tokenizer(String s) {
        this.s = s;
        readNext();
    }
    
    
    
    public boolean hasNext(){
        return next != null;
    }
    
    public Token getNext(){
        Token r = next;
        readNext();
        return r;
    }
    
    private void readNext(){
        moveToNextNonSpace();
        if(i >= s.length()){
            next = null;
        }else{
            if(shiftcmp(STR_SLASH)){
                readSlash();
            }else if(shiftcmp(STR_QUEST)){
                readQuestionMark();
            }else if(shiftcmp(STR_COMMENT)){
                jumpOverComment();
                readNext();
            }else if(shiftcmp(STR_LEFT_BRACKET)){
                readLeftBracket();
            }else if(shiftcmp(STR_RIGHT_BRACKET)){
                readRightBracket();
            }else{
                readString();
            } 
        }
    }
    
    private void readQuestionMark(){
        i++;
        next = factory.createToken(STR_QUEST, TokenType.QUEST);
    }
    
    private void readSlash(){
        i++;
        next = factory.createToken(STR_SLASH, TokenType.SLASH);
    }
    
    private void readLeftBracket(){
        i++;
        next = factory.createToken(STR_LEFT_BRACKET, TokenType.LEFT_BRACKET);
    }
    
    private void readRightBracket(){
        i++;
        next = factory.createToken(STR_RIGHT_BRACKET, TokenType.RIGHT_BRACKET);
    }
    
    private void readString(){
        int j = i;
        while(j < s.length()&&!isStringEndChar(s.charAt(j)))
            j++;
        next = factory.createToken(s.substring(i, j), TokenType.STR);
        i = j;
    }
    
    private void moveToNextNonSpace(){
        
        while(i < s.length() && s.charAt(i) == ' ')
            i++;
        
    }
    
    private boolean shiftcmp(String str){
        
        for(int i = 0; i < str.length(); i++)
            if(str.charAt(i) != s.charAt(i+this.i))
                return false;
        return true;
    }
    
    private void jumpOverComment(){
        while(i < s.length()&&s.charAt(i)!='>')
            i++;
    }
    
    private boolean isStringEndChar(char c){
        switch(c){
            case ' ':
            case '=':
            case '>':
            case '<':   
            return true;
        }
        return false;
    }
    
    public int getIndex(){
        return i;
    }
}
