package com.technerder.playerdatamanager.managers;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.technerder.playerdatamanager.PluginMain;
import com.technerder.playerdatamanager.objects.PlayerData;

public class PlayerDataManager {

	public PluginMain plugin;
	private Map<Player, PlayerData> currentData;

	public PlayerDataManager(PluginMain pl) {

		this.plugin = pl;

		currentData = new HashMap<>();

	}

	public void loadPlayerData(Player player) {

		currentData.put(player, new PlayerData(player, plugin));

	}

	public void unloadPlayerData(Player player) {

		currentData.remove(player, getPlayerData(player));

	}

	public PlayerData getPlayerData(Player player) {

		return currentData.get(player);

	}

	public Map<Player, PlayerData> getLoadedData() {

		return currentData;

	}

	public void saveAllData() {

		for (PlayerData data : currentData.values()) {

			data.save();

		}

	}

	public void loadAllData() {

		for (Player player : Bukkit.getOnlinePlayers()) {

			loadPlayerData(player);

		}

	}

}