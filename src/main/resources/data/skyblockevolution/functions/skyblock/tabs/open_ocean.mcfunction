# Grant @s the ocean root advancement
tellraw @s[advancements={skyblockevolution:ocean/root=false}] [{"translate":"A new quest line is now available: "}, {"translate": "The Ocean", "color":"green"}]
execute as @s run schedule function sbe:give_point 2s
advancement grant @s[advancements={skyblockevolution:ocean/root=false}] only skyblockevolution:ocean/root
