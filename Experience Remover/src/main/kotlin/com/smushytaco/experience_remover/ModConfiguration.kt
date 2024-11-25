package com.smushytaco.experience_remover
import io.wispforest.owo.config.Option
import io.wispforest.owo.config.annotation.Config
import io.wispforest.owo.config.annotation.Modmenu
import io.wispforest.owo.config.annotation.Sync
@Modmenu(modId = ExperienceRemover.MOD_ID)
@Config(name = ExperienceRemover.MOD_ID, wrapperName = "ModConfig")
@Suppress("UNUSED")
class ModConfiguration {
    @JvmField
    @Sync(Option.SyncMode.OVERRIDE_CLIENT)
    var disableMod = false
    @JvmField
    @Sync(Option.SyncMode.OVERRIDE_CLIENT)
    var allowAnvilUse = false
    @JvmField
    @Sync(Option.SyncMode.OVERRIDE_CLIENT)
    var allowEnchantmentTableUse = false
}