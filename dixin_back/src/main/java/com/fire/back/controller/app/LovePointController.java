package com.fire.back.controller.app;
import com.fire.back.common.FireResult;
import com.fire.back.entity.LovePointsTb;
import com.fire.back.service.LovePointsService;
import com.fire.back.util.ParamUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/lovePoint")
public class LovePointController {

    private final
    LovePointsService lovePointsService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(LovePointController.class);


    @Autowired
    public LovePointController(LovePointsService lovePointsService) {
        this.lovePointsService = lovePointsService;
    }

    /**
     * 获取用户的爱心积分变更列表
     * @param paramMap
     * @return
     */
    @PostMapping("/getLovedList")
    public FireResult getLovedPointsListByUserId(@RequestBody Map<String,Object> paramMap){
        try {
            LovePointsTb l = new LovePointsTb();
            l.setUserId(ParamUtil.getLong(paramMap, "userId"));
            l.setType(ParamUtil.getInteger(paramMap,"type",null));
            l.setStatus(ParamUtil.getInteger(paramMap,"status",null));
            l.setOperatorId(ParamUtil.getLong(paramMap,"operatorId",null));
            l.setIsDelete(ParamUtil.getInteger(paramMap,"isDelete",0));
            Integer page = ParamUtil.getInteger(paramMap, "page",1);
            Integer pageSize = ParamUtil.getInteger(paramMap, "pageSize",20);
            List<LovePointsTb> list = lovePointsService.getLovePointsTbListByUserId(l, page, pageSize);
            return FireResult.build(1, "爱心积分查询成功", list);
        }catch(Exception e){
            logger.error("爱心积分查询异常",e);
            return FireResult.build(0, "爱心积分查询异常", null);

        }
    }
}
