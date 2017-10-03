package com.instinctools.jbpm.gop.pizza.delivery.domain.node.listener;

import com.instinctools.jbpm.gop.pizza.delivery.domain.node.handler.NodeHandling;
import com.instinctools.jbpm.gop.pizza.delivery.domain.node.model.ProcessNode;
import com.instinctools.jbpm.gop.pizza.delivery.domain.node.repository.ProcessNodeRepository;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessState;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessStateRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OneMoreNodeListener extends DefaultNodeListener implements NodeListener {

    @Autowired
    public OneMoreNodeListener(ProcessNodeRepository processNodeRepository, ProcessStateRepository stateRepository, NodeHandling nodeHandling) {
        super(processNodeRepository, stateRepository, nodeHandling);
    }

    @Override
    public List<String> execute(final ProcessState process, final ProcessNode node) {
        return super.execute(process, node);
    }
}
