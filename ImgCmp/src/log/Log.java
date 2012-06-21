/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tamaran
 */
public class Log {
    
    private static class SystemOutReceiver implements MsgReceiver{

        @Override
        public void msg(String s) {
            System.out.println(s);
        }
        
    }

    private static final Log inst = new Log();
    private final LinkedList<String> msgs = new LinkedList();
    private final List<MsgReceiver> rec = new ArrayList();
    private boolean disp;

    private Log() {
        rec.add(new SystemOutReceiver());
        Thread t = new Thread(new Runnable(){

            @Override
            public void run() {
                loop();
            }
            
        });
        t.setDaemon(true);
        t.start();
    }
    
    private void loop(){
        
        String s;
        while(true){
            synchronized(msgs){
                if(disp)
                    return;
                if(msgs.isEmpty()){
                    try {
                        msgs.wait();
                    } catch (InterruptedException ex) {}
                    continue;
                }
                s = msgs.removeLast()+"\n";
            }
            for(MsgReceiver r : rec)
                r.msg(s);
        }
        
    }

    private void addString(String s) {
        synchronized(msgs){
            msgs.addFirst(s);
            msgs.notify();
        }
    }

    public void addReceiver(MsgReceiver r){
        synchronized(msgs){
            rec.add(r);
        }
    }

    public static void error(Exception e) {
        StringWriter s = new StringWriter();
        PrintWriter w = new PrintWriter(s);
        e.printStackTrace(w);
        msg(s.toString());
    }

    public static void msg(String s) {
        getInstance().addString(s);
    }
    
    public static Log getInstance(){
        return inst;
    }
}
