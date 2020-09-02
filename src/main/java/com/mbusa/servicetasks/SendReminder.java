package com.mbusa.servicetasks;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendReminder implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("sending reminder to dealer with details: " + execution.getVariables());
        /*
        ! this is where we would put a pending work item into a queue or have FE query the engine for any work
         */
    }
}
