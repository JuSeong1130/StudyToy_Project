package com.study.comments.controller;

import com.study.comments.dto.CommentsPatchDto;
import com.study.comments.dto.CommentsPostsDto;
import com.study.comments.entity.Comments;
import com.study.comments.mapper.CommentsMapper;
import com.study.comments.service.CommentsService;
import com.study.post.entity.Posts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/posts")
public class CommentsController {

    private final CommentsService commentsService;
    private final CommentsMapper commentsMapper;

    public CommentsController(CommentsService commentsService, CommentsMapper commentsMapper) {
        this.commentsService = commentsService;
        this.commentsMapper = commentsMapper;
    }

    //등록
    @PostMapping("/{post-id}/comments")
    public ResponseEntity postComments(@PathVariable("post-id") Long postId,@RequestBody CommentsPostsDto requestBody){
        Posts posts = new Posts();
        posts.setPostId(postId);
        requestBody.setPosts(posts);
        Comments comments = commentsMapper.commentsPostsDtoToComments(requestBody);
        comments= commentsService.postComments(comments);
        return new ResponseEntity<>(commentsMapper.commentsToCommentsResponseDto(comments),HttpStatus.CREATED);
    }

    //수정
    @PatchMapping("/{post-id}/comments/{comments-id}")
    public ResponseEntity patchComments(@PathVariable("post-id") Long postId,@PathVariable("comments-id") Long commentsId,@RequestBody CommentsPatchDto requestBody){
        requestBody.setCommentsId(commentsId);
        Comments comments = commentsMapper.commentsPatchDtoToComments(requestBody);
        comments=commentsService.patchComments(comments);
        return new ResponseEntity<>(commentsMapper.commentsToCommentsResponseDto(comments),HttpStatus.OK);
    }
    //삭제
    @DeleteMapping("/{post-id}/comments/{comments-id}")
    public ResponseEntity deleteComments(@PathVariable("post-id") Long postId,@PathVariable("comments-id") Long commentsId){
        String memberId ="aa";
        commentsService.deleteComments(memberId,commentsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
