package com.study.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    MEMBER_EXISTS(409, "Member exists"),
    POSTS_NOT_FOUND(404, "Posts not found"),
    POSTS_EXISTS(409, "Posts exists"),
    GROUP_NOT_FOUND(404, "Group not found"),
    GROUP_EXISTS(409, "Group exists"),
    APPLY_MEMBER_NOT_FOUND(404, "Group not found");

    @Getter
    private final int status;

    @Getter
    private final String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
