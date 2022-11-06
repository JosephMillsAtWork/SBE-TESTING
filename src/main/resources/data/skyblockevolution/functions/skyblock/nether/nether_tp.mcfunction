execute in minecraft:the_nether run tp @a 7.5 65 204.5 facing 7.5 65 203.5
execute in minecraft:the_nether run spawnpoint @a 7 65 204
playsound minecraft:block.respawn_anchor.deplete master @s ~ ~ ~ 100 1 1
playsound minecraft:block.respawn_anchor.deplete master @s ~ ~ ~ 100 0.5 1
execute as @a run schedule function skyblockevolution:nether/portal 5s