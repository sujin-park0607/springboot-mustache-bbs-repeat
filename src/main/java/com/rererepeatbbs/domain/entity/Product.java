package com.rererepeatbbs.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product") // 생략 가능
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;    // 상품 번호

    @Column(nullable = false) // not null
    private String name;    // 상품 이름

    @Column(nullable = false)
    private Integer price;  // 상품 가격

    @Column(nullable = false)
    private Integer stock;  // 상품 재고

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
