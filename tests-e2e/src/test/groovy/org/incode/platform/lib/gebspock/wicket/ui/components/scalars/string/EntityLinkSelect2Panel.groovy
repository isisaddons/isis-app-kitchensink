package org.incode.platform.lib.gebspock.wicket.ui.components.scalars.string

import geb.Module
import geb.module.Select
import org.openqa.selenium.Keys

abstract class EntityLinkSelect2Panel extends Module {

    static content = {
        select { $(".select2") }
        value { $("select").module(Select).getSelectedText() }
        searchField { closest("body").$("input.select2-search__field") }

        //feedback { $(".alert") }
        //columnValue { $( "div.scalarNameAndValueComponentType.stringPanel", it ).text() }
    }

    void setInput(String newValue) {
        select.click()
        def element = searchField.firstElement() // findElement(By.cssSelector("input.select2-search__field"))
        element.sendKeys(newValue)
        sleep(250) // yuk
        element.sendKeys(Keys.ENTER)
    }

}
