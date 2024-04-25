package com.gianpc.restapis.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@JsonPropertyOrder(alphabetic = true)
//@JsonPropertyOrder({"description", "code"}) // Para personalizar el orden de los campos en el JSON
//@JsonInclude(JsonInclude.Include.NON_NULL) // Para que no se muestren los campos nulos
@XmlRootElement// Cambiamos el nombre del elemento raíz
@XmlAccessorType(XmlAccessType.FIELD) // aplicar tecnica de serialización y deserilización
@XmlType(propOrder = {"code", "dateCreated", "lastUpdated"}) // orden de los elementos en el XML
public class TodoType {
    private  String code;
    @XmlTransient // Para que no se muestre en el XML
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dateCreated;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date lastUpdated;
}
