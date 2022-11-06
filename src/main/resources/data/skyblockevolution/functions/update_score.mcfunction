# Function that updates your advancement score depending on how many advancements you have obtained in your world so far
# For use if you have a world that ran 1.5 or an earlier version of the pack and updated to 1.5.1 but want to see your score

# Set to 0
scoreboard players set @a sbe 0

# Go through every advancement, and adds 1 to score if you have obtained that advancement
#Adventure

execute as @a[advancements={skyblockevolution:adventure/02exploration=true}] run scoreboard players add @s sbeac 1
execute as @a[advancements={skyblockevolution:adventure/04visit_all_structures=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:adventure/09kill_while_flying=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:adventure/ancient_city=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:adventure/desert_pyramid=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:adventure/evoker=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:adventure/jungle_pyramid=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:adventure/mansion=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:adventure/monument=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:adventure/pillager_outpost=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:adventure/shipwreck=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:adventure/spyglass_at_parrot=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:adventure/swamp_hut=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:adventure/totem_of_undying=true}] run scoreboard players add @s sbe 1

#Collector

execute as @a[advancements={skyblockevolution:collector/dlog=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:collector/rainbow=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:collector/cobblestone=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:collector/arrow=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:collector/stonebrick=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:collector/sand=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:collector/drowned_clay=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:collector/dirt=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:collector/interior=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:collector/gravel=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:collector/glass_pane=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:collector/enderpearl=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:collector/todye=true}] run scoreboard players add @s sbe 1

#End

execute as @a[advancements={skyblockevolution:end/shiny_gear=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:end/3spyglass_at_dragon=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:end/1respawn_dragon=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:end/enter_end_gateway=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:end/find_end_city=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:end/2kill_dragon=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:end/levitate=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:end/diamond=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:end/dragon_breath=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:end/11dragon_egg=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:end/ultimate_sword=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:end/elytra=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:end/tool=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:end/enchant_item=true}] run scoreboard players add @s sbe 1

#Farmer

execute as @a[advancements={skyblockevolution:farmer/1silk_touch_nest=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/02melon=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/5nether_wart=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/animal_friends=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/bamboo=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/beetroot=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/beetroot_soup=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/bread=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/harvest_honey=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/honey_block_slide=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/honey_blocks=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/jack_o_lantern=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/nether_wart_block=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/pumpkin=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/sea_pickle=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/seedy_place=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/sugar_cane=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/suit_up=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/wax_off=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/wax_on=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:farmer/wheat=true}] run scoreboard players add @s sbe 1


#Nether

execute as @a[advancements={skyblockevolution:nether/01obtain_ancient_debris=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/02find_bastion=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/02gold=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/02wither_skull=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/04nether_wart=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/05fortress=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/08blaze_rod=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/08end=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/09return_to_sender=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/10obtain_crying_obsidian=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/all_effects=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/all_potions=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/brew_potion=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/charge_respawn_anchor=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/create_beacon=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/create_full_beacon=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/kill_wither=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/loot_bastion=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/netherite_armor=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/quartz=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/ride_strider=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/ride_strider_in_overworld_lava=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/spyglass_at_ghast=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:nether/uneasy_alliance=true}] run scoreboard players add @s sbe 1

#Ocean

execute as @a[advancements={skyblockevolution:ocean/axolotl_in_a_bucket=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:ocean/bio_fuel=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:ocean/conduit=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:ocean/conduit_root=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:ocean/elder_guardian=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:ocean/founders_faces=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:ocean/guardian=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:ocean/head_hunter=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:ocean/kelp=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:ocean/lightning_creeper=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:ocean/scute=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:ocean/seagrass=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:ocean/throw_trident=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:ocean/turtle_breed=true}] run scoreboard players add @s sbe 1

#Skyblock

execute as @a[advancements={skyblockevolution:skyblock/02fake_cave=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/04furnace=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/09portal=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/all_saplings=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/cobblestone_generator=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/for_science=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/golems=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/iron=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/magical_trade=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/map_trade=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/regrowth=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/shoot_arrow=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/slime_ball=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/sniper_duel=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/the_cure=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/trade_master=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/witch_power=true}] run scoreboard players add @s sbe 1
execute as @a[advancements={skyblockevolution:skyblock/you_have_been_stopped=true}] run scoreboard players add @s sbe 1