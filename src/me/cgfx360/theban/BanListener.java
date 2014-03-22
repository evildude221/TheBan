package me.cgfx360.theban;


import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class BanListener implements Listener {
	public Main plugin;
	public BanListener(Main instance){
	plugin = instance;
	}
	
	@EventHandler 
	(priority = EventPriority.HIGHEST)
	public void onPlayerBanned(PlayerLoginEvent event) {
		String BanMessage = plugin.getConfig().getString("BanMessage");
    	BanMessage = ChatColor.translateAlternateColorCodes('&', BanMessage);
	if (event.getResult() == Result.KICK_BANNED) {
	if(BanMessage != null){
	event.setKickMessage(BanMessage);
	}
   }
  }

}
