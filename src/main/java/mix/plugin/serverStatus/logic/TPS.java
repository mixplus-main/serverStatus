package mix.plugin.serverStatus.logic;


import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;


import mix.plugin.serverStatus.Config.ConfigManager;

public class TPS {
    public TPS(JavaPlugin plugin, ConfigManager config) {
        plugin.getServer().getScheduler().runTaskTimer(plugin, () -> {
            double tps = Bukkit.getServer().getTPS()[0];
            config.set("TPS", tps);
            config.save();

        }, 0L, 20L * 10);
    }
}
