package main.models;

import java.util.Collections;
import java.util.List;

public class GenericChecks<T extends List<? extends Hospital>> {
    public static Boolean chekone(String name) {
        if (name.length() > 2) {
            return true;
        }
        return false;
    }

    public Boolean unicname(List<? extends Hospital> t, String name, int index) {
        for (int i = 0; i < t.get(index).getDepartments().size(); i++) {
            if (name.equalsIgnoreCase(t.get(index).getDepartments().get(i).getDepartmentName())) {
                return false;
            }
        }

        return true;
    }
}
