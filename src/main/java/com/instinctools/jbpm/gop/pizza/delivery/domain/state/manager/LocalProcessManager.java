package com.instinctools.jbpm.gop.pizza.delivery.domain.state.manager;

import com.instinctools.jbpm.gop.pizza.delivery.domain.node.handler.NodeHandling;
import com.instinctools.jbpm.gop.pizza.delivery.domain.node.model.ProcessNode;
import com.instinctools.jbpm.gop.pizza.delivery.domain.node.repository.ProcessNodeRepository;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LocalProcessManager implements ProcessManagement {

    private final ProcessNodeRepository processNodeRepository;
    private final NodeHandling nodeHandling;

    @Override
    public List<String> executeProcess(final ProcessState process) {
        final Long state = process.getState();
        final ProcessNode node = processNodeRepository.findOne(state);

        return node.accept(process, nodeHandling);
    }
}
