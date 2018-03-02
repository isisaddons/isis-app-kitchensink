package org.incode.platform.lib.gebspock.wicket.ui.pages.signin

import geb.Page

class WicketSignInPage extends Page {

    static url = 'http://localhost:8080/wicket'

    static at = {
        title == 'Kitchensink'
        username.value() == ''
        password.value() == ''
    }

    static content = {
        username { $("input.isis-username", 0)}
        password { $("input.isis-password", 0)}
        signIn { $("#signInForm1 button", 0) }
    }
}
