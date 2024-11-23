package mandooparty.mandoo.repository;

import jakarta.persistence.Tuple;
import mandooparty.mandoo.domain.SellPost;
import mandooparty.mandoo.domain.enums.SellPostStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SellPostRepository extends JpaRepository<SellPost, Long> {
    Optional<SellPost> findByTitle(String title);

    @Query("SELECT s FROM SellPost s WHERE s.member.id = :memberId AND s.status= :status")
    List<SellPost> findByMemberAndStatus(@Param("memberId") Long memberId,@Param("status") SellPostStatus status);

    Optional<SellPost> existsByMemberId(Long memberId);

    @Query("SELECT s.createdAt, COUNT(s) " +
            "FROM SellPost s " +
            "GROUP BY s.createdAt " +
            "ORDER BY s.createdAt ASC")
    List<Tuple> countByCreatedAt();

    @Query("SELECT COUNT(m) FROM SellPost s WHERE s.createdAt=:day")
    Long getCountByDate(@Param("day") LocalDate day);

}

