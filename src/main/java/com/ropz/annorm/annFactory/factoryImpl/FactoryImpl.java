package com.ropz.annorm.annFactory.factoryImpl;

import com.ropz.annorm.annFactory.AnnFactory;
import com.ropz.annorm.annotation.Constraints;
import com.ropz.annorm.annotation.TableColumn;
import com.ropz.annorm.annotation.TableName;

import java.lang.reflect.Field;
import java.util.Optional;

/**
 * @author ropz
 */
@SuppressWarnings("all")
public class FactoryImpl implements AnnFactory {
    @Override
    public void createTable(Object entity) {
        //获取StringBuilder对线，因为不考虑线程同步，用StringBuiler最快
        StringBuilder strb = new StringBuilder();
        //解析TableName注解
        TableName tableName = entity.getClass().getAnnotation(TableName.class);
        //判断是否为空
        Optional.of(tableName).map(TableName::name).ifPresent(s -> {
            strb.append("CREATE TABLE " + tableName.name() + "(\n");
        });
        //Field获取反射对线，getDeclaredFields()获取被所有关键字修饰的对线
        for (Field field : entity.getClass().getDeclaredFields()) {
            //循环把每个变量的注解都给解析
            TableColumn tc = field.getAnnotation(TableColumn.class);
            if (tc != null) {
                strb.append(tc.columnName() + " ");
                strb.append(tc.columnType() + "(" + tc.size() + ")");
            }
            //同上，解析字段关键字的注解
            Constraints con = field.getAnnotation(Constraints.class);
            if (con != null) {
                if (con.primary()) {
                    strb.append(" PRIMARY KEY");
                } else if (con.allowNull()) {
                    strb.append(" NOT NULL");
                }
                if (con.isUnique()) {
                    strb.append(" UNIQUE");
                }
            }
            //每次循环之后添加逗号和回车
            strb.append(",\n");
        }
        //删除最后一个逗号
        strb.delete(strb.lastIndexOf(",\n"), strb.lastIndexOf(",\n") + ",\n".length());
        //strb.deleteCharAt(strb.lastIndexOf(","));
        //添加右括号
        strb.append("\n)");
        System.out.println(new String(strb));
    }
}
