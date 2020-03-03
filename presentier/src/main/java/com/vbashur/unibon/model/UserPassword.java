package com.vbashur.unibon.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@org.immutables.value.Value.Immutable
@JsonSerialize(as = ImmutableUserPassword.class)
@JsonDeserialize(as = ImmutableUserPassword.class)
public interface UserPassword {

    String username();

    String password();

}
