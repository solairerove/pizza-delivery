package com.instinctools.jbpm.gop.pizza.delivery.domain.node.listener;

import com.instinctools.jbpm.gop.pizza.delivery.domain.node.handler.NodeHandling;
import com.instinctools.jbpm.gop.pizza.delivery.domain.node.model.ProcessNode;
import com.instinctools.jbpm.gop.pizza.delivery.domain.node.repository.ProcessNodeRepository;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessState;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class WaitNodeListener extends DefaultNodeListener implements NodeListener {

    private final static String PAID = "PAID";

    @Autowired
    public WaitNodeListener(ProcessNodeRepository processNodeRepository, ProcessStateRepository stateRepository, NodeHandling nodeHandling) {
        super(processNodeRepository, stateRepository, nodeHandling);
    }

    @Override
    public List<String> execute(final ProcessState process, final ProcessNode node) {
        final ProcessNode save = save(process, node);

        final List<String> response = new ArrayList<>();
        response.add("Entered to: " + node.getTitle());

        for (final ProcessNode processNode : save.getOutgoing()) {
            if ("true".equalsIgnoreCase(process.getProperties().get(PAID))
                    && "Paid".equalsIgnoreCase(processNode.getTitle())) {
                response.addAll(processNode.accept(process, super.nodeHandling));
            } else if ("false".equalsIgnoreCase(process.getProperties().get(PAID))
                    && "NotPaid".equalsIgnoreCase(processNode.getTitle())) {
                response.addAll(processNode.accept(process, super.nodeHandling));
            }
        }

        return response;
    }
}
