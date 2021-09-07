package com.cloud360.test.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;


    @Data
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    public class Topic {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long topicId;
    private String topicName;


    @OneToMany()
    @JoinColumn(
            name = "topic_id",
            referencedColumnName = "topicId"
    )
    @JsonIgnore
    private List<Comment>comment;

}

