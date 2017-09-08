
package com.shepherdjerred.stbungeemessages.listeners;

import com.shepherdjerred.stbungeemessages.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;


public class LoginEvent implements Listener {

    @EventHandler
    public void onPreLogin(PreLoginEvent event) {

        // http://wiki.vg/Protocol_version_numbers
        if (event.getConnection().getVersion() != 316) {
            event.setCancelReason("Please join with 1.11.1 or 1.11.2");
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {

        Main.getInstance().players.put(event.getPlayer(), "first");

        TextComponent messageUsername = new TextComponent(event.getPlayer().getDisplayName());
        messageUsername.setColor(ChatColor.DARK_AQUA);

        TextComponent messageStart = new TextComponent(" has joined the server");
        messageStart.setColor(ChatColor.DARK_GRAY);

        messageUsername.addExtra(messageStart);

        ProxyServer.getInstance().broadcast(messageUsername);

    }

}
