package com.vbashur.guardian.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@org.immutables.value.Value.Immutable
@JsonSerialize(as = ImmutableUserDTO.class)
@JsonDeserialize(as = ImmutableUserDTO.class)
public interface UserDTO {

    String username();

    String password();

}
