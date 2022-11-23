package com.bankaya.challenge.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "request_log")
@Entity
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String ipAddress;

    @NotNull
    private LocalDateTime requestDate = LocalDateTime.now();

    @NotNull
    private String method;
}
