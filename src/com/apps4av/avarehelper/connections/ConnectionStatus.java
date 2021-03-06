/*
Copyright (c) 2012, Apps4Av Inc. (apps4av.com) 
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
    *     * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    *
    *     THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package com.apps4av.avarehelper.connections;

import com.apps4av.avarehelper.R;

import android.content.Context;

/**
 * 
 * @author zkhan
 *
 */
public class ConnectionStatus {

    public static final int CONNECTED = 1;
    public static final int CONNECTING = 2;
    public static final int DISCONNECTED = 0;
    
    private int mState;
   
    /**
     * 
     */
    public ConnectionStatus() {
        mState = DISCONNECTED;
    }
    
    /**
     * 
     * @return
     */
    public int getState() {
        return mState;
    }
    
    /**
     * 
     * @param state
     */
    public void setState(int state) {
        mState = state;
    }
    
    /*
     * Find names of all running connections.
     */
    public static String getConnections(Context ctx) {
    	String s = "";
    	s += BlueToothConnectionIn.getInstance().isConnected() ? "," + ctx.getString(R.string.Bluetooth) : "";
    	s += WifiConnection.getInstance().isConnected() ?  "," + ctx.getString(R.string.WIFI) : "";
    	s += XplaneConnection.getInstance().isConnected() ? "," + ctx.getString(R.string.XPlane) : "";
    	s += MsfsConnection.getInstance().isConnected() ? "," + ctx.getString(R.string.MSFS) : "";
    	s += BlueToothConnectionOut.getInstance().isConnected() ? "," + ctx.getString(R.string.AP) : "";
    	s += FileConnectionIn.getInstance().isConnected() ? "," + ctx.getString(R.string.Play) : "";
    	s += GPSSimulatorConnection.getInstance().isRunning() ? "," + ctx.getString(R.string.GPSSIM) : "";
    	s += USBConnectionIn.getInstance(ctx).isConnected() ? "," + ctx.getString(R.string.USBIN) : "";
    	if(s.startsWith(",")) {
    		s = s.substring(1);
    	}
    	return "(" + s + ")";
    }
}
