package leobook.leoshop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

/**
 * 배송지 관련 Model
 */
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
