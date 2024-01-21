package bwhelper;

import bwhelper.config.ConfigManager;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
	modid = HelperMod.modid,
	name = HelperMod.name,
	version = HelperMod.version,
	acceptedMinecraftVersions = "[1.8.9]"
)

public class HelperMod {

	public static final String modid = "bwutils", name = "Bedwars Helper", version = "b1";
	
	public boolean enabled;
	
	private Listener listener;

    public Listener getListener() {
		return listener;
	}

	@EventHandler
    public void init(FMLInitializationEvent e) {
        listener = new Listener();
        ClientCommandHandler.instance.registerCommand(new HelperCommand(this));
        MinecraftForge.EVENT_BUS.register(this.getListener());
        ConfigManager.loadConfig();
    }
	
}
