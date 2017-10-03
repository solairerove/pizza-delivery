package com.instinctools.jbpm.gop.pizza.delivery.domain.node.listener;

import com.instinctools.jbpm.gop.pizza.delivery.domain.node.handler.NodeHandling;
import com.instinctools.jbpm.gop.pizza.delivery.domain.node.model.ProcessNode;
import com.instinctools.jbpm.gop.pizza.delivery.domain.node.repository.ProcessNodeRepository;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessState;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultNodeListener implements NodeListener {

    protected final ProcessNodeRepository processNodeRepository;
    protected final ProcessStateRepository stateRepository;
    protected final NodeHandling nodeHandling;

    @Override
    public List<String> execute(final ProcessState process, final ProcessNode node) {
        final ProcessNode currentNode = save(process, node);

        final List<String> response = new ArrayList<>();
        response.add("Entered to: " + node.getTitle());

        if (Optional.ofNullable(currentNode.getOutgoing()).isPresent()) {
            currentNode.getOutgoing().forEach(n -> response.addAll(n.accept(process, nodeHandling)));
        }

        return response;
    }

    protected ProcessNode save(final ProcessState process, final ProcessNode node) {
        process.setState(node.getId());
        stateRepository.save(process);

        return processNodeRepository.findOne(node.getId());
    }
}
