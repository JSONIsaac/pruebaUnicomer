package com.example.crud.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @SequenceGenerator(name = "tarea_sequence", sequenceName = "tarea_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarea_sequence")
    @JsonIgnore // Excluir el campo "id" del JSON
    private Long id;

    private String name;

    @Column(name = "due_date")
    private Date dueDate;

    private String priority;
    private String status;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private Usuario assigned;

    // Getters y setters (¡Asegúrate de tenerlos correctamente definidos!)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getAssigned() {
        return assigned;
    }

    public void setAssigned(Usuario assigned) {
        this.assigned = assigned;
    }
}
