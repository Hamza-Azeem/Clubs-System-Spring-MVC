package com.run.runningMvc.Dtos;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ClubDto {

    private Integer id;
    @NotEmpty(message = "Title shouldn't be empty!")
    private String title;
    @NotEmpty(message = "Photo Url shouldn't be empty!")
    private String photoUrl;
    @NotEmpty(message = "Content shouldn't be empty!")
    private String content;
    private LocalDate createdOn;
    private LocalDate updatedOn;
    private List<EventDto> events = new ArrayList<>();
}
