/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplexmlparser;

/**
 *
 * @author Tamaran
 */
public class SimpleXMLParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "<A>asdf</A>";
        Tokenizer t = new Tokenizer(s);
        while(t.hasNext())
            System.out.println(t.getNext());
    }
}
