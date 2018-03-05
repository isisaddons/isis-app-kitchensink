package org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string

import geb.Module
import geb.module.Select
import org.openqa.selenium.Keys

class EntityLinkSelect2Panel extends Module {

    static content = {
        searchField { closest("body").$("input.select2-search__field") }
        select { $(".select2") }
        value { select.module(Select).getSelectedText() }

        //

        //feedback { $(".alert") }
        //columnValue { $( "div.scalarNameAndValueComponentType.stringPanel", it ).text() }
    }

    void setInput(String newValue) {
        select.click()
        def element = searchField.firstElement() // findElement(By.cssSelector("input.select2-search__field"))
        element.sendKeys(newValue)
        sleep(100) // yuk
        element.sendKeys(Keys.ENTER)
    }

}
