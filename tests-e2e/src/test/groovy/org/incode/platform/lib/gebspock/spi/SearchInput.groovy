package org.incode.platform.lib.gebspock.spi;

import geb.module.AbstractInput;

class SearchInput extends AbstractInput {

    final String inputType = "search"

    String getText() {
        navigator.value()
    }

    void setText(String text) {
        navigator.value(text)
    }
}
