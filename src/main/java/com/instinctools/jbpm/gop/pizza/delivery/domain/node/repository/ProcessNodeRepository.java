package com.instinctools.jbpm.gop.pizza.delivery.domain.node.repository;

import com.instinctools.jbpm.gop.pizza.delivery.domain.node.model.ProcessNode;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "nodes", path = "nodes")
public interface ProcessNodeRepository extends PagingAndSortingRepository<ProcessNode, Long> {
}
