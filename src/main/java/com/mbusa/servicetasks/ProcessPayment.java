package com.mbusa.servicetasks;

import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Job;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProcessPayment implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("processing payment");

        //? get carModel string from process variable
        String carModel = (String) execution.getVariable("carModel");

        Set carTypes = getCarTypes();
        boolean validModel = carTypes.contains(carModel);

        if(!validModel){
            throw new RuntimeException("model not valid, cannot process payment");
        }
    }

    private Set<String> getCarTypes(){
        List<String> list = Arrays.asList("c-class","g-class","a-class" );
        Set<String> set1 = new HashSet<>(list);
        return set1;
    }
}
