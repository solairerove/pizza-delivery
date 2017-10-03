package com.instinctools.jbpm.gop.pizza.delivery.domain.node.handler;

import com.instinctools.jbpm.gop.pizza.delivery.domain.node.listener.NodeListener;
import com.instinctools.jbpm.gop.pizza.delivery.domain.node.model.ProcessNode;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultNodeHandler implements NodeHandling {

    private final ApplicationContext context;

    @Override
    public List<String> handle(final ProcessState process, final ProcessNode node) {
        final String beanName = convertToBeanName(node.getListener());
        final NodeListener nodeListener = (NodeListener) context.getBean(beanName);

        return nodeListener.execute(process, node);
    }

    private String convertToBeanName(final String listenerClass) {
        return listenerClass.substring(0, 1).toLowerCase(Locale.getDefault()) + listenerClass.substring(1);
    }
}
