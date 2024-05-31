package com.gianpc.restapis.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gianpc.restapis.utils.validators.TitleConstraint;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@NamedQuery(name = "Todo.fetchAllDone", query = "SELECT t FROM Todo t WHERE t.done = true")
@NamedQuery(name = "Todo.fetchAllByName", query = "SELECT t FROM Todo t WHERE t.title = ?1")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // IDENTITY, SEQUENCE, TABLE
    private Long id;

    //@NotNull
    @TitleConstraint
    private String title;

    @JsonIgnore
    private String description;

    private boolean done;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dateCreated;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dueDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dateDone;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date lastUpdated;

    @ManyToOne
    @JsonProperty("type")
    private TodoType todoType;
}
