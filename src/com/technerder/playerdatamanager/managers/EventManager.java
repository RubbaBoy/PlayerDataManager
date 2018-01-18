package com.technerder.playerdatamanager.managers;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.technerder.playerdatamanager.PluginMain;

public class EventManager implements Listener {

	public PluginMain plugin;

	public EventManager(PluginMain pl) {

		this.plugin = pl;

		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {

		plugin.getPlayerDataManager().loadPlayerData(event.getPlayer());

	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {

		plugin.getPlayerDataManager().unloadPlayerData(event.getPlayer());

	}

}