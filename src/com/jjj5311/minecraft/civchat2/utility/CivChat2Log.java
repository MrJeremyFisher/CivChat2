package com.jjj5311.minecraft.civchat2.utility;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.jjj5311.minecraft.civchat2.CivChat2;

public class CivChat2Log {
	private String pluginName = "[CivChat2] ";
	private Logger log;
	
	public void initializeLogger(JavaPlugin jp){
		log = jp.getLogger();
	}

	public void info(String msg) {
		log.info(msg);		
	}
	
	public void warning(String msg){
		log.warning(msg);
	}
	
	public void severe(String msg){
		log.severe(msg);
	}
	
	public void debug(String msg){
		if(CivChat2.debugEnabled()){
			log.info("[Debug] " + msg);
		}
	}
}
