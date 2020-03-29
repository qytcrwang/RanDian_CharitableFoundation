package com.fire.back.service.impl;

import com.fire.back.common.CheckEmptyUtil;
import com.fire.back.common.FireResult;
import com.fire.back.dao.ContriInfoTbMapper;
import com.fire.back.dao.extend.ExtendContriInfoTbMapper;
import com.fire.back.dto.ContriInfoListParamsDto;
import com.fire.back.dto.ContriInfoResultDto;
import com.fire.back.entity.ContriInfoTb;
import com.fire.back.entity.ContriInfoTbExample;
import com.fire.back.service.ContriInfoService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 捐赠信息相关Service相关实现.
 *
 * @author 王凯
 * @since 2020/2/22 18:35
 */
@Service
public class ContriInfoServiceImpl implements ContriInfoService {

  @Resource
  ContriInfoTbMapper contriInfoTbMapper;
  @Resource
  ExtendContriInfoTbMapper extendContriInfoTbMapper;

  @Override
  public Boolean saveContriInfo(ContriInfoTb contriInfoTb) {
    contriDefaultParamUtil(contriInfoTb);
    int i = contriInfoTbMapper.insertSelective(contriInfoTb);
    return i == 1;
  }

  @Override
  public Boolean updateContriStatus(ContriInfoTb contriInfoTb) {
    contriInfoTb.setUpdateTime(System.currentTimeMillis() / 1000);
    int i = contriInfoTbMapper.updateByPrimaryKeySelective(contriInfoTb);
    return i == 1;
  }

  @Override
  public FireResult getContriInfoList(ContriInfoListParamsDto paramsDto) {
    List<ContriInfoResultDto> list = extendContriInfoTbMapper.selectContriInfoByPage(paramsDto);
    Integer count = extendContriInfoTbMapper.getCount(paramsDto);
    if (null != list) {
      return FireResult.build(1, "数据获取成功", list, count);
    }
    return FireResult.build(0, "数据获取失败", list, count);
  }

  @Override
  public List<ContriInfoTb> getSelfContriInfoByStatus(Long userId, int status) {
    ContriInfoTbExample contriInfoTbExample = new ContriInfoTbExample();
    contriInfoTbExample.createCriteria().andUserIdEqualTo(userId).andContriTypeEqualTo(status);
    return contriInfoTbMapper.selectByExample(contriInfoTbExample);
  }

  /**
   * 获取捐赠详情.
   *
   * @param contriInfoId 入参
   * @return
   */
  @Override
  public ContriInfoResultDto getContriInfoDetail(Long contriInfoId) {
    ContriInfoListParamsDto c = new ContriInfoListParamsDto();
    c.setOffSet(0);
    c.setLimit(1);
    c.setContriInfoId(contriInfoId);
    List<ContriInfoResultDto> list = extendContriInfoTbMapper.selectContriInfoByPage(c);
    if (CheckEmptyUtil.isNotEmpty(list)) {
      return list.get(0);
    }
    return null;
  }

  /**
   * 捐赠信息补全方法.
   *
   * @param contriInfoTb 入参
   */
  private void contriDefaultParamUtil(ContriInfoTb contriInfoTb) {
    contriInfoTb.setIsDelete(0);
    contriInfoTb.setContriState(0);
    contriInfoTb.setContriTime(System.currentTimeMillis() / 1000);
    contriInfoTb.setCreateTime(System.currentTimeMillis() / 1000);
  }
}
