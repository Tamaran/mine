/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import backend.util.CalculationStep;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tamaran
 */
public class ComparatorDriver {

    private static final int NTHREADS_IMAGEREADER = 2;

    public List<ResultGroup> compareFiles(List<File> in) {

        Thread[] frThreads, irThreads, icsThreads;

        ImageComparatorStep ics = new ImageComparatorStep();
        ImageReader ir = new ImageReader();
        FileReader fr = new FileReader(in);
        
        fr.dispose();
        fr.setImageReader(ir);
        ir.setNext(ics);
        
        frThreads = runInSeperateThreads(fr, 1);
        irThreads = runInSeperateThreads(ir, NTHREADS_IMAGEREADER);
        icsThreads = runInSeperateThreads(ics, 1);
        
        joinAll(frThreads);
        ir.dispose();
        joinAll(irThreads);
        ics.dispose();
        joinAll(icsThreads);
        
        return ics.getResult();
    }

    private void joinAll(Thread[] a){
        for(Thread t : a)
            try {
            t.join();
        } catch (InterruptedException ex) {}
    }

    private Thread[] runInSeperateThreads(final CalculationStep<?> step, int n) {

        Thread[] out = new Thread[n];
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    step.run();
                }
            });
            t.start();
            out[i] = t;
        }

        return out;
    }
}
