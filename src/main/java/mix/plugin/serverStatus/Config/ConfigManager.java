package mix.plugin.serverStatus.Config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class ConfigManager {
    private final JavaPlugin plugin;
    private final FileConfiguration config;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    public void set(String path, Object value) {
        config.set(path, value);
    }

    public void save() {
        plugin.saveConfig();
    }

    public int getInt(String path, int def) {
        return config.getInt(path, def);
    }


    public FileConfiguration getConfig() {
        return config;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }
}
