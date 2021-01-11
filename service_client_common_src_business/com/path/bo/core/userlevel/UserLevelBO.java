package com.path.bo.core.userlevel;

import java.util.List;


import com.path.dbmaps.vo.USR_LEVELVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.userlevel.UserLevelSC;


public interface UserLevelBO {
	 public int userLevelListCount(UserLevelSC userLevelSC) throws BaseException;
	 public List userLevelList(UserLevelSC userLevelSC) throws BaseException;
	 public USR_LEVELVO returnUserLevelById(UserLevelSC criteria) throws BaseException;

}
