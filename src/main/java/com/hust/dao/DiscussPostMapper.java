package com.hust.dao;

import com.hust.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
//@Repository,二者均可
public interface DiscussPostMapper {

    //查询社区首页,显示前10个帖子
    List<DiscussPost> selectDiscussPosts(@Param("userId")int userId, @Param("offset")int offset, @Param("limit")int limit);

    //@Param注解用于给参数起别名
    //如果只有一个参数,并且在<if>里使用,则必须加别名
    int selectDiscussPostRows(@Param("userId")int userId);

}
