package bwhelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import bwhelper.config.Config;
import bwhelper.utils.ChatUtils;
import bwhelper.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Listener implements ChatUtils {
	
	public static final Minecraft mc = Minecraft.getMinecraft();

	protected static final List<EntityPlayer> iSword = new ArrayList();
	protected static final List<EntityPlayer> dSword = new ArrayList();
	protected static final List<EntityPlayer> invis = new ArrayList();
	protected static final List<EntityPlayer> bowList = new ArrayList();
	protected static final List<EntityPlayer> jumpyppl = new ArrayList();
	protected static final List<EntityPlayer> spedppl = new ArrayList();
	protected static final List<EntityPlayer> iArmor = new ArrayList();
	protected static final List<EntityPlayer> dArmor = new ArrayList();
	
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event) {
		if (Utils.isPlayerInGame() &&  Config.enabled) {
            Iterator<EntityPlayer> playerIterator = mc.theWorld.playerEntities.iterator();
			while (true) {
				EntityPlayer en;
				do {
					do { 
						if (!playerIterator.hasNext()) {
							return;
						} en = (EntityPlayer)playerIterator.next();
					} while (en == mc.thePlayer);
				} while (Utils.hasNoArmor(en)); 
				// make the == to != for debugging in single player and testing new checks 
				if (en.isDead) {
					iSword.clear();
					dSword.clear();
					bowList.clear();
					invis.clear();
					jumpyppl.clear();
				}
				String ping = "note.pling";
				if (en.getHeldItem() != null) {
					Item heldItem = en.getHeldItem().getItem();
					if (heldItem instanceof ItemSword && Config.SWORDS) {
						String swordType = ((ItemSword) heldItem).getToolMaterialName().toLowerCase();
						if (swordType.contains("iron")) {
							if (!iSword.contains(en)) {
								iSword.add(en);
								Utils.addChatMessage(prefix + en.getName() + " has an " + gray + "Iron" + white + " Sword.");
								Utils.playSound();
							}
						}
						if (swordType.contains("emerald")) { //idek why the diamond sword material is called emerald. it just works let it stay.
							if (!dSword.contains(en)) {
								dSword.add(en);
								Utils.addChatMessage(prefix + en.getDisplayNameString() + " has a " + aqua + "Diamond" + white + " Sword.");
								Utils.playSound();
							}
						}
					}
					if (heldItem instanceof ItemBow && Config.BOW) {
						if (!bowList.contains(en)) {
							bowList.add(en);
							Utils.addChatMessage(prefix + en.getDisplayNameString() + " has a " + dark_red + "Bow.");
							Utils.playSound();
						}
					}
					if (heldItem instanceof ItemBlock && Utils.hasNoArmor(en)) {
						Utils.addChatMessage(prefix + en.getName() + " does not have full armor. ");
					}
					
				}
				if (en.getActivePotionEffect(Potion.invisibility) != null && Config.INVISIBLE) {
					if (!invis.contains(en)) {
						invis.add(en);
						Utils.addChatMessage(prefix + en.getDisplayNameString() + " is now " + dark_purple + "Invisible.");
						Utils.playSound();
					}
				} else if (invis.contains(en)) {
					invis.remove(en);
					Utils.addChatMessage(prefix + en.getDisplayNameString() + " is now " + dark_purple + "Visible.");
				}
				if (en.getActivePotionEffect(Potion.jump) != null && Config.POTIONS) {
					if (!jumpyppl.contains(en)) {
						jumpyppl.add(en);
						Utils.addChatMessage(prefix + en.getDisplayNameString() + " now has " + green + "JUMP!"); 
						Utils.playSound();
					}
				} else if (jumpyppl.contains(en)) {
					jumpyppl.remove(en);
					Utils.addChatMessage(prefix + en.getDisplayNameString() + " no longer has " + green + "JUMP!"); 
				}
				if (en.getActivePotionEffect(Potion.moveSpeed) != null && Config.POTIONS) {
					if (!spedppl.contains(en)) {
						spedppl.add(en);
						Utils.addChatMessage(prefix + en.getDisplayNameString() + " now has " + yellow + "SPEEED"); 
						Utils.playSound();
					}
				} else if (spedppl.contains(en)) {
					spedppl.remove(en);
					Utils.addChatMessage(prefix + en.getDisplayNameString() + " no longer has " + yellow + "SPEEED"); 
				}
				for (int a = 0; a < 4; a++) {
					if (en.getCurrentArmor(a) != null && Config.ARMOR) {
						Item daArmor = en.getCurrentArmor(a).getItem();
						ArmorMaterial asd = ((ItemArmor) daArmor).getArmorMaterial();
						String armr = en.getCurrentArmor(a).getDisplayName().toLowerCase();
						if (armr.contains("iron")) {
							if (!iArmor.contains(en)) {
								iArmor.add(en);
								Utils.addChatMessage(prefix + en.getDisplayNameString() + " has " + gray + "Iron" + white + " armor."); 
								Utils.playSound();
							}
						}
						if (armr.contains("diamond")) {
							if (!dArmor.contains(en)) {
								dArmor.add(en);
								Utils.addChatMessage(prefix + en.getDisplayNameString() + " has " + aqua + "Diamond" + white + " armor.");
								Utils.playSound();
							}
						}
					}
				}
			}
		}
	}
	
}
