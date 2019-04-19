package info.loenwind.enderioaddons.common;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface InitAware {

  void init(FMLPreInitializationEvent event);

  void init(FMLInitializationEvent event);

  void init(FMLPostInitializationEvent event);
}
