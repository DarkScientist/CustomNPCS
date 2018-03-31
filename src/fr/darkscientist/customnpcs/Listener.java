package fr.darkscientist.customnpcs;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.md_5.bungee.api.ChatColor;

public class Listener implements org.bukkit.event.Listener {
	
	public Main main;
	
	public Listener(Main main){
		this.main = main;
	}
	
	@EventHandler
	public void onDammage(EntityDamageByEntityEvent e){
		Entity ent = e.getEntity();
		
		Entity damager = e.getDamager();
		if(ent instanceof Villager){
			Entity npc = (Villager) ent;
			if(npc.isCustomNameVisible()){
				if(damager instanceof Player){
					Player killer = (Player) e.getDamager();
					if(killer.getItemInHand() != null && killer.getItemInHand().getType() == Material.DIAMOND_SWORD){
						e.setDamage(120);
					}else if(killer.getItemInHand() == null || killer.getItemInHand().getType() != Material.DIAMOND_SWORD){
						e.setCancelled(true);
					}
				}
			
			}
			
		}
	}
	
	
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e){
		Player p = e.getPlayer();
		Entity ent = e.getRightClicked();
		if(ent instanceof Villager){
			Entity npc = (Villager) ent;
			if(npc.isCustomNameVisible()){
				e.setCancelled(true);
				
				  ByteArrayOutputStream b = new ByteArrayOutputStream();
				  DataOutputStream out = new DataOutputStream(b);
				  
				  
						  
				
			
					
					
					try {
						out.writeUTF("Message");
						out.writeUTF(p.getDisplayName());
						out.writeUTF(ChatColor.AQUA + "Vous avez rejoint la file d'attente de LuckyWars 1v1. Tentative de connexion...");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					
					
				
				
				p.sendPluginMessage(main, "BungeeCord", b.toByteArray());
				
				
				
				
			}
			
		}
	}

}
