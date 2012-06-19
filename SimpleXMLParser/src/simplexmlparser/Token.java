/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplexmlparser;

/**
 *
 * @author Tamaran
 */
public class Token {

    private String text;
    private TokenType type;

    public Token(String text, TokenType type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public TokenType getType() {
        return type;
    }
    
    public String toString(){
        return text.toString();
    }
    
}
