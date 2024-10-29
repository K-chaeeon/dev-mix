package msa.devmix.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.domain.constant.Location;
import msa.devmix.domain.constant.RecruitmentStatus;
import msa.devmix.dto.BoardDto;
import msa.devmix.dto.BoardTechStackDto;
import msa.devmix.dto.UserDto;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class UpdateBoardRequest {

    @NotBlank(message = "제목을 입력해주세요.")
    @Length(max = 50)
    private String title; //게시글 제목

    @NotBlank(message = "내용을 입력해주세요.")
    @Length(max = 1500)
    private String content; //게시글 내용

    private String imageUrl; //게시글 이미지 URL

    @NotBlank
    private Long projectPeriod; //프로젝트 진행기간
    @NotBlank
    private LocalDateTime startDate; //프로젝트 시작일
    @NotBlank
    private LocalDateTime recruitEndDate; //모집 마감일

    @NotBlank
    private String location;

    @NotBlank
    private String recruitmentStatus; //모집 상태 (RECRUITING, COMPLETED)

    @NotBlank
    private ArrayList<BoardTechStackRequest> boardTechStackList;
    @NotBlank
    private ArrayList<BoardPositionRequest> boardPositionList;

    public BoardDto toDto(UserDto userDto) {
        return BoardDto.of(
                title,
                content,
                userDto,
                Location.valueOf(location),
                imageUrl,
                projectPeriod,
                startDate,
                recruitEndDate,
                RecruitmentStatus.valueOf(recruitmentStatus));
    }
}
