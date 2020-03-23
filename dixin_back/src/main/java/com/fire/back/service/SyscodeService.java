package com.fire.back.service;

import java.util.List;

import com.fire.back.entity.SyscodeTb;

/**
 * 
 * @author dragon
 *
 * Mar 19, 2020
 */
public interface SyscodeService {
	List<SyscodeTb> getSyscode(String name);
}
