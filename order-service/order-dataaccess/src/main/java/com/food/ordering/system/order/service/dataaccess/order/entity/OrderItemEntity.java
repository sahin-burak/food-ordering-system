package com.food.ordering.system.order.service.dataaccess.order.entity;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_items")
@Entity
public class OrderItemEntity {

  @Id @EqualsAndHashCode.Include private Long id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "order_id")
  @EqualsAndHashCode.Include
  private OrderEntity order;

  private UUID productId;
  private BigDecimal price;
  private Integer quantity;
  private BigDecimal subTotal;
}
