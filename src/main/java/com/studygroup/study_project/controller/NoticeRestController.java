package com.studygroup.study_project.controller;

import com.studygroup.study_project.entity.Notice;
import com.studygroup.study_project.service.NoticeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
// REST API 사용 시


// @controller -> 페이지 리턴
// @Restcontroller -> 데이터(텍스트 : JSON 형식)리턴

public class NoticeRestController {

    @Autowired
    private NoticeRestService noticeRestService;
    // REST, API 개발

    // 게시물 조회
    @GetMapping("/Notice/all")
    public ResponseEntity<List<Notice>> getAllNoticeS(){
        List<Notice>notices = noticeRestService.getLists();
        if(notices!=null && !notices.isEmpty()){
            return ResponseEntity.ok(notices);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    // 게시물 생성
    @PostMapping("/Notice/add")
    public ResponseEntity<String> addNotice(@RequestBody Notice notice){
        // 현재 날짜 자동 입력
        if(notice.getIndate()==null || notice.getIndate().isEmpty()){
            notice.setIndate(LocalDate.now().toString());
        }

        // 조회 수 기본 값 0 지정
        notice.setCount(0);

        // 게시물 생성 기능
        noticeRestService.boardInsert(notice);
        return ResponseEntity.ok("Board Added Successfully");

    }

    // 게시글 수정
    @PutMapping("/Notice/Update/{idx}")
    public void updateNotice(@RequestBody Notice notice, @PathVariable("idx") int idx){
        notice.setIdx(idx);
        noticeRestService.boardUpdate(notice);
    }

    // 게시글 삭제
    @DeleteMapping("Notice/delete/{idx}")
    public void deleteNotice(@PathVariable("idx") int idx){
        noticeRestService.boardDelete(idx);
    }

    // 특정 게시물의 내용 조회
    @GetMapping("/Notice/{idx}")
    public ResponseEntity<Notice> getNoticeById(@PathVariable("idx") int idx){
        Notice notice = noticeRestService.boardContent(idx);
        if(notice != null){
            return ResponseEntity.ok(notice);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    // 조회수 증가
    @PutMapping("/Notice/count/{idx}")
    public void updateNoticeCount(@PathVariable("idx") int idx){
        noticeRestService.boardCount(idx);
    }

}
