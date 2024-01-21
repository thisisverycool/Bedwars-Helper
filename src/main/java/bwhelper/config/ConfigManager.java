package bwhelper.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import bwhelper.utils.Utils;

public class ConfigManager {

	public static void saveConfig() {
		try {
			File file = new File(Utils.mc.mcDataDir + File.separator + "bwh", "config.txt");
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file, false);
			writer.write("Bedwars Helper config" + "\r\n" + "\r\n");
			writer.write("armor: " + Config.ARMOR + "\r\n");
			writer.write("bow: " + Config.BOW + "\r\n");
			writer.write("invisible: " + Config.INVISIBLE + "\r\n");
			writer.write("potions: " + Config.POTIONS + "\r\n");
			writer.write("swords: " + Config.SWORDS + "\r\n");
			writer.write("sounds: " + Config.SOUNDS + "\r\n");
			writer.close();
			
		} catch (Throwable buh) {
			buh.printStackTrace();
		}
	}
	
	public static void loadConfig() {
		try {
			File file = new File(Utils.mc.mcDataDir + File.separator + "bwh", "config.txt");
			if (!file.exists()) {
				saveConfig();
				return;
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.contains(":")) {
					continue;
				}
				String arg = line.split(": ")[1];
				if (line.startsWith("armor:")) {
					Config.ARMOR = Boolean.parseBoolean(arg);
				}
				if (line.startsWith("bow:")) {
					Config.BOW = Boolean.parseBoolean(arg);
				}
				if (line.startsWith("invisible:")) {
					Config.INVISIBLE = Boolean.parseBoolean(arg);
				}
				if (line.startsWith("potions:")) {
					Config.POTIONS = Boolean.parseBoolean(arg);
				}
				if (line.startsWith("swords:")) {
					Config.SWORDS = Boolean.parseBoolean(arg);
				}
				if (line.startsWith("sounds:")) {
					Config.SOUNDS = Boolean.parseBoolean(arg);
				}
			}
			reader.close();
			
		} catch (Throwable buhx2) {
			buhx2.printStackTrace();
			saveConfig();
		}
	}
	
}
