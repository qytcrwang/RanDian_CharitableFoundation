package com.fire.back.controller.web;

import com.fire.back.common.FireResult;
import com.fire.back.controller.app.UserController;
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
@RequestMapping("/back/lovePoint")
public class BackLovePointController {

    private final
    LovePointsService lovePointsService;

    @Autowired
    public BackLovePointController(LovePointsService lovePointsService) {
        this.lovePointsService = lovePointsService;
    }


    private org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

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

    /**
     * 新增一条爱心积分
     * @param paramMap
     * @return
     */
    @PostMapping("/insertLovePoint")
    public FireResult insertLovePoints(@RequestBody Map<String,Object> paramMap){
        try {
            LovePointsTb l = new LovePointsTb();
            l.setUserId(ParamUtil.getLong(paramMap,"userId"));
            l.setLovePoints(ParamUtil.getInteger(paramMap,"lovePoint",0));
            l.setType(ParamUtil.getInteger(paramMap,"type",0));
            l.setActivityId(ParamUtil.getLong(paramMap,"activityId",null));
            l.setDescription(ParamUtil.getString(paramMap,"description",null));
            l.setOperatorId(ParamUtil.getLong(paramMap,"operatorId",null));
            l.setStatus(ParamUtil.getInteger(paramMap,"status",0));
            l.setCreateTime(System.currentTimeMillis()/1000);
            l.setUpdateTime(System.currentTimeMillis()/1000);
            l.setIsDelete(0);
            int result = lovePointsService.insertLovePoints(l);
            return result>0?FireResult.build(1,"添加爱心积分成功",null):
                    FireResult.build(0,"添加爱心积分失败",null);
        } catch (Exception e) {
            logger.error("添加爱心积分异常",e);
            return FireResult.build(0,"添加爱心积分异常",null);
        }

    }

    /**
     * 删除一条爱心积分
     * @param paramMap
     * @return
     */
    @PostMapping("/deleteLovePoint")
    public FireResult deleteLovePoints(@RequestBody Map<String,Object> paramMap){
        try {
            LovePointsTb l = new LovePointsTb();
            l.setId(ParamUtil.getLong(paramMap,"id"));
            l.setUserId(ParamUtil.getLong(paramMap,"userId"));
            l.setUpdateTime(System.currentTimeMillis()/1000);
            l.setIsDelete(1);
            int result = lovePointsService.updateLovePoints(l);
            return result>0?FireResult.build(1,"删除爱心积分成功",null):
                    FireResult.build(0,"删除爱心积分失败",null);
        } catch (Exception e) {
            logger.error("删除异常",e);
            return FireResult.build(0,"删除爱心积分异常",null);
        }
    }
}
