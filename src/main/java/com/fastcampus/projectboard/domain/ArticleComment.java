package com.fastcampus.projectboard.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    //기본 정보
    private Long id;
    private Article article;           // 게시글(ID)
    private String content;            // 본문
    private String hashtag;            // 해시태그

    //메타정보
    private LocalDateTime createdAt;   // 생성일자
    private String createdBy;          // 생성자
    private LocalDateTime modifiedAt;  // 수정일자
    private String modifiedBy;         // 수정자
}
