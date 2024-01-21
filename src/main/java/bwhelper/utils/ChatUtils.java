package bwhelper.utils;

import com.mojang.realmsclient.gui.ChatFormatting;

public interface ChatUtils {
	
	// cuz annoying to do Chatformatting.RED or smh else EVERY SINGLE TIME ONG

	//colors 
	public static final ChatFormatting red = ChatFormatting.RED;
	public static final ChatFormatting blue = ChatFormatting.BLUE;
	public static final ChatFormatting black = ChatFormatting.BLACK;
	public static final ChatFormatting yellow = ChatFormatting.YELLOW;
	public static final ChatFormatting green = ChatFormatting.GREEN;
	public static final ChatFormatting aqua = ChatFormatting.AQUA;
	public static final ChatFormatting gold = ChatFormatting.GOLD;
	public static final ChatFormatting white = ChatFormatting.WHITE;
	public static final ChatFormatting gray = ChatFormatting.GRAY;
	public static final ChatFormatting purple = ChatFormatting.LIGHT_PURPLE;
	public static final ChatFormatting dark_gray = ChatFormatting.DARK_GRAY;
	public static final ChatFormatting dark_red = ChatFormatting.DARK_RED;
	public static final ChatFormatting dark_blue = ChatFormatting.DARK_BLUE;
	public static final ChatFormatting dark_green = ChatFormatting.DARK_GREEN;
	public static final ChatFormatting dark_aqua = ChatFormatting.DARK_AQUA;
	public static final ChatFormatting dark_purple = ChatFormatting.DARK_PURPLE;
	
	//formatting
	public static final ChatFormatting bold = ChatFormatting.BOLD;
	public static final ChatFormatting italic = ChatFormatting.ITALIC;
	public static final ChatFormatting obf = ChatFormatting.OBFUSCATED;
	public static final ChatFormatting reset = ChatFormatting.RESET;
	public static final ChatFormatting strike = ChatFormatting.STRIKETHROUGH;
	public static final ChatFormatting underline = ChatFormatting.UNDERLINE;
	
	//e
	public static final String prefix = red + "[" + white + bold + "BWH" + reset + red + "]" + white + " ";
	public static final String bruhh = red + "br" + obf + "u" + reset + "h";

}
