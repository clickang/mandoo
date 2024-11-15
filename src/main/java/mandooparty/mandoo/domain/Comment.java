package mandooparty.mandoo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import mandooparty.mandoo.domain.common.BaseEntity;
import mandooparty.mandoo.domain.enums.CommentStatus;

@Entity
@Getter
@Builder
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    private CommentStatus commentStatus;

    private long memberId;

    private long sellPostId;
}
