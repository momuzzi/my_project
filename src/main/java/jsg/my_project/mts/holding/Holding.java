package jsg.my_project.mts.holding;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jsg.my_project.global.util.BaseTime;
import jsg.my_project.mts.stock.Stock;
import jsg.my_project.mts.member.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 보유 주식 엔티티
 *
 * 특정 스톡을 매수 시 발생
 */

@Entity
@Table(name = "holding")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Holding extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private Long quantity;

}
