package org.incode.platform.lib.gebspock.spi

import geb.Browser
import org.openqa.selenium.WebElement

class NonEmptyNavigator extends geb.navigator.NonEmptyNavigator {
    NonEmptyNavigator(Browser browser, Collection<? extends WebElement> contextElements) {
        super(browser, contextElements)
    }

    void select(String value){
        browser.js.exec(firstElement(), value, 'jQuery(arguments[0]).select2("val", arguments[1]);')
    }
}


