package ua.edu.ucu;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import java.util.Arrays;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return (((Student) t).getGPA() >= 4.0 && ((Student) t).getYear() == 2);
            }
        };
        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String sur1 = ((Student) o1).getSurname();
                String sur2 = ((Student) o2).getSurname();
                return sur1.compareTo(sur2);
            }
        };
        SmartArray sa = new BaseArray(students);
        sa = new DistinctDecorator(sa);
        sa = new FilterDecorator(sa, pr);
        sa = new SortDecorator(sa, cmp);
        Object[] arr = sa.toArray();
        String[] result = new String[arr.length];
        for (int i = 0 ; i < arr.length ; i ++){
            String sur1 = ((Student) arr[i]).getName();
            String sur2 = ((Student) arr[i]).getSurname();
            result[i] = sur2 + " " + sur1;
        }
        return result;
    }
}
