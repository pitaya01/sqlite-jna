package org.sqlite;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfigTest {
  @Ignore("fails on Travis")
  @Test
  public void testThreadingMode() {
    assertEquals(SQLite.SQLITE_OK, SQLite.sqlite3_config(SQLite.SQLITE_CONFIG_SINGLETHREAD));
    assertEquals(SQLite.SQLITE_OK, SQLite.sqlite3_config(SQLite.SQLITE_CONFIG_MULTITHREAD));
    assertEquals(SQLite.SQLITE_OK, SQLite.sqlite3_config(SQLite.SQLITE_CONFIG_SERIALIZED));
  }

  @Ignore("fails on Travis")
  @Test
  public void testURIHandling() {
    assertEquals(SQLite.SQLITE_OK, SQLite.sqlite3_config(SQLite.SQLITE_CONFIG_URI, false));
    assertEquals(SQLite.SQLITE_OK, SQLite.sqlite3_config(SQLite.SQLITE_CONFIG_URI, true));
  }

  @Ignore("fails on Travis")
  @Test
  public void testMemoryStatus() {
    assertEquals(SQLite.SQLITE_OK, SQLite.sqlite3_config(SQLite.SQLITE_CONFIG_MEMSTATUS, false));
  }

  @Test
  public void testLog() {
    /*int rv = SQLite.sqlite3_config(SQLite.SQLITE_CONFIG_LOG, new SQLite.LogCallback() {
      @Override
      public void invoke(Pointer udp, int err, String msg) {
        System.out.printf("%d: %s\n", err, msg);
      }
    }, null);
    assertEquals(SQLite.SQLITE_OK, rv);*/
    SQLite.sqlite3_log(-1, "testLog");
    /*rv = SQLite.sqlite3_config(SQLite.SQLITE_CONFIG_LOG, null, null);
    assertEquals(SQLite.SQLITE_OK, rv);*/
  }
}
