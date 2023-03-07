package com.pentspace.feedservice.service.impl;

import com.pentspace.feedservice.dto.CommentDto;
import com.pentspace.feedservice.entities.Comment;
import com.pentspace.feedservice.entities.Feed;
import com.pentspace.feedservice.entities.enums.Status;
import com.pentspace.feedservice.entities.repositories.CommentRepository;
import com.pentspace.feedservice.entities.repositories.FeedRepository;
import com.pentspace.feedservice.service.FeedService;
import com.pentspace.feedservice.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FeedServiceImpl implements FeedService {
    @Autowired
    private FeedRepository feedRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    FileUploadService fileUploadService;

    @Override
    public Feed createFeed(MultipartFile file, String username, String content) {
        Feed feed = new Feed();
        feed.setStatus(Status.PENDING);
        feed.setMessage(content);
        feed.setUsername(username);
        feed = feedRepository.save(feed);
        String media_url = fileUploadService.uploadFile(feed.getId(), file);
        feed.setMediaUrl(media_url);
        return feedRepository.save(feed);
    }

    @Override
    public List<Feed> getAll() {
        return feedRepository.findAll();
    }

    @Override
    public Feed getById(String id) {
        Feed feed =  feedRepository.findById(id).orElseThrow(()->new NoSuchElementException("Feed not found"));
        String imageInBase64 = fileUploadService.readAndConvertImageToBase64Read(feed.getId());
        feed.setFeedImageBase64(imageInBase64);
        return feed;
    }

    @Override
    public List<Feed> getAllByUser(String username) {
        return feedRepository.findByUsername(username);
    }

    @Override
    public Feed updateFeedStatus(String id, String status) {
        Feed feed = getById(id);
        feed.setStatus(Status.valueOf(status));
        return feedRepository.save(feed);
    }

    @Override
    public Feed comment(String feedId, CommentDto commentDto) {
        Feed feed = getById(feedId);
        Comment comment = new Comment();
        comment.setMessage(commentDto.getMessage());
        comment.setUsername(commentDto.getUsername());
        comment.setFeed(feed);
        comment = commentRepository.save(comment);
        feed.getComments().add(comment);
        return feedRepository.save(feed);
    }
}
