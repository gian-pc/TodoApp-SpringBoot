package com.gianpc.restapis.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@XmlRootElement// Cambiamos el nombre del elemento raíz
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"code", "dateCreated", "lastUpdated"})
@JsonPropertyOrder({"description", "code"})
@JsonInclude(JsonInclude.Include.NON_NULL) // or NON_EMPTY, ALWAYS, CUSTOM
public class TodoType {

    @Id
    @NotBlank
    @Size(min = 4, max = 10)
    private  String code;

    @XmlTransient
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dateCreated;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date lastUpdated;
}
