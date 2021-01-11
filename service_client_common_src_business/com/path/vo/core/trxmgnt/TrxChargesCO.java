package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;
import java.util.List;

import com.path.vo.core.common.RetailBaseVO;

public class TrxChargesCO  extends RetailBaseVO
{
    private List<TrxMgntChargesCO> 	trxMgntChargesCOs;
    private String 		 	baseForeign;
    private BigDecimal		 	row;
    private BigDecimal			branch;
    private BigDecimal			currency;
    private BigDecimal			amount;
    private BigDecimal			total;			//To calculate Total Amount
    private BigDecimal			totalNew;		//To calculate Total of New Amounts
    private BigDecimal			totalFc;		//To calculate Total FC Amounts
    private BigDecimal			totalDuesNew;		//To calculate Total of New Dues Amounts
    private BigDecimal			totalDuesFc;		//To calculate Total FC Dues Amounts
    private Boolean 			isEmptied = false;	//This is set to True when the charges are changed from trx screen and require recalculation. Upon calling of various charges function, they will check on this flag to see if to continue in calculation or not.
    private Boolean 			fetchSeperate = false;	//This is to see if to fetch the regular charges or those with PASS_SEPERATELY and have a debit criteria
    private Double 			exchRate;		//Exchange Rate
    private BigDecimal			numOfEntities;		//To know the number of entities (mainly Chequebook and Lost & Found)
    private String			entityType;		//To know from which entity the Trx is being generated. (CHQ/SAF/LOS/CAR/PAS)
    private BigDecimal			chargeBranch;		//Branch of Charge to be checked if exempted
    private BigDecimal			reasonCode;		//Code of reason chosen on screen.
    private BigDecimal			leaves;			//Leave code for Chequebooks
    private BigDecimal			type;			//Chequebook type
    private String 			chqIssueType;		//Chequebook Issuance Type (Normal/Urgent)
    private String			statusIdentifier;	//Cards Status Identifier (Equivalent to Cards Reason Code)
    private String			chargeType;		//To set Charge Type (P: Authorize, N:Cancel)
    private BigDecimal			ticketNo;		//PMS ticket number to get CIF No for Charges
    private Boolean			fromDependency;		//To know if charge perc change is from dependency or Waive button
    private String			printingLocation;	// to know the prinitng location ( by provider or in house)
    
    public String getBaseForeign()
    {
        return baseForeign;
    }
    public void setBaseForeign(String baseForeign)
    {
        this.baseForeign = baseForeign;
    }
    public BigDecimal getRow()
    {
        return row;
    }
    public void setRow(BigDecimal row)
    {
        this.row = row;
    }
    public BigDecimal getCurrency()
    {
        return currency;
    }
    public void setCurrency(BigDecimal currency)
    {
        this.currency = currency;
    }
 
    public BigDecimal getAmount()
    {
        return amount;
    }
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }
    public List<TrxMgntChargesCO> getTrxMgntChargesCOs()
    {
        return trxMgntChargesCOs;
    }
    public void setTrxMgntChargesCOs(List<TrxMgntChargesCO> trxMgntChargesCOs)
    {
        this.trxMgntChargesCOs = trxMgntChargesCOs;
    }
    public BigDecimal getTotal()
    {
        return total;
    }
    public void setTotal(BigDecimal total)
    {
        this.total = total;
    }
    public BigDecimal getTotalNew()
    {
        return totalNew;
    }
    public void setTotalNew(BigDecimal totalNew)
    {
        this.totalNew = totalNew;
    }
    public BigDecimal getTotalFc()
    {
        return totalFc;
    }
    public void setTotalFc(BigDecimal totalFc)
    {
        this.totalFc = totalFc;
    }
    public Boolean getIsEmptied()
    {
        return isEmptied;
    }
    public void setIsEmptied(Boolean isEmptied)
    {
        this.isEmptied = isEmptied;
    }
    public Boolean getFetchSeperate()
    {
        return fetchSeperate;
    }
    public void setFetchSeperate(Boolean fetchSeperate)
    {
        this.fetchSeperate = fetchSeperate;
    }
    public Double getExchRate()
    {
        return exchRate;
    }
    public void setExchRate(Double exchRate)
    {
        this.exchRate = exchRate;
    }
    public BigDecimal getBranch()
    {
        return branch;
    }
    public void setBranch(BigDecimal branch)
    {
        this.branch = branch;
    }
    public BigDecimal getNumOfEntities()
    {
        return numOfEntities;
    }
    public void setNumOfEntities(BigDecimal numOfEntities)
    {
        this.numOfEntities = numOfEntities;
    }
    public String getEntityType()
    {
        return entityType;
    }
    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }
    public BigDecimal getChargeBranch()
    {
        return chargeBranch;
    }
    public void setChargeBranch(BigDecimal chargeBranch)
    {
        this.chargeBranch = chargeBranch;
    }
    public BigDecimal getReasonCode()
    {
        return reasonCode;
    }
    public void setReasonCode(BigDecimal reasonCode)
    {
        this.reasonCode = reasonCode;
    }
    public BigDecimal getTotalDuesNew()
    {
        return totalDuesNew;
    }
    public void setTotalDuesNew(BigDecimal totalDuesNew)
    {
        this.totalDuesNew = totalDuesNew;
    }
    public BigDecimal getTotalDuesFc()
    {
        return totalDuesFc;
    }
    public void setTotalDuesFc(BigDecimal totalDuesFc)
    {
        this.totalDuesFc = totalDuesFc;
    }
    /**
     * @return the leaves
     */
    public BigDecimal getLeaves()
    {
        return leaves;
    }
    /**
     * @param leaves the leaves to set
     */
    public void setLeaves(BigDecimal leaves)
    {
        this.leaves = leaves;
    }
    /**
     * @return the type
     */
    public BigDecimal getType()
    {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(BigDecimal type)
    {
        this.type = type;
    }
    /**
     * @return the chqIssueType
     */
    public String getChqIssueType()
    {
        return chqIssueType;
    }
    /**
     * @param chqIssueType the chqIssueType to set
     */
    public void setChqIssueType(String chqIssueType)
    {
        this.chqIssueType = chqIssueType;
    }
    /**
     * @return the statusIdentifier
     */
    public String getStatusIdentifier()
    {
        return statusIdentifier;
    }
    /**
     * @param statusIdentifier the statusIdentifier to set
     */
    public void setStatusIdentifier(String statusIdentifier)
    {
        this.statusIdentifier = statusIdentifier;
    }
    public String getChargeType()
    {
        return chargeType;
    }
    public void setChargeType(String chargeType)
    {
        this.chargeType = chargeType;
    }
    public BigDecimal getTicketNo()
    {
        return ticketNo;
    }
    public void setTicketNo(BigDecimal ticketNo)
    {
        this.ticketNo = ticketNo;
    }
    public Boolean getFromDependency()
    {
        return fromDependency;
    }
    public void setFromDependency(Boolean fromDependency)
    {
        this.fromDependency = fromDependency;
    }
    public String getPrintingLocation()
    {
        return printingLocation;
    }
    public void setPrintingLocation(String printingLocation)
    {
        this.printingLocation = printingLocation;
    }

}
