package com.example.review.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;
import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String userId;
    private String commentText;
    private String commentId;
    private Date commentDate;
    private String emotion;

    public Comment(String userId, String commentText, String commentId, Date commentDate) {
        this.userId = userId;
        this.commentText = commentText;
        this.commentId = commentId;
        this.commentDate = commentDate;
    }

    public String getUserId() {
        return userId;
    }

    public String getCommentText() {
        return commentText;
    }

    public String getCommentId() {
        return commentId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

}