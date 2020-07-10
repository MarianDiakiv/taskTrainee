package com.example.testtrainee.Controller;

import com.example.testtrainee.Service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MainController {
    @Autowired
    private ValidationService validationService;
        @GetMapping("/getstatus")
        public String getStatus(){
        return "OK";
    }
    @PostMapping("/check")
    public String checkPOints(@RequestBody ArrayList<ArrayList<Double>> list){
            for (ArrayList<Double> l:list){
                for (Double i:l){
                    System.out.println(i);
                }
            }

// перевірка
        String s = validationService.cheackByNullElement(list);
            if (s.equals("OK")){
                s= validationService.checkSize(list);
                if (s.equals("OK")){
                    // цілі числа
                    s = validationService.checkByDivisionByOne(list);
                    if (s.equals("OK")){
                        s = validationService.checkIfPoinMoreZero(list);
                        if (s.equals("OK")){
                            s= validationService.checkByRightAngle(list);
                            if (s.equals("OK")){
                                s = validationService.cheackBrokenLines(list);
                                if (s.equals("OK")){
                                    s = validationService.cheackInfinity(list);
                                    if (s.equals("OK")){
                                        s = validationService.cheaсkCrossing(list);
                                        if (s.equals("OK")){
                                            return s;
                                        }else {
                                            return s;
                                        }
                                    }else {return s;}
                                }else {return s;}
                            }else {
                                return s;
                            }
                        }else {
                            return s;
                        }
                    }else {
                        return s;
                    }
                }else {
                    return s;
                }
            }else {
                return s;
            }


//        System.out.println(s);
//            return "OK";
    }
}
