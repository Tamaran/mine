/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.util;

import java.util.ArrayList;
import java.util.List;
import log.Log;

/**
 *
 * @author Tamaran
 */
public abstract class CalculationStep<T> {

    private final List<T> list;
    private boolean disp;

    public CalculationStep() {
        list = new ArrayList();
    }

    public CalculationStep(List<T> l) {
        list = l;
    }

    public void run() {

        long t;
        T e;
        out:
        while (true) {
            synchronized (list) {

                if (disp && list.isEmpty()) {
                    break out;
                }
                if (list.isEmpty()) {
                    try {
                        list.wait();
                        continue;
                    } catch (InterruptedException ex) {
                    }
                }
                e = list.remove(list.size() - 1);
            }
            t = System.currentTimeMillis();
            perform(e);
            t = System.currentTimeMillis()-t;
            Log.msg(this.getClass().getName()+": finished Task ("+e+") after "+t+"ms");
        }

    }

    public void add(T e) {
        synchronized (list) {
            list.add(e);
            list.notify();
        }
    }

    public void dispose() {
        synchronized (list) {
            disp = true;
            list.notifyAll();
        }
    }

    public abstract void perform(T e);
}
