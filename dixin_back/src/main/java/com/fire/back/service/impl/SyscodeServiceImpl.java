package com.fire.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.back.dao.SyscodeTbMapper;
import com.fire.back.entity.SyscodeTb;
import com.fire.back.entity.SyscodeTbExample;
import com.fire.back.entity.SyscodeTbExample.Criteria;
import com.fire.back.service.SyscodeService;
/**
 * 
 * @author dragon
 *
 * Mar 19, 2020
 */
@Service
public class SyscodeServiceImpl implements SyscodeService {
	@Autowired
	private SyscodeTbMapper syscodeTbMapper;
	
	@Override
	public List<SyscodeTb> getSyscode(String name){
		SyscodeTbExample example = new SyscodeTbExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		return syscodeTbMapper.selectByExample(example);
	}
}
