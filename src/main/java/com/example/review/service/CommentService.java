package com.example.review.service;

import com.example.review.dto.CommentRequest;
import com.example.review.dto.CommentResponse;
import com.example.review.model.Comment;
import com.example.review.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;

    public void createComment(CommentRequest commentRequest){
        Comment comment = Comment.builder()
                .userId(commentRequest.getUserId())
                .commentDate(commentRequest.getCommentDate())
                .commentId(commentRequest.getCommentId())
                .commentText(commentRequest.getCommentText())
                .build();

        commentRepository.save(comment);
        log.info("Comment {} is saved", comment.getCommentId());
    }

    public List<CommentResponse> getAllComments() {
        List<Comment> comments = (List<Comment>) commentRepository.findAll();
        return comments.stream().map(this::mapToCommentResponse).toList();
    }

    private CommentResponse mapToCommentResponse(Comment comment) {
        return CommentResponse.builder()
                .userId(comment.getUserId())
                .commentDate(comment.getCommentDate())
                .commentId(comment.getCommentId())
                .commentText(comment.getCommentText())
                .build();
    }
}
