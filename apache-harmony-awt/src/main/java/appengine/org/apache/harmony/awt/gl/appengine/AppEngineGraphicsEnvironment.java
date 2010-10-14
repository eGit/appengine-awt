package org.apache.harmony.awt.gl.appengine;

import org.apache.harmony.awt.gl.CommonGraphicsEnvironment;

import com.google.code.appengine.awt.GraphicsDevice;
import com.google.code.appengine.awt.HeadlessException;


public class AppEngineGraphicsEnvironment extends CommonGraphicsEnvironment
{
	@Override
	public GraphicsDevice getDefaultScreenDevice() throws HeadlessException
	{
		return null;
	}

	@Override
	public GraphicsDevice[] getScreenDevices() throws HeadlessException
	{
		return null;
	}
}
