package com.smushytaco.experience_remover
import net.fabricmc.api.ModInitializer
object ExperienceRemover : ModInitializer {
    const val MOD_ID = "experience_remover"
    val config = ModConfig.createAndLoad()
    override fun onInitialize() {}
}