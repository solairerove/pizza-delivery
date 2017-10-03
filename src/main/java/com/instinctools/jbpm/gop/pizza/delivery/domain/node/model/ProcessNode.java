package com.instinctools.jbpm.gop.pizza.delivery.domain.node.model;

import com.instinctools.jbpm.gop.pizza.delivery.domain.node.handler.NodeHandling;
import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessState;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NodeEntity
@NoArgsConstructor
public class ProcessNode implements Node, Serializable {

    private static final long serialVersionUID = -1890444071123345233L;

    @GraphId
    private Long id;

    @Property(name = "title")
    private String title;

    @Property(name = "listener")
    private String listener;

    @Labels
    private List<String> labels = new ArrayList<>();

    @Relationship
    private List<ProcessNode> outgoing = new ArrayList<>();

    @Override
    public List<String> accept(final ProcessState processState, final NodeHandling handler) {
        return handler.handle(processState, this);
    }
}
