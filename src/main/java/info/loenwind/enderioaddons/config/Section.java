package info.loenwind.enderioaddons.config;

import javax.annotation.Nonnull;

public enum Section {
  DRAIN("drain"), COBBLEWORKS("cobbleworks"), WATERWORKS("waterworks"), RECIPES("recipes"), DEV("development"), IHOPPER("impulsehopper"), NIARD("niard"), VOIDTANK(
      "void tank");

  @Nonnull
  public final String name;
  public final boolean sync;

  private Section(@Nonnull String name) {
    this.name = name;
    this.sync = true;
  }

  private Section(@Nonnull String name, boolean sync) {
    this.name = name;
    this.sync = sync;
  }

}
