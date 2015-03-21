dataSource {
    pooled = true
    driverClassName = "org.postgresql.Driver"
    dialect = org.hibernate.dialect.PostgresPlusDialect
}
hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='com.opensymphony.oscache.hibernate.OSCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop"
            url = "jdbc:postgresql://10.0.0.21:5432/grails"
            username = "grails"
            password = "grails"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:postgresql://10.0.0.21:5432/grails"
            username = "grails"
            password = "grails"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:postgresql://10.0.0.21:5432/grails"
            username = "grails"
            password = "grails"
        }
    }
}
