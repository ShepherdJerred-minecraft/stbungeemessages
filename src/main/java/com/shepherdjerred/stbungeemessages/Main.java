
package com.shepherdjerred.stbungeemessages;

import com.shepherdjerred.stbungeemessages.listeners.DisconnectEvent;
import com.shepherdjerred.stbungeemessages.listeners.KickEvent;
import com.shepherdjerred.stbungeemessages.listeners.LoginEvent;
import com.shepherdjerred.stbungeemessages.listeners.SwitchEvent;
import com.shepherdjerred.stbungeemessages.metrics.MetricsLite;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;


public class Main extends Plugin {

	/*
     * TODO
	 * - Add configurable messages to everything
	 * - Add reload command (if necessary/possible)
	 * - Add config for kick events
	 * - Add config for message events
	 */

    // Provide instance of Main class
    private static Main instance;
    public ConcurrentHashMap<ProxiedPlayer, String> players = new ConcurrentHashMap<>();

    public Main() {
        instance = this;
    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        // Register events
        this.getProxy().getPluginManager().registerListener(this, new DisconnectEvent());
        this.getProxy().getPluginManager().registerListener(this, new KickEvent());
        this.getProxy().getPluginManager().registerListener(this, new LoginEvent());
        this.getProxy().getPluginManager().registerListener(this, new SwitchEvent());

        // Setup Metrics
        try {
            MetricsLite metrics = new MetricsLite(this);
            metrics.start();
        } catch (IOException e) {

        }

    }

}
