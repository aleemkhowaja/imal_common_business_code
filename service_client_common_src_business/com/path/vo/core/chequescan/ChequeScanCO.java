package com.path.vo.core.chequescan;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CHQ_OBJECTVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRSVO;
import com.path.dbmaps.vo.CTSTRS_UPLOADVO;
import com.path.dbmaps.vo.CTS_INT_DEVICES_PARAMVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.trxmgnt.TrxMgntCO;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to this source code
 * @author: CHADY.A
 * ChequeScanCO.java used to
 */
public class ChequeScanCO extends RetailBaseVO implements Serializable
{
    private CHQ_OBJECTVO chqObject = new CHQ_OBJECTVO();
    private CTSTRSVO ctstrsVO = new CTSTRSVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private boolean allowAccess;
    
    private byte[] oleObject;
    private byte[] oleObjectFront;
    private byte[] oleObjectRear;
    
    // ABARI120334 -- [John Massaad]
    private CTSTRS_UPLOADVO ctsTrsUploadVO = new CTSTRS_UPLOADVO();
    
    private BigDecimal op_type;
    
    private String chequeCodeList;
    private String operCompletedMsg;
    private String keyAlgorithm;
    private String terminalId;
    private String chqObjStReq;
    private String chqObjectStatus;
    private String fileImg;
    private String funcName;
    private String entriesLevel;
    private String deviceType;
    private String scanRFHTrx;
    private String scanPRGChq;
    private String scanDELChq;
    private String scanRFHChq;
    private String scanDevice;
    private String scanChequer;
    private String scanMicr;
    private String inoutCheque; //inoutCheque : "0" outward cheque, "1" inward cheque
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO > hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private BigDecimal bankCif;
    private String additionalRefComp;
  //BISI120155
    private boolean validMicr=true;
    private BigDecimal[] chequeCodeArr;
    private String chequeCodeArrStr;// this is used for dependency parameters
    private String DirectoryImg;
    private String fromWhere;// flag to identify the screen
    private int imgCounter;
    private CTS_INT_DEVICES_PARAMVO intDevicesParam = new CTS_INT_DEVICES_PARAMVO();
    private List<TrxMgntCO> trxMgntCOList = new ArrayList<TrxMgntCO>();
    private boolean chequeIsHouseWithdrawal;
    private String initParam;
    private String saveMsg;
    private String documentType;
    private String paniniImgNameFront;
    private String paniniImgNameRear;
    private String scannerType;
    
    private String addString2;
    private String trsNo;
    // BISI120155
   
    private String frontImagePath;
    private String rearImagePath;
    
    private BigDecimal lineNo;
    
    private String scanScreen;
    private BigDecimal loginBranchCode;

    /**
     * @return the chqObject
     */
    public CHQ_OBJECTVO getChqObject()
    {
        return chqObject;
    }

    /**
     * @param chqObject the chqObject to set
     */
    public void setChqObject(CHQ_OBJECTVO chqObject)
    {
        this.chqObject = chqObject;
    }

    /**
     * @return the ctsTellerVO
     */
    public CTSTELLERVO getCtsTellerVO()
    {
        return ctsTellerVO;
    }

    /**
     * @param ctsTellerVO the ctsTellerVO to set
     */
    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
        this.ctsTellerVO = ctsTellerVO;
    }

    /**
     * @return the allowAccess
     */
    public boolean isAllowAccess()
    {
        return allowAccess;
    }

    /**
     * @param allowAccess the allowAccess to set
     */
    public void setAllowAccess(boolean allowAccess)
    {
        this.allowAccess = allowAccess;
    }

    /**
     * @return the hm
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
        return hm;
    }

    /**
     * @param hm the hm to set
     */
    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
        this.hm = hm;
    }

    /**
     * @return the ctstrsVO
     */
    public CTSTRSVO getCtstrsVO()
    {
        return ctstrsVO;
    }

    /**
     * @param ctstrsVO the ctstrsVO to set
     */
    public void setCtstrsVO(CTSTRSVO ctstrsVO)
    {
        this.ctstrsVO = ctstrsVO;
    }

    /**
     * @return the oleObject
     */
    public byte[] getOleObject()
    {
        return oleObject;
    }

    /**
     * @param oleObject the oleObject to set
     */
    public void setOleObject(byte[] oleObject)
    {
        this.oleObject = oleObject;
    }

    /**
     * @return the op_type
     */
    public BigDecimal getOp_type()
    {
        return op_type;
    }

    /**
     * @param opType the op_type to set
     */
    public void setOp_type(BigDecimal opType)
    {
        op_type = opType;
    }

    /**
     * @return the chequeCodeList
     */
    public String getChequeCodeList()
    {
        return chequeCodeList;
    }

    /**
     * @param chequeCodeList the chequeCodeList to set
     */
    public void setChequeCodeList(String chequeCodeList)
    {
        this.chequeCodeList = chequeCodeList;
    }

    /**
     * @return the operCompletedMsg
     */
    public String getOperCompletedMsg()
    {
        return operCompletedMsg;
    }

    /**
     * @param operCompletedMsg the operCompletedMsg to set
     */
    public void setOperCompletedMsg(String operCompletedMsg)
    {
        this.operCompletedMsg = operCompletedMsg;
    }

    /**
     * @return the keyAlgorithm
     */
    public String getKeyAlgorithm()
    {
        return keyAlgorithm;
    }

    /**
     * @param keyAlgorithm the keyAlgorithm to set
     */
    public void setKeyAlgorithm(String keyAlgorithm)
    {
        this.keyAlgorithm = keyAlgorithm;
    }

    /**
     * @return the funcName
     */
    public String getFuncName()
    {
        return funcName;
    }

    /**
     * @param funcName the funcName to set
     */
    public void setFuncName(String funcName)
    {
        this.funcName = funcName;
    }

    /**
     * @return the inoutCheque
     */
    public String getInoutCheque()
    {
        return inoutCheque;
    }

    /**
     * @param inoutCheque the inoutCheque to set
     */
    public void setInoutCheque(String inoutCheque)
    {
        this.inoutCheque = inoutCheque;
    }

    /**
     * @return the terminalId
     */
    public String getTerminalId()
    {
        return terminalId;
    }

    /**
     * @param terminalId the terminalId to set
     */
    public void setTerminalId(String terminalId)
    {
        this.terminalId = terminalId;
    }

    /**
     * @return the entriesLevel
     */
    public String getEntriesLevel()
    {
        return entriesLevel;
    }

    /**
     * @param entriesLevel the entriesLevel to set
     */
    public void setEntriesLevel(String entriesLevel)
    {
        this.entriesLevel = entriesLevel;
    }

    /**
     * @return the scanRFHTrx
     */
    public String getScanRFHTrx()
    {
        return scanRFHTrx;
    }

    /**
     * @param scanRFHTrx the scanRFHTrx to set
     */
    public void setScanRFHTrx(String scanRFHTrx)
    {
        this.scanRFHTrx = scanRFHTrx;
    }

    /**
     * @return the scanPRGChq
     */
    public String getScanPRGChq()
    {
        return scanPRGChq;
    }

    /**
     * @param scanPRGChq the scanPRGChq to set
     */
    public void setScanPRGChq(String scanPRGChq)
    {
        this.scanPRGChq = scanPRGChq;
    }

    /**
     * @return the scanDELChq
     */
    public String getScanDELChq()
    {
        return scanDELChq;
    }

    /**
     * @param scanDELChq the scanDELChq to set
     */
    public void setScanDELChq(String scanDELChq)
    {
        this.scanDELChq = scanDELChq;
    }

    /**
     * @return the scanRFHChq
     */
    public String getScanRFHChq()
    {
        return scanRFHChq;
    }

    /**
     * @param scanRFHChq the scanRFHChq to set
     */
    public void setScanRFHChq(String scanRFHChq)
    {
        this.scanRFHChq = scanRFHChq;
    }

    /**
     * @return the scanDevice
     */
    public String getScanDevice()
    {
        return scanDevice;
    }

    /**
     * @param scanDevice the scanDevice to set
     */
    public void setScanDevice(String scanDevice)
    {
        this.scanDevice = scanDevice;
    }

    /**
     * @return the scanChequer
     */
    public String getScanChequer()
    {
        return scanChequer;
    }

    /**
     * @param scanChequer the scanChequer to set
     */
    public void setScanChequer(String scanChequer)
    {
        this.scanChequer = scanChequer;
    }

    /**
     * @return the chqObjectStatus
     */
    public String getChqObjectStatus()
    {
        return chqObjectStatus;
    }

    /**
     * @param chqObjectStatus the chqObjectStatus to set
     */
    public void setChqObjectStatus(String chqObjectStatus)
    {
        this.chqObjectStatus = chqObjectStatus;
    }

    /**
     * @return the chqObjStReq
     */
    public String getChqObjStReq()
    {
        return chqObjStReq;
    }

    /**
     * @param chqObjStReq the chqObjStReq to set
     */
    public void setChqObjStReq(String chqObjStReq)
    {
        this.chqObjStReq = chqObjStReq;
    }

    /**
     * @return the scanMicr
     */
    public String getScanMicr()
    {
        return scanMicr;
    }

    /**
     * @param scanMicr the scanMicr to set
     */
    public void setScanMicr(String scanMicr)
    {
        this.scanMicr = scanMicr;
    }

    /**
     * @return the deviceType
     */
    public String getDeviceType()
    {
        return deviceType;
    }

    /**
     * @param deviceType the deviceType to set
     */
    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

    /**
     * @return the fileImg
     */
    public String getFileImg()
    {
        return fileImg;
    }

    /**
     * @param fileImg the fileImg to set
     */
    public void setFileImg(String fileImg)
    {
        this.fileImg = fileImg;
    }

    /**
     * @return the oleObjectFront
     */
    public byte[] getOleObjectFront()
    {
        return oleObjectFront;
    }

    /**
     * @param oleObjectFront the oleObjectFront to set
     */
    public void setOleObjectFront(byte[] oleObjectFront)
    {
        this.oleObjectFront = oleObjectFront;
    }

    /**
     * @return the oleObjectRear
     */
    public byte[] getOleObjectRear()
    {
        return oleObjectRear;
    }

    /**
     * @param oleObjectRear the oleObjectRear to set
     */
    public void setOleObjectRear(byte[] oleObjectRear)
    {
        this.oleObjectRear = oleObjectRear;
    }

    public BigDecimal getBankCif()
    {
        return bankCif;
    }

    public void setBankCif(BigDecimal bankCif)
    {
        this.bankCif = bankCif;
    }
    
    public CTSTRS_UPLOADVO getCtsTrsUploadVO()
    {
	return ctsTrsUploadVO;
    }

    public void setCtsTrsUploadVO(CTSTRS_UPLOADVO ctsTrsUploadVO)
    {
	this.ctsTrsUploadVO = ctsTrsUploadVO;
    }

    public String getAdditionalRefComp()
    {
        return additionalRefComp;
    }

    public void setAdditionalRefComp(String additionalRefComp)
    {
        this.additionalRefComp = additionalRefComp;
    }

    public boolean isValidMicr()
    {
        return validMicr;
    }

    public void setValidMicr(boolean validMicr)
    {
        this.validMicr = validMicr;
    }

    public BigDecimal[] getChequeCodeArr()
    {
        return chequeCodeArr;
    }

    public void setChequeCodeArr(BigDecimal[] chequeCodeArr)
    {
        this.chequeCodeArr = chequeCodeArr;
    }

    public String getChequeCodeArrStr()
    {
        return chequeCodeArrStr;
    }

    public void setChequeCodeArrStr(String chequeCodeArrStr)
    {
        this.chequeCodeArrStr = chequeCodeArrStr;
    }

    public String getDirectoryImg()
    {
        return DirectoryImg;
    }

    public void setDirectoryImg(String directoryImg)
    {
        DirectoryImg = directoryImg;
    }

    public String getFromWhere()
    {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere)
    {
        this.fromWhere = fromWhere;
    }

    public int getImgCounter()
    {
        return imgCounter;
    }

    public void setImgCounter(int imgCounter)
    {
        this.imgCounter = imgCounter;
    }

    public CTS_INT_DEVICES_PARAMVO getIntDevicesParam()
    {
        return intDevicesParam;
    }

    public void setIntDevicesParam(CTS_INT_DEVICES_PARAMVO intDevicesParam)
    {
        this.intDevicesParam = intDevicesParam;
    }

    public List<TrxMgntCO> getTrxMgntCOList()
    {
        return trxMgntCOList;
    }

    public void setTrxMgntCOList(List<TrxMgntCO> trxMgntCOList)
    {
        this.trxMgntCOList = trxMgntCOList;
    }

    public boolean isChequeIsHouseWithdrawal()
    {
        return chequeIsHouseWithdrawal;
    }

    public void setChequeIsHouseWithdrawal(boolean chequeIsHouseWithdrawal)
    {
        this.chequeIsHouseWithdrawal = chequeIsHouseWithdrawal;
    }

    public String getInitParam()
    {
        return initParam;
    }

    public void setInitParam(String initParam)
    {
        this.initParam = initParam;
    }

    public String getSaveMsg()
    {
        return saveMsg;
    }

    public void setSaveMsg(String saveMsg)
    {
        this.saveMsg = saveMsg;
    }

    public String getDocumentType()
    {
        return documentType;
    }

    public void setDocumentType(String documentType)
    {
        this.documentType = documentType;
    }

    public String getPaniniImgNameFront()
    {
        return paniniImgNameFront;
    }

    public void setPaniniImgNameFront(String paniniImgNameFront)
    {
        this.paniniImgNameFront = paniniImgNameFront;
    }

    public String getPaniniImgNameRear()
    {
        return paniniImgNameRear;
    }

    public void setPaniniImgNameRear(String paniniImgNameRear)
    {
        this.paniniImgNameRear = paniniImgNameRear;
    }

    public String getScannerType()
    {
        return scannerType;
    }

    public void setScannerType(String scannerType)
    {
        this.scannerType = scannerType;
    }
    
    public String getFrontImagePath()
    {
        return frontImagePath;
    }

    public void setFrontImagePath(String frontImagePath)
    {
        this.frontImagePath = frontImagePath;
    }

    public String getRearImagePath()
    {
        return rearImagePath;
    }

    public void setRearImagePath(String rearImagePath)
    {
        this.rearImagePath = rearImagePath;
    }

    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }

    public String getScanScreen()
    {
        return scanScreen;
    }

    public void setScanScreen(String scanScreen)
    {
        this.scanScreen = scanScreen;
    }

    public String getAddString2()
    {
        return addString2;
    }

    public void setAddString2(String addString2)
    {
        this.addString2 = addString2;
    }

    public String getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(String trsNo)
    {
        this.trsNo = trsNo;
    }

    public BigDecimal getLoginBranchCode()
    {
        return loginBranchCode;
    }

    public void setLoginBranchCode(BigDecimal loginBranchCode)
    {
        this.loginBranchCode = loginBranchCode;
    }
    
}
