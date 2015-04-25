package com.matigakis.fgcontrol.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.bootstrap.Bootstrap;

/**
 * The BaseFDMServer object is the base object for all servers that can
 * connect to flightgear and receive FDM data
 */
public abstract class BaseFDMServer implements FDMDataServer{
	private static final Logger logger = LoggerFactory.getLogger(BaseFDMServer.class);
	
	private boolean running;
	private int port;
	private EventLoopGroup group;
	private FDMDataHandler fdmDataHandler;
	
	protected abstract Bootstrap createBootstrap(EventLoopGroup group, FDMDataHandler fdmDataHandler);
	
	public BaseFDMServer(int port){
		this.port = port;
		
		this.fdmDataHandler = new FDMDataHandler(this);
		
		running = false;
	}
	
	public int getPort(){
		return port;
	}
	
	@Override
	public void startServer() throws FDMServerException{
		if(!isRunning()){
			logger.debug("Starting the FDM server on port " + getPort());
			
			group = new NioEventLoopGroup();
			
			Bootstrap bootstrap = createBootstrap(group, fdmDataHandler);
			
			try {
				bootstrap.bind(port).sync();
			} catch (InterruptedException e) {
				logger.error("The FDM server has failed to start on port " + getPort(), e);
				
				group.shutdownGracefully();
			
				throw new FDMServerException("The FDM server has failed to start on port " + getPort(), e);
			}
			
			running = true;
			
			fdmDataHandler.notifyListenersThatServerHasStarted();
			
			logger.debug("The FDM server has started successfully on port " + getPort());
		}else{
			logger.error("The FDM server is already running on port " + getPort());
			throw new FDMServerException("The FDM server is already running on port " + getPort());
		}
	}
	
	@Override
	public void stopServer() throws FDMServerException{
		logger.debug("Shutting down the FDM server");
		
		if (isRunning()){
			group.shutdownGracefully();
			
			running = false;
			
			fdmDataHandler.notifyListenersThatServerHasStopped();
			
			logger.debug("The FDM server has stopped");
		}else{
			logger.error("The FDM server is not running");
			throw new FDMServerException("The FDM server is not running");
		}
	}
	
	public boolean isRunning(){
		return running;
	}
	
	@Override
	public void addFDMDataServerEventListener(FDMDataServerEventListener listener){
		fdmDataHandler.addFDMDataServerEventListener(listener);
	}
	
	@Override
	public void removeFDMDataServerEventListener(FDMDataServerEventListener listener){
		fdmDataHandler.removeFDMDataServerEventListener(listener);
	}
}
