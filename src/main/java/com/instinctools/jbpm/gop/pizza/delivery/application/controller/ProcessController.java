package com.instinctools.jbpm.gop.pizza.delivery.application.controller;

import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessState;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessStateRepository;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.manager.ProcessManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/process")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProcessController {

    private final ProcessStateRepository stateRepository;
    private final ProcessManagement processManager;

//    @RequestMapping(path = "/", method = RequestMethod.GET)
//    public ResponseEntity process() {
//        create new process
//
//        nodeManagement.executeProcess();
//        return ResponseEntity.ok().body("");
//    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity process(@PathVariable("id") final String id) {
        final ProcessState processState = stateRepository.findOne(id);
        final List<String> response = processManager.executeProcess(processState);

        return ResponseEntity.ok().body(response);
    }
}
