package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private int size;
    private Object[] arr;

    public BaseArray(Object[] integers) {
        arr = integers;
        size = arr.length;
    }

    public Object[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    public String operationDescription() {
        return "BaseArray";
    }

    public int size() {
        return size;
    }
}
