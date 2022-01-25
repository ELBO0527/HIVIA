package com.example.hibia.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private boolean published;

    public Post(){}

    @Builder
    public Post(String title,String content,boolean published){
        this.title = title;
        this.content = content;
        this.published = published;
    }
}
