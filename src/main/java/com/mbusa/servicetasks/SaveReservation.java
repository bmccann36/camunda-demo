package com.mbusa.servicetasks;

import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.ActivityInstance;
import org.camunda.bpm.engine.runtime.Job;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SaveReservation implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("saving reservation");

        // ? determine if network failure should be simulated
        Object simulateFailVar = execution.getVariable("simulateNetworkFail");
        boolean simulateFail = simulateFailVar != null && (boolean) simulateFailVar;


        // ? set up query to process engine
        ManagementService mgmtSvc = execution.getProcessEngine().getManagementService();
        Job job = mgmtSvc.createJobQuery()
                .active()
                .processInstanceId(execution.getProcessInstanceId())
                .singleResult();

        int remainingRetries = job.getRetries();

        //? when one retry remains we will simulate success
        if (remainingRetries > 1 && simulateFail) {
            System.out.println("remaining retries: " + remainingRetries);
            throw new RuntimeException("failed to save reservation");
        }

        String reservationId = UUID.randomUUID().toString();
        execution.setVariable("reservationId", reservationId);

        System.out.println("reservation save successful");

    }
}
