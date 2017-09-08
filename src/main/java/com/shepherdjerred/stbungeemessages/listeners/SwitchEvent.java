
package com.shepherdjerred.stbungeemessages.listeners;

import com.shepherdjerred.stbungeemessages.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;


public class SwitchEvent implements Listener {

    @EventHandler
    public void onServerSwitchEvent(ServerSwitchEvent event) {

        if (Main.getInstance().players.get(event.getPlayer()).equals("first")) {

            Main.getInstance().players.put(event.getPlayer(), "notfirst");

        } else {

            TextComponent messageUsername = new TextComponent(event.getPlayer().getDisplayName());
            messageUsername.setColor(ChatColor.DARK_AQUA);

            TextComponent messageStart = new TextComponent(" switched to the ");
            messageStart.setColor(ChatColor.DARK_GRAY);

            TextComponent messageServer = new TextComponent(event.getPlayer().getServer().getInfo().getName());
            messageServer.setColor(ChatColor.DARK_AQUA);

            TextComponent messageEnd = new TextComponent(" server");
            messageEnd.setColor(ChatColor.DARK_GRAY);

            messageUsername.addExtra(messageStart);

            messageUsername.addExtra(messageServer);

            messageUsername.addExtra(messageEnd);

            ProxyServer.getInstance().broadcast(messageUsername);

        }

    }

}
