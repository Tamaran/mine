
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplexmlparser;

import simplexmlparser.entitys.XMLDocument;
import simplexmlparser.entitys.XMLElement;

import static simplexmlparser.TokenType.*;
import simplexmlparser.entitys.XMLProperty;

/**
 *
 * @author Tamaran
 */
public class Parser {
    
    private static final String XML = "xml";
    
    private final Tokenizer t;
    private XMLDocument doc;

    public Parser(Tokenizer t) {
        this.t = t;
        doc = readDocument();
    }
    
    public XMLDocument getResult(){
        return doc;
    }
    
    private XMLDocument readDocument(){
        XMLDocument doc = new XMLDocument();
        doc.setDeclaration(readDeclaration());
        doc.addChild(readElement());
        return doc;
    }
    
    private XMLDeclaration readDeclaration(){
      
        Token leftbracket = t.getNext();
        if(leftbracket.getType() != LEFT_BRACKET)
            throwParseError();
        Token que = t.getNext();
        if(que.getType() != QUEST)
            throwParseError();
        Token xml = t.getNext();
        if(!xml.getText().equals(XML))
            throwParseError();
        
    }
    
    private List<XMLProperty> readTagPropertys(){
        
        
        
    }
    
    private XMLProperty readProperty(){
        Token prop = t.getNext();
        String[] tmp = prop.getText().split("=");
        tmp[1] = tmp[1].replaceAll("[\"']", "");
        return new XMLProperty(tmp[0], tmp[1]);
    }
    
    private XMLElement readElement(){
        XMLElement ele = new XMLElement();
        return ele;
    }
    
    private void throwParseError(){
        throw new RuntimeException("Parse error near "+t.getIndex());
    }
}
>>>>>>> cde1127f65dfcc579650fb118f3edeaad2277637
