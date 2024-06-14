package com.pmd.app.repository.TasksRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pmd.app.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}