package mandooparty.mandoo.repository;

import mandooparty.mandoo.domain.Like;
import mandooparty.mandoo.domain.SellPost;
import mandooparty.mandoo.domain.enums.SellPostStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    @Query("SELECT * FROM Like,SellPost WHERE Like.memberId=?1 " +
            "AND Like.sellPostId=SellPost.Id" +
            "ORDER BY SellPost.createdAt" +
            "LIMIT 6 OFFSET ?2")
    List<SellPost> findAllLike(Long memberId,Integer page);

    @Query("SELECT * FROM Like,SellPost WHERE Like.memberId=?1 " +
            "AND Like.sellPostId=SellPost.Id " +
            "AND SellPost.Status=?2" +
            "ORDER BY SellPost.createdAt" +
            "LIMIT 6 OFFSET ?3")
    List<SellPost> findAllLike(Long memberId, SellPostStatus status,Integer page);
}
