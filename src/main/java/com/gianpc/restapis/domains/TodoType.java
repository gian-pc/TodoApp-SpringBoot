package com.gianpc.restapis.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.Date;

@Data
@JsonPropertyOrder({"description", "code"}) // Para personalizar el orden de los campos en el JSON
@JsonInclude(JsonInclude.Include.NON_NULL) // Para que no se muestren los campos nulos
//@XmlRootElement // Para que pueda ser convertido a XML
public class TodoType {
    private  String code;
    @JsonIgnore // Para que no se muestre en el JSON
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dateCreated;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date lastUpdated;
}
