package com.vbashur.authservice.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@org.immutables.value.Value.Immutable
@JsonSerialize(as = ImmutableTestData.class)
@JsonDeserialize(as = ImmutableTestData.class)
public interface TestData {

    String getName();

    Integer getValue();
}
