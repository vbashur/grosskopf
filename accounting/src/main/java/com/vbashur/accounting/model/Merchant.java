package com.vbashur.accounting.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@org.immutables.value.Value.Immutable
@JsonSerialize(as = ImmutableMerchant.class)
@JsonDeserialize(as = ImmutableMerchant.class)
public interface Merchant {

    Integer getId();

    String getName();

    String getAddress();

}
