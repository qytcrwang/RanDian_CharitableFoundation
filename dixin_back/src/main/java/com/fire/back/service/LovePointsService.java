package com.fire.back.service;

import com.fire.back.entity.LovePointsTb;

import java.util.List;

public interface LovePointsService {


    int insertLovePoints(LovePointsTb u);

    int batchInsertLvoePoints(List<LovePointsTb> list);

    List<LovePointsTb> getLovePointsTbListByUserId(LovePointsTb lovePointsTb,int page,int pageSize);

    int getLovePointsTbCountByUserId(LovePointsTb lovePointsTb);

    int updateLovePoints(LovePointsTb u);

    int batchUpdateLovePoints(List<LovePointsTb> list);
}
