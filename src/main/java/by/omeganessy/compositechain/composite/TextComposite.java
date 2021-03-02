package by.omeganessy.compositechain.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
    static final String WORD_SPLITTER = " ";
    static final String PARAGRAPH_SPLITTER = "\n\t";
    private List<Component> components;
    private TextType textType;

    public TextComposite(TextType textType) {
        this.components = new ArrayList<>();
        this.textType = textType;
    }

    @Override
    public Component getComponent(int index) {
        return components.get(index);
    }

    @Override
    public List<Component> getAll() {
        return components;
    }

    @Override
    public boolean removeComponent(Component component) {
        return components.remove(component);
    }

    @Override
    public boolean addComponent(Component component) {
        return components.add(component);
    }

    @Override
    public TextType getTextType() {
        return textType;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Component t : components) {
            string.append(t.toString());
            switch (t.getTextType()) {
                case WORD -> string.append(WORD_SPLITTER);
                case PARAGRAPH -> string.append(PARAGRAPH_SPLITTER);
            }
        }
        return string.toString();
    }
}
