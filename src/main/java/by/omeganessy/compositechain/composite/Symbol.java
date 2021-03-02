package by.omeganessy.compositechain.composite;

import java.util.List;

public class Symbol implements Component {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public Component getComponent(int index) {
        return null;
    }

    @Override
    public List<Component> getAll() {
        return null;
    }

    @Override
    public boolean removeComponent(Component component) {
        return false;
    }

    @Override
    public boolean addComponent(Component component) {
        return false;
    }

    @Override
    public TextType getTextType() {
        return TextType.SYMBOL;
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
        string.append("Sybol{\n");
        string.append("sybol=");
        string.append(symbol);
        string.append("\n}");
        return string.toString();
    }
}
