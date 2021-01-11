package com.path.dao.core.cifuseraccess.impl;

import java.math.BigDecimal;
import java.util.Map;

import com.path.dao.core.cifuseraccess.CifUserAccessDAO;
import com.path.dbmaps.vo.CTSTELLER_AXSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cifuseraccess.CifUserAccessSC;

class CifUserAccessDAOImpl extends BaseDAO implements CifUserAccessDAO
{
    
    public Map<BigDecimal, CTSTELLER_AXSVO>   selectCifUserAccessList (CifUserAccessSC cifUserAccessSC) throws DAOException
    {
	return getSqlMap().queryForMap("cifUserAccessMapper.selectCifUserAccessList", cifUserAccessSC,"ACCESS_CODE");
    }
}
