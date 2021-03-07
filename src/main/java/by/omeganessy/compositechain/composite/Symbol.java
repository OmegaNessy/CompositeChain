package by.omeganessy.compositechain.composite;

import java.util.List;

public class Symbol implements Component {
    private char symbol;
    private TextType type;

    public Symbol(char symbol, TextType type) {
        this.symbol = symbol;
        this.type=type;
    }

    @Override
    public Component getComponent(int index) {
        throw new UnsupportedOperationException("Symbol.getComponents() method is not supported");
    }

    @Override
    public List<Component> getAll() {
        throw new UnsupportedOperationException("Symbol.getComponents() method is not supported");
    }

    @Override
    public boolean removeComponent(Component component) {
        throw new UnsupportedOperationException("Symbol.getComponents() method is not supported");
    }

    @Override
    public boolean addComponent(Component component) {
        throw new UnsupportedOperationException("Symbol.getComponents() method is not supported");
    }

    @Override
    public TextType getTextType() {
        return TextType.SYMBOL;
    }

    @Override
    public void setTextType(TextType type) {
        throw new UnsupportedOperationException("Symbol.getComponents() method is not supported");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symbol)) return false;
        Symbol symbol1 = (Symbol) o;
        return symbol == symbol1.symbol;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        return result * PRIME + symbol;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(symbol);
        return string.toString();
    }
}
