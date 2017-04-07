package ch.silviowangler.geb.pages

import geb.Page

/**
 * @author Silvio Wangler
 */
class GoogleFrontPage extends Page {

    static url = '/'

    static at = {
        title == 'Google'
    }

    static content = {
        searchInputField { $("input", name: "q") }

        searchButton { $("button", name: "btnG") }

        searchResultsContainer { $('#sbfrm_l') }

        searchResults { $('h3.r') }

        firstResult { searchResults[0] }
    }
}
