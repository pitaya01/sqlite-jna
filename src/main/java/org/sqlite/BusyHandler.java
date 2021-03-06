package org.sqlite;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * Callback to handle SQLITE_BUSY errors
 *
 * @see Conn#setBusyHandler(BusyHandler)
 * @see <a href="http://sqlite.org/c3ref/busy_handler.html">sqlite3_busy_handler</a>
 */
@FunctionalInterface
public interface BusyHandler extends Callback {
	/**
	 * @param pArg  User data (<code>null</code>)
	 * @param count the number of times that the busy handler has been invoked previously for the same locking event.
	 * @return <code>true</code> to try again, <code>false</code> to abort.
	 */
	default boolean callback(Pointer pArg, int count) {
		return busy(count);
	}

	/**
	 * @param count the number of times that the busy handler has been invoked previously for the same locking event.
	 * @return <code>true</code> to try again, <code>false</code> to abort.
	 */
	boolean busy(int count);
}
