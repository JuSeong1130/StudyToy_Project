package com.study.post.service;

import com.study.exception.BusinessLogicException;
import com.study.exception.ExceptionCode;
import com.study.post.entity.Posts;
import com.study.post.repository.PostsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostsService {

    private PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public Posts createPost(Posts post) {
        verifyExistsPost(post.getPostId());
        return postsRepository.save(post);
    }

    public Posts findPost(Long postsId) {
        return findVerifiedPost(postsId);
    }

    public Page<Posts> findPosts(int page, int size) {
        return postsRepository.findAll(PageRequest.of(page, size, Sort.by("postsId").descending()));
    }

    private Posts findVerifiedPost(Long postsId) {
        Optional<Posts> optionalPosts = postsRepository.findById(postsId);
        return optionalPosts.orElseThrow(() -> new BusinessLogicException(ExceptionCode.POSTS_NOT_FOUND));
    }

    private void verifyExistsPost(Long postsId) {
        Optional<Posts> posts = postsRepository.findById(postsId);
        if(posts.isPresent())
            throw new BusinessLogicException(ExceptionCode.POSTS_EXISTS);
    }
}
