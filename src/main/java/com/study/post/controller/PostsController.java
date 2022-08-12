package com.study.post.controller;

import com.study.member.entity.Member;
import com.study.post.dto.PostsPostDto;
import com.study.post.entity.Posts;
import com.study.post.mapper.PostsMapper;
import com.study.post.service.PostsService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/posts")
public class PostsController {

    private final PostsService postsService;
    private final PostsMapper postsMapper;

    public PostsController(PostsService postsService, PostsMapper postsMapper) {
        this.postsService = postsService;
        this.postsMapper = postsMapper;
    }

    @PostMapping
    public ResponseEntity postPosts(@RequestBody PostsPostDto requestBody) {
        Posts posts = postsMapper.postsPostDtoToPosts(requestBody);
        Member member = Member.builder()
                .memberId("aa")
                .address("ThisIsAddress")
                .email("aa@gmail.com")
                .password("ThisIsPassword")
                .role("ROLE_USER")
                .build();
        posts.setMember(member);

        Posts savePosts = postsService.createPost(posts);
        return new ResponseEntity<>(postsMapper.postsToPostsResponseDto(savePosts), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getPosts(@Positive @RequestParam int page,
                                   @Positive @RequestParam int size) {
        Page<Posts> pagePosts = postsService.findPosts(page - 1, size);
        return new ResponseEntity<>(pagePosts, HttpStatus.OK);

    }
    @GetMapping("/{post-id}")
    public ResponseEntity getPost(@PathVariable("post-id") Long postId) {
        Posts posts = postsService.findPost(postId);
        return new ResponseEntity<>(postsMapper.postsToPostsResponseDto(posts), HttpStatus.OK);
    }
}
