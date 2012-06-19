/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tamaran
 */
public class MainFrame extends JFrame{
    
    private static final Dimension DEFAULTSIZE = new Dimension(1024, 816);
    
    private static final ImageAlgo[] algos = new ImageAlgo[]{
        new Absoluter(),
        new Laplace(),
        new Sobel(),
        new MinFilter(),
        new MedianFilter(),
        new AvgFilter(),
        new Fourier(),
        new Contraster()
    };
    
    private ImagePane left, right;
    private JPanel centerPane;
    private JMenuBar mBar;
    private JMenu filesMenu, algosMenu;
    private JMenuItem loadItem, resetItem;
    
    private MainFrameController cont;
    
    public MainFrame(){
        
        this.setLayout(new BorderLayout());
        this.setJMenuBar(getMBar());
        this.add(getCenterPane());
        
        this.setSize(DEFAULTSIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cont = new MainFrameController(this);
    }
    
    private JMenuBar getMBar(){
        if(mBar == null){
            mBar = new JMenuBar();
            mBar.add(getFilesMenu());
            mBar.add(getAlgosMenu());
        }
        return mBar;
    }
    
    private JMenu getAlgosMenu(){
        if(algosMenu == null){
            algosMenu = new JMenu("Algorithms");
            for(ImageAlgo a : algos)
                algosMenu.add(createAlgoItem(a));
        }
        return algosMenu;
    }
    
    private JMenuItem createAlgoItem(final ImageAlgo a){
        JMenuItem item = new JMenuItem(a.getName());
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cont.performAlgo(a);
            }
        });
        return item;
    }
    
    private JMenu getFilesMenu(){
        if(filesMenu == null){
            filesMenu = new JMenu("Files");
            filesMenu.add(getLoadItem());
            filesMenu.add(getResetItem());
        }
        return filesMenu;
    }
    
    private JMenuItem getLoadItem(){
        if(loadItem == null){
            loadItem = new JMenuItem("Load");
            loadItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    cont.loadPressed();
                }
            });
        }
        return loadItem;
    }
    
    private JMenuItem getResetItem(){
        if(resetItem == null){
            resetItem = new JMenuItem("Reset");
            resetItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    cont.resetPressed();
                }
            });
        }
        return resetItem;
    }
    
    private JPanel getCenterPane(){
        if(centerPane == null){
            centerPane = new JPanel();
            centerPane.setLayout(new GridLayout(1,2));
            centerPane.add(createLeft());
            centerPane.add(createRight());
        }
        return centerPane;
    }
    
    private ImagePane createLeft(){
        if(left == null){
            left = new ImagePane();
        }
        return left;
    }
    
    private ImagePane createRight(){
        if(right == null){
            right = new ImagePane();
        }
        return right;
    }

    public ImagePane getLeft() {
        return left;
    }

    public ImagePane getRight() {
        return right;
    }

    
}
