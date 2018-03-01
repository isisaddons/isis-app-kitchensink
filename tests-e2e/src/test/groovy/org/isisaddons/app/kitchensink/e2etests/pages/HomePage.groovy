package org.isisaddons.app.kitchensink.e2etests.pages

class HomePage extends LoggedInPage {

    static at = {
        $(".intro").text().contains(" a platform to let you rapidly develop")
    }

    static content = {
    }

}
