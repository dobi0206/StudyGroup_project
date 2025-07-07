package com.studygroup.study_project.service;

import com.studygroup.study_project.entity.Notice;
import com.studygroup.study_project.mapper.NoticeRestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeRestService {

    @Autowired
    private NoticeRestMapper noticeRestMapper;

    // 게시글 가져오는 메소드
    public List<Notice>getLists(){
        return noticeRestMapper.getLists();
    }

    // 게시글 추가 메소드
    public void boardInsert(Notice notice){
        noticeRestMapper.boardInsert(notice);
    }

    // 특정 게시글 내용 가져오는 메소드
    public Notice boardContent(int idx){
        return NoticeRestMapper.boardContent(idx);
    }

    // 특정 게시글 삭제
    public void boardDelete(int idx){
        NoticeRestMapper.boardDelete(idx);
    }

    // 특정 게시글 수정
    public void boardUpdate(Notice notice){
        NoticeRestMapper.boardUpdate(notice);
    }

    // 게시글 조회수 증가 메소드
    public void boardCount(int idx){
        NoticeRestMapper.boardCount(idx);
    }

}
