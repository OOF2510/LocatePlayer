package me.nate.locateplayer;

import me.nate.locateplayer.commands.LocatePlayerCmd;
import org.bukkit.plugin.java.JavaPlugin;

public final class LocatePlayer extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("locateplayer").setExecutor(new LocatePlayerCmd());
    }
}
