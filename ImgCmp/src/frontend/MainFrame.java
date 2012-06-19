/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.ResultGroup;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Tamaran
 */
public class MainFrame extends JFrame{
    
    private static final String TITLE = "Image Comparator",
                                SEARCH = "Search",
                                SEARCHDIR = "Search Dir",
                                DEBUG = "Debug",
                                OTHER = "Other";
    private static final Dimension INITSIZE = new Dimension(1024, 816);
    
    private final DebugFrame df;
    private final MainFrameStateFactory states;
    
    private JPanel backPane, centerPane;
    private JScrollPane centerScrollPane;
    private JMenuBar mymenubar;
    private JMenu searchmenu, otherMenu;
    private JMenuItem searchDirItem, debug;
    
    private boolean busy;
    
    public MainFrame(){
        
        this.setLayout(new BorderLayout());
        this.setJMenuBar(getMyMenuBar());
        this.add(getBackPane(), BorderLayout.CENTER);
        this.setTitle(TITLE);
        this.setSize(INITSIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        states = new MainFrameStateFactory(this);
        df = new DebugFrame();
    }
    
    public boolean isBusy(){
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    private JMenuBar getMyMenuBar(){
        if(mymenubar == null){
            mymenubar = new JMenuBar();
            mymenubar.add(getSearchmenu());
            mymenubar.add(getOtherMenu());
        }
        return mymenubar;
    }
    
    private JMenu getOtherMenu(){
        if(otherMenu == null){
            otherMenu = new JMenu(OTHER);
            otherMenu.add(getDebug());
        }
        return otherMenu;
    }
    
    private JMenu getSearchmenu(){
        if(searchmenu == null){
            searchmenu = new JMenu(SEARCH);
            searchmenu.add(getSearchDirItem());
        }
        return searchmenu;
    }
    
    private JMenuItem getSearchDirItem(){
        if(searchDirItem == null){
            searchDirItem = new JMenuItem(SEARCHDIR);
            searchDirItem.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    states.getState().searchDir();
                }
                
            });
        }
        return searchDirItem;
    }
    
    private JPanel getBackPane(){
        if(backPane == null){
            backPane = new JPanel();
            backPane.setLayout(new BorderLayout());
            backPane.add(getCenterScrollPane(), BorderLayout.CENTER);
        }
        return backPane;
    }
    
    private JScrollPane getCenterScrollPane(){
        if(centerScrollPane == null){
            centerScrollPane = new JScrollPane();
            centerScrollPane.setViewportView(getCenterPane());
        }
        return centerScrollPane;
    }
    
    private JPanel getCenterPane(){
        if(centerPane == null){
            centerPane = new JPanel();
        }
        return centerPane;
    }
    
    private JMenuItem getDebug(){
        if(debug == null){
            debug = new JMenuItem(DEBUG);
            debug.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    df.setVisible(true);
                    df.toFront();
                }
                
            });
        }
        return debug;
    }

    public void msg(String s) {
        JOptionPane.showMessageDialog(this, s, "!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setResult(List<ResultGroup> result) {
        System.out.println(result);
    }
}
