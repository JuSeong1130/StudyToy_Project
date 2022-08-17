package com.study.comments.mapper;

import com.study.comments.dto.CommentsPatchDto;
import com.study.comments.dto.CommentsPostsDto;
import com.study.comments.dto.CommentsResponseDto;
import com.study.comments.entity.Comments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentsMapper {
  Comments commentsPostsDtoToComments(CommentsPostsDto requestBody);
  CommentsResponseDto commentsToCommentsResponseDto(Comments comments);
  Comments commentsPatchDtoToComments(CommentsPatchDto requestBody);
}
