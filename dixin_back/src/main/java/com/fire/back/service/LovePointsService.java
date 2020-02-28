package com.fire.back.service;

import com.fire.back.entity.LovePointsTb;

import java.util.List;

public interface LovePointsService {


    int insertLovePoints(LovePointsTb u);

    List<LovePointsTb> getLovePointsTbListByUserId(LovePointsTb lovePointsTb,int page,int pageSize);

    int updateLovePoints(LovePointsTb u);
}
