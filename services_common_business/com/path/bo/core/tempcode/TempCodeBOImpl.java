package com.path.bo.core.tempcode;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.dao.core.tempcode.TempCodeDAO;
import com.path.dbmaps.vo.TRSPAYPLANTMPLTVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.tempcode.TempCodeSC;

public class TempCodeBOImpl extends BaseBO implements TempCodeBO {
	private TempCodeDAO tempCodeDAO;
	
	 public TempCodeDAO getTempCodeDAO()
	    {
		return tempCodeDAO;
	    }
	  public void setTempCodeDAO(TempCodeDAO tempCodeDAO)
	    {
		this.tempCodeDAO = tempCodeDAO;
	    }
	@Override
	public TRSPAYPLANTMPLTVO returnTempCodeById(TempCodeSC criteria)throws BaseException {
		TRSPAYPLANTMPLTVO tempCodeVO = tempCodeDAO.returnTempCodeById(criteria);
		if(tempCodeVO == null)
		{
			throw new BOException(MessageCodes.INVALID_REPAYMENT_TEMPLATE_CODE);
		}
		return tempCodeDAO.returnTempCodeById(criteria);
	}

	@Override
	public List tempCodeList(TempCodeSC tempCodeSC) throws BaseException {
		return tempCodeDAO.tempCodeList(tempCodeSC);
	}

	@Override
	public int tempCodeListCount(TempCodeSC tempCodeSC) throws BaseException {
		return tempCodeDAO.tempCodeListCount(tempCodeSC);		
	}

	

}
