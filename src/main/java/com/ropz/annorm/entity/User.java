package com.ropz.annorm.entity;

import com.ropz.annorm.annotation.Constraints;
import com.ropz.annorm.annotation.TableColumn;
import com.ropz.annorm.annotation.TableName;
import com.ropz.annorm.eumBean.ColumnType;
import lombok.Data;

/**
 * @author ropz
 */
@Data
@TableName(name = "My_User")
public class User {
    @TableColumn(columnName = "id", columnType = ColumnType.INT, size = 10)
    @Constraints(primary = true)
    private int id;
    @TableColumn(columnName = "name", columnType = ColumnType.VARCHAR, size = 1024)
    @Constraints(isUnique = true)
    private String name;
    @TableColumn(columnName = "age", columnType = ColumnType.INT, size = 10)
    private int age;
}
