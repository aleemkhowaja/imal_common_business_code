package com.path.bo.common.swift.swiftoutward;

import com.path.lib.common.exception.BaseException;


public interface SwiftEngineBO
{
	//efarah 07/04/2017 EWBI170270
    public void startEngine() throws BaseException;
    public void stopEngine() throws BaseException;
}
