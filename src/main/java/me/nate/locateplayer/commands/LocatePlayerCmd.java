package me.nate.locateplayer.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.World.Environment.*;

public class LocatePlayerCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length <= 1) {
            String ps = args[0];
            Player p = Bukkit.getServer().getPlayer(ps);
            String pn = p.getName();
            Location pl = p.getLocation();
            World.Environment di = pl.getWorld().getEnvironment();
            String plsy = String.valueOf(Math.round(pl.getY()));
            String plsx = String.valueOf(Math.round(pl.getX()));
            String plsz = String.valueOf(Math.round(pl.getZ()));
            String pls = plsx+", "+plsy+", "+plsz;
            if (sender instanceof Player) {
                Player s = (Player) sender;
                if (di == NORMAL) {
                    String dim = "The Overworld";
                    s.sendMessage(pn+" is at "+pls+" in "+dim);
                } else if (di == NETHER) {
                    String dim = "The Nether";
                    s.sendMessage(pn+" is at "+pls+" in "+dim);
                } else if (di == THE_END) {
                    String dim = "The End";
                    s.sendMessage(pn+" is at "+pls+" in "+dim);
                }
            } else {
                ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
                if (di == NORMAL) {
                    String dim = "The Overworld";
                    c.sendMessage(pn+" is at "+pls+" in "+dim);
                } else if (di == NETHER) {
                    String dim = "The Nether";
                    c.sendMessage(pn+" is at "+pls+" in "+dim);
                } else if (di == THE_END) {
                    String dim = "The End";
                    c.sendMessage(pn+" is at "+pls+" in "+dim);
                }
            }
        }

        return true;
    }
}
