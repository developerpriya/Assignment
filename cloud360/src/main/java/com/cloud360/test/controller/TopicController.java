package com.cloud360.test.controller;

import com.cloud360.test.entity.Comment;
import com.cloud360.test.entity.Topic;
import com.cloud360.test.repository.CommentRepository;
import com.cloud360.test.repository.TopicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cloud360")
@Slf4j
public class TopicController {

    @Autowired
    public TopicRepository topicRepo;

    @Autowired
    public CommentRepository commentRepo;


    @PostMapping("/topics")
    public ResponseEntity<?> createCourse(@RequestBody Topic topic) {
        log.info("Save new topic details");
        topicRepo.save(topic);
        return new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @GetMapping("/topics")
    public List<Topic> getAllTopic() {
        log.info("Get all topic details");
        return topicRepo.findAll();
    }

    @GetMapping("/topics/comment")
    public List<Comment> getAllComment() {
        log.info("Get all topic details");
        return commentRepo.findAll();
    }


    @PutMapping("/topics/{id}")
    public ResponseEntity<?> updateTopic(@RequestBody Topic topic,
                                         @PathVariable("id") Long topicId) {
        log.info("Update a topic using id");
        Optional<Topic> TopicOpt = topicRepo.findById(topicId);
        if (TopicOpt.isPresent()) {
            Topic newTopic = TopicOpt.get();
            newTopic.setTopicId(topicId);
            newTopic.setTopicName(topic.getTopicName());
            topicRepo.save(newTopic);
            return new ResponseEntity<Topic>(TopicOpt.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/topics/{id}/comment")
    public ResponseEntity<?> addComment(@RequestBody Comment comment,
                                        @PathVariable("id") Long topicId) {
        log.info("ADD NEW COMMENT");
        Optional<Topic> TopicOpt = topicRepo.findById(topicId);
        if (TopicOpt.isPresent()) {
            Comment newComment = new Comment();
            newComment.setComment(comment.getComment());
            newComment.setTopic(comment.getTopic());
            commentRepo.save(newComment);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/topics/{id}/comment")
    public ResponseEntity<?> getTopicById(@PathVariable("id") Long topicId) {
        log.info("Get comment details of a topic by id");
        return new ResponseEntity<Void>(HttpStatus.CREATED);

    }
}