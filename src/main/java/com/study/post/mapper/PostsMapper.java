package com.study.post.mapper;

import com.study.post.dto.PostsPostDto;
import com.study.post.dto.PostsResponseDto;
import com.study.post.entity.Posts;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import com.study.post.dto.PostsPatchDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostsMapper {
    Posts postsPostDtoToPosts(PostsPostDto requestBody);
    PostsResponseDto postsToPostsResponseDto(Posts posts);
    Posts postsPatchDtoToPosts(PostsPatchDto postsPatchDto);


}


