package mix.plugin.serverStatus.logic;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.plugin.java.JavaPlugin;

import mix.plugin.serverStatus.Config.ConfigManager;

import java.util.List;


public class Event implements Listener{
    private final JavaPlugin plugin;
    private final ConfigManager config;
    private final OnlinePlayers onlinePlayers;


    public Event(JavaPlugin plugin, ConfigManager config) {
        this.onlinePlayers = new OnlinePlayers(plugin, config);

        this.plugin = plugin;
        this.config = config;
        System.out.println("Event");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        SaveUserData SUD = new SaveUserData(plugin, config, player);
        onlinePlayers.update();

        System.out.println("Event join");


    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        SaveUserData SUD = new SaveUserData(plugin, config, player);
        Bukkit.getScheduler().runTaskLater(plugin, onlinePlayers::update, 5L);
        System.out.println("Event quit");
    }

    @EventHandler
    public void onKick(PlayerKickEvent event) {
        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();
        String path = "PlayerData." + uuid + ".kickCount";

        int current = config.getConfig().getInt(path, 0);
        config.set(path, ++current);
        config.save();



    }
}
