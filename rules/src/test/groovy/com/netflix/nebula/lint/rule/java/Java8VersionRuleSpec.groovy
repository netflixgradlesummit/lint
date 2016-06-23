package com.netflix.nebula.lint.rule.java

import com.netflix.nebula.lint.rule.test.AbstractRuleSpec
import spock.lang.Unroll

class Java8VersionRuleSpec extends AbstractRuleSpec {
    @Unroll
    def 'java version #version #violationText rule'() {
        setup:
        project.buildFile << """
            sourceCompatibility = $version
            targetCompatibility = $version
        """

        when:
        def results = runRulesAgainst(new Java8VersionRule())

        then:
        results.violates(Java8VersionRule) == violates

        when:
        correct(new Java8VersionRule())

        then:
        project.buildFile.text.contains(/sourceCompatibility = '1.8'/)
        project.buildFile.text.contains(/targetCompatibility = '1.8'/)

        where:
        version     | violates
        /'1.7'/     | true
        '1.7'       | true
        '1.6'       | true
        /'1.8'/     | false

        violationText = violates ? 'violates' : 'does not violate'
    }
}
