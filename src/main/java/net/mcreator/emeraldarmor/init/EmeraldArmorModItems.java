/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.emeraldarmor.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.emeraldarmor.item.EmeraldSwordItem;
import net.mcreator.emeraldarmor.item.EmeraldSpadeItem;
import net.mcreator.emeraldarmor.item.EmeraldPickaxeItem;
import net.mcreator.emeraldarmor.item.EmeraldHoeItem;
import net.mcreator.emeraldarmor.item.EmeraldAxeItem;
import net.mcreator.emeraldarmor.item.ArmorEmeraldItem;
import net.mcreator.emeraldarmor.EmeraldArmorMod;

public class EmeraldArmorModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EmeraldArmorMod.MODID);
	public static final RegistryObject<Item> ARMOR_EMERALD_HELMET = REGISTRY.register("armor_emerald_helmet", ArmorEmeraldItem.Helmet::new);
	public static final RegistryObject<Item> ARMOR_EMERALD_CHESTPLATE = REGISTRY.register("armor_emerald_chestplate", ArmorEmeraldItem.Chestplate::new);
	public static final RegistryObject<Item> ARMOR_EMERALD_LEGGINGS = REGISTRY.register("armor_emerald_leggings", ArmorEmeraldItem.Leggings::new);
	public static final RegistryObject<Item> ARMOR_EMERALD_BOOTS = REGISTRY.register("armor_emerald_boots", ArmorEmeraldItem.Boots::new);
	public static final RegistryObject<Item> EMERALD_SWORD = REGISTRY.register("emerald_sword", EmeraldSwordItem::new);
	public static final RegistryObject<Item> EMERALD_PICKAXE = REGISTRY.register("emerald_pickaxe", EmeraldPickaxeItem::new);
	public static final RegistryObject<Item> EMERALD_AXE = REGISTRY.register("emerald_axe", EmeraldAxeItem::new);
	public static final RegistryObject<Item> EMERALD_SPADE = REGISTRY.register("emerald_spade", EmeraldSpadeItem::new);
	public static final RegistryObject<Item> EMERALD_HOE = REGISTRY.register("emerald_hoe", EmeraldHoeItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}