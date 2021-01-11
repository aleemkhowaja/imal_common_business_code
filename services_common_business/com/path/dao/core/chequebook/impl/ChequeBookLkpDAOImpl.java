package com.path.dao.core.chequebook.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.dao.core.chequebook.ChequeBookLkpDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.chequebook.ChequeBookCO;
import com.path.vo.core.chequebook.ChequeBookSC;


public class ChequeBookLkpDAOImpl extends BaseDAO implements ChequeBookLkpDAO
{
    public Integer chequeBookLkpCount(ChequeBookSC chequeBookSC) throws DAOException
    {
        DAOHelper.fixGridMaps(chequeBookSC, getSqlMap(), "chequeBookLkpMapper.chequeBookLkpMap");
        return (Integer) getSqlMap().queryForObject("chequeBookLkpMapper.chequeBookLkpCount", chequeBookSC);
    }

    public List chequeBookLkpList(ChequeBookSC chequeBookSC) throws DAOException
    {
        // check if no order Specified then Order by ChequeBook CODE No Descending
        if(StringUtil.nullToEmpty(chequeBookSC.getSidx()).isEmpty())
        {
            chequeBookSC.setSidx("CODE");
            chequeBookSC.setSord("DESC");
        }
        DAOHelper.fixGridMaps(chequeBookSC, getSqlMap(), "chequeBookLkpMapper.chequeBookLkpMap");
        if(chequeBookSC.getNbRec() == -1)
        {
            return getSqlMap().queryForList("chequeBookLkpMapper.chequeBookLkpList", chequeBookSC);
        }
        else
        {
            return getSqlMap().queryForList("chequeBookLkpMapper.chequeBookLkpList", chequeBookSC,
                chequeBookSC.getRecToskip(), chequeBookSC.getNbRec());
        }
    }
    
    @Override
    public Integer chequeBookPortalLkpCount(ChequeBookSC chequeBookSC) throws DAOException
    {
        DAOHelper.fixGridMaps(chequeBookSC, getSqlMap(), "chequeBookLkpMapper.chequeBookLkpMap");
        return (Integer) getSqlMap().queryForObject("chequeBookLkpMapper.chequeBookPortalLkpCount", chequeBookSC);
    }

    @Override
    public List<ChequeBookCO> chequeBookPortalLkpList(ChequeBookSC chequeBookSC) throws DAOException
    {
        // check if no order Specified then Order by ChequeBook CODE No Descending
        if(StringUtil.nullToEmpty(chequeBookSC.getSidx()).isEmpty())
        {
            chequeBookSC.setSidx("CODE");
            chequeBookSC.setSord("DESC");
        }
        DAOHelper.fixGridMaps(chequeBookSC, getSqlMap(), "chequeBookLkpMapper.chequeBookLkpMap");
        if(chequeBookSC.getNbRec() == -1)
        {
            return getSqlMap().queryForList("chequeBookLkpMapper.chequeBookPortalLkpList", chequeBookSC);
        }
        else
        {
            return getSqlMap().queryForList("chequeBookLkpMapper.chequeBookPortalLkpList", chequeBookSC,
                chequeBookSC.getRecToskip(), chequeBookSC.getNbRec());
        }
    }
    
    /**
     * Return count of TRX Cheque
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB:w_lookup_chq_trx/dw_lookup_cheque_on_trx_type(tfa01.pbl)
     */
    public int returnChqTrxLkpCount(ChequeBookSC chequeBookSC) throws DAOException
    {
        DAOHelper.fixGridMaps(chequeBookSC, getSqlMap(), "chequeBookLkpMapper.resultTfaChqLkpMap");
        return ((Integer) getSqlMap().queryForObject("chequeBookLkpMapper.returnTfaChqTrxLkpCount", chequeBookSC))
            .intValue();
    }

    /**
     * Return list of of TRX Cheque
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB: w_lookup_chq_trx/dw_lookup_cheque_on_trx_type(tfa01.pbl)
     */
    public List<ChequeBookCO> returnChqTrxLkpList(ChequeBookSC chequeBookSC) throws DAOException
    {

        DAOHelper.fixGridMaps(chequeBookSC, getSqlMap(), "chequeBookLkpMapper.resultTfaChqLkpMap");
        if(chequeBookSC.getNbRec() == -1)
        {
            return getSqlMap().queryForList("chequeBookLkpMapper.returnTfaChqTrxLkpList", chequeBookSC);

        }
        else
        {
            return getSqlMap().queryForList("chequeBookLkpMapper.returnTfaChqTrxLkpList", chequeBookSC,
                chequeBookSC.getRecToskip(), chequeBookSC.getNbRec());
        }
    }
    
    /**
     * Return count of Cheques
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB: w_lookup_chq/dw_lookup_cheque(tfa01.pbl)
     */
    public int returnChqLkpCount(ChequeBookSC chequeBookSC) throws DAOException
    {
        DAOHelper.fixGridMaps(chequeBookSC, getSqlMap(), "chequeBookLkpMapper.resultTfaChqLkpMap");
        return ((Integer) getSqlMap().queryForObject("chequeBookLkpMapper.returnTfaChqLkpCount", chequeBookSC))
            .intValue();
    }

    /**
     * Return list of Cheques
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     * @PB: w_lookup_chq/dw_lookup_cheque(tfa01.pbl)
     */
    public List<ChequeBookCO> returnChqLkpList(ChequeBookSC chequeBookSC) throws DAOException
    {

        DAOHelper.fixGridMaps(chequeBookSC, getSqlMap(), "chequeBookLkpMapper.resultTfaChqLkpMap");
        if(chequeBookSC.getNbRec() == -1)
        {
            return getSqlMap().queryForList("chequeBookLkpMapper.returnTfaChqLkpList", chequeBookSC);

        }
        else
        {
            return getSqlMap().queryForList("chequeBookLkpMapper.returnTfaChqLkpList", chequeBookSC,
                chequeBookSC.getRecToskip(), chequeBookSC.getNbRec());
        }
    }
    
    /**
     * Return trxType from the table CTS_REMITT_TRXTYPE
     * 
     * @author: BoushraFahs
     * @date: 27 Jan 2014
     */
    public BigDecimal returnCtsRemittTrx(ChequeBookSC chequeBookSC) throws DAOException
    {
        return (BigDecimal) getSqlMap().queryForObject("chequeBookLkpMapper.returnCtsRemittTrxType", chequeBookSC);
    }

   
}
