package fr.darkscientist.customnpcs;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{


    @Override
    public void onEnable(){
        System.out.println("NPC ON");
        getCommand("npc").setExecutor(new CmdExecutor());
        getServer().getPluginManager().registerEvents(new Listener(this), this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
       

    }

    


    @Override
    public void onDisable(){
        System.out.println("NPC OFF");
    }

}
