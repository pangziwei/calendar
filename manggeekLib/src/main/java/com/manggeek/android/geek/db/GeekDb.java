package com.manggeek.android.geek.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.manggeek.android.geek.db.sqlite.CursorUtils;
import com.manggeek.android.geek.db.sqlite.DbModel;
import com.manggeek.android.geek.db.sqlite.ManyToOneLazyLoader;
import com.manggeek.android.geek.db.sqlite.OneToManyLazyLoader;
import com.manggeek.android.geek.db.sqlite.SqlBuilder;
import com.manggeek.android.geek.db.sqlite.SqlInfo;
import com.manggeek.android.geek.db.table.KeyValue;
import com.manggeek.android.geek.db.table.ManyToOne;
import com.manggeek.android.geek.db.table.OneToMany;
import com.manggeek.android.geek.db.table.TableInfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class GeekDb {

    private static final String TAG = "GeekDb";

    private static HashMap<String, GeekDb> daoMap = new HashMap<String, GeekDb>();

    private SQLiteDatabase db;
    private DaoConfig config;

    private GeekDb(DaoConfig config) {
        if (config == null)
            throw new DbException("daoConfig is null");
        if (config.getContext() == null)
            throw new DbException("android context is null");
        if (config.getTargetDirectory() != null && config.getTargetDirectory().trim().length() > 0) {
            this.db = createDbFileOnSDCard(config.getTargetDirectory(), config.getDbName());
        } else {
            this.db = new SqliteDbHelper(config.getContext().getApplicationContext(), config.getDbName(), config.getDbVersion(), config.getDbUpdateListener()).getWritableDatabase();
        }
        this.config = config;
    }

    private synchronized static GeekDb getInstance(DaoConfig daoConfig) {
        GeekDb dao = daoMap.get(daoConfig.getDbName());
        if (dao == null) {
            dao = new GeekDb(daoConfig);
            daoMap.put(daoConfig.getDbName(), dao);
        }
        return dao;
    }

    /**
     * ??????GeekDb
     * @param context
     */
    public static GeekDb create(Context context) {
        DaoConfig config = new DaoConfig();
        config.setContext(context);
        return create(config);
    }

    /**
     * ??????GeekDb
     * @param context
     * @param isDebug ?????????debug?????????debug????????????????????????????????????????????????sql?????????
     */
    public static GeekDb create(Context context, boolean isDebug) {
        DaoConfig config = new DaoConfig();
        config.setContext(context);
        config.setDebug(isDebug);
        return create(config);

    }

    /**
     * ??????GeekDb
     * @param context
     * @param dbName ???????????????
     */
    public static GeekDb create(Context context, String dbName) {
        DaoConfig config = new DaoConfig();
        config.setContext(context);
        config.setDbName(dbName);
        return create(config);
    }

    /**
     * ?????? GeekDb
     * @param context
     * @param dbName ???????????????
     * @param isDebug ?????????debug?????????debug????????????????????????????????????????????????sql?????????
     */
    public static GeekDb create(Context context, String dbName, boolean isDebug) {
        DaoConfig config = new DaoConfig();
        config.setContext(context);
        config.setDbName(dbName);
        config.setDebug(isDebug);
        return create(config);
    }

    /**
     * ??????GeekDb
     * @param context
     * @param dbName ???????????????
     */
    public static GeekDb create(Context context, String targetDirectory, String dbName) {
        DaoConfig config = new DaoConfig();
        config.setContext(context);
        config.setDbName(dbName);
        config.setTargetDirectory(targetDirectory);
        return create(config);
    }

    /**
     * ?????? GeekDb
     * @param context
     * @param dbName ???????????????
     * @param isDebug ?????????debug?????????debug????????????????????????????????????????????????sql?????????
     */
    public static GeekDb create(Context context, String targetDirectory, String dbName, boolean isDebug) {
        DaoConfig config = new DaoConfig();
        config.setContext(context);
        config.setTargetDirectory(targetDirectory);
        config.setDbName(dbName);
        config.setDebug(isDebug);
        return create(config);
    }

    /**
     * ?????? GeekDb
     * @param context ?????????
     * @param dbName ???????????????
     * @param isDebug ???????????????????????????????????????log???sql??????
     * @param dbVersion ?????????????????????
     * @param dbUpdateListener ?????????????????????????????????????????????null????????????????????????????????????????????????
     * @return
     */
    public static GeekDb create(Context context, String dbName, boolean isDebug, int dbVersion, DbUpdateListener dbUpdateListener) {
        DaoConfig config = new DaoConfig();
        config.setContext(context);
        config.setDbName(dbName);
        config.setDebug(isDebug);
        config.setDbVersion(dbVersion);
        config.setDbUpdateListener(dbUpdateListener);
        return create(config);
    }

    /**
     * @param context ?????????
     * @param targetDirectory db??????????????????????????????sdcard?????????
     * @param dbName ???????????????
     * @param isDebug ???????????????????????????????????????log???sql??????
     * @param dbVersion ?????????????????????
     * @param dbUpdateListener ???????????????????????? ?????????????????????null????????????????????????????????????????????????
     * @return
     */
    public static GeekDb create(Context context, String targetDirectory, String dbName, boolean isDebug, int dbVersion, DbUpdateListener dbUpdateListener) {
        DaoConfig config = new DaoConfig();
        config.setContext(context);
        config.setTargetDirectory(targetDirectory);
        config.setDbName(dbName);
        config.setDebug(isDebug);
        config.setDbVersion(dbVersion);
        config.setDbUpdateListener(dbUpdateListener);
        return create(config);
    }

    /**
     * ??????GeekDb
     * @param daoConfig
     * @return
     */
    public static GeekDb create(DaoConfig daoConfig) {
        return getInstance(daoConfig);
    }

    /**
     * ??????????????????????????????save???
     * @param entity
     */
    public void save(Object entity) {
        checkTableExist(entity.getClass());
        exeSqlInfo(SqlBuilder.buildInsertSql(entity));
    }

    /**
     * ????????????????????????<br />
     * <b>?????????</b><br />
     * ??????????????????entity???????????????????????????????????????????????????????????? ?????????????????????id??????
     * @param entity ??????????????????
     * @return ture??? ???????????? false:????????????
     */
    public boolean saveBindId(Object entity) {
        checkTableExist(entity.getClass());
        List<KeyValue> entityKvList = SqlBuilder.getSaveKeyValueListByEntity(entity);
        if (entityKvList != null && entityKvList.size() > 0) {
            TableInfo tf = TableInfo.get(entity.getClass());
            ContentValues cv = new ContentValues();
            insertContentValues(entityKvList, cv);
            Long id = db.insert(tf.getTableName(), null, cv);
            if (id == -1)
                return false;
            tf.getId().setValue(entity, id);
            return true;
        }
        return false;
    }

    /**
     * ???List<KeyValue>???????????????ContentValues
     * @param list
     * @param cv
     */
    private void insertContentValues(List<KeyValue> list, ContentValues cv) {
        if (list != null && cv != null) {
            for (KeyValue kv : list) {
                cv.put(kv.getKey(), kv.getValue().toString());
            }
        } else {
            Log.w(TAG, "insertContentValues: List<KeyValue> is empty or ContentValues is empty!");
        }

    }

    /**
     * ???????????? ?????????ID?????????????????????
     * @param entity
     */
    public void update(Object entity) {
        checkTableExist(entity.getClass());
        exeSqlInfo(SqlBuilder.getUpdateSqlAsSqlInfo(entity));
    }

    /**
     * ????????????????????????
     * @param entity
     * @param strWhere ???????????????????????????????????????????????????
     */
    public void update(Object entity, String strWhere) {
        checkTableExist(entity.getClass());
        exeSqlInfo(SqlBuilder.getUpdateSqlAsSqlInfo(entity, strWhere));
    }

    /**
     * ????????????
     * @param entity entity?????????????????????
     */
    public void delete(Object entity) {
        checkTableExist(entity.getClass());
        exeSqlInfo(SqlBuilder.buildDeleteSql(entity));
    }

    /**
     * ????????????????????????
     * @param clazz ?????????????????????
     * @param id ?????????
     */
    public void deleteById(Class<?> clazz, Object id) {
        checkTableExist(clazz);
        exeSqlInfo(SqlBuilder.buildDeleteSql(clazz, id));
    }

    /**
     * ????????????????????????
     * @param clazz
     * @param strWhere ????????????????????? ???????????????????????????
     */
    public void deleteByWhere(Class<?> clazz, String strWhere) {
        checkTableExist(clazz);
        String sql = SqlBuilder.buildDeleteSql(clazz, strWhere);
        debugSql(sql);
        db.execSQL(sql);
    }

    /**
     * ????????????????????????
     * @param clazz
     */
    public void deleteAll(Class<?> clazz) {
        checkTableExist(clazz);
        String sql = SqlBuilder.buildDeleteSql(clazz, null);
        debugSql(sql);
        db.execSQL(sql);
    }

    /**
     * ??????????????????
     * @param clazz
     */
    public void dropTable(Class<?> clazz) {
        checkTableExist(clazz);
        TableInfo table = TableInfo.get(clazz);
        String sql = "DROP TABLE " + table.getTableName();
        debugSql(sql);
        db.execSQL(sql);
    }

    /**
     * ?????????????????????
     */
    public void dropDb() {
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type ='table' AND name != 'sqlite_sequence'", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                db.execSQL("DROP TABLE " + cursor.getString(0));
            }
        }
        if (cursor != null) {
            cursor.close();
            cursor = null;
        }
    }

    private void exeSqlInfo(SqlInfo sqlInfo) {
        if (sqlInfo != null) {
            debugSql(sqlInfo.getSql());
            db.execSQL(sqlInfo.getSql(), sqlInfo.getBindArgsAsArray());
        } else {
            Log.e(TAG, "sava error:sqlInfo is null");
        }
    }

    /**
     * ????????????????????????????????????????????????????????????????????????????????????
     * @param id
     * @param clazz
     */
    public <T> T findById(Object id, Class<T> clazz) {
        checkTableExist(clazz);
        SqlInfo sqlInfo = SqlBuilder.getSelectSqlAsSqlInfo(clazz, id);
        if (sqlInfo != null) {
            debugSql(sqlInfo.getSql());
            Cursor cursor = db.rawQuery(sqlInfo.getSql(), sqlInfo.getBindArgsAsStringArray());
            try {
                if (cursor.moveToNext()) {
                    return CursorUtils.getEntity(cursor, clazz, this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                cursor.close();
            }
        }
        return null;
    }

    /**
     * ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
     * @param id
     * @param clazz
     */
    public <T> T findWithManyToOneById(Object id, Class<T> clazz) {
        checkTableExist(clazz);
        String sql = SqlBuilder.getSelectSQL(clazz, id);
        debugSql(sql);
        DbModel dbModel = findDbModelBySQL(sql);
        if (dbModel != null) {
            T entity = CursorUtils.dbModel2Entity(dbModel, clazz);
            return loadManyToOne(dbModel, entity, clazz);
        }

        return null;
    }

    /**
     * ?????????????????????????????????????????????????????????????????????findClass?????????????????????
     * @param id
     * @param clazz
     * @param findClass ???????????????
     */
    public <T> T findWithManyToOneById(Object id, Class<T> clazz, Class<?>... findClass) {
        checkTableExist(clazz);
        String sql = SqlBuilder.getSelectSQL(clazz, id);
        debugSql(sql);
        DbModel dbModel = findDbModelBySQL(sql);
        if (dbModel != null) {
            T entity = CursorUtils.dbModel2Entity(dbModel, clazz);
            return loadManyToOne(dbModel, entity, clazz, findClass);
        }
        return null;
    }

    /**
     * ???entity??????????????????????????????????????? ??????????????????????????????dbModel????????????null
     * @param clazz
     * @param entity
     * @param <T>
     * @return
     */
    public <T> T loadManyToOne(DbModel dbModel, T entity, Class<T> clazz, Class<?>... findClass) {
        if (entity != null) {
            try {
                Collection<ManyToOne> manys = TableInfo.get(clazz).manyToOneMap.values();
                for (ManyToOne many : manys) {

                    Object id = null;
                    if (dbModel != null) {
                        id = dbModel.get(many.getColumn());
                    } else if (many.getValue(entity).getClass() == ManyToOneLazyLoader.class && many.getValue(entity) != null) {
                        id = ((ManyToOneLazyLoader) many.getValue(entity)).getFieldValue();
                    }

                    if (id != null) {
                        boolean isFind = false;
                        if (findClass == null || findClass.length == 0) {
                            isFind = true;
                        }
                        for (Class<?> mClass : findClass) {
                            if (many.getManyClass() == mClass) {
                                isFind = true;
                                break;
                            }
                        }
                        if (isFind) {

                            @SuppressWarnings("unchecked")
                            T manyEntity = (T) findById(Integer.valueOf(id.toString()), many.getManyClass());
                            if (manyEntity != null) {
                                if (many.getValue(entity).getClass() == ManyToOneLazyLoader.class) {
                                    if (many.getValue(entity) == null) {
                                        many.setValue(entity, new ManyToOneLazyLoader(entity, clazz, many.getManyClass(), this));
                                    }
                                    ((ManyToOneLazyLoader) many.getValue(entity)).set(manyEntity);
                                } else {
                                    many.setValue(entity, manyEntity);
                                }

                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return entity;
    }

    /**
     * ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
     * @param id
     * @param clazz
     */
    public <T> T findWithOneToManyById(Object id, Class<T> clazz) {
        checkTableExist(clazz);
        String sql = SqlBuilder.getSelectSQL(clazz, id);
        debugSql(sql);
        DbModel dbModel = findDbModelBySQL(sql);
        if (dbModel != null) {
            T entity = CursorUtils.dbModel2Entity(dbModel, clazz);
            return loadOneToMany(entity, clazz);
        }

        return null;
    }

    /**
     * ?????????????????????????????????????????????????????????????????????findClass????????????????????????
     * @param id
     * @param clazz
     * @param findClass
     */
    public <T> T findWithOneToManyById(Object id, Class<T> clazz, Class<?>... findClass) {
        checkTableExist(clazz);
        String sql = SqlBuilder.getSelectSQL(clazz, id);
        debugSql(sql);
        DbModel dbModel = findDbModelBySQL(sql);
        if (dbModel != null) {
            T entity = CursorUtils.dbModel2Entity(dbModel, clazz);
            return loadOneToMany(entity, clazz, findClass);
        }

        return null;
    }

    /**
     * ???entity???????????????????????????????????????
     * @param entity
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T loadOneToMany(T entity, Class<T> clazz, Class<?>... findClass) {
        if (entity != null) {
            try {
                Collection<OneToMany> ones = TableInfo.get(clazz).oneToManyMap.values();
                Object id = TableInfo.get(clazz).getId().getValue(entity);
                for (OneToMany one : ones) {
                    boolean isFind = false;
                    if (findClass == null || findClass.length == 0) {
                        isFind = true;
                    }
                    for (Class<?> mClass : findClass) {
                        if (one.getOneClass() == mClass) {
                            isFind = true;
                            break;
                        }
                    }

                    if (isFind) {
                        List<?> list = findAllByWhere(one.getOneClass(), one.getColumn() + "=" + id);
                        if (list != null) {
                            /* ?????????OneToManyLazyLoader??????????????????????????????????????? */
                            if (one.getDataType() == OneToManyLazyLoader.class) {
                                OneToManyLazyLoader oneToManyLazyLoader = one.getValue(entity);
                                oneToManyLazyLoader.setList(list);
                            } else {
                                one.setValue(entity, list);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return entity;
    }

    /**
     * ?????????????????????
     * @param clazz
     */
    public <T> List<T> findAll(Class<T> clazz) {
        checkTableExist(clazz);
        return findAllBySql(clazz, SqlBuilder.getSelectSQL(clazz));
    }

    /**
     * ??????????????????
     * @param clazz
     * @param orderBy ???????????????
     */
    public <T> List<T> findAll(Class<T> clazz, String orderBy) {
        checkTableExist(clazz);
        return findAllBySql(clazz, SqlBuilder.getSelectSQL(clazz) + " ORDER BY " + orderBy);
    }

    /**
     * ??????????????????????????????
     * @param clazz
     * @param strWhere ???????????????????????????????????????
     */
    public <T> List<T> findAllByWhere(Class<T> clazz, String strWhere) {
        checkTableExist(clazz);
        return findAllBySql(clazz, SqlBuilder.getSelectSQLByWhere(clazz, strWhere));
    }

    /**
     * ??????????????????????????????
     * @param clazz
     * @param strWhere ???????????????????????????????????????
     * @param orderBy ????????????
     */
    public <T> List<T> findAllByWhere(Class<T> clazz, String strWhere, String orderBy) {
        checkTableExist(clazz);
        return findAllBySql(clazz, SqlBuilder.getSelectSQLByWhere(clazz, strWhere) + " ORDER BY " + orderBy);
    }

    /**
     * ??????????????????????????????
     * @param clazz
     * @param strSQL
     */
    private <T> List<T> findAllBySql(Class<T> clazz, String strSQL) {
        checkTableExist(clazz);
        debugSql(strSQL);
        Cursor cursor = db.rawQuery(strSQL, null);
        try {
            List<T> list = new ArrayList<T>();
            while (cursor.moveToNext()) {
                T t = CursorUtils.getEntity(cursor, clazz, this);
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
            cursor = null;
        }
        return null;
    }

    /**
     * ??????sql???????????????????????????????????????????????????
     * @param strSQL
     */
    public DbModel findDbModelBySQL(String strSQL) {
        debugSql(strSQL);
        Cursor cursor = db.rawQuery(strSQL, null);
        try {
            if (cursor.moveToNext()) {
                return CursorUtils.getDbModel(cursor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        return null;
    }

    public List<DbModel> findDbModelListBySQL(String strSQL) {
        debugSql(strSQL);
        Cursor cursor = db.rawQuery(strSQL, null);
        List<DbModel> dbModelList = new ArrayList<DbModel>();
        try {
            while (cursor.moveToNext()) {
                dbModelList.add(CursorUtils.getDbModel(cursor));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        return dbModelList;
    }

    private void checkTableExist(Class<?> clazz) {
        if (!tableIsExist(TableInfo.get(clazz))) {
            String sql = SqlBuilder.getCreatTableSQL(clazz);
            debugSql(sql);
            db.execSQL(sql);
        }
    }

    private boolean tableIsExist(TableInfo table) {
        if (table.isCheckDatabese())
            return true;

        Cursor cursor = null;
        try {
            String sql = "SELECT COUNT(*) AS c FROM sqlite_master WHERE type ='table' AND name ='" + table.getTableName() + "' ";
            debugSql(sql);
            cursor = db.rawQuery(sql, null);
            if (cursor != null && cursor.moveToNext()) {
                int count = cursor.getInt(0);
                if (count > 0) {
                    table.setCheckDatabese(true);
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
            cursor = null;
        }

        return false;
    }

    private void debugSql(String sql) {
        if (config != null && config.isDebug())
            Log.d("Debug SQL", ">>>>>>  " + sql);
    }

    public static class DaoConfig {
        private Context mContext = null; // android?????????
        private String mDbName = "afinal.db"; // ???????????????
        private int dbVersion = 1; // ???????????????
        private boolean debug = true; // ???????????????????????????????????? ???????????????????????????SQL?????????
        private DbUpdateListener dbUpdateListener;
        // private boolean saveOnSDCard = false;//???????????????SD???
        private String targetDirectory;// ??????????????????sd???????????????

        public Context getContext() {
            return mContext;
        }

        public void setContext(Context context) {
            this.mContext = context;
        }

        public String getDbName() {
            return mDbName;
        }

        public void setDbName(String dbName) {
            this.mDbName = dbName;
        }

        public int getDbVersion() {
            return dbVersion;
        }

        public void setDbVersion(int dbVersion) {
            this.dbVersion = dbVersion;
        }

        public boolean isDebug() {
            return debug;
        }

        public void setDebug(boolean debug) {
            this.debug = debug;
        }

        public DbUpdateListener getDbUpdateListener() {
            return dbUpdateListener;
        }

        public void setDbUpdateListener(DbUpdateListener dbUpdateListener) {
            this.dbUpdateListener = dbUpdateListener;
        }


        public String getTargetDirectory() {
            return targetDirectory;
        }

        public void setTargetDirectory(String targetDirectory) {
            this.targetDirectory = targetDirectory;
        }
    }

    /**
     * ???SD?????????????????????????????????
     * @param sdcardPath
     * @param dbfilename
     * @return
     */
    private SQLiteDatabase createDbFileOnSDCard(String sdcardPath, String dbfilename) {
        File dbf = new File(sdcardPath, dbfilename);
        if (!dbf.exists()) {
            try {
                if (dbf.createNewFile()) {
                    return SQLiteDatabase.openOrCreateDatabase(dbf, null);
                }
            } catch (IOException ioex) {
                throw new DbException("???????????????????????????", ioex);
            }
        } else {
            return SQLiteDatabase.openOrCreateDatabase(dbf, null);
        }

        return null;
    }

    class SqliteDbHelper extends SQLiteOpenHelper {

        private DbUpdateListener mDbUpdateListener;

        public SqliteDbHelper(Context context, String name, int version, DbUpdateListener dbUpdateListener) {
            super(context, name, null, version);
            this.mDbUpdateListener = dbUpdateListener;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (mDbUpdateListener != null) {
                mDbUpdateListener.onUpgrade(db, oldVersion, newVersion);
            } else { // ???????????????????????????
                dropDb();
            }
        }

    }

    public interface DbUpdateListener {
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
    }

}
