package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import java.util.*;


// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    private int size = 0;
    private MyComparator compar;

    public SortDecorator(SmartArray sa, MyComparator compar) {
        super(sa);
        this.compar = compar;
    }

    public Object[] toArray() {
        ArrayList<Object> finall = new ArrayList<>(Arrays.asList(smartArray.toArray()));
        finall.sort(compar);
        size = finall.size();
        return finall.toArray();
    }

    public String operationDescription() {
        return "Sort " + smartArray.operationDescription();
    }

    public int size() {
        return size;
    }
}
