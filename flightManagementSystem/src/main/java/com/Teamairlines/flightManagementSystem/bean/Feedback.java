package com.Teamairlines.flightManagementSystem.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Feedback {
    @Id
    private Long fId;
    private String name;
    private String username;
    @Lob
    private String content;

    public Feedback() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Feedback(Long fId, String name, String username, String content) {
        super();
        this.fId = fId;
        this.name = name;
        this.username = username;
        this.content = content;
    }

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
