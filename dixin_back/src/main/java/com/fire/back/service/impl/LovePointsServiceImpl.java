package com.fire.back.service.impl;

import com.fire.back.dao.extend.ExtendLovePointsTbMapper;
import com.fire.back.dao.extend.ExtendUserTbMapper;
import com.fire.back.entity.LovePointsTb;
import com.fire.back.entity.LovePointsTbExample;
import com.fire.back.service.LovePointsService;
import org.slf4j.LoggerFactory;
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
        int result = 0;
        try {
            result = lovePointsTbMapper.insertSelective(l);
            int uResult = extendUserTbMapper.updateLovePointsByUser(l.getUserId());
            if (result <= 0 || uResult <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return 0;
            }
        }catch(Exception e){
            LoggerFactory.getLogger(LovePointsServiceImpl.class).error("添加爱心积分异常,操作回滚");
            e.printStackTrace();
            //事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }


    @Override
    public List<LovePointsTb> getLovePointsTbListByUserId(LovePointsTb lovePointsTb,int page,int pageSize) {
        return lovePointsTbMapper.selectLovePointsByPage(lovePointsTb,(page-1)*pageSize,pageSize);
    }

    @Override
    public int updateLovePoints(LovePointsTb l) {
        int result = 0;
        try {
            result = lovePointsTbMapper.updateByPrimaryKeySelective(l);
            int uResult = extendUserTbMapper.updateLovePointsByUser(l.getUserId());
            if (result <= 0 || uResult <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return 0;
            }
        }catch(Exception e){
            //事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }
}
