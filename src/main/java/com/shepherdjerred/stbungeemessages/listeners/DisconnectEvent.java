
package com.shepherdjerred.stbungeemessages.listeners;

import com.shepherdjerred.stbungeemessages.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;


public class DisconnectEvent implements Listener {

    @EventHandler
    public void onPlayerDisconnectEvent(PlayerDisconnectEvent event) {

        Main.getInstance().players.remove(event.getPlayer());

        TextComponent messageUsername = new TextComponent(event.getPlayer().getDisplayName());
        messageUsername.setColor(ChatColor.DARK_AQUA);

        TextComponent messageStart = new TextComponent(" has left the server");
        messageStart.setColor(ChatColor.DARK_GRAY);

        messageUsername.addExtra(messageStart);

        ProxyServer.getInstance().broadcast(messageUsername);

    }

}
