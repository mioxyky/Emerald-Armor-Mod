package net.noxysoff.emeraldarmor.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import static net.noxysoff.emeraldarmor.EmeraldArmorModConstants.MOD_ID;

public final class EmeraldArmorModFabric implements ModInitializer {
    private static final Tier EMERALD_TIER = new EmeraldToolTier();
    private static final ArmorMaterial EMERALD_ARMOR = new EmeraldArmorMaterial();

    public static final Item EMERALD_HELMET = register("emerald_helmet", new ArmorItem(EMERALD_ARMOR, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final Item EMERALD_CHESTPLATE = register("emerald_chestplate", new ArmorItem(EMERALD_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final Item EMERALD_LEGGINGS = register("emerald_leggings", new ArmorItem(EMERALD_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final Item EMERALD_BOOTS = register("emerald_boots", new ArmorItem(EMERALD_ARMOR, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final Item EMERALD_SWORD = register("emerald_sword", new SwordItem(EMERALD_TIER, 3, -2.4F, new Item.Properties()));
    public static final Item EMERALD_PICKAXE = register("emerald_pickaxe", new PickaxeItem(EMERALD_TIER, 1, -2.8F, new Item.Properties()));
    public static final Item EMERALD_AXE = register("emerald_axe", new AxeItem(EMERALD_TIER, 5.0F, -3.1F, new Item.Properties()));
    public static final Item EMERALD_SHOVEL = register("emerald_shovel", new ShovelItem(EMERALD_TIER, 1.5F, -3.0F, new Item.Properties()));
    public static final Item EMERALD_HOE = register("emerald_hoe", new HoeItem(EMERALD_TIER, -3, 0.0F, new Item.Properties()));

    @Override
    public void onInitialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, id("emerald_armor_mod"), FabricItemGroup.builder()
                .title(Component.translatable("itemGroup.emerald_armor_mod.emerald_armor_mod"))
                .icon(() -> new ItemStack(EMERALD_HELMET))
                .displayItems((parameters, output) -> {
                    output.accept(EMERALD_HELMET);
                    output.accept(EMERALD_CHESTPLATE);
                    output.accept(EMERALD_LEGGINGS);
                    output.accept(EMERALD_BOOTS);
                    output.accept(EMERALD_SWORD);
                    output.accept(EMERALD_PICKAXE);
                    output.accept(EMERALD_AXE);
                    output.accept(EMERALD_SHOVEL);
                    output.accept(EMERALD_HOE);
                }).build());

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                if (player.getItemBySlot(EquipmentSlot.HEAD).is(EMERALD_HELMET)) {
                    player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 260, 1, true, false, true));
                }
            }
        });
    }

    private static Item register(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, id(name), item);
    }

    private static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    private static final class EmeraldToolTier implements Tier {
        @Override
        public int getUses() {
            return 1400;
        }

        @Override
        public float getSpeed() {
            return 7.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 2.5F;
        }

        @Override
        public int getLevel() {
            return 3;
        }

        @Override
        public int getEnchantmentValue() {
            return 8;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.EMERALD);
        }
    }

    private static final class EmeraldArmorMaterial implements ArmorMaterial {
        private static final int[] DURABILITY_PER_SLOT = new int[]{11, 16, 15, 13};
        private static final int[] DEFENSE_PER_SLOT = new int[]{2, 5, 6, 2};

        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            return DURABILITY_PER_SLOT[type.ordinal()] * 30;
        }

        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            return DEFENSE_PER_SLOT[type.ordinal()];
        }

        @Override
        public int getEnchantmentValue() {
            return 8;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_DIAMOND;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.EMERALD);
        }

        @Override
        public String getName() {
            return MOD_ID + ":emerald";
        }

        @Override
        public float getToughness() {
            return 1.0F;
        }

        @Override
        public float getKnockbackResistance() {
            return 0.0F;
        }
    }
}
