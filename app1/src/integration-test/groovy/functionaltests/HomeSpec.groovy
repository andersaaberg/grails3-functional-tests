package functionaltests

import geb.spock.*
import grails.testing.mixin.integration.Integration

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration(applicationClass=functionaltests.Application)
class HomeSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test the home page renders correctly"() {
        when:"The home page is visited"
            go '/'
            if(title != "Welcome to Grails") {
              println driver.pageSource
            }
        then:"The title is correct"
            title == "Welcome to Grails"
            $('li.controller', text: 'demo.AlphaController')
            $('li.controller', text: 'functionaltests.BookController')
            $('li.controller', text: 'functionaltests.ErrorsController')
            $('li.controller', text: 'functionaltests.ForwardingController')
            $('li.controller', text: 'functionaltests.InspectConfigController')
            $('li.controller', text: 'functionaltests.MiscController')
            $('li.controller', text: 'functionaltests.UploadController')
            $('li.controller', text: 'grails.functionaltests.InGrailsPackageController')
            
            // SimpleController should not become a controller as it is not in a grails-app/controllers dir
            !$('li.controller', text: 'functionaltests.SimpleController')

    }
}
