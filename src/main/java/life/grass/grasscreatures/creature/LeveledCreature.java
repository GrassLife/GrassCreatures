package life.grass.grasscreatures.creature;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;

/**
 * Created by ecila on 2017/06/18.
 */
public class LeveledCreature {
    private LivingEntity entity;
    private int level;
    private String name;
    private static Gson gson;

    static {
        gson = new Gson();
    }

    public LeveledCreature(LivingEntity entity) {
        this.entity = entity;
        String jsonString = entity.getScoreboardTags().stream().filter(s -> s.startsWith("{")).findFirst().orElse(null);
        level = 0;
        if(jsonString != null) {
            JsonObject json = gson.fromJson(jsonString, JsonElement.class).getAsJsonObject();
            if(json.get("CustomName") != null) name = json.get("CustomName").getAsString();
            if(json.get("Level") != null) level = json.get("Level").getAsInt();
        }
    }

    private LeveledCreature(LivingEntity entity, int level) {
        this.entity = entity;
        this.level = level;
        setupEntity();
    }

    private LeveledCreature(LivingEntity entity, int level, String name) {
        this.entity = entity;
        this.level = level;
        this.name = name;
        setupEntity();
    }

    public static LeveledCreature generate(LivingEntity entity, LevelRange range, String name) {
        return new LeveledCreature(entity, range.getRandomLevel(), name);
    }

    public static LeveledCreature generate(LivingEntity entity, LevelRange range) {
        return new LeveledCreature(entity, range.getRandomLevel());
    }

    public static LeveledCreature generate(LivingEntity entity) {
        return generate(entity, LevelRange.NORMAL);
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public int getLevel() {
        return level;
    }

    public String getDisplayName() {
        return name != null ? name : entity.getName();
    }

    public ChatColor getLevelColor() {
        if(level >= 10) {
            return ChatColor.GOLD;
        } else if(level >= 5) {
            return ChatColor.YELLOW;
        } else if(level >= 3) {
            return ChatColor.GRAY;
        } else {
            return ChatColor.DARK_GRAY;
        }
    }

    private void setupEntity() {
        entity.setCanPickupItems(false);
        entity.setMaxHealth(entity.getMaxHealth() + 3.0 * (level - 1));
        entity.setHealth(entity.getMaxHealth());
        if(entity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE) != null) {
            entity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(entity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue() + (level - 1) / 4);
        }
        JsonObject json = new JsonObject();
        json.addProperty("Level", level);
        json.addProperty("CustomName", name != null ? name : getDisplayName());
        entity.addScoreboardTag(new Gson().toJson(json));
//        entity.setCustomName(buildName());
    }

    public String buildName() {
        return getLevelColor() + "[Lv." + level + "] " + ChatColor.WHITE + name;
    }
}
