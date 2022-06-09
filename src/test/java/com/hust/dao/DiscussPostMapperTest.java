package com.hust.dao;

import com.hust.entity.DiscussPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DiscussPostMapperTest {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectDiscussPost(){
        List<DiscussPost> posts = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost post : posts) {
            System.out.println(post);
        }
        System.out.println();
        System.out.println(discussPostMapper.selectDiscussPostRows(0));
    }
}
