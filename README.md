#用例
李A 男 35 30 0 是 
李B 男 36 30 0 否 男性_年龄_加_贷款年限_不能超过65 
李C 女 35 26 0 否 女性_年龄_加_贷款年限_不能超过60  
李D 男 30 31 0 否 住房贷款年限最长为30年 
李E 男 30 30 10 是 
李F 男 30 30 11 否 贷款年限加上房龄总和不能超过40年 
李E 男 30 30 10 是 

最大贷款年限计算
李A 男 35 30 0 是 65-35=25
李B 男 35 20 20 是 40-20=20
李C 女 35 26 0 否 60-35=25 40-26=14 ==14
李D 女 45 20 20 是 60-45=15 40-20=20 ==15
李F 男 30 30 11 否 贷款年限加上房龄总和不能超过40年 

# Server

## 本地环境安装

- Java JDK 1.8
- IntelliJ IDEA
- Docker
- Maven

### 技术栈

- Java
- Springboot
- MyBatis (MyBatis-Plus)
- Junit4
- JMockit
- h2
- Assertj
- flywaydb

## 测试

- 接口测试 使用 MockMvc 测试
- 单元测试 使用 JUnit4 + JMockito + AssertJ

## 命令行操作

#### 1、运行测试

* 运行测试

```shell
mvn clean test
```

#### 2、本地运行项目

* 本地启动MySQL和数据库查看工具

```shell
docker-compose -f env/local/docker-compose.yml up
```

* 运行项目

```shell
mvn clean install
mvn spring-boot:run
 ```

#### 数据初始化脚本

地址

```text
./env/init.sql
```


