function skyblockevolution:iu/count_advancemnts

execute as @a run function skyblockevolution:iu/slot_lock

kill @e[type=item,nbt={Item:{id:"minecraft:structure_void",tag:{display:{Name:'[{"text":"Locked Slot","color":"dark_red"}]'}}}}]
