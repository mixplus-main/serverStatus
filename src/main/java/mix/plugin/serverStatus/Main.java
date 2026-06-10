package mix.plugin.serverStatus;

import mix.plugin.serverStatus.Config.configManager;
import mix.plugin.serverStatus.logic.Loop;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private configManager config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        config = new configManager(this);
        Loop loop = new Loop(this, config);
        config.set("server", "online");
        config.save();

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        config.set("server", "offline");
        config.save();
    }
}
