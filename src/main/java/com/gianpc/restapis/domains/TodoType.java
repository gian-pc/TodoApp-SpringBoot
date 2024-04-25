package com.gianpc.restapis.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.Date;

@Data
@JsonPropertyOrder({"description", "code"}) // Para personalizar el orden de los campos en el JSON
//@XmlRootElement // Para que pueda ser convertido a XML
public class TodoType {
    private  String code;
    @JsonIgnore // Para que no se muestre en el JSON
    private String description;
    private Date dateCreated;
    private Date lastUpdated;
}
