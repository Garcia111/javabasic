package com.example.javabasic.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author：Cheng.
 * @date：Created in 9:32 2019/11/18
 */
@Data
@ToString
@EqualsAndHashCode
@Table(name = "order_info")
@Entity
@Accessors(chain = true)
@EntityListeners({AuditingEntityListener.class})
public class OrderEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "amount",nullable = false)
    private Long amount;

}
