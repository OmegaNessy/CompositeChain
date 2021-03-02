package by.omeganessy.compositechain.parser;

import by.omeganessy.compositechain.composite.Component;
import by.omeganessy.compositechain.exception.CustomException;

public interface Parser {
    Component parse(String text) throws CustomException;
}
