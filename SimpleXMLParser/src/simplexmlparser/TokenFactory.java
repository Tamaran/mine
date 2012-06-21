/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplexmlparser;

import java.util.HashMap;

/**
 *
 * @author Tamaran
 */
public class TokenFactory {
    
    private HashMap<String, Token> tokens = new HashMap();
    
    public Token createToken(String s, TokenType t){
        
        Token r = tokens.get(s);
        if(r == null){
            r = new Token(s, t);
            tokens.put(s, r);
        }
        return r;
    }
    
}
