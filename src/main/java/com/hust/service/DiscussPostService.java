package com.hust.service;

import com.hust.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiscussPostService {

    List<DiscussPost> findDiscussPosts(int userId, int offset, int limit);

    int findDiscussPostRows(int userId);
}
