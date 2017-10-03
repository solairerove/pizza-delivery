package com.instinctools.jbpm.gop.pizza.delivery.domain.state.manager;

import com.instinctools.jbpm.gop.pizza.delivery.domain.node.model.Node;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessState;

import java.util.List;

public interface ProcessManagement {

    List<String> executeProcess(ProcessState process);
}
