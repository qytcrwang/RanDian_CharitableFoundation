package com.fire.back.controller.web;

import com.fire.back.common.FireResult;
import com.fire.back.entity.LovePointsTb;
import com.fire.back.service.LovePointsService;
import com.fire.back.util.ParamUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/back/lovePoint")
public class BackLovePointController {

    private final
    LovePointsService lovePointsService;

    @Autowired
    public BackLovePointController(LovePointsService lovePointsService) {
        this.lovePointsService = lovePointsService;
    }


    private org.slf4j.Logger logger = LoggerFactory.getLogger(BackLovePointController.class);

    @GetMapping("/love")
    public String info(String name,String mobile, ModelMap map){
        map.put("name",name);
        map.put("mobile",mobile);
        return "/user/lovePoint";
    }
    @GetMapping("/")
    public String index(){
        return "user/lovePoint";
    }

    /**
     * 获取用户的爱心积分变更列表
     * @param paramMap
     * @return
     */
    @PostMapping("/list")
    @ResponseBody
    public FireResult getLovedPointsListByUserId(@RequestBody Map<String,Object> paramMap){
        try {
            LovePointsTb l = new LovePointsTb();
            l.setUserId(ParamUtil.getLong(paramMap, "userId"));
            l.setType(ParamUtil.getInteger(paramMap,"type",null));
            l.setStatus(ParamUtil.getInteger(paramMap,"status",0));
            l.setOperatorId(ParamUtil.getLong(paramMap,"operatorId",null));
            l.setIsDelete(ParamUtil.getInteger(paramMap,"isDelete",0));
            Integer page = ParamUtil.getInteger(paramMap, "page",1);
            Integer limit = ParamUtil.getInteger(paramMap, "limit",10);
            List<LovePointsTb> list = lovePointsService.getLovePointsTbListByUserId(l, page, limit);
            int count = lovePointsService.getLovePointsTbCountByUserId(l);
            return FireResult.build(1, "爱心积分查询成功", list,count);
        }catch(Exception e){
            logger.error("爱心积分查询异常",e);
            return FireResult.build(0, "爱心积分查询异常", null);

        }
    }

    /**
     * 新增一条爱心积分
     * @param  l
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public FireResult insertLovePoints(@RequestBody LovePointsTb l){
        try {
            l.setOperatorId(1l);//TODO
            l.setStatus(0);
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
     * 批量添加爱心积分
     * @param  list
     * @return
     */
    @PostMapping("/batchAdd")
    @ResponseBody
    public FireResult batchInsertLovePoints(@RequestBody List<LovePointsTb> list){
        try {
            for(LovePointsTb l:list){
                l.setOperatorId(1l);//TODO
                l.setStatus(0);
                l.setCreateTime(System.currentTimeMillis()/1000);
                l.setUpdateTime(System.currentTimeMillis()/1000);
                l.setIsDelete(0);
            }
            int result = lovePointsService.batchInsertLvoePoints(list);
            return result>0?FireResult.build(1,"添加爱心积分成功",null):
                    FireResult.build(0,"添加爱心积分失败",null);
        } catch (Exception e) {
            logger.error("添加爱心积分异常",e);
            return FireResult.build(0,"添加爱心积分异常",null);
        }

    }
    /**
     * 删除一条爱心积分
     * @param
     * @return
     */
    @PostMapping("/del")
    @ResponseBody
    public FireResult deleteLovePoints(@RequestBody LovePointsTb l){
        try {
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

    /**
     * 删除一条爱心积分
     * @param
     * @return
     */
    @PostMapping("/batchDel")
    @ResponseBody
    public FireResult batchDeleteLovePoints(@RequestBody List<LovePointsTb> list){
        try {
            for(LovePointsTb l :list){
                l.setUpdateTime(System.currentTimeMillis()/1000);
                l.setIsDelete(1);
            }
            int result = lovePointsService.batchUpdateLovePoints(list);
            return result>0?FireResult.build(1,"删除爱心积分成功",null):
                    FireResult.build(0,"删除爱心积分失败",null);
        } catch (Exception e) {
            logger.error("删除异常",e);
            return FireResult.build(0,"删除爱心积分异常",null);
        }
    }
}
