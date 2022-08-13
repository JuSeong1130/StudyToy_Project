package com.study.post.mapper;

import com.study.post.dto.PostsPatchDto;
import com.study.post.dto.PostsResponseDto;
import com.study.post.entity.Posts;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.DeleteMapping;

@Mapper(componentModel = "spring")
public interface PostsMapper {

    Posts postsPatchDtoToPosts(PostsPatchDto postsPatchDto);
    PostsResponseDto postsToPostsResponseDto(Posts posts);
}
