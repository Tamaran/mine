/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author Tamaran
 */
public class MainFrameStateFactory {
    
    private MainFrameBusyState mfbs;
    private MainFrameIdleState mfis;
    private MainFrame frame;
    
    
    public MainFrameStateFactory(MainFrame frame){
        this.frame = frame;
        mfbs = new MainFrameBusyState(frame);
        mfis = new MainFrameIdleState(frame);
    }
    
    public MainFrameState getState(){
        if(frame.isBusy())
            return mfbs;
        return mfis;
    }
    
}
