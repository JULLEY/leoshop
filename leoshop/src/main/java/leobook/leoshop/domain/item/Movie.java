package leobook.leoshop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")    // 싱글테이블 구분자
@Getter
@Setter
public class Movie extends Item {

    private String director;
    private String actor;
}
