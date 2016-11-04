package org.feiyu.myblog.admin.entity;/**
 * Created by feiyu on 2016/11/3.
 */

/**
 * @author feiyu
 * @version 1.0
 * @title: DictEntity
 * @description 数据字典实体类
 * @create 2016/11/3
 */
public class DictEntity {
    
    /**id**/
    private String id;
    
    /**类型**/
    private String dictType;
    
    /**值**/
    private String dictValue;

    /**字典数据名**/
    private String dictName;

    public DictEntity(){}

    public DictEntity(String id, String dictType, String dictValue, String dictName) {
        this.id = id;
        this.dictType = dictType;
        this.dictValue = dictValue;
        this.dictName = dictName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    @Override
    public String toString() {
        return "DictEntity{" +
                "id='" + id + '\'' +
                ", dictType='" + dictType + '\'' +
                ", dictValue='" + dictValue + '\'' +
                ", dictName='" + dictName + '\'' +
                '}';
    }
}
