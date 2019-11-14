package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.*;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray sa) {
        super(sa);
    }

    public Object[] toArray() {
        ArrayList<Object> list = new ArrayList<>(Arrays.asList(smartArray.toArray()));
        ArrayList<Object> finall = new ArrayList<>();
        for (Object o : list) {
            int count = 0;
            for (Object value : finall) {
                if (o.toString().equals(value.toString())) {
                    count += 1;
                }
            }
            if (count == 0) {
                finall.add(o);
            }
        }
        return finall.toArray();
    }

    public String operationDescription() {
        return "Distinct" + smartArray.operationDescription();
    }

    public int size() {
        return smartArray.size();
    }
}
