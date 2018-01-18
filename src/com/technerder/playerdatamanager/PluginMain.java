package com.technerder.playerdatamanager;

import org.bukkit.plugin.java.JavaPlugin;

import com.technerder.playerdatamanager.managers.CommandManager;
import com.technerder.playerdatamanager.managers.EventManager;
import com.technerder.playerdatamanager.managers.PlayerDataManager;

public class PluginMain extends JavaPlugin {

	private CommandManager commandManager;
	private EventManager eventManager;
	private PlayerDataManager playerDataManager;

	@Override
	public void onEnable() {

		commandManager = new CommandManager(this);
		eventManager = new EventManager(this);
		playerDataManager = new PlayerDataManager(this);

		playerDataManager.loadAllData();

	}

	@Override
	public void onDisable() {

		playerDataManager.saveAllData();

	}

	public CommandManager getCommandManager() {

		return commandManager;

	}

	public EventManager getEventManager() {

		return eventManager;

	}

	public PlayerDataManager getPlayerDataManager() {

		return playerDataManager;

	}

}