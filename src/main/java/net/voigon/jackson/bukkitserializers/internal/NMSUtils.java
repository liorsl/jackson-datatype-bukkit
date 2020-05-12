package net.voigon.jackson.bukkitserializers.internal;

import org.bukkit.Bukkit;

/**
 * @author Voigon
 * NMS Utils class, taken from apartium commons
 */
public class NMSUtils {

    private static final  String PACKAGENAME = Bukkit.getServer().getClass().getPackage().getName(),
            VERSION = PACKAGENAME.substring(PACKAGENAME.lastIndexOf(".") + 1);

    /**
     * Get minecraft version. Ex: v_1_10_R1
     *
     * @return the minecraft version
     */
    public static String getVersion() {
        return VERSION;
    }

    /**
     * get class of packet
     *
     * @param name
     *            name of the packet, packet prefix is not needed
     * @return Class variable of the packet
     * @throws ClassNotFoundException
     */
    public static Class<?> getPacketClass(String name) throws ClassNotFoundException {
        if (!name.startsWith("Packet"))
            name = "Packet" + name;

        return getClass(true, name);
    }

    static Class<?> getClassInternal(boolean nms, String name) throws ClassNotFoundException {
        try {
            return getClass(nms, name);
        } catch (ClassNotFoundException e) {
            throw e;
        }
    }

    /**
     * Get non/nms class
     *
     * @param nms
     *            determine if the required class is for NMS or OBC - true for NMS,
     *            false for OBC
     * @param name
     *            the name of the class (including sub packages if any)
     * @return the required class
     * @throws ClassNotFoundException
     */
    public static Class<?> getClass(boolean useIndex, boolean nms, String name) throws ClassNotFoundException {
        String pack = (nms ? "net.minecraft.server." : "org.bukkit.craftbukkit.") + getVersion();

        try {
            Class<?> clazz = Class.forName(pack + "." + name);
            return clazz;
        } catch (ClassNotFoundException e) {
            throw e;
        }

    }

    /**
     * Get non/nms class
     *
     * @param nms
     *            determine if the required class is for NMS or OBC - true for NMS,
     *            false for OBC
     * @param name
     *            the name of the class (including sub packages if any)
     * @return the required class
     * @throws ClassNotFoundException
     */
    public static Class<?> getClass(boolean nms, String name) throws ClassNotFoundException {
        return getClass(true, nms, name);
    }



}
