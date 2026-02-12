package jsg.my_project.mts.trade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jsg.my_project.global.util.BaseTime;
import jsg.my_project.mts.member.Member;
import jsg.my_project.mts.orders.Order;
import jsg.my_project.mts.stock.Stock;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 체결 기록 엔티티
 *
 */

@Entity
@Table(name = "trade")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Trade extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buy_order_id")
    private Order buyOrder; // 매수 주문

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sell_order_id")
    private Order sellOrder; // 매도 주문

    private Long price;

    private Long quantity;
}
