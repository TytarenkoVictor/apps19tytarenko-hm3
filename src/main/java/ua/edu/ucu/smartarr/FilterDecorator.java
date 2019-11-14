package ua.edu.ucu.smartarr;

import java.util.*;
import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    private MyPredicate pred;
    private int size = 0;

    public FilterDecorator(SmartArray sa, MyPredicate pred) {
        super(sa);
        this.pred = pred;
    }

    public Object[] toArray() {
        ArrayList<Object> finall = new ArrayList<>();
        for (Object k : smartArray.toArray()) {
            if (pred.test(k)) {
                finall.add(k);
                size += 1;
            }
        }
        return finall.toArray();
    }

    public String operationDescription() {
        return "Filter " + smartArray.operationDescription();
    }

    public int size() {
        return size;
    }
}
