# Function runs at the beginning of a load

# # Adds/updates scoreboard objectives
scoreboard objectives add sbe dummy {"text":"Advancements"}

# # This function sets base scoreboards when loading a world for the first time
scoreboard objectives add sbe_created dummy
execute unless score sbe_created sbe_created matches 1 run function sbe:new_world
