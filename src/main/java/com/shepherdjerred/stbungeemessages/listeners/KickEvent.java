
package com.shepherdjerred.stbungeemessages.listeners;

import com.shepherdjerred.stbungeemessages.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class KickEvent implements Listener {

    @EventHandler
    public void onServerKickEvent(ServerKickEvent event) {

        ProxiedPlayer player = event.getPlayer();

        if (event.getPlayer().getServer() != null) {

            event.setCancelled(true);

            if (event.getPlayer().getServer().getInfo().getName().equals("survival")) {

                Main.getInstance().getProxy().getScheduler().schedule(Main.getInstance(), () -> {

                    player.connect(Main.getInstance().getProxy().getServerInfo("creative"));

                    player.sendMessage(new TextComponent(ChatColor.RED + "Disconnected: " + ChatColor.RESET + Arrays.toString(event.getKickReasonComponent())));

                }, 1L, TimeUnit.MICROSECONDS);

            } else {

                Main.getInstance().getProxy().getScheduler().schedule(Main.getInstance(), () -> {

                    player.connect(Main.getInstance().getProxy().getServerInfo("survival"));

                    player.sendMessage(new TextComponent(ChatColor.RED + "Disconnected: " + ChatColor.RESET + Arrays.toString(event.getKickReasonComponent())));

                }, 1L, TimeUnit.MICROSECONDS);

            }

        }

    }

}
