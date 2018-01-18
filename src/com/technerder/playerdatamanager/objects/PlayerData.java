package com.technerder.playerdatamanager.objects;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.technerder.playerdatamanager.PluginMain;

public class PlayerData {

	private final Player player;
	private PluginMain plugin;
	public File dataFile;
	public FileConfiguration dataConfig;

	public PlayerData(Player player, PluginMain pl) {

		this.player = player;
		this.plugin = pl;

		if (plugin.getDataFolder() == null) {

			plugin.getDataFolder().mkdirs();

		}

		dataFile = new File(plugin.getDataFolder() + "/data/" + player.getUniqueId().toString());

		if (!dataFile.exists()) {

			dataFile.mkdirs();

		}

		dataConfig = YamlConfiguration.loadConfiguration(dataFile);

	}

	public void setStat(String stat, Object value) {

		dataConfig.set(stat, value);

	}

	public Object getStat(String stat) {

		return dataConfig.get(stat);

	}

	public void save() {

		try {
			dataConfig.save(dataFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Player getPlayer() {

		return player;

	}

}