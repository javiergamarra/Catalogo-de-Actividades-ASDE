package com.nhpatt.asde.async;

import de.greenrobot.event.EventBus;

public class EventBusUtil {
    public static void post(Object event) {
        EventBus.getDefault().post(event);
    }

    public static void register(Object object) {
        EventBus.getDefault().register(object);
    }

    public static void unregister(Object object) {
        EventBus.getDefault().unregister(object);
    }
}
