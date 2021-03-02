package by.omeganessy.compositechain.composite;

import java.util.List;

public interface Component {
    Component getComponent(int index);
    List<Component> getAll();
    boolean removeComponent(Component component);
    boolean addComponent(Component component);
    TextType getTextType();
}
