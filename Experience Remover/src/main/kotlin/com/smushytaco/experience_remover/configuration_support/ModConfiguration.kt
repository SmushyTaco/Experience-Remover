package com.smushytaco.experience_remover.configuration_support
import com.smushytaco.experience_remover.ExperienceRemover
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment
@Config(name = ExperienceRemover.MOD_ID)
class ModConfiguration: ConfigData {
    @Comment("Default value is no. If set to yes the mod will be disabled and experience, enchantment tables, and anvils will be enabled. If set to no the mod will be enabled and experience, enchantment tables, and anvils will be disabled. Anvils and enchantment tables can be separately enabled.")
    val disableMod = false
    @Comment("Default value is no. If set to yes anvils will be enabled. If set to no anvils will be disabled.")
    val allowAnvilUse = false
    @Comment("Default value is no. If set to yes enchantment tables will be enabled. If set to no enchantment tables will be disabled.")
    val allowEnchantmentTableUse = false
}