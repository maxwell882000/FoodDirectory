

package com.elbehiry.shared.database

import androidx.room.Room
import androidx.room.testing.MigrationTestHelper
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.platform.app.InstrumentationRegistry
import com.elbehiry.shared.data.db.DelishDataBase
import com.elbehiry.shared.data.db.MIGRATIONS
import org.junit.Rule
import org.junit.Test

private const val TEST_DB_NAME = "migration-test"

@RunWith(AndroidJUnit4::class)
class MigrationTest {

    @get:Rule
    val migrationTestHelper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        DelishDataBase::class.java.canonicalName,
        FrameworkSQLiteOpenHelperFactory()
    )

    @Test
    fun run_all_migrations() {
        migrationTestHelper.createDatabase(TEST_DB_NAME, 1).close()
        Room.databaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            DelishDataBase::class.java,
            TEST_DB_NAME
        ).addMigrations(*MIGRATIONS)
            .build()
            .apply {
                openHelper.writableDatabase
                close()
            }
    }
}
