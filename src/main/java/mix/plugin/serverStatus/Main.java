package mix.plugin.serverStatus;

import mix.plugin.serverStatus.Config.configManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private configManager config;

    @Override
    public void onEnable() {
        config = new configManager(this);
        config.set("server", "online");
        config.save();
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        config.set("server", "offline");
        config.save();
    }
}
