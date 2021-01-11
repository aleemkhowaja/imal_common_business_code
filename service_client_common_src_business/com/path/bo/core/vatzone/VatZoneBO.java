package com.path.bo.core.vatzone;

import java.util.List;

import com.path.dbmaps.vo.CTS_VAT_ZONEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.vatzone.VatZoneSC;

public interface VatZoneBO
{
    public int vatZoneListCount(VatZoneSC vatZoneSC) throws BaseException;

    public List vatZoneList(VatZoneSC vatZoneSC) throws BaseException;

    public CTS_VAT_ZONEVO returnZoneCodeById(VatZoneSC criteria) throws BaseException;

}
