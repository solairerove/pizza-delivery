package com.instinctools.jbpm.gop.pizza.delivery.domain.node.listener;

import com.instinctools.jbpm.gop.pizza.delivery.domain.node.model.ProcessNode;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessState;

import java.util.List;

/**
 * Describe node listener behaviour.
 */
public interface NodeListener {

    /**
     * Node execute method.
     */
    List<String> execute(ProcessState state, ProcessNode node);
}
