package com.instinctools.jbpm.gop.pizza.delivery.domain.node.handler;

import com.instinctools.jbpm.gop.pizza.delivery.domain.node.model.ProcessNode;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessState;

import java.util.List;

public interface NodeHandling {

    List<String> handle(ProcessState process, ProcessNode node);
}
