package com.study.post.service;


import com.study.comments.entity.Comments;
import com.study.comments.repository.CommentsRepository;
import com.study.exception.BusinessLogicException;
import com.study.exception.ExceptionCode;
import com.study.post.entity.Posts;
import com.study.post.repository.PostsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.study.utils.CustomBeanUtils;
import java.util.Optional;

@Service
public class PostsService {

    private final PostsRepository postsRepository;

    private final CustomBeanUtils<Posts> beanUtils;

    public PostsService(PostsRepository postsRepository, CustomBeanUtils<Posts> beanUtils) {
        this.postsRepository = postsRepository;
        this.beanUtils = beanUtils;
    }

    public Posts createPost(Posts post) {

        //verifyExistsPost(post.getPostId());
        return postsRepository.save(post);
    }

    public Posts findPost(Long postsId) {
        return findVerifiedPost(postsId);
    }

    public Page<Posts> findPosts(int page, int size) {
        return postsRepository.findAll(PageRequest.of(page, size, Sort.by("postId").descending()));
    }

    private Posts findVerifiedPost(Long postsId) {
        Optional<Posts> optionalPosts = postsRepository.findById(postsId);
        return optionalPosts.orElseThrow(() -> new BusinessLogicException(ExceptionCode.POSTS_NOT_FOUND));
    }

    private void verifyExistsPost(Long postsId) {
        Optional<Posts> posts = postsRepository.findById(postsId);
        if (posts.isPresent())
            throw new BusinessLogicException(ExceptionCode.POSTS_EXISTS);
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
        return postsRepository.save(beanUtils.copyNonNullProperties(posts, findPosts));
    }
}
