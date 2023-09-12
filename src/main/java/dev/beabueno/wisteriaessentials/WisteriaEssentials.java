package dev.beabueno.wisteriaessentials;

import dev.beabueno.wisteriaessentials.commands.*;
import dev.beabueno.wisteriaessentials.commands.tabs.GamemodeTab;
import dev.beabueno.wisteriaessentials.commands.tabs.PlayerNameTab;
import org.bukkit.plugin.java.JavaPlugin;

public final class WisteriaEssentials extends JavaPlugin {
    MessageManager messagemanager;
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Wisteria Essentials has loaded! BETA");
        registerCommands();
        registerTabCompleters();
        constructManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Wisteria Essentials has shut down successfully!");
    }

    public void registerCommands() {
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("heal").setExecutor(new HealCommand());

        getCommand("message").setExecutor(new MessageCommand(messagemanager));
        getCommand("reply").setExecutor(new ReplyCommand(messagemanager));

        getCommand("kick").setExecutor(new KickCommand());
        getCommand("ban").setExecutor(new BanCommand());
    }

    public void registerTabCompleters() {
        getCommand("gm").setTabCompleter(new PlayerNameTab(1));
        getCommand("gm").setTabCompleter(new GamemodeTab());
        getCommand("feed").setTabCompleter(new PlayerNameTab());
        getCommand("heal").setTabCompleter(new PlayerNameTab());
        getCommand("message").setTabCompleter(new PlayerNameTab());
        getCommand("kick").setTabCompleter(new PlayerNameTab());
        getCommand("ban").setTabCompleter(new PlayerNameTab());
    }

    public void constructManager() {
        messagemanager = new MessageManager();
    }

}
