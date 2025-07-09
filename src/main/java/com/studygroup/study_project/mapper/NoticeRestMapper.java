package com.studygroup.study_project.mapper;

import com.studygroup.study_project.entity.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface NoticeRestMapper {

    @Insert("INSERT INTO study_group.notice (userID,title,content,username,indate) VALUES (#{userID},#{title},#{content},#{username},#{indate})")
    public void boardInsert(Notice notice);

    @Select("SELECT idx,userID,title,content,username,indate,count FROM study_group.notice ORDER BY idx DESC")
    public List<Notice>getLists();

    @Select("SELECT idx,userID,title,content,username,indate,count FROM study_group.notice WHERE idx=#{idx}")
    public Notice boardContent(int idx);

    @Update("UPDATE study_group.notice SET title=#{title}, content=#{content},userID=#{userID} WHERE idx=#{idx}")
    public void boardUpdate(Notice notice);

    @Update("UPDATE study_group.notice SET count = count + 1 WHERE idx = #{idx}")
    public void boardCount(int idx);

    @Delete("DELETE FROM study_group.notice WHERE idx=#{idx}")
    public void boardDelete(int idx);

}
