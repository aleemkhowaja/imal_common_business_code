package com.path.bo.core.avafile;

import java.util.List;

import com.path.dbmaps.vo.CTS_AVA_FILEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.avafile.AvaFileLkpSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * AvaCategoryBO.java used to
 */
public interface AvaFileLkpBO
{
    public int returnAvaFileLookupCount(AvaFileLkpSC criteria) throws BaseException;

    public List returnAvaFileLookupList(AvaFileLkpSC criteria) throws BaseException;

    public CTS_AVA_FILEVO dependencyForAvaFile(AvaFileLkpSC criteria) throws BaseException;
}