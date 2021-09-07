package com.cloud360.test.repository;

import com.cloud360.test.entity.Comment;
import com.cloud360.test.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
