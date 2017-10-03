package com.instinctools.jbpm.gop.pizza.delivery.domain.state;

import com.instinctools.jbpm.gop.pizza.delivery.domain.state.ProcessState;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "processes", path = "processes")
public interface ProcessStateRepository extends PagingAndSortingRepository<ProcessState, String> {

}
