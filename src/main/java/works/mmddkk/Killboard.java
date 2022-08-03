package works.mmddkk;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import works.mmddkk.handlers.PlayerHandler;

public final class Killboard extends JavaPlugin {
    FileConfiguration config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        loadConfig();

        /*if (config.getBoolean("test")) {
            Bukkit.getLogger().info("Killboard: Test in true");
        }*/

        //register command executor
        //getCommand("fly").setExecutor(new Fly());

        //instantiate handlers
        new PlayerHandler(this);
        //new TorchHandler(this);
    }

    @Override
    public void onLoad() {
        Bukkit.getLogger().info("[Killboard] Plugin is loaded");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[Killboard] Shutting Down");
    }

    private void loadConfig() {
        config = getConfig();
        Bukkit.getLogger().info("Loading Config");
        //config.addDefault("joinmessage.enabled", true);
        //config.addDefault("joinmessage.message", "&4%player% &7has joined the server");
        config.addDefault("killboard-enabled", true);
        config.options().copyDefaults(true);
        saveConfig();
    }
}
