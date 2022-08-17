package com.study.comments.service;

import com.study.comments.entity.Comments;
import com.study.comments.repository.CommentsRepository;
import com.study.member.entity.Member;
import com.study.post.entity.Posts;
import com.study.post.repository.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;

    public CommentsService(CommentsRepository commentsRepository, PostsRepository postsRepository) {
        this.commentsRepository = commentsRepository;
        this.postsRepository = postsRepository;
    }

    public Comments postComments(Comments comments) {
        //post가 존재하면
        Posts posts = postsRepository.findById(comments.getPosts().getPostId()).orElseThrow(()->{
            throw new RuntimeException("게시글이 없습니다.");
        });
        Member member = new Member();
        member.setMemberId("aa");
        comments.setMember(member);
        //comments.setPosts(posts);   << 객체가 저장된다는 생각이여서 해줘야한다 생각했었음
        //save
        return commentsRepository.save(comments);
    }

    /*
     *
     * 1. 매개변수로 postId를 받는다
     * 2. Comments에 postId를 넣는다
     * */
    public Comments patchComments(Comments comments) {
        //commnets가 존재하면 posts에 cascade 조건 줘서 posts삭제되면 comments도 같이삭제하니 comments만 확인하면됨
        Comments findComments = commentsRepository.findById(comments.getCommnetsId()).orElseThrow(()->{
            throw new RuntimeException("게시글 혹은 댓글이 없습니다");
        });
        //commets를 수정
        findComments.patchContent(comments.getContents());
        Optional<Comments> byId = commentsRepository.findById(comments.getCommnetsId());
        if(!byId.isPresent()){
            throw new RuntimeException("게시글 혹은 댓글이 없습니다");
        }
        return commentsRepository.save(findComments);
    }

    public void deleteComments(String memberId, Long commentsId) {
        //memberid가 맞아야 삭제가되어야함  or admin
        //cascacde 조건
        Comments comments = commentsRepository.findById(commentsId).orElseThrow(() ->
                new RuntimeException("댓글이 없습니다")
        );
        //1번게시물에 && 2번댓글이있으면
        //commentsId
        commentsRepository.delete(comments);
    }
}