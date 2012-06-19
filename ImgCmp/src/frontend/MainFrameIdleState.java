/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.ComparatorDriver;
import backend.ResultGroup;
import backend.util.FileTreeGatherer;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import log.Log;

/**
 *
 * @author Tamaran
 */
public class MainFrameIdleState extends MainFrameState {

    public MainFrameIdleState(MainFrame mainFrame) {
        super(mainFrame);
    }

    @Override
    public void searchDir() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                mainFrame.setBusy(true);
                try {
                    ComparatorDriver d = new ComparatorDriver();
                    Log.msg("Choosing Dir");
                    JFileChooser c = new JFileChooser();
                    c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    if (c.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
                        return;
                    }
                    FileTreeGatherer g = new FileTreeGatherer();
                    Log.msg("Reading all files from dir");
                    List<File> files = g.getAll(c.getSelectedFile());
                    Log.msg("Comparing Files");
                    List<ResultGroup> result = d.compareFiles(files);
                    Log.msg("Displaying Result");
                    mainFrame.setResult(result);
                }catch(Exception e){
                    Log.error(e);
                }finally{
                    mainFrame.setBusy(false);
                }
            }
        }).start();
    }
}
