package com.instinctools.jbpm.gop.pizza.delivery.domain.state;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@Document(collection = "processes")
public class ProcessState implements Serializable {

    private static final long serialVersionUID = -1521956273845888063L;

    @Id
    private String id;

    private String title;

    private Map<String, String> properties = new HashMap<>();

    private Long state;
}
