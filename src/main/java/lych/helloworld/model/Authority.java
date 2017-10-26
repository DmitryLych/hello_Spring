package lych.helloworld.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = 2990114094264182518L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment1")
    @GenericGenerator(name = "increment1", strategy = "increment")
    private Integer id;

    private String authority;

    @Column(name = "user_id")
    private Integer userId;

    @Override
    public String getAuthority() {

        return this.authority;
    }
}
