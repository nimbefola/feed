package com.pentspace.feedservice.entities.repositories;

import com.pentspace.feedservice.entities.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRepository  extends JpaRepository<Feed, String> {
    List<Feed> findByUsername(String username);
}
