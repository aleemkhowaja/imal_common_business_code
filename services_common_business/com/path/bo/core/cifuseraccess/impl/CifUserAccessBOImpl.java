package com.path.bo.core.cifuseraccess.impl;

import java.math.BigDecimal;
import java.util.Map;

import com.path.bo.core.cifuseracces.CifUserAccessBO;
import com.path.dao.core.cifuseraccess.CifUserAccessDAO;
import com.path.dbmaps.vo.CTSTELLER_AXSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cifuseraccess.CifUserAccessSC;

public class CifUserAccessBOImpl extends BaseBO implements CifUserAccessBO {
    
    private CifUserAccessDAO cifUserAccessDAO;

    public void setCifUserAccessDAO(CifUserAccessDAO cifUserAccessDAO)
    {
        this.cifUserAccessDAO = cifUserAccessDAO;
    }

    public Map<BigDecimal, CTSTELLER_AXSVO>  selectCifUserAccessList (CifUserAccessSC cifUserAccessSC) throws BaseException
    {
	
	
	
	return cifUserAccessDAO.selectCifUserAccessList(cifUserAccessSC);
	
    }

}
