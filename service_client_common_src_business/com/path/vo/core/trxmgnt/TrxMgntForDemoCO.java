/**
 * 
 */
package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.vo.core.common.RetailBaseVO;

/**
 * @author tonynouh
 *
 */
public class TrxMgntForDemoCO extends RetailBaseVO
{
    private Date runningDateRET;
    
    private BigDecimal TRX_TYPE;
    private BigDecimal TRS_AC_BR;
    private BigDecimal TRS_AC_CY;
    private BigDecimal TRS_AC_GL;
    private BigDecimal TRS_AC_CIF;
    private BigDecimal TRS_AC_SL;
    
    private List<TrxMgntForDemoCO> listBulkRemittance = new ArrayList<TrxMgntForDemoCO>();
    
    private BigDecimal TRS_CY;
    private BigDecimal AMOUNT;
    private BigDecimal TO_TRS_AC_BR;
    private BigDecimal TO_TRS_AC_CY;
    private BigDecimal TO_TRS_AC_GL;
    private BigDecimal TO_TRS_AC_CIF;
    private BigDecimal TO_TRS_AC_SL;
    private BigDecimal REMITTANCE_FR_NUM;
    private BigDecimal REMITTANCE_TO_NUM;       
    private BigDecimal CHQ_NUM;       
    private Date CHQ_DATE; 
    private String TRSFR_METHOD;

    

    public String getTRSFR_METHOD()
    {
        return TRSFR_METHOD;
    }

    public void setTRSFR_METHOD(String tRSFRMETHOD)
    {
        TRSFR_METHOD = tRSFRMETHOD;
    }

    public Date getRunningDateRET()
    {
        return runningDateRET;
    }

    public void setRunningDateRET(Date runningDateRET)
    {
        this.runningDateRET = runningDateRET;
    }

    public BigDecimal getTRX_TYPE()
    {
        return TRX_TYPE;
    }

    public void setTRX_TYPE(BigDecimal tRXTYPE)
    {
        TRX_TYPE = tRXTYPE;
    }

    public BigDecimal getTRS_AC_BR()
    {
        return TRS_AC_BR;
    }

    public void setTRS_AC_BR(BigDecimal tRSACBR)
    {
        TRS_AC_BR = tRSACBR;
    }

    public BigDecimal getTRS_AC_CY()
    {
        return TRS_AC_CY;
    }

    public void setTRS_AC_CY(BigDecimal tRSACCY)
    {
        TRS_AC_CY = tRSACCY;
    }

    public BigDecimal getTRS_AC_GL()
    {
        return TRS_AC_GL;
    }

    public void setTRS_AC_GL(BigDecimal tRSACGL)
    {
        TRS_AC_GL = tRSACGL;
    }

    public BigDecimal getTRS_AC_CIF()
    {
        return TRS_AC_CIF;
    }

    public void setTRS_AC_CIF(BigDecimal tRSACCIF)
    {
        TRS_AC_CIF = tRSACCIF;
    }

    public BigDecimal getTRS_AC_SL()
    {
        return TRS_AC_SL;
    }

    public void setTRS_AC_SL(BigDecimal tRSACSL)
    {
        TRS_AC_SL = tRSACSL;
    }

    public List<TrxMgntForDemoCO> getListBulkRemittance()
    {
        return listBulkRemittance;
    }

    public void setListBulkRemittance(List<TrxMgntForDemoCO> listBulkRemittance)
    {
        this.listBulkRemittance = listBulkRemittance;
    }

    public BigDecimal getTRS_CY()
    {
        return TRS_CY;
    }

    public void setTRS_CY(BigDecimal tRSCY)
    {
        TRS_CY = tRSCY;
    }

    public BigDecimal getAMOUNT()
    {
        return AMOUNT;
    }

    public void setAMOUNT(BigDecimal aMOUNT)
    {
        AMOUNT = aMOUNT;
    }

    public BigDecimal getTO_TRS_AC_BR()
    {
        return TO_TRS_AC_BR;
    }

    public void setTO_TRS_AC_BR(BigDecimal tOTRSACBR)
    {
        TO_TRS_AC_BR = tOTRSACBR;
    }

    public BigDecimal getTO_TRS_AC_CY()
    {
        return TO_TRS_AC_CY;
    }

    public void setTO_TRS_AC_CY(BigDecimal tOTRSACCY)
    {
        TO_TRS_AC_CY = tOTRSACCY;
    }

    public BigDecimal getTO_TRS_AC_GL()
    {
        return TO_TRS_AC_GL;
    }

    public void setTO_TRS_AC_GL(BigDecimal tOTRSACGL)
    {
        TO_TRS_AC_GL = tOTRSACGL;
    }

    public BigDecimal getTO_TRS_AC_CIF()
    {
        return TO_TRS_AC_CIF;
    }

    public void setTO_TRS_AC_CIF(BigDecimal tOTRSACCIF)
    {
        TO_TRS_AC_CIF = tOTRSACCIF;
    }

    public BigDecimal getTO_TRS_AC_SL()
    {
        return TO_TRS_AC_SL;
    }

    public void setTO_TRS_AC_SL(BigDecimal tOTRSACSL)
    {
        TO_TRS_AC_SL = tOTRSACSL;
    }

    public BigDecimal getREMITTANCE_FR_NUM()
    {
        return REMITTANCE_FR_NUM;
    }

    public void setREMITTANCE_FR_NUM(BigDecimal rEMITTANCEFRNUM)
    {
        REMITTANCE_FR_NUM = rEMITTANCEFRNUM;
    }

    public BigDecimal getREMITTANCE_TO_NUM()
    {
        return REMITTANCE_TO_NUM;
    }

    public void setREMITTANCE_TO_NUM(BigDecimal rEMITTANCETONUM)
    {
        REMITTANCE_TO_NUM = rEMITTANCETONUM;
    }

    /**
     * @return the cHQ_NUM
     */
    public BigDecimal getCHQ_NUM()
    {
        return CHQ_NUM;
    }

    /**
     * @param cHQNUM the cHQ_NUM to set
     */
    public void setCHQ_NUM(BigDecimal cHQNUM)
    {
        CHQ_NUM = cHQNUM;
    }

    /**
     * @return the cHQ_DATE
     */
    public Date getCHQ_DATE()
    {
        return CHQ_DATE;
    }

    /**
     * @param cHQDATE the cHQ_DATE to set
     */
    public void setCHQ_DATE(Date cHQDATE)
    {
        CHQ_DATE = cHQDATE;
    }
}
