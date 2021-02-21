package leobook.leoshop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")    // 싱글테이블 구분자
@Getter
@Setter
public class Album extends Item {

    private String artist;
    private String etc;
}
