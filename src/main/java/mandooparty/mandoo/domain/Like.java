package mandooparty.mandoo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import mandooparty.mandoo.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@Table(name = "like")
public class Like extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private Long sellPostId;


}
