package com.dsa.phase1;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@EqualsAndHashCode
@Builder
@Getter
public class RequestPayload {
    @EqualsAndHashCode.Exclude
    String id;

    @EqualsAndHashCode.Include
    String name;
}
