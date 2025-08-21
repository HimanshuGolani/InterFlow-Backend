package com.interflow.userservice.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class UserUpdater {
    private boolean changed = false;

    public boolean isChanged() {
        return changed;
    }

    public void update(Consumer<String> setter, Supplier<String> getter, String newValue) {
        if (newValue != null && !newValue.trim().equalsIgnoreCase(String.valueOf(getter.get()).trim())) {
            setter.accept(newValue.trim());
            changed = true;
        }
    }
}
