package com.vbashur.authservice.security;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vbashur.authservice.security.ImmutableAccountCredentials;

@org.immutables.value.Value.Immutable
@JsonSerialize(as = ImmutableAccountCredentials.class)
@JsonDeserialize(as = ImmutableAccountCredentials.class)
public interface AccountCredentials {

    String getUsername();

    String getPassword();
}
