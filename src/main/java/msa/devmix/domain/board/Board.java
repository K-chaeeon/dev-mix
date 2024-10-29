package msa.devmix.domain.board;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import msa.devmix.domain.common.BaseTimeEntity;
import msa.devmix.domain.constant.Location;
import msa.devmix.domain.constant.RecruitmentStatus;
import msa.devmix.domain.constant.RecruitmentType;
import msa.devmix.domain.user.User;

import java.time.LocalDateTime;


@Slf4j
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Board extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Setter
    private User user;

    private Location location;

    private String title; //게시글 제목
    private String content; //게시글 내용
    private String imageUrl; //게시글 이미지 URL
    private Long projectPeriod; //프로젝트 진행기간
    private LocalDateTime startDate; //프로젝트 시작일
    private LocalDateTime recruitEndDate; //모집 마감일

    @Enumerated(EnumType.STRING)
    @Setter
    private RecruitmentStatus recruitmentStatus; //모집 현황 (RECRUITING, COMPLETED)

    @Setter
    private Long viewCount; //조회수
    private Long commentCount; //댓글 갯수

    @Builder
    public Board(
                 String title,
                 String content,
                 String imageUrl,
                 Location location,
                 Long projectPeriod,
                 LocalDateTime startDate,
                 LocalDateTime recruitEndDate
    ) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.location = location;
        this.projectPeriod = projectPeriod;
        this.startDate = startDate;
        this.recruitEndDate = recruitEndDate;
    }

    public void increaseViewCount() {
        this.viewCount++;
    }

    public void increaseCommentCount() {
        this.commentCount++;
    }
}
