package mix.plugin.serverStatus.logic;

import mix.plugin.serverStatus.Config.configManager;
import mix.plugin.serverStatus.Main;
import org.bukkit.plugin.java.JavaPlugin;

public class Loop {
    private JavaPlugin plugin;
    private configManager config;

    public Loop(JavaPlugin plugin, configManager config) {
        OnlinePlayer onlineplayer = new OnlinePlayer(plugin, config);

    }
}
