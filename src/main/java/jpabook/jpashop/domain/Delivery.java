package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;  //REDY, COMP

}

/*
* Enum 사용시 주의 사항
* Enumerated를 주입할 때,EnumType은 두가지가 있다.
*
* EnumType.ORDINARY - 순서대로 1,2,3 식으로 입력(인덱스)
* EnumType.STRING   - 문자로 입력(READY, COMP)
*
* 인덱스 순서는 변경 가능성이 있으니
* 꼭 스트링으로 넣기 ->  유지 보수에 유리
* */