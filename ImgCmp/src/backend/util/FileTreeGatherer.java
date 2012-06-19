/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tamaran
 */
public class FileTreeGatherer {
    
    public List<File> getAll(File dir){
        List<File> l = new ArrayList();
        internGetAll(dir, l);
        return l;
    }
    
    private void internGetAll(File dir, List<File> l){
        
        File[] files = dir.listFiles();
        if(files == null)
            return;
        for(File f : files){
            if(f.isDirectory())
                internGetAll(f,l);
            else
                l.add(f);
        }
    }
    
}
