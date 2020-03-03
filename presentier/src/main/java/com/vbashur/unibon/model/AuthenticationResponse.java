package com.vbashur.unibon.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@org.immutables.value.Value.Immutable
@JsonSerialize(as = ImmutableAuthenticationResponse.class)
@JsonDeserialize(as = ImmutableAuthenticationResponse.class)
public interface AuthenticationResponse {

    String token();
}