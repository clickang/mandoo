package mandooparty.mandoo.repository;

import mandooparty.mandoo.domain.Comment;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {


//    @Query("SELECT COUNT(c) FROM Comment c WHERE c.createdAt >= :startOfDay AND c.createdAt<:endOfDay")
//    Long getCountByDate(@Param("startOfDay") LocalDateTime startOfDay, @Param("endOfDay")LocalDateTime endOfDay);

    @Query("SELECT COUNT(c) FROM Comment c WHERE c.createdAt >= :startOfDay AND c.createdAt<:endOfDay")
    Long getCountByDate(@Param("startOfDay") LocalDateTime startOfDay, @Param("endOfDay")LocalDateTime endOfDay);
}
