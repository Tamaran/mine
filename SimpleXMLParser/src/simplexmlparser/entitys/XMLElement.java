/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplexmlparser.entitys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Tamaran
 */
public class XMLElement {
    
    private List<XMLElement> childs = new ArrayList();
    private HashMap<String, String> props = new HashMap();
    
    public void addChild(XMLElement e){
        childs.add(e);
    }
    
    public void addProperty(String k, String v){
        props.put(k, v);
    }
}
