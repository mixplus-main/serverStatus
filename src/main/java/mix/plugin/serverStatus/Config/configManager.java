package mix.plugin.serverStatus.Config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class configManager {
    private final JavaPlugin plugin;
    private final FileConfiguration config;

    public configManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    public void set(String path, Object value) {
        config.set(path, value);
    }

    public void save() {
        plugin.saveConfig();
    }

    public Object load(String path) {
        return config.get(path);
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }
}
