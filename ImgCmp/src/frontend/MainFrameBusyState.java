/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author Tamaran
 */
public class MainFrameBusyState extends MainFrameState{
    
    private static final String ALREADY_RUNNING = "A Task is already running";
    
    public MainFrameBusyState(MainFrame mainFrame) {
        super(mainFrame);
    }

    @Override
    public void searchDir() {
        mainFrame.msg(ALREADY_RUNNING);
    }
    
    
    
}
