package com.run.runningMvc.repositories;

import com.run.runningMvc.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
