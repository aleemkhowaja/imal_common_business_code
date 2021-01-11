package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CTSCHARGESVO;
import com.path.dbmaps.vo.CTSTRS_CHARGES_DET_VOIDVO;
import com.path.vo.core.common.RetailBaseVO;

public class TrxMgntVoidChargesCO  extends RetailBaseVO
{
    private CTSTRS_CHARGES_DET_VOIDVO ctsChargesDetVoidVO = new CTSTRS_CHARGES_DET_VOIDVO(); 
    private CTSTRS_CHARGES_DET_VOIDVO tvaChargesDetVoidVO = new CTSTRS_CHARGES_DET_VOIDVO();
    private CTSCHARGESVO         ctsChargesVO = new CTSCHARGESVO();
    private String               DEDUCT_FROM_ACC_DESC;
    private String               DEDUCT_FROM_ACC_REF;
    private BigDecimal           AMOUNT_FORMAT;
    private BigDecimal           AMOUNT_NEW_FORMAT;
    private BigDecimal           AMOUNT_FC_NEW_FORMAT;
    
    private BigDecimal           tva_amount_FORMAT;
    private BigDecimal           tva_amount_new_FORMAT;
    private BigDecimal           tva_amount_fc_new_FORMAT;
    private String          	 editableChargeLine;
    private String           	 selectedRow;
    private String           	 actionType;
    private String           	 actionTypeDesc;
    private String 		 subgridId;
    private String 		 mainGridRowId;
    private String 		 subgridRowId;
    private String 		 subgridColId;
    private String 		 typeInd;
    
    /**
     * @return the ctsChargesVO
     */
    public CTSCHARGESVO getCtsChargesVO()
    {
        return ctsChargesVO;
    }
    /**
     * @param ctsChargesVO the ctsChargesVO to set
     */
    public void setCtsChargesVO(CTSCHARGESVO ctsChargesVO)
    {
        this.ctsChargesVO = ctsChargesVO;
    }

    /**
     * @return the dEDUCT_FROM_ACC_DESC
     */
    public String getDEDUCT_FROM_ACC_DESC()
    {
        return DEDUCT_FROM_ACC_DESC;
    }
    /**
     * @param dEDUCTFROMACCDESC the dEDUCT_FROM_ACC_DESC to set
     */
    public void setDEDUCT_FROM_ACC_DESC(String dEDUCTFROMACCDESC)
    {
        DEDUCT_FROM_ACC_DESC = dEDUCTFROMACCDESC;
    }
    /**
     * @return the dEDUCT_FROM_ACC_REF
     */
    public String getDEDUCT_FROM_ACC_REF()
    {
        return DEDUCT_FROM_ACC_REF;
    }
    /**
     * @param dEDUCTFROMACCREF the dEDUCT_FROM_ACC_REF to set
     */
    public void setDEDUCT_FROM_ACC_REF(String dEDUCTFROMACCREF)
    {
        DEDUCT_FROM_ACC_REF = dEDUCTFROMACCREF;
    }
    public BigDecimal getAMOUNT_FORMAT()
    {
        return AMOUNT_FORMAT;
    }
    public void setAMOUNT_FORMAT(BigDecimal aMOUNTFORMAT)
    {
        AMOUNT_FORMAT = aMOUNTFORMAT;
    }
    public BigDecimal getAMOUNT_NEW_FORMAT()
    {
        return AMOUNT_NEW_FORMAT;
    }
    public void setAMOUNT_NEW_FORMAT(BigDecimal aMOUNTNEWFORMAT)
    {
        AMOUNT_NEW_FORMAT = aMOUNTNEWFORMAT;
    }
    public BigDecimal getAMOUNT_FC_NEW_FORMAT()
    {
        return AMOUNT_FC_NEW_FORMAT;
    }
    public void setAMOUNT_FC_NEW_FORMAT(BigDecimal aMOUNTFCNEWFORMAT)
    {
        AMOUNT_FC_NEW_FORMAT = aMOUNTFCNEWFORMAT;
    }
    public BigDecimal getTva_amount_FORMAT()
    {
        return tva_amount_FORMAT;
    }
    public void setTva_amount_FORMAT(BigDecimal tvaAmountFORMAT)
    {
        tva_amount_FORMAT = tvaAmountFORMAT;
    }
    public BigDecimal getTva_amount_new_FORMAT()
    {
        return tva_amount_new_FORMAT;
    }
    public void setTva_amount_new_FORMAT(BigDecimal tvaAmountNewFORMAT)
    {
        tva_amount_new_FORMAT = tvaAmountNewFORMAT;
    }
    public BigDecimal getTva_amount_fc_new_FORMAT()
    {
        return tva_amount_fc_new_FORMAT;
    }
    public void setTva_amount_fc_new_FORMAT(BigDecimal tvaAmountFcNewFORMAT)
    {
        tva_amount_fc_new_FORMAT = tvaAmountFcNewFORMAT;
    }
    public String getEditableChargeLine()
    {
        return editableChargeLine;
    }
    public void setEditableChargeLine(String editableChargeLine)
    {
        this.editableChargeLine = editableChargeLine;
    }
    public String getSelectedRow()
    {
        return selectedRow;
    }
    public void setSelectedRow(String selectedRow)
    {
        this.selectedRow = selectedRow;
    }
    public String getActionType()
    {
        return actionType;
    }
    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }
    public String getSubgridId()
    {
        return subgridId;
    }
    public void setSubgridId(String subgridId)
    {
        this.subgridId = subgridId;
    }
    public String getSubgridRowId()
    {
        return subgridRowId;
    }
    public void setSubgridRowId(String subgridRowId)
    {
        this.subgridRowId = subgridRowId;
    }
    public String getSubgridColId()
    {
        return subgridColId;
    }
    public void setSubgridColId(String subgridColId)
    {
        this.subgridColId = subgridColId;
    }
    public String getMainGridRowId()
    {
        return mainGridRowId;
    }
    public void setMainGridRowId(String mainGridRowId)
    {
        this.mainGridRowId = mainGridRowId;
    }
    public String getActionTypeDesc()
    {
        return actionTypeDesc;
    }
    public void setActionTypeDesc(String actionTypeDesc)
    {
        this.actionTypeDesc = actionTypeDesc;
    }
    public String getTypeInd()
    {
        return typeInd;
    }
    public void setTypeInd(String typeInd)
    {
        this.typeInd = typeInd;
    }

    public CTSTRS_CHARGES_DET_VOIDVO getCtsChargesDetVoidVO()
    {
        return ctsChargesDetVoidVO;
    }

    public void setCtsChargesDetVoidVO(CTSTRS_CHARGES_DET_VOIDVO ctsChargesDetVoidVO)
    {
        this.ctsChargesDetVoidVO = ctsChargesDetVoidVO;
    }

    public CTSTRS_CHARGES_DET_VOIDVO getTvaChargesDetVoidVO()
    {
        return tvaChargesDetVoidVO;
    }

    public void setTvaChargesDetVoidVO(CTSTRS_CHARGES_DET_VOIDVO tvaChargesDetVoidVO)
    {
        this.tvaChargesDetVoidVO = tvaChargesDetVoidVO;
    }

}
