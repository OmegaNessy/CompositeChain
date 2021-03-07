package by.omeganessy.compositechain.comparator;

import by.omeganessy.compositechain.composite.Component;

import java.util.Comparator;

public class ComponentSizeComparator implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {
        return Integer.compare(o1.getAll().size(),o2.getAll().size());
    }
}
