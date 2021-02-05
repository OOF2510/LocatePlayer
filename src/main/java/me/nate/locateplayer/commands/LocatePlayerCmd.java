package me.nate.locateplayer.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class LocatePlayerCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length <= 1) {
            String ps = args[0];
            Player p = Bukkit.getServer().getPlayer(ps);
            String pn = p.getName();
            Location pl = p.getLocation();
            String plsy = String.valueOf(Math.round(pl.getY()));
            String plsx = String.valueOf(Math.round(pl.getX()));
            String plsz = String.valueOf(Math.round(pl.getZ()));
            String pls = plsy+", "+plsx+", "+plsz;
            if (sender instanceof Player) {
                Player s = (Player) sender;
                s.sendMessage(pn+" is at "+pls);
            } else {
                ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
                c.sendMessage(pn+" is at "+pls);
            }
        }

        return true;
    }
}
