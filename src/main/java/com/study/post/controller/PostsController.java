package com.study.post.controller;


import com.study.member.entity.Member;
import com.study.post.dto.PostsPatchDto;
import com.study.post.entity.Posts;
import com.study.post.mapper.PostsMapper;
import com.study.post.service.PostsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/posts")
public class PostsController {

    private PostsService postsService;
    private PostsMapper postsMapper;

    public PostsController(PostsService postsService, PostsMapper postsMapper) {
        this.postsService = postsService;
        this.postsMapper = postsMapper;
    }

    @DeleteMapping("/{post-id}")
    public ResponseEntity deletePost(@PathVariable("posts-id") Long postsId){
        postsService.deletePost(postsId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PatchMapping("/{post-id}")
    public ResponseEntity patchPost(@PathVariable("posts-id") Long postsId, @RequestBody PostsPatchDto requestBody){
          Posts posts = postsMapper.postsPatchDtoToPosts(requestBody);
          posts.setPostId(postsId);
          Member member = new Member();
          member.setMemberId("aa");
          posts.setMember(member);

          posts=postsService.patchPost(posts);

          return new ResponseEntity<>(postsMapper.postsToPostsResponseDto(posts),HttpStatus.OK);
    }







}
