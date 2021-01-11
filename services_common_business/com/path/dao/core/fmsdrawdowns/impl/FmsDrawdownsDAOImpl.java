package com.path.dao.core.fmsdrawdowns.impl;

import java.util.List;

import com.path.dao.core.fmsdrawdowns.FmsDrawdownsDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.facilitytype.FacilityTypeSC;
import com.path.vo.core.fmsdrowdowns.FMSDrawdownCO;
import com.path.vo.core.fmsdrowdowns.FMSDrawdownSC;

public class FmsDrawdownsDAOImpl extends BaseDAO implements FmsDrawdownsDAO
{

    public List fmsDrawDownsList(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "fmsDrawdownsMapper.fmsDrawdownListMap");
	if(facilityTypeSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("fmsDrawdownsMapper.fmsDrawDownsList", facilityTypeSC);
	}
	else
	{
	    return getSqlMap().queryForList("fmsDrawdownsMapper.fmsDrawDownsList", facilityTypeSC, facilityTypeSC.getRecToskip(),
	    		facilityTypeSC.getNbRec());
	}
    }

    public int fmsDrawDownsListCount(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("fmsDrawdownsMapper.fmsDrawDownsListCount", facilityTypeSC)).intValue();
	return nb;
    }

    public List fmsDrawDownsListFMS(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "fmsDrawdownsMapper.fmsDrawdownListMap");
	if(facilityTypeSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("fmsDrawdownsMapper.fmsDrawDownsListFMS", facilityTypeSC);
	}
	else
	{
	    return getSqlMap().queryForList("fmsDrawdownsMapper.fmsDrawDownsListFMS", facilityTypeSC, facilityTypeSC.getRecToskip(),
	    		facilityTypeSC.getNbRec());
	}
    }

    public int fmsDrawDownsListCountFMS(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("fmsDrawdownsMapper.fmsDrawDownsListCountFMS", facilityTypeSC)).intValue();
	return nb;
    }

    public FMSDrawdownCO returnDependencyByCode(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	return (FMSDrawdownCO) getSqlMap().queryForObject("fmsDrawdownsMapper.returnFMSDrawdownCOByCode", facilityTypeSC);
    }

    public int returnCountFMSDRWDWNByCodeAndStatus(FMSDrawdownSC fMSDrawdownSC) throws DAOException
    {
	return (Integer) getSqlMap().queryForObject("fmsDrawdownsMapper.returnCountFMSDRWDWNByCodeAndStatus", fMSDrawdownSC);
    }

	@Override
	public FMSDrawdownCO validateDrawdownCodeforAccounts(FacilityTypeSC facilityTypeSC) throws DAOException
	{
		return (FMSDrawdownCO) getSqlMap().queryForObject("fmsDrawdownsMapper.validateDrawdownCodeforAccounts", facilityTypeSC);
	}

    /**
     * TfaFmsDrawDowns Lookup count
     *
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_draw_down (tfa06.pbl)/ dw_lookup_draw_down (ora_syb.pbl,syb_tfa.pbl)
     */
    public int returnTfaDrwDwnCount(FacilityTypeSC facilityTypeSC) throws DAOException
    {
        DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "fmsDrawdownsMapper.resultTfaFmsDrwDwnLkpMap");
        return ((Integer) getSqlMap().queryForObject("fmsDrawdownsMapper.returnTfaDrwDwnCount", facilityTypeSC))
            .intValue();
    }

    /**
     * TfaFmsDrawDowns Lookup list
     *
     * @author: BoushraFahs
     * @date: 27 Feb 2014
     * @PB: w_lookup_draw_down (tfa06.pbl)/ dw_lookup_draw_down (ora_syb.pbl,syb_tfa.pbl)
     */
    public List<FMSDrawdownCO> returnTfaDrwDwnList(FacilityTypeSC facilityTypeSC) throws DAOException
    {

        DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "fmsDrawdownsMapper.resultTfaFmsDrwDwnLkpMap");
        if(facilityTypeSC.getNbRec() == -1)
        {
            return getSqlMap().queryForList("fmsDrawdownsMapper.returnTfaDrwDwnList", facilityTypeSC);

        }
        else
        {
            return getSqlMap().queryForList("fmsDrawdownsMapper.returnTfaDrwDwnList", facilityTypeSC,
                facilityTypeSC.getRecToskip(), facilityTypeSC.getNbRec());
        }
    }
    
    public int returnDrwDwnAccountCount(FacilityTypeSC facilityTypeSC) throws DAOException
    {
        DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "fmsDrawdownsMapper.resultDrwDwnAccountLkpMap");
        return ((Integer) getSqlMap().queryForObject("fmsDrawdownsMapper.returnDrwDwnAccountCount", facilityTypeSC))
            .intValue();
    }

    public List<FMSDrawdownCO> returnDrwDwnAccountList(FacilityTypeSC facilityTypeSC) throws DAOException
    {
        DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "fmsDrawdownsMapper.resultDrwDwnAccountLkpMap");
        if(facilityTypeSC.getNbRec() == -1)
        {
            return getSqlMap().queryForList("fmsDrawdownsMapper.returnDrwDwnAccountList", facilityTypeSC);

        }
        else
        {
            return getSqlMap().queryForList("fmsDrawdownsMapper.returnDrwDwnAccountList", facilityTypeSC,
                facilityTypeSC.getRecToskip(), facilityTypeSC.getNbRec());
        }
    }
    
    public int returnDrwDwnListCount(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "fmsDrawdownsMapper.resultDrwDwnLkpMap");
	return ((Integer) getSqlMap().queryForObject("fmsDrawdownsMapper.returnDrwDwnListCount", facilityTypeSC))
	.intValue();
    }
    
    public List<FMSDrawdownCO> returnDrwDwnList(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "fmsDrawdownsMapper.resultDrwDwnLkpMap");
	if(facilityTypeSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("fmsDrawdownsMapper.returnDrwDwnList", facilityTypeSC);
	    
	}
	else
	{
	    return getSqlMap().queryForList("fmsDrawdownsMapper.returnDrwDwnList", facilityTypeSC,
		    facilityTypeSC.getRecToskip(), facilityTypeSC.getNbRec());
	}
    }

    
    public List fmsDrawDownsListTemplateFMS(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	DAOHelper.fixGridMaps(facilityTypeSC, getSqlMap(), "fmsDrawdownsMapper.fmsDrawdownListMap");
	if(facilityTypeSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("fmsDrawdownsMapper.fmsDrawDownsListTemplateFMS", facilityTypeSC);
	}
	else
	{
	    return getSqlMap().queryForList("fmsDrawdownsMapper.fmsDrawDownsListTemplateFMS", facilityTypeSC, facilityTypeSC.getRecToskip(),
	    		facilityTypeSC.getNbRec());
	}
    }

    public int fmsDrawDownsListCountTemplateFMS(FacilityTypeSC facilityTypeSC) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("fmsDrawdownsMapper.fmsDrawDownsListCountTemplateFMS", facilityTypeSC)).intValue();
	return nb;
    }
}
