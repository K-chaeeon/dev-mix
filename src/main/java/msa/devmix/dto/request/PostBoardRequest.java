package msa.devmix.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.domain.constant.Location;
import msa.devmix.dto.BoardDto;
import msa.devmix.dto.UserDto;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostBoardRequest {

    // 제목, 내용, 대표이미지, 모집상태, 포지션리스트, 지역, 프로젝트 진행기간, 기술스택


    @NotBlank(message = "제목을 입력해주세요.")
    @Length(max = 50)
    private String title; //게시글 제목

    @NotBlank(message = "내용을 입력해주세요.")
    @Length(max = 1500)
    private String content; //게시글 내용

    private String imageUrl; //게시글 이미지 URL

    @NotBlank
    private Long projectPeriod; //프로젝트 진행기간

    private Location location; //모집 지역

    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime startDate; //프로젝트 시작일

    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime recruitEndDate; //모집 마감일


    @NotBlank
    private List<BoardTechStackRequest> boardTechStackList;
    @NotBlank
    private List<BoardPositionRequest> boardPositionList;


//    public BoardDto toDto() {
//        return BoardDto.of(
//                title,
//                content,
//                location,
//                imageUrl,
//                projectPeriod,
//                startDate,
//                recruitEndDate
//                );
//    }

    public BoardDto toDto(UserDto userDto) {
        return BoardDto.of(
                title,
                content,
                userDto,
                location,
                imageUrl,
                projectPeriod,
                startDate,
                recruitEndDate
        );
    }
}
