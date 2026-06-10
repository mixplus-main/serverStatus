package mix.plugin.serverStatus.logic;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.List;

import mix.plugin.serverStatus.Config.ConfigManager;

public class OnlinePlayers {
    private final JavaPlugin plugin;
    private final ConfigManager config;

    public OnlinePlayers(JavaPlugin plugin, ConfigManager config) {
        this.plugin = plugin;
        this.config = config;
    }

    public void update() {
        int player = plugin.getServer().getOnlinePlayers().size();

        List<String> players =
                plugin.getServer()
                        .getOnlinePlayers()
                        .stream()
                        .map(Player::getName)
                        .toList();



        config.set("OnlinePlayers", player);
        config.set("Players", players);
        config.save();
    }
}