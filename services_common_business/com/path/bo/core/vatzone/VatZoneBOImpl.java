package com.path.bo.core.vatzone;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.dao.core.vatzone.VatZoneDAO;
import com.path.dbmaps.vo.CTS_VAT_ZONEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.vatzone.VatZoneSC;

public class VatZoneBOImpl extends BaseBO implements VatZoneBO
{
    private VatZoneDAO vatZoneDAO;

    public VatZoneDAO getVatZoneDAO()
    {
	return vatZoneDAO;
    }

    public void setVatZoneDAO(VatZoneDAO vatZoneDAO)
    {
	this.vatZoneDAO = vatZoneDAO;
    }

    @Override
    public CTS_VAT_ZONEVO returnZoneCodeById(VatZoneSC criteria) throws BaseException
    {
	CTS_VAT_ZONEVO ctsVatZoneVO = vatZoneDAO.returnZoneCodeById(criteria);
	if(ctsVatZoneVO == null || ctsVatZoneVO.getZONE_CODE() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_VAT_CODE);
	}
	return ctsVatZoneVO;
    }

    @Override
    public List vatZoneList(VatZoneSC vatZoneSC) throws BaseException
    {
	return vatZoneDAO.vatZoneList(vatZoneSC);
    }

    @Override
    public int vatZoneListCount(VatZoneSC vatZoneSC) throws BaseException
    {
	return vatZoneDAO.vatZoneListCount(vatZoneSC);
    }
}
