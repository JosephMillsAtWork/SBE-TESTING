# Grant @s the adventure root advancement
tellraw @s[advancements={skyblockevolution:adventure/root=false}] [{"translate":"A new quest line is now available: "}, {"translate": "The Adventure", "color":"green"}]
execute as @s run schedule function skyblockevolution:give_point 2s
advancement grant @s[advancements={skyblockevolution:adventure/root=false}] only skyblockevolution:adventure/root
