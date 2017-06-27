package life.grass.grasscreatures.loader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import life.grass.grasscreatures.treasure.DropTable;
import life.grass.grasscreatures.treasure.LootTable;
import life.grass.grasscreatures.treasure.TreasureHolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by ecila on 2017/06/18.
 */
public class TreasureLoader {
    public static void loadDrops(File dir) {
        Gson gson = new Gson();
        if(!dir.exists()) dir.mkdirs();
        for(File file: dir.listFiles()) {
            try {
                System.out.println(file.getName());
                if(!file.getName().endsWith(".json")) break;
                Type type = new TypeToken<Collection<DropTable>>(){}.getType();
                JsonReader reader = new JsonReader(new FileReader(file));
                List<DropTable> tables = gson.fromJson(reader, type);
                for(DropTable table: tables) {
                    TreasureHolder.putDropTable(table);
                }
            } catch(FileNotFoundException ex) {
                Logger.getLogger("読み込みエラー: " + file.getName());
            }
        }
    }

    public static void loadLoots(File dir) {
        Gson gson = new Gson();
        if(!dir.exists()) dir.mkdirs();
        for(File file: dir.listFiles()) {
            try {
                System.out.println(file.getName());
                if(!file.getName().endsWith(".json")) break;
                Type type = new TypeToken<Collection<LootTable>>(){}.getType();
                JsonReader reader = new JsonReader(new FileReader(file));
                List<LootTable> tables = gson.fromJson(reader, type);
                for(LootTable table: tables) {
                    TreasureHolder.putLootTable(table);
                }
            } catch(FileNotFoundException ex) {
                Logger.getLogger("読み込みエラー: " + file.getName());
            }
        }
    }
}
