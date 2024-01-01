package com.run.runningMvc.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String photoUrl;
    private String content;
    @CreationTimestamp
    private LocalDate createdOn;
    @UpdateTimestamp
    private LocalDate updatedOn;
    @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE)
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event){
        events.add(event);
    }
}
