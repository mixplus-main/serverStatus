package mix.plugin.serverStatus.logic;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.List;

import mix.plugin.serverStatus.Config.configManager;

public class OnlinePlayer {

    public OnlinePlayer(JavaPlugin plugin, configManager config) {

        plugin.getServer().getScheduler().runTaskTimer(plugin, () -> {
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

        }, 0L, 20L * 5);
    }
}