#Visit All Structures Advancement
#Mansion Advancement
execute in minecraft:overworld positioned 631 83 -566 if entity @p[distance=..20] run advancement grant @p only skyblockevolution:adventure/mansion
execute in minecraft:overworld positioned 631 83 -566 if entity @p[distance=..20] run advancement grant @p only skyblockevolution:adventure/04visit_all_structures mansion

#Shipwreck Advancement
execute in minecraft:overworld positioned -522 46 671 if entity @p[distance=..5] run advancement grant @p only skyblockevolution:adventure/shipwreck
execute in minecraft:overworld positioned -522 46 671 if entity @p[distance=..5] run advancement grant @p only skyblockevolution:adventure/04visit_all_structures shipwreck

#Jungle Pyramid			
execute in minecraft:overworld positioned 1 65 -924 if entity @p[distance=..10] run advancement grant @p only skyblockevolution:adventure/04visit_all_structures jungle_pyramid
execute in minecraft:overworld positioned 1 86 -945 if entity @p[distance=..5] run advancement grant @p only skyblockevolution:adventure/jungle_pyramid
execute if entity @p[nbt={Inventory:[{id:"minecraft:written_book",tag:{title:"Curse of Montezuma"}}]}] run fill 1 66 -925 1 67 -925 air
execute run effect give @a[advancements={skyblock:adventure/jungle_pyramid=false},x=1,y=59,z=-945,distance=..64] minecraft:mining_fatigue 2 3 true

#Ancient City			
execute in minecraft:overworld positioned -892 -43 -272 if entity @p[distance=..5] run advancement grant @p only skyblockevolution:adventure/04visit_all_structures ancient_city
execute in minecraft:overworld positioned -892 -43 -272 if entity @p[distance=..5] run advancement grant @p only skyblockevolution:adventure/ancient_city

#Desert Pyramid			
execute in minecraft:overworld positioned 810 65 253 if entity @p[distance=..10] run advancement grant @p only skyblockevolution:adventure/04visit_all_structures desert_pyramid
execute in minecraft:overworld positioned 810 65 253 if entity @p[distance=..10] run advancement grant @p only skyblockevolution:adventure/desert_pyramid

#Ruined Portal Nether
execute in minecraft:the_nether positioned -154 44 -882 if entity @p[distance=..5] run advancement grant @p only skyblockevolution:adventure/04visit_all_structures ruined_portal_nether

#Exploration Advancement
execute in minecraft:overworld positioned -761 -3 -256 if entity @p[distance=..5] run advancement grant @p only skyblockevolution:adventure/02exploration lush_cave

#Full Inventory Unlock Reward
execute as @p if score @s sbe matches 105 at @s run advancement grant @s only skyblockevolution:ocean/sbeaur

# Composter dirt
function skyblockevolution:skyblock/composter_dirt/update