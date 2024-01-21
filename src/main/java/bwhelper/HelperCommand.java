package bwhelper;

import java.util.Arrays;
import java.util.List;

import bwhelper.config.Config;
import bwhelper.config.ConfigManager;
import bwhelper.utils.ChatUtils;
import bwhelper.utils.Utils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraftforge.common.MinecraftForge;

public class HelperCommand extends CommandBase implements ChatUtils {

	private HelperMod helper;
	private Listener listener;
	
	private List<String> alias = Arrays.asList(new String[] {
			"bwhelper",
			"bw"
	});
	
    public HelperCommand(HelperMod helper) {
        this.helper = helper;
    }

	@Override
	public String getCommandName() {
		return "bwh";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/bwh";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		if (args.length == 0) {
			ConfigManager.saveConfig();
			help();
		} else if (args.length == 1) {
			switch (args[0].toLowerCase()) {
			case "toggle":
				Config.enabled = !Config.enabled;
				Utils.addChatMessage(prefix + "Bedwars helper is now " + isEnabled(Config.enabled));
				ConfigManager.saveConfig();
				return;
			case "armor":
				Config.ARMOR = !Config.ARMOR;
				Utils.addChatMessage(prefix + "Armor alerts have been " + isEnabled(Config.ARMOR));
				ConfigManager.saveConfig();
				return;
			case "bow":
				Config.BOW = !Config.BOW;
				Utils.addChatMessage(prefix + "Bow alerts have been " + isEnabled(Config.BOW));
				ConfigManager.saveConfig();
				return;
			case "invisible":
				Config.INVISIBLE = !Config.INVISIBLE;
				Utils.addChatMessage(prefix + "Invisible alerts have been " + isEnabled(Config.INVISIBLE));
				ConfigManager.saveConfig();
				return;
			case "potions":
				Config.POTIONS = !Config.POTIONS;
				Utils.addChatMessage(prefix + "Potion alerts have been " + isEnabled(Config.POTIONS));
				ConfigManager.saveConfig();
				return;
			case "swords":
				Config.SWORDS = !Config.SWORDS;
				Utils.addChatMessage(prefix + "Swords alerts have been " + isEnabled(Config.SWORDS));
				ConfigManager.saveConfig();
				return;
			case "sounds":
				Config.SOUNDS = !Config.SOUNDS;
				Utils.addChatMessage(prefix + "Sounds have been" + isEnabled(Config.SOUNDS));
				ConfigManager.saveConfig();
				return;
			case "reset":
				Utils.addChatMessage(prefix + "Resetting player data...");
				try {
					listener.dArmor.clear();
					listener.iArmor.clear();
					listener.iSword.clear();
					listener.dSword.clear();
					listener.invis.clear();
					listener.spedppl.clear();
					listener.jumpyppl.clear();
					listener.bowList.clear();
					listener.iSword.clear();
					Utils.addChatMessage(prefix + "Resetting player data: " + green + "DONE!");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				return;
			}
			invalid();
		}
	}
	
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
    
    public List<String> aliases() {
    	return this.alias;
    }
    
    private void help() {
    	Utils.addChatMessage(bold + "/bwh toggle: " + isEnabled(Config.enabled));
    	Utils.addChatMessage("");
    	Utils.addChatMessage("/bwh armor: " + isEnabled(Config.ARMOR));
    	Utils.addChatMessage("/bwh bow: " + isEnabled(Config.BOW));
    	Utils.addChatMessage("/bwh invisible: " + isEnabled(Config.INVISIBLE));
    	Utils.addChatMessage("/bwh potions: " + isEnabled(Config.POTIONS));
    	Utils.addChatMessage("/bwh swords: " + isEnabled(Config.SWORDS));
    	Utils.addChatMessage("/bwh sounds: " + isEnabled(Config.SOUNDS));
    	Utils.addChatMessage("");
    	Utils.addChatMessage("/bwh reset" + green + " <- resets player data");
    }
    
    private String isEnabled(boolean f) {
        return f ? green + "Enabled": red + "Disabled";
    }
    
    private void invalid() {
    	Utils.addChatMessage(prefix + "Invalid Command Usage. Use " + aqua +"/bwh" + reset + " for help");
    }
}
