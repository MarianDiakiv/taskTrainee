package com.example.testtrainee.Service;

import java.util.ArrayList;

public interface ValidationService {
    String checkIfPoinMoreZero(ArrayList<ArrayList<Double>> list);
    String checkSize(ArrayList<ArrayList<Double>> list);
    String checkByDivisionByOne(ArrayList<ArrayList<Double>> list);
    String checkByRightAngle(ArrayList<ArrayList<Double>> list);
    String cheackduplicate(ArrayList<ArrayList<Double>> list);
    String cheackInfinity(ArrayList<ArrayList<Double>> list);
    String cheaсkCrossing(ArrayList<ArrayList<Double>> list);
    String cheackBrokenLines(ArrayList<ArrayList<Double>> list);
    String cheackByNullElement(ArrayList<ArrayList<Double>> list);


}
