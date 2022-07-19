

@("ace", "agender", "aro", "bi", "gay", "genderqueer", "lesbian", "nonbinary", "pan", "trans") | Foreach-Object {
$name = "$_`_furnace"

# block state
New-Item -Path $(Join-Path -Path $PSScriptRoot -ChildPath "block_states") -ItemType File -Name "$name.json" -Force -Value @"
{
  "variants": {
    "facing=east,lit=false": {
      "model": "pridefurnaces:block/$_`_furnace",
      "y": 90
    },
    "facing=east,lit=true": {
      "model": "pridefurnaces:block/$_`_furnace_on",
      "y": 90
    },
    "facing=north,lit=false": {
      "model": "pridefurnaces:block/$_`_furnace"
    },
    "facing=north,lit=true": {
      "model": "pridefurnaces:block/$_`_furnace_on"
    },
    "facing=south,lit=false": {
      "model": "pridefurnaces:block/$_`_furnace",
      "y": 180
    },
    "facing=south,lit=true": {
      "model": "pridefurnaces:block/$_`_furnace_on",
      "y": 180
    },
    "facing=west,lit=false": {
      "model": "pridefurnaces:block/$_`_furnace",
      "y": 270
    },
    "facing=west,lit=true": {
      "model": "pridefurnaces:block/$_`_furnace_on",
      "y": 270
    }
  }
}
"@

# block models
New-Item -Path $(Join-Path -Path $PSScriptRoot -ChildPath "block_models") -ItemType File -Name "$name.json" -Force -Value @"
{
  "parent": "minecraft:block/orientable",
  "textures": {
    "top": "pridefurnaces:block/$_`_furnace_top",
    "front": "pridefurnaces:block/$_`_furnace_front",
    "side": "pridefurnaces:block/$_`_furnace_side"
  }
}
"@

New-Item -Path $(Join-Path -Path $PSScriptRoot -ChildPath "block_models") -ItemType File -Name "$name`_on.json" -Force -Value @"
{
  "parent": "minecraft:block/orientable",
  "textures": {
    "top": "pridefurnaces:block/$_`_furnace_top",
    "front": "pridefurnaces:block/$_`_furnace_front_on",
    "side": "pridefurnaces:block/$_`_furnace_side"
  }
}
"@

# item
New-Item -Path $(Join-Path -Path $PSScriptRoot -ChildPath "items") -ItemType File -Name "$name.json" -Force -Value @"
{
  "parent": "pridefurnaces:block/$_`_furnace"
}
"@

# loot table
New-Item -Path $(Join-Path -Path $PSScriptRoot -ChildPath "loot_tables") -ItemType File -Name "$name.json" -Force -Value @"
{
  "type": "minecraft:block",
  "pools": [
    {
      "rolls": 1.0,
      "bonus_rolls": 0.0,
      "entries": [
        {
          "type": "minecraft:item",
          "functions": [
            {
              "function": "minecraft:copy_name",
              "source": "block_entity"
            }
          ],
          "name": "pridefurnaces:$_`_furnace"
        }
      ],
      "conditions": [
        {
          "condition": "minecraft:survives_explosion"
        }
      ]
    }
  ]
}
"@

# recipe
New-Item -Path $(Join-Path -Path $PSScriptRoot -ChildPath "recipes") -ItemType File -Name "$name.json" -Force -Value @"
{
  "type": "minecraft:crafting_shapeless",
  "ingredients": [
    {
      "item": "minecraft:furnace"
    },
    {
      "item": "minecraft:xxx"
    }
  ],
  "result": {
    "item": "pridefurnaces:$_`_furnace"
  }
}
"@

# lang
Write-Host @"
"block.pridefurnaces.$_`_furnace": "$_ Furnace","
"@

}
