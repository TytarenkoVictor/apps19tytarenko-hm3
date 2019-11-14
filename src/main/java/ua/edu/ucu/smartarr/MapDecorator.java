package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;


// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private int size = 0;
    private MyFunction f;

    public MapDecorator(SmartArray sa, MyFunction f) {
        super(sa);
        this.f = f;
    }

    public Object[] toArray() {
        Object[] finall = smartArray.toArray();
        for (int i = 0; i < finall.length; i++) {
            finall[i] = f.apply(finall[i]);
            size += 1;
        }
        return finall;
    }

    public String operationDescription() {
        return "Map " + smartArray.operationDescription();
    }

    public int size() {
        return size;
    }
}
