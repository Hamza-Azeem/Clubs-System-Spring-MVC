package com.run.runningMvc.Dtos;

import com.run.runningMvc.models.Club;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private int id;
    @NotEmpty(message = "Name of event shouldn't be empty")
    private String name;
    //@NotEmpty(message = "Type of event shouldn't be empty")
    private String type;
    @NotEmpty(message = "Photo Url of event shouldn't be empty")
    private String photoUrl;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    @DateTimeFormat(pattern = "yyyy/MM/dd'T'HH:mm")
    @NotNull(message = "Start of event shouldn't be empty")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern = "yyyy/MM/dd'T'HH:mm")
    @NotNull(message = "End of event shouldn't be empty")
    private LocalDateTime endTime;
    private Club club;

}
