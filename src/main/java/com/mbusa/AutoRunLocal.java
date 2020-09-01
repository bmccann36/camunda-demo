package com.mbusa;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AutoRunLocal {
    @Autowired
    private RuntimeService runtimeService;

    /**
     * Uses the Camunda Java api to manually start a business process that is otherwise triggered by a timer event.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void start() {

            Map<String, Object> vars = new HashMap();
            vars.put("carModel", "c-class");
            vars.put("simulateNetworkFail", true);

            runtimeService.startProcessInstanceByKey("cmnda-demo-process", vars);


    }
}
