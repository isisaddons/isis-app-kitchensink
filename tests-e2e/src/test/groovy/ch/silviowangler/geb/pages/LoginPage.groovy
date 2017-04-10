package ch.silviowangler.geb.pages

import geb.Page

class LoginPage extends Page {

    static url = 'http://localhost:8080/wicket'

    static at = {
        title == 'Kitchensink'
        username_field.value() == ''
        password_field.value() == ''
    }

    static content = {
        username_field { $("#username2")}
        password_field { $("#password3")}
        signIn_button { $("#signInForm1 button", 0) }
    }
}
