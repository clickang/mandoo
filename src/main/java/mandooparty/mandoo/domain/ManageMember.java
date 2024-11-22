package mandooparty.mandoo.domain;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ManageMember extends Member{
    private LocalDate createAt;
    private LocalDate modifiedAt;
}
