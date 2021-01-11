package com.path.dbmaps.vo;

public class CIF_COUNTRY_INFOVO extends CIF_COUNTRY_INFOVOKey{
	
    private String ID_NO;

	public String getID_NO() {
		return ID_NO;
	}

	public void setID_NO(String ID_NO) {
        this.ID_NO = ID_NO == null ? null : ID_NO.trim();
	}
    
}
