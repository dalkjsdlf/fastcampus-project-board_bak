package com.fastcampus.projectboard.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ArticleComment {

    //도메인 고유 데이터
    private Long id;
    private Article arcidle;          // 게시글(ID)
    private String contents;          // 본문

    //메타 데이터
    private LocalDateTime createdAt;  //생성일자
    private String createBy;          // 생성자
    private LocalDateTime modifiedAt; // 수정일자
    private String modifiedBy;        // 수정자
}
