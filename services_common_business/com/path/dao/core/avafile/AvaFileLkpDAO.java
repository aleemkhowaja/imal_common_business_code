package com.path.dao.core.avafile;

import java.util.List;

import com.path.dbmaps.vo.CTS_AVA_FILEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.avafile.AvaFileLkpSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaCategoryDAO.java used to
 */
public interface AvaFileLkpDAO
{
    public int returnAvaFileLookupCount(AvaFileLkpSC criteria) throws DAOException;

    public List returnAvaFileLookup(AvaFileLkpSC criteria) throws DAOException;

    public CTS_AVA_FILEVO dependencyForAvaFile(AvaFileLkpSC criteria) throws DAOException;

}