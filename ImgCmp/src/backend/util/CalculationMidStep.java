/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.util;

/**
 *
 * @author Tamaran
 */
public abstract class CalculationMidStep<I,O> extends CalculationStep<I> {
    
    private CalculationStep<O> next;

    @Override
    public void perform(I e) {
        O res = midPerform(e);
        if(res != null)
            next.add(res);
    }
    
    public abstract O midPerform(I in);

    public CalculationStep<O> getNext() {
        return next;
    }

    public void setNext(CalculationStep<O> next) {
        this.next = next;
    }
    
    
    

}
