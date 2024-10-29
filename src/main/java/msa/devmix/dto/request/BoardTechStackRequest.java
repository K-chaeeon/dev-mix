package msa.devmix.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.dto.BoardTechStackDto;

@Data
@AllArgsConstructor
public class BoardTechStackRequest {

    private String techStackName;

    public BoardTechStackDto toDto() {
        return BoardTechStackDto.of(techStackName, null);
    }

}
