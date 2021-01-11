/**
 * @Auther:Raed Saad
 * @Date:NOV 10, 2016
 * @Team:CSM JAVA Team.
 * @copyright: PathSolution 2016
 * @User Story: USER STORY #308189 BMOI150250 - BMO160034 - S:Credit Card Management - PRIME R4 - CSM R14.x
 * @Description: Lookup Action
 **/

package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.core.facilitytype.FacilityTypeBO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cardsmanagement.CardsManagementCO;
import com.path.vo.core.cardsmanagement.CardsManagementSC;

public class CardsFacilityLookupAction extends LookupBaseAction
{
    private FacilityTypeBO facilityTypeBO;
    private List<CardsManagementCO> cardsManagementList;
    private CardsManagementSC criteria = new CardsManagementSC();
    
    @Override
    public Object getModel()
    {
        return criteria;
    }

    public String constructCardsFacilityLookup()
    {
        try
        {
            // Design the Grid by defining the column model and column names
            String[] name = {"fmsCreditCardDetailsVO.COMP_CODE","fmsCreditCardDetailsVO.BRANCH_CODE","fmsFacilityDetVO.CODE","fmsCreditCardDetailsVO.SUBLIMIT_LINE_NBR","fmsCreditCardDetailsVO.LINE_NBR","fmsCreditCardDetailsVO.CREDIT_CARD_NUMBER","fmsCreditCardDetailsVO.INDICATOR","fmsCreditCardDetailsVO.CARD_HOLDER_NAME","fmsCreditCardDetailsVO.CARD_TYPE","fmsCreditCardDetailsVO.PAYMENT_PERC","fmsCreditCardDetailsVO.LIMIT_AMT","fmsCreditCardDetailsVO.OUTSTANDING_AMT","fmsCreditCardDetailsVO.EFFECTIVE_DATE","fmsCreditCardDetailsVO.EXPIRY_DATE","statusDesc"};
            String[] colType = {"number","number","number","number","number","text","text","text","number","number","number","number","date","date","text"};
            String[] titles = {getText("Comp_Code_key"),getText("branch_code_key"),getText("Facility No"),getText("Sublimit_Line_No_key"),getText("lineno_key"),getText("Credit_Card_Number_key"),getText("Indicator_key"),getText("Card_Holder_Name_key"),getText("Card_Type_key"),getText("Payment_Perc_key"),getText("Limit_Amount_key"),getText("Oustanding_Amount_key"),getText("Effective_Date_key"),getText("Expiry_date_key"),getText("Status_key") };

            // Defining the Grid
            LookupGrid grid = new LookupGrid();
          //  grid.setCaption(getText("Lookup/Query__For_FacilityType_key"));
            
            criteria.getCif();
            
            grid.setRowNum("5");
            grid.setUrl("/pathdesktop/CardsFacilityLkpAction_fillCardsFacilityLookup");
            int cols = name.length;
            List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
            for(int i = 0; i < cols; i++)
            {
                // Defining each column
                LookupGridColumn gridColumn = new LookupGridColumn();
                gridColumn.setName(name[i]);
                gridColumn.setIndex(name[i]);
                gridColumn.setColType(colType[i]);
                gridColumn.setTitle(titles[i]);
                gridColumn.setSearch(true);
                // adding column to the list
                lsGridColumn.add(gridColumn);
            }
            lookup(grid, lsGridColumn, null, criteria);
        }
        catch(Exception e)
        {
            log.error(e, "Error in CardsFacilityLookup of CardFacilityLookupAction");
            handleException(e, null, null);
        }

        return SUCCESS;

    }

    public String fillCardsFacilityLookup()
    {
        try
        {
            setSearchFilter(criteria);
            copyproperties(criteria);
            SessionCO sessionCO = returnSessionObject();
            criteria.setCompCode(sessionCO.getCompanyCode());
            criteria.setLanguage(sessionCO.getLanguage());
            criteria.setLovTypeStatus(new BigDecimal(92));
            if(checkNbRec(criteria))
            {
               setRecords(facilityTypeBO.cardsFacilityCountList(criteria));
            }
            // set the collection into gridModel attribute defined at JSP grid
            setGridModel(facilityTypeBO.cardsFacilityList(criteria));
        }
        catch(Exception e)
        {
            log.error(e, "Error in fillLookupData of FacilityLookupAction");
            handleException(e, null, null);
        }
        return SUCCESS;
    }
    /**
     * @param facilityTypeBO the facilityTypeBO to set
     */
    public void setFacilityTypeBO(FacilityTypeBO facilityTypeBO)
    {
        this.facilityTypeBO = facilityTypeBO;
    }

    public List<CardsManagementCO> getCardsManagementList()
    {
        return cardsManagementList;
    }

    public void setCardsManagementList(List<CardsManagementCO> cardsManagementList)
    {
        this.cardsManagementList = cardsManagementList;
    }

    public CardsManagementSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(CardsManagementSC criteria)
    {
        this.criteria = criteria;
    }

}
