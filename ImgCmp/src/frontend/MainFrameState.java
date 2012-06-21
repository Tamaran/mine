/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author Tamaran
 */
abstract public class MainFrameState {
    
    protected MainFrame mainFrame;

    public MainFrameState(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    abstract public void searchDir();
    
}
