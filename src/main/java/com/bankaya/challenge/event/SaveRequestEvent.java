package com.bankaya.challenge.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveRequestEvent {

    private String ipAddress;
    private String method;

}
