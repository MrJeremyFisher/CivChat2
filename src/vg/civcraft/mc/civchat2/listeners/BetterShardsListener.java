package vg.civcraft.mc.civchat2.listeners;

import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import vg.civcraft.mc.bettershards.events.PlayerChangeServerEvent;
import vg.civcraft.mc.civchat2.CivChat2;
import vg.civcraft.mc.civchat2.CivChat2Manager;
import vg.civcraft.mc.mercury.MercuryAPI;
import vg.civcraft.mc.namelayer.NameAPI;

public class BetterShardsListener implements Listener{
	private static CivChat2 plugin;
	private static CivChat2Manager chatMan;
	private static final String sep = "|";
	
	public BetterShardsListener(CivChat2 plugin) {
		this.plugin = plugin;
		chatMan = plugin.getCivChat2Manager();
	}
	
	
	@EventHandler
	public void PlayerChangeServer(PlayerChangeServerEvent event){
		String playerName = NameAPI.getCurrentName(event.getPlayerUUID());
		UUID playerToReplyUUID = chatMan.getPlayerReply(playerName);
		String playerToReply = NameAPI.getCurrentName(playerToReplyUUID);
		if(playerToReply != null){
			MercuryAPI.sendMessage(event.getServerTravelingTo(), "reply|" + playerName + sep + playerToReply, "civchat2");
		}
	}
}