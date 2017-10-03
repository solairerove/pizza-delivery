package com.instinctools.jbpm.gop.pizza.delivery.domain.node.listener;

import com.instinctools.jbpm.gop.pizza.delivery.domain.node.model.ProcessNode;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessState;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NotPaidListener implements NodeListener {

    private final ProcessStateRepository stateRepository;

    @Override
    public List<String> execute(final ProcessState process, final ProcessNode node) {
        process.setState(node.getId());
        stateRepository.save(process);

        return Collections.singletonList("It isn't payed");
    }
}
