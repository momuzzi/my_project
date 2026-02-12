package jsg.my_project.mts.orders;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jsg.my_project.global.util.BaseTime;
import jsg.my_project.mts.member.Member;
import jsg.my_project.mts.stock.Stock;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * 주문 엔티티
 *
 */

@Entity
@Table(name = "orders")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private Long quantity; // 주문량
    private Long remainingQuantity; // 남은 주문량

    @Enumerated(EnumType.STRING)
    private OrderType orderType; // 매수 or 매도

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // 미체결, 부분 체결, 체결 완료, 취소
}
