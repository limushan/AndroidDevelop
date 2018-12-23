package greendao.develop.android.multi.table.bean.two;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import greendao.develop.android.multi.table.bean.one.DaoSession;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TWO_CLASS_BEAN".
*/
public class TwoClassBeanDao extends AbstractDao<TwoClassBean, Long> {

    public static final String TABLENAME = "TWO_CLASS_BEAN";

    /**
     * Properties of entity TwoClassBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property ClassId = new Property(0, long.class, "classId", false, "CLASS_ID");
        public final static Property Id = new Property(1, long.class, "id", true, "_id");
        public final static Property ClassName = new Property(2, String.class, "className", false, "CLASS_NAME");
    }

    private Query<TwoClassBean> schoolBean_ClassBeenQuery;

    public TwoClassBeanDao(DaoConfig config) {
        super(config);
    }
    
    public TwoClassBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TWO_CLASS_BEAN\" (" + //
                "\"CLASS_ID\" INTEGER NOT NULL ," + // 0: classId
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 1: id
                "\"CLASS_NAME\" TEXT NOT NULL );"); // 2: className
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TWO_CLASS_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TwoClassBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getClassId());
        stmt.bindLong(2, entity.getId());
        stmt.bindString(3, entity.getClassName());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TwoClassBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getClassId());
        stmt.bindLong(2, entity.getId());
        stmt.bindString(3, entity.getClassName());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 1);
    }    

    @Override
    public TwoClassBean readEntity(Cursor cursor, int offset) {
        TwoClassBean entity = new TwoClassBean( //
            cursor.getLong(offset + 0), // classId
            cursor.getLong(offset + 1), // id
            cursor.getString(offset + 2) // className
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TwoClassBean entity, int offset) {
        entity.setClassId(cursor.getLong(offset + 0));
        entity.setId(cursor.getLong(offset + 1));
        entity.setClassName(cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TwoClassBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TwoClassBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TwoClassBean entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "classBeen" to-many relationship of SchoolBean. */
    public List<TwoClassBean> _querySchoolBean_ClassBeen(long classId) {
        synchronized (this) {
            if (schoolBean_ClassBeenQuery == null) {
                QueryBuilder<TwoClassBean> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ClassId.eq(null));
                schoolBean_ClassBeenQuery = queryBuilder.build();
            }
        }
        Query<TwoClassBean> query = schoolBean_ClassBeenQuery.forCurrentThread();
        query.setParameter(0, classId);
        return query.list();
    }

}
