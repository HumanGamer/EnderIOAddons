package info.loenwind.enderioaddons.machine.cobbleworks;

import info.loenwind.enderioaddons.common.GuiIds;
import info.loenwind.enderioaddons.machine.framework.IFrameworkBlock;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazypants.enderio.ModObject;
import crazypants.enderio.machine.AbstractMachineBlock;

public class BlockCobbleworks extends AbstractMachineBlock<TileCobbleworks> implements IFrameworkBlock {

  public static final ModObject ModObject_blockCobbleworks = EnumHelper.addEnum(ModObject.class, "blockCobbleworks", new Class<?>[0], new Object[0]);
  public static BlockCobbleworks blockCobbleworks;
  public static int renderId;

  public static BlockCobbleworks create() {
    blockCobbleworks = new BlockCobbleworks();
    blockCobbleworks.init();
    return blockCobbleworks;
  }

  protected BlockCobbleworks() {
    super(ModObject_blockCobbleworks, TileCobbleworks.class);
  }

  @Override
  public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    TileEntity te = world.getTileEntity(x, y, z);
    if (te instanceof TileCobbleworks) {
      return new ContainerCobbleworks(player.inventory, (TileCobbleworks) te);
    }
    return null;
  }

  @Override
  public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    TileEntity te = world.getTileEntity(x, y, z);
    if (te instanceof TileCobbleworks) {
      return new GuiCobbleworks(player.inventory, (TileCobbleworks) te);
    }
    return null;
  }

  @Override
  protected int getGuiId() {
    return GuiIds.GUI_ID_COBBLEWORKS;
  }

  @Override
  protected String getMachineFrontIconKey(boolean active) {
    return "enderio:machineTemplate";
  }

  @Override
  public int getRenderType() {
    return renderId;
  }

  @Override
  protected String getModelIconKey(boolean active) {
    return "enderioaddons:frameworkModel";
  }

  @Override
  public String getControllerModelName() {
    return "cobbleController";
  }

  @Override
  public boolean renderAsNormalBlock() {
    return false;
  }

  @Override
  public boolean isOpaqueCube() {
    return false;
  }

  @SideOnly(Side.CLIENT)
  @Override
  public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
    if (isActive(world, x, y, z) && !world.getBlock(x, y + 1, z).isOpaqueCube()) {
      float startX = x + 0.8F - rand.nextFloat() * 0.6F;
      float startY = y + 1.0F;
      float startZ = z + 0.8F - rand.nextFloat() * 0.6F;
      if (rand.nextInt(20) == 0) {
        world.spawnParticle("lava", startX, startY, startZ, 0.0D, -0.2D, 0.0D);
      } else {
        world.spawnParticle("smoke", startX, startY, startZ, 0.0D, 0.0D, 0.0D);
      }
    }
  }

}