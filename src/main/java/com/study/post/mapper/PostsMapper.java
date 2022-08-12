package com.study.post.mapper;

import com.study.post.dto.PostsPostDto;
import com.study.post.dto.PostsResponseDto;
import com.study.post.entity.Posts;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostsMapper {
    Posts postsPostDtoToPosts(PostsPostDto requestBody);
    PostsResponseDto postsToPostsResponseDto(Posts posts);
}
