package com.pentspace.feedservice.service;

import com.pentspace.feedservice.dto.CommentDto;
import com.pentspace.feedservice.entities.Feed;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FeedService {
    Feed createFeed(MultipartFile file, String username, String content);
    List<Feed> getAll();
    Feed getById(String id);
    List<Feed> getAllByUser(String accountId);
    Feed updateFeedStatus(String id, String status);
    Feed comment(String feedId, CommentDto commentDto);
}
