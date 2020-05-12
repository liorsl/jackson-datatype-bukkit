package net.voigon.jackson.bukkitserializers.internal;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;

public class CraftTypeResolver extends SimpleAbstractTypeResolver {

    public void addMapping(Class<?> iface, String craftImplementationName) {
        try {
            super.addMapping(iface, cast(NMSUtils.getClass(false, craftImplementationName)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private <T> T cast(Object object) {
        return (T) object;
    }

}
