package com.path.dbmaps.vo;

public class SWIFT_HISTORYVOWithBLOBs extends SWIFT_HISTORYVO {
  

    /**
     * This field corresponds to the database column SWIFT_HISTORY.SWIFT_MSG_BLOB
     */
    private String SWIFT_MSG_BLOB;

	public String getSWIFT_MSG_BLOB() 
	{
		return SWIFT_MSG_BLOB;
	}

	public void setSWIFT_MSG_BLOB(String sWIFT_MSG_BLOB) 
	{
		SWIFT_MSG_BLOB = sWIFT_MSG_BLOB;
	}

}