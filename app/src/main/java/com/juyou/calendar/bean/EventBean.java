package com.juyou.calendar.bean;

import android.content.ContentValues;

/**
 *@desc  eventBus
*/
public class EventBean {

    public static final String TYPE = "type";

    /**
     * 接收方Class
     */
    private String mClass;

    public Object obj;

    private ContentValues values;

    /**
     * 是否发送到所有Activity
     */
    private boolean sendAll = false;

    public boolean isSendAll() {
        return sendAll;
    }

    public void setSendAll(boolean sendAll) {
        this.sendAll = sendAll;
    }

    public EventBean(Class mCls, ContentValues values) {
        if(mCls!=null) {
            this.mClass = mCls.getName();
        }
        this.values = values;
        sendAll = mCls==null;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(Class mCls) {
        this.mClass = mCls.getName();
    }

    public ContentValues getValues() {
        return values;
    }

    public void setValues(ContentValues values) {
        this.values = values;
    }
}
