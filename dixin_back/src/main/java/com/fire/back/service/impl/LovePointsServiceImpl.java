package com.fire.back.service.impl;

import com.fire.back.dao.extend.ExtendLovePointsTbMapper;
import com.fire.back.dao.extend.ExtendUserTbMapper;
import com.fire.back.entity.LovePointsTb;
import com.fire.back.service.LovePointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class LovePointsServiceImpl implements LovePointsService {

    private final
    ExtendLovePointsTbMapper lovePointsTbMapper;

    private final
    ExtendUserTbMapper extendUserTbMapper;

    @Autowired
    public LovePointsServiceImpl(ExtendLovePointsTbMapper lovePointsTbMapper,ExtendUserTbMapper extendUserTbMapper) {
        this.lovePointsTbMapper = lovePointsTbMapper;
        this.extendUserTbMapper = extendUserTbMapper;
    }

    @Transactional
    @Override
    public int insertLovePoints(LovePointsTb l) {
         lovePointsTbMapper.insertSelective(l);
        return  extendUserTbMapper.updateLovePointsByUser(l.getUserId(),l.getUpdateTime());
    }

    @Override
    @Transactional
    public int batchInsertLvoePoints(List<LovePointsTb> list) {
        lovePointsTbMapper.batchInsertLvoePoints(list);
        return   extendUserTbMapper.batchUpdateLovePointsByUser(list);
    }


    @Override
    public List<LovePointsTb> getLovePointsTbListByUserId(LovePointsTb lovePointsTb,int page,int pageSize) {
        return lovePointsTbMapper.selectLovePointsByPage(lovePointsTb,(page-1)*pageSize,pageSize);
    }

    @Override
    public int getLovePointsTbCountByUserId(LovePointsTb lovePointsTb){
        return lovePointsTbMapper.selectLovePointsCount(lovePointsTb);
    }

    @Transactional
    @Override
    public int updateLovePoints(LovePointsTb l) {
        lovePointsTbMapper.updateByPrimaryKeySelective(l);
        return extendUserTbMapper.updateLovePointsByUser(l.getUserId(),l.getUpdateTime());
    }

    @Override
    @Transactional
    public int batchUpdateLovePoints(List<LovePointsTb> list) {
      lovePointsTbMapper.batchDeleteLovePoints(list);
      return   extendUserTbMapper.batchUpdateLovePointsByUser(list);
    }
}
