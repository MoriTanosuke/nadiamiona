def inner = "{\"parent\": \"block/inner_stairs\",\"textures\": {\"bottom\": \"blocks/wool_colored_magenta\",\"top\": \"blocks/wool_colored_magenta\",\"side\": \"blocks/wool_colored_magenta\"}}"
def outer = "{\"parent\": \"block/outer_stairs\", \"textures\": { \"bottom\": \"blocks/wool_colored_magenta\", \"top\": \"blocks/wool_colored_magenta\", \"side\": \"blocks/wool_colored_magenta\" } }"
def normal = "{ \"parent\": \"block/stairs\", \"textures\": { \"bottom\": \"blocks/wool_colored_magenta\", \"top\": \"blocks/wool_colored_magenta\", \"side\": \"blocks/wool_colored_magenta\" } }"

def baseDir = "src/main/resources/assets/kalle/models"

for(i = 2; i <= 15; i++) {
    /*
    new File(baseDir, "block/wool_inner_stairs_" + i + ".json").withWriter { out ->
        out.write(inner);
    }
    new File(baseDir, "block/wool_outer_stairs_" + i + ".json").withWriter { out ->
        out.write(outer);
    }
    new File(baseDir, "block/wool_stairs_" + i + ".json").withWriter { out ->
        out.write(normal);
    }
    */
    new File(baseDir, "item/wool_stairs_" + i + ".json").withWriter { out ->
        out.write(
                "{ \"parent\": \"kalle:block/wool_stairs_" + i + "\", \"display\": { \"thirdperson\": { \"rotation\": [10, -45, 170 ], \"translation\": [0, 1.5, -2.75 ], \"scale\": [0.375, 0.375, 0.375 ] }, \"gui\": { \"rotation\": [0, 180, 0 ] } } }"
        )
    }
}