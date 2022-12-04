package com.fastcampus.projectboard.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Article {

    //도메인 고유 데이터
    private Long id;
    private String title;            // 제목
    private String content;          // 본문
    private String hashtag;          // 해시태그


    //메타 데이터
    private LocalDateTime createdAt;  //생성일자
    private String createBy;          // 생성자
    private LocalDateTime modifiedAt; // 수정일자
    private String modifiedBy;        // 수정자

}
