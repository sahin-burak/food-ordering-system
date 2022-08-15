package com.food.ordering.system.order.service.domain.valueobject;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class StreetAddress {

  private final UUID id;
  private final String street;
  private final String postalCode;
  private final String city;
}
