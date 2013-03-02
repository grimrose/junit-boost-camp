package chapter12

import groovy.util.logging.Slf4j
import org.yaml.snakeyaml.Yaml


@Slf4j
class YamlResourceLoader {

    Yaml yaml

    Object load(String filePath, String charset = 'UTF-8') {
        load new File(filePath), charset
    }

    Object load(File file, String charset = 'UTF-8') {
        log.info "file: $file   charset: $charset"
        load new FileInputStream(file), charset
    }

    Object load(InputStream stream, String charset = 'UTF-8') {
        stream.with {
            try {
                getYaml().load(new InputStreamReader(delegate, charset))
            } finally {
                close()
            }
        }
    }

    static YamlResourceLoader getInstance() {
        getInstance(new Yaml())
    }

    static YamlResourceLoader getInstance(Yaml yaml) {
        new YamlResourceLoader(yaml: yaml)
    }

}
