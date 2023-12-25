package com.nirmal.springbooth2demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Instructor")
public class Instructor {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "instructor_id")
    private UUID instructorId;

    @Column(name = "instructor_first_name")
    private String instructorFirstName;

    @Column(name = "instructor_last_name")
    private String instructorLastName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;

    @Column(name = "active")
    private Boolean active;
    @JsonIgnore
    @Column(name = "created_by")
    private String createdBy;

    @JsonIgnore
    @Column(name = "updated_by")
    private String updatedBy;

    @JsonIgnore
    @Column(name = "created_at")
    @UpdateTimestamp
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}