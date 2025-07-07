package com.studygroup.study_project.mapper;

import com.studygroup.study_project.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper

// java 언어와 mysql 언어를 통역해주는 역할 + Controller (mapper -> service -> controller) , model과 DB 사이에서 Spring Framework 연결 시켜주기 위한 mapper (DB 연결 및 해석 역할)
public interface UserMapper {


    // CREATE + idx는 Auto Increment이기 때문에 기입 안해도 자동으로 변경됨
    @Insert("INSERT INTO study_group.user(username,userID,password,role) VALUES(#{username},#{userID},#{password},#{role})")
    Void insertUser(User user); // 반환할 값이 없기 때문에 void 작성 (DB에서 back(spring framework)으로 데이터를 가져온게 없음)


    // READ
    @Select("SELECT username,userID,password,role FROM study_group.user WHERE userID = #{userID}")
    User findByUserID(String userID);


    @Select("SELECT username FROM study_group.user WHERE userID = ${userID}")
    String findUsername(String userID);

    // UPDATE
    // @Update()


    // DELETE
    // @Delete()



}
