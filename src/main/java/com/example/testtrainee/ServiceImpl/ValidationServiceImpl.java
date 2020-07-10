package com.example.testtrainee.ServiceImpl;

import com.example.testtrainee.Service.ValidationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public String checkIfPoinMoreZero(ArrayList<ArrayList<Double>> list) {
        ArrayList<Double> X = list.get(0);
        ArrayList<Double> Y = list.get(1);
        for (int i=0;i<X.size();i++){
            if (X.get(i)<0) {
                return " Point " + X.get(i) + "less than 0";
            }
        }
        for (int i=0;i<Y.size();i++){
            if (Y.get(i)<0) {
                return " Point " + Y.get(i) + "less than 0";
            }
        }
        return "OK";
    }

    @Override
    public String checkSize(ArrayList<ArrayList<Double>> list) {
        ArrayList<Double> X = list.get(0);
        ArrayList<Double> Y = list.get(1);
        if (X.size()==Y.size()){
            if (X.size()>4&&Y.size()>4){
                return "OK";
            }else {
                return "ERROR Size has to be  more than 4!";
            }
        }else {
            return "ERROR Size isn't same!";
        }

    }

    @Override
    public String checkByDivisionByOne(ArrayList<ArrayList<Double>> list) {
        ArrayList<Double> X = list.get(0);
        ArrayList<Double> Y = list.get(1);
        for (int i=0;i<X.size();i++){
            if (X.get(i)%1!=0) {
                return " Point " + X.get(i) + "isn't integer!";
            }
        }
        for (int i=0;i<Y.size();i++){
            if (Y.get(i)%1!=0) {
                return " Point " + Y.get(i) + "isn't integer!";
            }
        }
        return "OK";
    }

    @Override
    public String cheackduplicate(ArrayList<ArrayList<Double>> list) {
        // не потрібно цієї перевірки
        ArrayList<Double> X = list.get(0);
        ArrayList<Double> Y = list.get(1);
        for (int i = 0; i <X.size()-1 ; i++) {
            for (int j = i+1; j <X.size() ; j++) {
                if (X.get(i).equals(X.get(j))&&Y.get(i).equals(Y.get(j))){
                    return "ERROR ";
                }
            }
        }
        return null;
    }

    @Override
    public String checkByRightAngle(ArrayList<ArrayList<Double>> list) {
        ArrayList<Double> X = list.get(0);
        ArrayList<Double> Y = list.get(1);
        for (int i = 1; i < X.size(); i++) {
            if (!X.get(i).equals(X.get(i-1))){
                if (!Y.get(i).equals(Y.get(i-1))){
                    return "ERROR point x = "+ X.get(i)+" y= "+Y.get(i)+ " doesn't made right angle!";
                }
            }
        }
        return "OK";
    }

    @Override
    public String cheackInfinity(ArrayList<ArrayList<Double>> list) {

        ArrayList<Double> X = list.get(0);
        ArrayList<Double> Y = list.get(1);
        if (X.get(0).equals(X.get(X.size()-1))){
            if (Y.get(0).equals(Y.get(Y.size()-1))){
                return "OK";
            }else {
                return "ERROR Infinity!";
            }
        }else {
            return "ERROR Infinity!";
        }
//        return null;
    }

    @Override
    public String cheackBrokenLines(ArrayList<ArrayList<Double>> list) {
        ArrayList<Double> X = list.get(0);
        ArrayList<Double> Y = list.get(1);
        for (int i=1;i<X.size();i++){
            if (!X.get(i).equals(X.get(i-1))){
                if (!Y.get(i).equals(Y.get(i-1))){
                    return "ERROR Broken Line";
                }
            }
        }
        return "OK";
    }

//    @Override
//    public String cheaсkCrossing(ArrayList<ArrayList<Double>> list) {
//        ArrayList<Double> X = list.get(0);
//        ArrayList<Double> Y = list.get(1);
//        for (int i=4;i<X.size();i++){
//            // вибір точки для перетину
//            // не враховуєм ост точку оскіки буде порівняння між собою
//            for (int j =0;j<X.size()-2;j++){
//                // перевірки коли одна із точок співпадає
//                if (X.get(i)==X.get(j)){
//                    // перевірка на перетин по у
//                    if (Y.get(i)<Y.get(j)&&Y.get(i)>Y.get(j+1)){
//                        return "ERROR crossing";
//                    }
//                }else if (Y.get(i)==Y.get(j)){
//                    // перевірка на перетин по x
//                    if (X.get(i)<X.get(j)&&X.get(i)>X.get(j+1)){
//                        return "ERROR crossing";
//                    }
//                }
//            }
//        }
//        return "ОК";
//    }

    @Override
    public String cheaсkCrossing(ArrayList<ArrayList<Double>> list) {
        ArrayList<Double> X = list.get(0);
        ArrayList<Double> Y = list.get(1);
        for (int i = 3; i <X.size() ; i++) {

            //відрізок який перевіряєм
            double x11 = X.get(i);
            double x12 = X.get(i-1);
            double y11 = Y.get(i);
            double y12 = Y.get(i-1);

            //відрізок з яким перевіряєм
            double x21 = X.get(i-2);
            double  x22 = X.get(i-3);
            double y21 = Y.get(i-2);
            double y22 = Y.get(i-3);

            // із рівняння прямих
           double K1 = (y12-y11)/(x12-x11);
           double K2 = (y22-y21)/(x22-x21);
           double d1 = (x12*y11-x11*y12)/(x12-x11);
           double d2 = (x22*y21*y22)/(x22-x21);

           double x = (d2-d1)/(K1-K2);
           double y = K1*(d2-d1)/(K1-K2)+d1;
           // перевірка чи точка належить до відрізку із яким ми перевіряєм
            // за
           double vur1 = (x-x22)*(y21-y22);
           double vur2 = (y-y22)*(y21-y22);
           if (vur1==vur2){
               // точка належить відрізку отрже сторони перетинаються
               return "ERROR Crosing!";
           }

        }
        return "OK";
    }

    @Override
    public String cheackByNullElement(ArrayList<ArrayList<Double>> list) {
        ArrayList<Double> X = list.get(0);
        ArrayList<Double> Y = list.get(1);
        for (Double  d:X ) {
            if (d.equals(null)){
                return "ERROR null Element";
            }
        }
        for (Double  d:Y ) {
            if (d==null){
                return "ERROR null Element";
            }
        }
        return "OK";
    }
}
