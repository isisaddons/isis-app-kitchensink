package ch.silviowangler.geb.pages

import geb.Page

class KitchenSinkLoginPage extends Page {

    static url = 'http://localhost:8080/wicket'

    static at = {
        title == 'Kitchensink'
    }

    static content = {
        usernameField { $("#username2")}
        passwordField { $("#password3")}

//        searchInputField { $("input", name: "q") }
//
//        searchButton { $("button", name: "btnG") }
//
//        searchResultsContainer { $('#sbfrm_l') }
//
//        searchResults { $('h3.r') }
//
//        firstResult { searchResults[0] }
    }
}
