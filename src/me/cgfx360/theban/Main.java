package me.cgfx360.theban;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
public final Logger logger = Logger.getLogger("Minecraft");




	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
	
	}
    
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
		System.out.println("IT'S ALIVE!!!");
		System.out.println("This plugin was requested by B1GM4N!");
		System.out.println("Report any bugs or leave any suggestions by contacting Evildude221 on Bukkit!");
		getServer().getPluginManager().registerEvents(new BanListener(this), this);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	 public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
    	 
	        StringBuilder str = new StringBuilder();
	        for (int i = 1; i < args.length; i++){
	            str.append(args[i] + " ");
	        }
	 
	     
	        String message = getConfig().getString("BanMessage");
        	message = ChatColor.translateAlternateColorCodes('&', message);
        	
        	String broadcast = getConfig().getString("BroadcastMessage");
        	broadcast = ChatColor.translateAlternateColorCodes('&', broadcast);
        	
        	String pcolor = getConfig().getString("PlayerColor");
        	pcolor = ChatColor.translateAlternateColorCodes('&', pcolor);
        	
        	String Ban = getConfig().getString("Success");
        	Ban = ChatColor.translateAlternateColorCodes('&', Ban);
        	
        	String Error = getConfig().getString("IncorrectUsage");
        	Error = ChatColor.translateAlternateColorCodes('&', Error);
        	
        	String unban = getConfig().getString("UnbanMessage");
        	unban = ChatColor.translateAlternateColorCodes('&', unban);
        	
         	String NotBanned = getConfig().getString("NotBanned");
        	NotBanned = ChatColor.translateAlternateColorCodes('&', NotBanned);
	 
	 
	        if (commandLabel.equalsIgnoreCase("ban")){
	            if (args.length > 0){ 
	            	OfflinePlayer targetPlayer = Bukkit.getServer().getOfflinePlayer(args[0]);
	            	if (targetPlayer.isOnline()){
	                targetPlayer.getPlayer().kickPlayer(message);
	                targetPlayer.setBanned(true);
	                sender.sendMessage(Ban + pcolor + targetPlayer.getName());
	                Bukkit.broadcast(pcolor + targetPlayer.getName() + broadcast + pcolor + sender.getName(), "theban.see");
	            	}else{
	            		targetPlayer.setBanned(true);
	 	                sender.sendMessage(Ban + pcolor + targetPlayer.getName());
	 	                Bukkit.broadcast(pcolor + targetPlayer.getName() + broadcast + pcolor + sender.getName(), "theban.see");
	            	}
	            }else{
	                sender.sendMessage(Error);
	            }
	        }

	        if (commandLabel.equalsIgnoreCase("unban")){
	            if (args.length > 0){
	            	OfflinePlayer targetPlayer = Bukkit.getServer().getOfflinePlayer(args[0]);
	                if(targetPlayer.isBanned()){
	                    targetPlayer.setBanned(false);        	        
	                    sender.sendMessage(unban + pcolor + targetPlayer.getName());
	 
	                }else{
	                    sender.sendMessage(NotBanned);
	                }
	                
	                
	            }
	        }
	        return false;
	    }
	}
	
	
	


