# expandSql

- [项目简介](#项目简介)
- [环境依赖](#环境依赖)
- [安装](#安装)
- [帮助文档](#帮助文档)
    - [SqlCBuilder](#SqlCBuilder)
    - [SqlRBuilder](#SqlRBuilder)
    - [SqlUBuilder](#SqlUBuilder)
    - [SqlDBuilder](#SqlDBuilder)
- [主要项目负责人](#主要项目负责人)
- [开源协议](#开源协议)

## 项目简介

像写SQL语句一样使用Java语言编写动态SQL。

## 环境依赖

使用JDK-1.8.0_151版本编译，使用MySQL-5.5.27版本。

## 安装

使用Git把源码荡下来。

```git
$ git clone https://github.com/snowflake-tu/expandSql.git
```

编译源码，找到expandBoot-1.0.0-RELEASE.jar文件，发布到Maven本地仓库。

```mvn
mvn install:install-file -Dfile=绝对路径\expandBoot-1.0.0-RELEASE.jar -DgroupId=cn.eck2016 -DartifactId=expandSql -Dversion=1.0.0-RELEASE -Dpackaging=jar
```

## 帮助文档

成功发布到Maven本地仓库后，在开发项目的pom.xml文件中添加依赖。

``` xml
<dependency>
    <groupId>cn.eck2016</groupId>
    <artifactId>expandSql</artifactId>
    <version>1.0.0-RELEASE</version>
</dependency>
```

示例数据表结构。

```mysql
-- 切换到test数据库
USE test;
-- 创建t_expand表
CREATE TABLE `t_expand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uuid` char(32) NOT NULL COMMENT 'uuid',
  `s_name` varchar(32) NOT NULL COMMENT '名称',
  `s_info` varchar(150) NOT NULL COMMENT '信息',
  `data_state` varchar(32) DEFAULT NULL COMMENT '数据状态',
  `data_version` int(11) DEFAULT NULL COMMENT '数据版本',
  `create_by` char(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '最后更新者',
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `data_desc` varchar(255) DEFAULT NULL COMMENT '备注',
  `attribute1` varchar(32) DEFAULT NULL COMMENT '扩展字段1',
  `attribute2` varchar(32) DEFAULT NULL COMMENT '扩展字段2',
  `attribute3` varchar(32) DEFAULT NULL COMMENT '扩展字段3',
  `attribute4` varchar(32) DEFAULT NULL COMMENT '扩展字段4',
  `attribute5` varchar(32) DEFAULT NULL COMMENT '扩展字段5',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

> ### SqlCBuilder

```java
Table tbExpand = Table.define("test.t_expand", "tExpand");
SqlCBuilder sqlCBuilder = SqlCBuilder.baseTable(tbExpand)
        .insert("uuid", UuidUtil.generateUUID())
        .insert("s_name", "1")
        .insert("s_info", "1")
        .insert("data_state", "create")
        .insert("data_version", 1)
        .insert("create_by", "author")
        .insert("create_time", SqlFunction.NOW)
        .insertSplit();
System.out.println(sqlCBuilder.buildSql());
```
```mysql
INSERT INTO test.t_expand (
	uuid,
	s_name,
	s_info,
	data_state,
	data_version,
	create_by,
	create_time
)
VALUES
	(
		'57dd69eec28b4a00856c8e5556b30da1',
		'1',
		'1',
		'create',
		1,
		'author',
		NOW()
	)
```

> ### SqlRBuilder

```java
Table tbExpand = Table.define("test.t_expand", "tbExpand");
SqlRBuilder sqlRBuilder = SqlRBuilder.baseTable(tbExpand)
        .select(
                tbExpand.column("id", "uuid", "s_name", "s_info")
        ).where(() -> {
            IgnoreItemWhere exp1 = tbExpand.field("id").eq(1);
            IgnoreItemWhere exp2 = tbExpand.field("uuid").eq("1");
            IgnoreItemWhere exp3 = tbExpand.field("s_name").eq("1");
            IgnoreItemWhere exp4 = tbExpand.field("s_info").eq("1");
            return Sql.or(exp1, exp2, exp3, exp4);
        });
System.out.println(sqlRBuilder.buildSql());
```
```mysql
SELECT
	tbExpand.id,
	tbExpand.uuid,
	tbExpand.s_name,
	tbExpand.s_info
FROM
	test.t_expand AS tbExpand
WHERE
	(
		tbExpand.id = 1
		OR tbExpand.uuid = '1'
		OR tbExpand.s_name = '1'
		OR tbExpand.s_info = '1'
	)
```

> ### SqlUBuilder

```java
Table tbExpand = Table.define("test.t_expand", "tbExpand");
SqlUBuilder sqlUBuilder = SqlUBuilder.baseTable(tbExpand)
        .update(
                tbExpand.field("s_name").setValue("1"),
                tbExpand.field("s_info").setValue("1"),
                tbExpand.field("data_state").setValue("update"),
                tbExpand.field("data_version").setValue(tbExpand.function("$.data_version + 1")),
                tbExpand.field("update_by").setValue("author"),
                tbExpand.field("update_time").setValue(SqlFunction.NOW)
        )
        .where(() -> {
            IgnoreItemWhere exp1 = tbExpand.field("id").eq(1);
            IgnoreItemWhere exp2 = tbExpand.field("uuid").eq("1");
            IgnoreItemWhere exp3 = tbExpand.field("s_name").eq("1");
            IgnoreItemWhere exp4 = tbExpand.field("s_info").eq("1");
            return Sql.or(exp1, exp2, exp3, exp4);
        });
System.out.println(sqlUBuilder.buildSql());
```

```mysql
UPDATE test.t_expand AS tbExpand
SET tbExpand.s_name = '1',
 tbExpand.s_info = '1',
 tbExpand.data_state = 'update',
 tbExpand.data_version = tbExpand.data_version + 1,
 tbExpand.update_by = 'author',
 tbExpand.update_time = NOW()
WHERE
	(
		tbExpand.id = 1
		OR tbExpand.uuid = '1'
		OR tbExpand.s_name = '1'
		OR tbExpand.s_info = '1'
	)
```

> ### SqlDBuilder

```java
Table tbExpand = Table.define("test.t_expand", "tbExpand");
SqlDBuilder sqlDBuilder = SqlDBuilder.baseTable(tbExpand)
        .delete(tbExpand)
        .where(() -> {
            IgnoreItemWhere exp1 = tbExpand.field("id").eq(1);
            IgnoreItemWhere exp2 = tbExpand.field("uuid").eq("1");
            IgnoreItemWhere exp3 = tbExpand.field("s_name").eq("1");
            IgnoreItemWhere exp4 = tbExpand.field("s_info").eq("1");
            return Sql.or(exp1, exp2, exp3, exp4);
        });
System.out.println(sqlDBuilder.buildSql());
```

```mysql
DELETE tbExpand
FROM
	test.t_expand AS tbExpand
WHERE
	(
		tbExpand.id = 1
		OR tbExpand.uuid = '1'
		OR tbExpand.s_name = '1'
		OR tbExpand.s_info = '1'
	)
```

## 主要项目负责人

[@snowflake-tu](https://github.com/snowflake-tu)

## 开源协议

The project is licensed under the Apache 2.0 License.[More Information](LICENSE)
