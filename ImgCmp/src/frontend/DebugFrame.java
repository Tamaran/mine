/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.awt.*;
import javax.swing.*;
import log.Log;
import log.MsgReceiver;

/**
 *
 * @author Tamaran
 */
public class DebugFrame extends JFrame{
    
    private static final Dimension INITSIZE = new Dimension(512, 512);
    
    private JTextArea text;
    
    public DebugFrame(){
        text = new JTextArea();
        text.setEditable(false);
        JScrollPane sc = new JScrollPane();
        sc.setViewportView(text);
        this.setLayout(new BorderLayout());
        this.add(sc, BorderLayout.CENTER);
        Log.getInstance().addReceiver(new MsgReceiver() {

            @Override
            public void msg(String s) {
                text.append(s);
            }
        });
        this.setSize(INITSIZE);
        
    }
    
}
