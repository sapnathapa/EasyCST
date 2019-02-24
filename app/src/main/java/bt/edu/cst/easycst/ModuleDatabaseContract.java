package bt.edu.cst.easycst;

import android.provider.BaseColumns;

/**
 * Created by Tek Nath Acharya nathtek136@gmail.com
 * for Easy CST app
 */
public final class ModuleDatabaseContract {
    private ModuleDatabaseContract() {
    }

    public static class ModuleDatabase implements BaseColumns {
        public static final String TABLE_NAME = "module_details";
        public static final String COLUMN_NAME_COL1 = "code";
        public static final String COLUMN_NAME_COL2 = "name";
        public static final String COLUMN_NAME_COL3 = "tutor";
        public static final String COLUMN_NAME_COL4 = "attendance";
    }
}
