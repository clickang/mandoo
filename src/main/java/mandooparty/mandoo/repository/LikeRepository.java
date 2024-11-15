package mandooparty.mandoo.repository;

import mandooparty.mandoo.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

//    List<SellPost> findAllLike(Long memberId);
}
