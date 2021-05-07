package com.smushytaco.experience_remover.configuration_support
import com.smushytaco.experience_remover.ExperienceRemover
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment
@Config(name = ExperienceRemover.MOD_ID)
class ModConfiguration: ConfigData {
    @Comment("Default value is no. If set to yes the mod will be disabled and experience, enchantment tables, and anvils will be enabled. If set to no the mod will be enabled and experience, enchantment tables, and anvils will be disabled.")
    val disableMod = false
}