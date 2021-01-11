package com.path.dao.core.vatzone;

import java.util.List;

import com.path.dbmaps.vo.CTS_VAT_ZONEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.vatzone.VatZoneSC;

public interface VatZoneDAO
{
    public CTS_VAT_ZONEVO returnZoneCodeById(VatZoneSC criteria) throws DAOException;

    public List vatZoneList(VatZoneSC vatZoneSC) throws DAOException;

    public int vatZoneListCount(VatZoneSC vatZoneSC) throws DAOException;
}
