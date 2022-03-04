package com.oracle.todoapp.object;

import javax.persistence.*;
import java.time.OffsetDateTime;
// CREATE TABLE todoitem (
// id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY ,
// description VARCHAR2(4000),
// creation_ts TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
// done NUMBER(1,0),
// PRIMARY KEY (id)
// );
@Entity
@Table(name = "TODOITEM")
public class TodoItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name ="DESCRIPTION", nullable = true)
    String description;

    @Column(name ="CREATION_TS", nullable = true)
    OffsetDateTime created_at;

    @Column(name ="DONE", nullable = true)
    boolean done;

    public TodoItem(){

    }

    public TodoItem(int id, String description, OffsetDateTime created_at, boolean done) {
        this.id = id;
        this.description = description;
        this.created_at = created_at;
        this.done = done;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated_at(OffsetDateTime created_at) {
        this.created_at = created_at;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public OffsetDateTime getCreated_at() {
        return created_at;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", done=" + done +
                '}';
    }
}