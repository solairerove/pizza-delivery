package com.instinctools.jbpm.gop.pizza.delivery.domain.node.model;

import com.instinctools.jbpm.gop.pizza.delivery.domain.node.handler.NodeHandling;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessState;

import java.util.List;

public interface Node {

    String getTitle();

    String getListener();

    List<String> accept(ProcessState processState, NodeHandling handler);
}
