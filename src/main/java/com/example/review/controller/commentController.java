package com.example.review.controller;

import com.example.review.dto.CommentRequest;
import com.example.review.dto.CommentResponse;
import com.example.review.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class commentController {

    private final CommentService commentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@RequestBody CommentRequest commentRequest) {
        commentService.createComment(commentRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommentResponse> getAllComments(){
        return commentService.getAllComments();
    }
}
