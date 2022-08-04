package com.food.ordering.system.order.service.domain.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class StreetAddress {

  private final UUID id;
  private final String street;
  private final String postCode;
  private final String city;
}
