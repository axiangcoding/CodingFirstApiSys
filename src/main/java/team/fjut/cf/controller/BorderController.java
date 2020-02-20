package team.fjut.cf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.fjut.cf.pojo.enums.ResultJsonCode;
import team.fjut.cf.pojo.vo.*;
import team.fjut.cf.service.BorderHonorRankService;
import team.fjut.cf.service.UserInfoService;

import java.util.List;

/**
 * @author axiang [2019/11/11]
 */
@RestController
@CrossOrigin
@RequestMapping("/border")
public class BorderController {
    @Autowired
    BorderHonorRankService borderHonorRankService;

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/honor_rank")
    public ResultJsonVO getHonorRankList(@RequestParam("pageNum") Integer pageNum,
                                         @RequestParam("pageSize") Integer pageSize) {
        ResultJsonVO resultJsonVO = new ResultJsonVO();
        List<BorderHonorRankVO> borderHonorRankVOS = borderHonorRankService.pages(pageNum, pageSize);
        Integer count  = borderHonorRankService.selectAllCount();
        resultJsonVO.addInfo(borderHonorRankVOS);
        resultJsonVO.addInfo(count);
        return resultJsonVO;
    }

    @GetMapping("/mini")
    public ResultJsonVO getUserBorder(@RequestParam("pageNum") Integer pageNum,
                                      @RequestParam("pageSize") Integer pageSize) {
        ResultJsonVO resultJsonVO = new ResultJsonVO();
        List<UserRatingBorderVO> userRatingBorderVOS = userInfoService.selectRatingBorder(pageNum, pageSize);
        List<UserAcNumBorderVO> userAcNumBorderVOS = userInfoService.selectAcNumBorder(pageNum, pageSize);
        List<UserAcbBorderVO> userAcbBorderVOS = userInfoService.selectAcbBorder(pageNum, pageSize);
        resultJsonVO.setStatus(ResultJsonCode.REQUIRED_SUCCESS);
        resultJsonVO.addInfo(userRatingBorderVOS);
        resultJsonVO.addInfo(userAcNumBorderVOS);
        resultJsonVO.addInfo(userAcbBorderVOS);
        return resultJsonVO;
    }


}