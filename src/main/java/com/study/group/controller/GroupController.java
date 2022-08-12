package com.study.group.controller;

import com.study.group.dto.GroupPostDto;
import com.study.group.entity.Group;
import com.study.group.mapper.GroupMapper;
import com.study.group.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/groups")
public class GroupController {
    private GroupMapper groupMapper;
    private GroupService groupService;

    public GroupController(GroupMapper groupMapper, GroupService groupService) {
        this.groupMapper = groupMapper;
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity postGroup(@RequestBody GroupPostDto groupPostDto) {
        Group group = groupService.createGroup(groupMapper.groupPostDtoToGroup(groupPostDto));
        return new ResponseEntity<>(groupMapper.groupToGroupResponseDto(group), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getGroups(@RequestParam @Positive int page,
                                    @RequestParam @Positive int size) {
        Page<Group> pageGroups = groupService.findGroups(page - 1, size);
        return new ResponseEntity<>(pageGroups, HttpStatus.OK);
    }

    @GetMapping("/{group-id}")
    public ResponseEntity getGroup(@PathVariable("group-id") Long groupId) {
        Group group = groupService.findGroup(groupId);
        return new ResponseEntity<>(groupMapper.groupToGroupResponseDto(group), HttpStatus.OK);
    }

    @DeleteMapping("/{group-id}")
    public ResponseEntity deleteGroup(@PathVariable("group-id") Long groupId) {
        groupService.deleteGroup(groupId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
