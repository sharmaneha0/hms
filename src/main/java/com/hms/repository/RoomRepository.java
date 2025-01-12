package com.hms.repository;

import com.hms.entity.Property;
import com.hms.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r WHERE r.date BETWEEN :startDate AND :endDate and r.type=:type and r.property=:property")
    List<Room> findByTypeAndProperty(
            @Param("startDate") LocalDate fromDate,
            @Param("endDate")   LocalDate toDate,
            @Param("type")       String  type,
            @Param("property")   Property property
    );

}
