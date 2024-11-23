package mandooparty.mandoo.repository;

import mandooparty.mandoo.domain.CommentReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentReportRepository extends JpaRepository<CommentReport,Long> {


}
