/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplexmlparser.entitys;

/**
 *
 * @author Tamaran
 */
public class XMLProperty {
    
    private String key, value;

    public XMLProperty(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
    
}
