package net.noxysoff.emeraldarmor.neoforge;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.noxysoff.emeraldarmor.EmeraldArmorModConstants.MOD_ID;

@Mod(MOD_ID)
public final class EmeraldArmorModNeoForge {
    private static final Tier EMERALD_TIER = new EmeraldToolTier();
    private static final ArmorMaterial EMERALD_ARMOR = new EmeraldArmorMaterial();

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet", () -> new ArmorItem(EMERALD_ARMOR, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", () -> new ArmorItem(EMERALD_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> new ArmorItem(EMERALD_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new ArmorItem(EMERALD_ARMOR, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", () -> new SwordItem(EMERALD_TIER, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () -> new PickaxeItem(EMERALD_TIER, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", () -> new AxeItem(EMERALD_TIER, 5.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", () -> new ShovelItem(EMERALD_TIER, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", () -> new HoeItem(EMERALD_TIER, -3, 0.0F, new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> EMERALD_TAB = TABS.register("emerald_armor_mod", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.emerald_armor_mod.emerald_armor_mod"))
            .icon(() -> new ItemStack(EMERALD_HELMET.get()))
            .displayItems((parameters, output) -> {
                output.accept(EMERALD_HELMET.get());
                output.accept(EMERALD_CHESTPLATE.get());
                output.accept(EMERALD_LEGGINGS.get());
                output.accept(EMERALD_BOOTS.get());
                output.accept(EMERALD_SWORD.get());
                output.accept(EMERALD_PICKAXE.get());
                output.accept(EMERALD_AXE.get());
                output.accept(EMERALD_SHOVEL.get());
                output.accept(EMERALD_HOE.get());
            }).build());

    public EmeraldArmorModNeoForge() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modBus);
        TABS.register(modBus);
        MinecraftForge.EVENT_BUS.addListener(this::onPlayerTick);
    }

    private void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && !event.player.level().isClientSide()
                && event.player.getItemBySlot(EquipmentSlot.HEAD).is(EMERALD_HELMET.get())) {
            event.player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 260, 1, true, false, true));
        }
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
