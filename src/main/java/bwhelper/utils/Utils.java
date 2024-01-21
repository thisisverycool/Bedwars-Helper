package bwhelper.utils;

import com.mojang.realmsclient.gui.ChatFormatting;

import bwhelper.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemSkull;
import net.minecraft.util.ChatComponentText;

public class Utils {

	public static final Minecraft mc = Minecraft.getMinecraft();
	public static final String ping = "note.pling";
	
	public static boolean isPlayerInGame() {
		return mc.thePlayer != null && mc.theWorld != null;
	}
	
	public static void addChatMessage(String message) {
		mc.thePlayer.addChatMessage(new ChatComponentText(message));
	}
	
	public static void playSound() {
		if (Config.SOUNDS) {
			mc.thePlayer.playSound(ping, 1.0F, 1.0F);
		}
	}
	
	public static boolean hasNoArmor(EntityPlayer en) {
		for (int x = 0; x < 4; x++) {
			if (en.getCurrentArmor(x) == null || !(en.getCurrentArmor(x).getItem() instanceof ItemArmor)) {
				return true;
			}
		}
		return false;
	}
	
}
