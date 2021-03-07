package by.omeganessy.compositechain.logic;

import by.omeganessy.compositechain.comparator.ComponentSizeComparator;
import by.omeganessy.compositechain.composite.Component;
import by.omeganessy.compositechain.composite.TextComposite;
import by.omeganessy.compositechain.composite.TextType;
import by.omeganessy.compositechain.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    public Component paragraphSort(Component text) throws CustomException {
        if (text.getTextType() != TextType.TEXT) {
            throw new CustomException("Incorrect text type");
        }
        Component sortedParagraphs = new TextComposite(TextType.PARAGRAPH);
        List<Component> paragraphs = new ArrayList<>(text.getAll());
        paragraphs.sort(new ComponentSizeComparator());
        for (Component paragraph : paragraphs) {
            sortedParagraphs.addComponent(paragraph);
        }
        return sortedParagraphs;
    }

    public Component removeSentences(Component text, int amountOfWords){
        List<Component> paragraphList = text.getAll();
        List<Component> listToRemove = new ArrayList<>();
        for (Component t : paragraphList) {
            List<Component> sentenceList = t.getAll();
            for (Component t2 : sentenceList) {
                if (t2.getTextType() == TextType.SENTENCE) {
                    if (t2.getAll().size() < amountOfWords) {
                        listToRemove.add(t2);
                    }
                }
            }
            for (Component t3 : listToRemove) {
                t.removeComponent(t3);
            }
            listToRemove.clear();
        }
        return text;
    }
}