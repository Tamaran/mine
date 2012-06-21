/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import backend.util.CalculationStep;
import java.util.ArrayList;
import java.util.List;
import log.Log;

/**
 *
 * @author Tamaran
 */
public class ImageComparatorStep extends CalculationStep<ImageData> {
    
    private List<ImageData> checked = new ArrayList();
    private List<ResultGroup> result = new ArrayList();

    @Override
    public void perform(ImageData a) {
        
        ResultGroup group = new ResultGroup();
        ImageComparator comp = new ImageComparator();
        group.add(a.getFile());
        for(ImageData b : checked)
            if(comp.compare(a, b))
                group.add(a.getFile());
        if(group.size() > 1){
            result.add(group);
        }
        checked.add(a);
        
    }

    public List<ResultGroup> getResult() {
        return result;
    }
    
    
    
}
