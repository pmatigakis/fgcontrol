package com.matigakis.fgcontrol.network;

import com.matigakis.fgcontrol.fdm.FDMData;


/**
 * Every object that needs to be informed when new fdm data have
 * been received, needs to implement this interface.
 */
public interface FDMDataListener {
	void handleFDMData(FDMData fdmData); 
}
