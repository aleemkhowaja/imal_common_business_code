package com.path.vo.core.cardreader;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.SYNC_PARAM_MAPPINGVO;
import com.path.vo.core.common.RetailBaseVO;

public class CardReaderCO extends RetailBaseVO
{
    SYNC_PARAM_MAPPINGVO syncParamMappingVO = new SYNC_PARAM_MAPPINGVO();

    
    private String EXTERNAL_CODE;
    private String imalValue;
    private String extValue;
    private String elementId;
    private String biometricApprovedYN;
    private String cardReaderCivilID;
    private String cardReaderCardSerial;
    private String cardReaderNameEn;

    private String[] cardInfoArr;
    
     private String cardReaderDevice;

//    private String  cardReaderClicked;
    
    private BigDecimal errorCode;
    private String errorDesc;
    private String errorType;
    private Integer confirmationMsg;
    private Boolean recordIsConfirmed = false;
    
    //added by maria for BMO180276
    private Date idExpiryDate;
    private String titleNameEng;
    private String fromMethod;
    private BigDecimal nationality;
    private String gender;
    private String cardWarningMsg;

    public String getBiometricApprovedYN()
    {
	return biometricApprovedYN;
    }

    public void setBiometricApprovedYN(String biometricApprovedYN)
    {
	this.biometricApprovedYN = biometricApprovedYN;
    }

    public Integer getConfirmationMsg()
    {
	return confirmationMsg;
    }

    public void setConfirmationMsg(Integer confirmationMsg)
    {
	this.confirmationMsg = confirmationMsg;
    }

    public BigDecimal getErrorCode()
    {
	return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
	this.errorCode = errorCode;
    }

    public String getErrorDesc()
    {
	return errorDesc;
    }

    public void setErrorDesc(String errorDesc)
    {
	this.errorDesc = errorDesc;
    }

    public String getCardReaderCivilID()
    {
	return cardReaderCivilID;
    }

    public void setCardReaderCivilID(String cardReaderCivilID)
    {
	this.cardReaderCivilID = cardReaderCivilID;
    }

    public String getCardReaderCardSerial()
    {
	return cardReaderCardSerial;
    }

    public void setCardReaderCardSerial(String cardReaderCardSerial)
    {
	this.cardReaderCardSerial = cardReaderCardSerial;
    }

    public Boolean getRecordIsConfirmed()
    {
	return recordIsConfirmed;
    }

    public void setRecordIsConfirmed(Boolean recordIsConfirmed)
    {
	this.recordIsConfirmed = recordIsConfirmed;
    }

    public String getErrorType()
    {
	return errorType;
    }

    public void setErrorType(String errorType)
    {
	this.errorType = errorType;
    }

    public SYNC_PARAM_MAPPINGVO getSyncParamMappingVO()
    {
	return syncParamMappingVO;
    }

    public void setSyncParamMappingVO(SYNC_PARAM_MAPPINGVO syncParamMappingVO)
    {
	this.syncParamMappingVO = syncParamMappingVO;
    }

    public String getImalValue()
    {
	return imalValue;
    }

    public void setImalValue(String imalValue)
    {
	this.imalValue = imalValue;
    }

    public String getExtValue()
    {
	return extValue;
    }

    public void setExtValue(String extValue)
    {
	this.extValue = extValue;
    }

    public String getElementId()
    {
	return elementId;
    }

    public void setElementId(String elementId)
    {
	this.elementId = elementId;
    }

    public String getEXTERNAL_CODE()
    {
        return EXTERNAL_CODE;
    }

    public void setEXTERNAL_CODE(String eXTERNAL_CODE)
    {
        EXTERNAL_CODE = eXTERNAL_CODE;
    }

    public String getCardReaderNameEn()
    {
        return cardReaderNameEn;
    }

    public void setCardReaderNameEn(String cardReaderNameEn)
    {
        this.cardReaderNameEn = cardReaderNameEn;
    }

    public String[] getCardInfoArr()
    {
        return cardInfoArr;
    }

    public void setCardInfoArr(String[] cardInfoArr)
    {
        this.cardInfoArr = cardInfoArr;
    }

    public String getCardReaderDevice()
    {
        return cardReaderDevice;
    }

    public void setCardReaderDevice(String cardReaderDevice)
    {
        this.cardReaderDevice = cardReaderDevice;
    }

	public Date getIdExpiryDate() {
		return idExpiryDate;
	}

	public void setIdExpiryDate(Date idExpiryDate) {
		this.idExpiryDate = idExpiryDate;
	}

	public String getTitleNameEng() {
		return titleNameEng;
	}

	public void setTitleNameEng(String titleNameEng) {
		this.titleNameEng = titleNameEng;
	}

	public String getFromMethod() {
		return fromMethod;
	}

	public void setFromMethod(String fromMethod) {
		this.fromMethod = fromMethod;
	}

	public BigDecimal getNationality() {
		return nationality;
	}

	public void setNationality(BigDecimal nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCardWarningMsg() {
		return cardWarningMsg;
	}

	public void setCardWarningMsg(String cardWarningMsg) {
		this.cardWarningMsg = cardWarningMsg;
	}

}
