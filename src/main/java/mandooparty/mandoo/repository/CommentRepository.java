package mandooparty.mandoo.repository;

import mandooparty.mandoo.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {


    @Query("SELECT COUNT(m) FROM Comment c WHERE c.createdAt=:day")
    Long getCountByDate(@Param("day") LocalDate day);
}
