
# Gamerules
#gamerule logAdminCommands false
#gamerule commandBlockOutput false

# Scoreboards
scoreboard objectives add place_composter minecraft.used:minecraft.composter
scoreboard objectives add Var dummy

# Worldborder Reset
worldborder set 29999984

#Skyblock Evolution Advancement Counter
execute as @a run schedule function skyblockevolution:skyblock/main/sbeac 10s