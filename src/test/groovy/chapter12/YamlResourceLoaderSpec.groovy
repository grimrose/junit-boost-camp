package chapter12

import org.yaml.snakeyaml.Yaml
import spock.lang.Specification

class YamlResourceLoaderSpec extends Specification {

    def "usersをYamlで表現できる"() {
        when:
        def users = []
        users << [id: 1, name: 'Ichiro']
        users << [id: 2, name: 'Jiro']

        then:
        new Yaml().dump([users: users]) == '''users:
- {id: 1, name: Ichiro}
- {id: 2, name: Jiro}
'''
    }

    def "fixtures.yamlを読み込んでusersを取得できる"() {
        given:
        def fixtures = YamlResourceLoader.instance.load(getClass().getResourceAsStream('fixtures.yaml'))

        expect:
        fixtures.users[index].id == id
        fixtures.users[index].name == name

        where:
        index | id | name
        0     | 1  | 'Ichiro'
        1     | 2  | 'Jiro'
    }

}