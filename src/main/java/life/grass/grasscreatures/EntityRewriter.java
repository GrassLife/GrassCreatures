package life.grass.grasscreatures;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.*;
import com.comphenix.protocol.wrappers.WrappedWatchableObject;
import life.grass.grasscreatures.creature.LeveledCreature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by ecila on 2017/07/08.
 */
public class EntityRewriter {
    private static EntityRewriter instance;
    private static final int NAME_INDEX = 2;

    static {
        instance = new EntityRewriter();
    }

    private EntityRewriter(){}

    public static EntityRewriter getInstance(){
        return instance;
    }

    public void addListener(ProtocolManager manager, JavaPlugin plugin) {
        manager.addPacketListener(new PacketAdapter(plugin,
                ListenerPriority.LOW,
                PacketType.Play.Server.SPAWN_ENTITY_LIVING,
                PacketType.Play.Server.ENTITY_METADATA) {
            @Override
            public void onPacketSending(PacketEvent event) {
                PacketContainer packet = event.getPacket();
                packet = packet.deepClone();
                event.setPacket(packet);

                Entity entity = packet.getEntityModifier(event.getPlayer().getWorld()).read(0);
                if(!(entity instanceof LivingEntity) || entity instanceof PacketType.Play) return;
                LivingEntity livingEntity = (LivingEntity) entity;
                PacketType type = event.getPacketType();
                if(type.equals(PacketType.Play.Server.SPAWN_ENTITY_LIVING)) {
                    // Do not need this?
                } else if(type.equals(PacketType.Play.Server.ENTITY_METADATA)) {
                    for(WrappedWatchableObject watcher: packet.getWatchableCollectionModifier().read(0)) {
                        if(watcher.getIndex() == NAME_INDEX) {
                            watcher.setValue(rewriteName(livingEntity));
                        }
                    }
                }
            }
        });
    }

    private String rewriteName(LivingEntity entity) {
        LeveledCreature creature = new LeveledCreature(entity);
        return creature.buildName();
    }
}
