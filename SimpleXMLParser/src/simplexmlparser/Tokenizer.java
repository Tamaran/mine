/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplexmlparser;

import java.util.ArrayList;
import java.util.List;

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
    private final List tokens = new ArrayList();
    private final String s;
    private int i;

    public Tokenizer(String s) {
        this.s = s;
        while(i < s.length()){
            readNext();
        }
    }

    public List getTokens() {
        return tokens;
    }
    
    

    private void readNext(){
        moveToNextNonSpace();
        if(i >= s.length()){
            return;
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
        addToken(STR_RIGHT_BRACKET, TokenType.RIGHT_BRACKET);
    }
    
    private void readString(){
        int j = i;
        while(j < s.length()&&!isStringEndChar(s.charAt(j)))
            j++;
        addToken(s.substring(i, j), TokenType.STR);
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
    
    private void addToken(String s, TokenType t){
        tokens.add(factory.createToken(s, t));
    }
    
    public int getIndex(){
        return i;
    }
}
