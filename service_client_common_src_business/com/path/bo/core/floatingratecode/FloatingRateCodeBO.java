package com.path.bo.core.floatingratecode;

import java.util.List;


import com.path.dbmaps.vo.IBOR_HDRVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.floatingratecode.FloatingRateCodeSC;

public interface FloatingRateCodeBO {
	public int  floatingRateCodeListCount(FloatingRateCodeSC floatingRateCodeSC) throws BaseException;
	public List floatingRateCodeList(FloatingRateCodeSC floatingRateCodeSC) throws BaseException;
	public IBOR_HDRVO returnFloatingRateCodeById(FloatingRateCodeSC criteria) throws BaseException;

}
