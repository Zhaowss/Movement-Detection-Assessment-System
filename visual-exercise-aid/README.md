# 视觉训练辅助系统说明文档

## 系统安装

1. 创建数据库：
导入`sql`目录下的`visual_exercise_aid.sql`文件，新建`MySQL`数据库`visual_exercise_aid`。
2. 运行项目：
- 导入项目至`IDEA`，等待`Maven`自动导入项目所需的依赖，在`src/main/resources`目录下修改`application.yml`配置文件中的数据源部分，修改`spring: datasource: url: username: password:`这三个部分分别为服务器数据库地址和账户密码，在`src/main/resources/static/layuimini/js/lay-module/common`目录下修改`common.js`文件，修改`api_uri`为服务器地址。
- 直接运行`VisualExerciseAidApplication.java`启动器文件。
- 或者终端输入命令`java -jar visual-exercise-aid-0.0.1-SNAPSHOT.jar`直接运行`jar`目录下的`visual-exercise-aid-0.0.1-SNAPSHOT.jar`。

## 系统部署

1. 连接到云服务器并上传`jar`包。
2. 终端输入命令`nohup java -jar visual-exercise-aid-0.0.1-SNAPSHOT.jar &`。
3. 停止系统`CTRL+C`。
4. 常用命令：
- `ps aux|grep "java"`
- `kill 11740`

## 系统访问

1. 本地部署访问：http://127.0.0.1:9999/
2. 云端部署访问：http://62.234.56.107:9999/
3. 项目测试用户名/密码：
- 客户：`user/user`
- 管理员：`admin/admin`