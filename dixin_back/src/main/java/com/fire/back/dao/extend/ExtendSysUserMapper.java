package com.fire.back.dao.extend;

import com.fire.back.dao.SysUserMapper;
import com.fire.back.dto.SysUserExtend;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtendSysUserMapper extends SysUserMapper {

    SysUserExtend getSysUserListByName(String loginName);
}
