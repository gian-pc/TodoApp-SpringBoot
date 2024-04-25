package com.gianpc.restapis.domains;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.Date;

@Data
@JsonPropertyOrder(alphabetic = true) // Para que se ordene alfabéticamente
//@XmlRootElement // Para que pueda ser convertido a XML
public class TodoType {
    private  String code;
    private String description;
    private Date dateCreated;
    private Date lastUpdated;
}
