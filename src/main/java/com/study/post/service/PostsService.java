package com.study.post.service;

import com.study.post.entity.Posts;
import com.study.post.repository.PostsRepository;
import com.study.utils.CustomBeanUtils;

public class PostsService {

    private final PostsRepository postsRepository;

    private final CustomBeanUtils<Posts> beanUtils;

    public PostsService(PostsRepository postsRepository, CustomBeanUtils<Posts> beanUtils) {
        this.postsRepository = postsRepository;
        this.beanUtils = beanUtils;
    }

    public void deletePost(Long postsId) {
        Posts posts = postsRepository.findById(postsId).orElseThrow(() ->
                new RuntimeException("게시글이 없습니다")
        );
        postsRepository.delete(posts);
    }


    public Posts patchPost(Posts posts) {

        Posts findPosts = postsRepository.findById(posts.getPostId()).orElseThrow(() ->
                new RuntimeException("게시글이 없습니다")
        );
        return postsRepository.save(beanUtils.copyNonNullProperties(posts,findPosts));
    }
}
