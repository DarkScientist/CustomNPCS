package fr.darkscientist.customnpcs;




import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import net.minecraft.server.v1_12_R1.Entity;
import net.minecraft.server.v1_12_R1.NBTTagCompound;






public class CmdExecutor implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            Location pLoc = p.getLocation();
            Villager npc = (Villager) pLoc.getWorld().spawnEntity(pLoc, EntityType.VILLAGER);
            Entity nmsVillager = ((CraftEntity) npc).getHandle();
            nmsVillager.setPositionRotation(pLoc.getX(), pLoc.getY(), pLoc.getZ(), pLoc.getYaw(), pLoc.getPitch());
            
           
           
           
           NBTTagCompound tag = new NBTTagCompound();
           nmsVillager.c(tag);
           tag.setInt("NoAI", 1);
           nmsVillager.f(tag);
            
            if(args.length == 0) return false;
            if(args[0].length() >= 1) {
                nmsVillager.setCustomName(StringUtils.join(args, " ").replace("&", "§"));
                nmsVillager.setCustomNameVisible(true);
                return true;
            }


        }

        return false;
    }
}
