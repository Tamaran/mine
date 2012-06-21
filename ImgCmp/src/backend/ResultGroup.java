/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tamaran
 */
public class ResultGroup {
    
    private List<File> files = new ArrayList();
    
    public void add(File f){
        files.add(f);
    }

    public int size() {
        return files.size();
    }
    
    public String toString(){
        return files.toString();
    }

    public List<File> getFiles() {
        return files;
    }
    
    
}
