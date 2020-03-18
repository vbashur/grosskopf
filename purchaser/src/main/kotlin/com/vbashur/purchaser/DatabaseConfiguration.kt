package com.vbashur.purchaser

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType

@Configuration
class DatabaseConfiguration {

    @Bean
    fun dataSource() : EmbeddedDatabase {
        return EmbeddedDatabaseBuilder()
                .addScripts("db/schema.sql"
                        , "db/data.sql"
                )
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }
}