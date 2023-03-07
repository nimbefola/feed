package com.pentspace.feedservice.handlers;

import com.pentspace.feedservice.entities.Feed;

public interface FeedHandler {
    Feed createFeed(String message, String username);
}
