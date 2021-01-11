package com.path.bo.core.vatcode;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.dao.core.vatcode.VatCodeDAO;
import com.path.dbmaps.vo.TRSVATVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.vatcode.VatCodeSC;

public class VatCodeBOImpl extends BaseBO implements VatCodeBO{
	private VatCodeDAO vatCodeDAO;
	
	 public VatCodeDAO getVatCodeDAO()
	    {
		return vatCodeDAO;
	    }
	  public void setVatCodeDAO(VatCodeDAO vatCodeDAO)
	    {
		this.vatCodeDAO = vatCodeDAO;
	    }
	@Override
	public TRSVATVO returnVatCodeById(VatCodeSC criteria)
			throws BaseException {
		TRSVATVO trsVatVO = vatCodeDAO.returnVatCodeById(criteria);
		if(trsVatVO == null || trsVatVO.getVAT_CODE() == null )
		{
			throw new BOException(MessageCodes.INVALID_MISSING_VAT_CODE);
		}
		return trsVatVO;
	}

	@Override
	public List vatCodeList(VatCodeSC vatCodeSC) throws BaseException {
		return vatCodeDAO.vatCodeList(vatCodeSC);
	}

	@Override
	public int vatCodeListCount(VatCodeSC vatCodeSC) throws BaseException {
		return vatCodeDAO.vatCodeListCount(vatCodeSC);		
	}
}
