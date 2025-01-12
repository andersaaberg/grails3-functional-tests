package functionaltests

import geb.spock.GebSpec
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

@Integration(applicationClass = Application)
@Rollback
class ConfigTestControllerSpec extends GebSpec {

    void "Test that configuration properties are correctly read"() {
        when:"When evaluting configuration values"
        go '/configTest/index'

        then:"The values are correct"
        $('div', 0).text() == 'test'
        $('div', 1).text() == '1'
        $('div', 2).text() == 'test'
        $('div', 3).text() == '1'
        $('div', 4).text() == 'test'
        $('div', 5).text() == '1'
        $('div', 6).text() == '{baz=1, bax=2, bar=test}'
    }
}
