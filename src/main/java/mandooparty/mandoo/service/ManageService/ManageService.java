package mandooparty.mandoo.service.ManageService;

import mandooparty.mandoo.domain.ManageMember;
import mandooparty.mandoo.domain.Member;
import mandooparty.mandoo.web.dto.ManageDTO;

import java.util.List;

public interface ManageService {

    public List<ManageDTO.ManageDashBoardSellPostDto> getDaySellPostCount();

    public List<ManageDTO.ManageDashBoardCategoryRatioDto> getCategoryRatio();

    public List<ManageDTO.ManageDashBoardDateViewDto> getDateView();

    public List<ManageMember> getMember(Integer page);
}
