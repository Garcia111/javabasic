nigix中的linux基础知识

1.版本

查看内核版本： cat /proc/version
--免费的，负责控制硬件、管理文件系统、程序进程等

查看发行版本：cat /etc/redhat-release
--不一定免费，C/C++编译器、C/C++库、系统管理工具、网络工具、办公软件、多媒体软件、绘图软件等


2.用户/权限组
    Linux用户一般分为3种：
    1)超级用户 root UID = 0
    2)普通用户 UID = 500~60000
    3)伪用户 UID = 1~499  伪用户是为满足文件或者程序运行时的需要而创建的，不能登录，不能使用


3.文件--权限

4.安装软件

5.shell脚本



【组相关命令】
1.cat命令读取一个文件  cat /etc/group 查看系统组设置
2.创建组命令：  groupadd  组名称
3.删除组命令： groupdel 组名称
4.修改组命令： groupmod -g 修改后的组id -n 修改后的组名称 原来的组名称
5.组的格式 www:*:80  其中组的名称为www,组的id号为80


【用户相关命令】
1.cat /etc/passwd
2. 用户格式：wqzskaifa0220:x:514:514::/home/wqzskaifa0220:/bin/bash
           第一列：用户名
           第二列：密码位
           第三列：UID号 用户id
           第四列：GID号 主组和辅助组
           第五列：用户全名或注释（当前例子中为空）
           第六列：用户的home目录
           第七列：用户默认的shell类型
3. 创建用户命令
        useradd -d 新建用户所处的目录 -m(指的是如果不存在当前目录则进行创建) 用户名称
        每创建一个用户，需要为这个用户指定密码，否则不能登录成功
4. 删除用户命令
        userdel 用户名称


【用户密码相关命令】
5. 指定用户密码
        passwd 用户名

6. 将某个用户的密码置空
        passwd -d 用户名

7. 密码锁定
        passwd -l 用户名
        对当前用户锁定之后，用户不再能登录


如果对某个设置的命令不太清楚可以直接百度或者在linux中使用 man 相关关键字 例如 man passwd  会显示与密码相关的命令



【LINUX文件和目录管理】
    文件相关属性意义
    文件示例：-rw-rw-r-- 1 inds inds        0 5月  31 2019 error.log
    第0位确定文件类型，如果有字母d标识，表名是目录，否则为文件；

    一个文件的使用者有3类：属主，一个组，其他的所有用户
    第1-3位：确定属主（该文件的所有者）拥有该文件的权限,r-读；w-写; x-执行
    第4-6位：确定属组（所有者的同组用户）拥有该文件的权限
    第7-9位：确定其他用户拥有该文件的权限

    其中第1、4、7位表示读权限；第2、5、8位表示写权限；第3、6、9位表示可执行权限，
    如果没有权限，则使用-字符表示

    第一个inds---文件的属主；
    第二个inds---文件的数组；

    后面的日期则是文件的创建时间；
    最后面是文件的名字。


1.创建文件命令
    touch 文件名 ---在当前目录下创建文件

2.删除文件命令
    rm 文件名

3.对某个文件的执行权限命令
    chmod +x 文件名称
    也可以使用 chmod 二进制值 文件名称来指定权限

4.将字符串写入某个文件命令
    echo "123" > b

5. 硬链接与软链接
    1)创建硬链接
    ln 文件名1 文件名2
    文件名1 与 文件名2 对应的文件为同一个文件
    当要删除一个文件时，不只要删除文件名1指向文件的引用， 也要删除文件名2指向文件的引用，才能将文件删除

    类似于 String s1 = new String("123");
          String s2 = s1;
          想要在磁盘上删除字符串123，需要将所有指向其的引用进行删除，你需要将s1赋值为null,也需要将s2赋值为null

    2)创建软链接
    ln -s 文件名1 文件名2
    此时类似于文件名2的引用指向文件名1,也就是文件名2是文件名1的一个快捷方式，
    当要删除一个文件时，只要删除一个即可

    例如 ln -s b c
    此时c的引用是指向b的，只要执行rm b，c指向b的软链接依然存在只不过失效了

【Linux rpm安装程序】
1.RPM包命名原则

    rpm -ivh jdk-8u221-linux-x64.rpm

2.查询安装软件的版本

    实例：查询安装的jdk版本
    rpm -qa|grep jdk

3.卸载软件命令

    rpm -e 卸载的软件的全称
    示例：rpm -e jdk1.8-1.8.0_221-fcs.x86_64



【yum命令】
yum提供了查找、安装、删除某一个、一组甚至全部软件包的命令。yum是在rpm的基础上继续封装出来的软件操作命令。
yum语法：
yum [options] [command] [packge_name]

options:可选，选项包括 -y(当安装过程提示选择全部为yes) -q(不显示安装的过程)等等


1.仅安装指定的软件命令
  yum install <package_name>

2.查找软件包的命令
   yum search <package_name>

3.查找已经安装的软件
   示例：查找已经安装的jdk软件 yum list installed |grep jdk

4.删除已经安装的软件
   yum remove <package_name>



【使用yum命令最好进行下如下配置：】配置完成之后，使用yum命令的速度就会快很多
1.cd /etc/yum.repos.d
2. yum文件的库文件以CentOS-Base.repo中记录的地址为准，也就是yum服务器的搜索地址
3. wget 163的版本路径   163的版本路径为：http://mirrors.163.com/.help/CentOS-Base-163.repo即可，然后将名字改为CentOS-Base.repo
4. 然后清理缓存即可，使用命令yum clean 和 yum clean all：



【YUM缓存】
    1.清除缓存目录(/var/cache/yum)下的软件包命令：yum clean packages
    2.清除缓存目录(/var/cache/yum)下的 headers命令：yum clean headers
    3.清除缓存目录(/var/cache/yum)下旧的 headers命令：yum clean oldheaders
    4.清除缓存目录(/var/cache/yum)下的软件包及旧的headers命令：yum clean, yum clean all



上传文件命令 rz
下载文件命令 sz


【Linux Shell】
Linux的Shell种类众多，常见的有：
1.Bourne Shell(/usr/bin/sh或 /bin/sh)
2.Bourne Again Shell(/bin/bash)
3.C Shell(/usr/bin/csh)
4.K Shell(/usr/bin/ksh)
5.Shell for Root(/sbin/sh)

Bash在日常工作中被广泛使用，也是大多数Linux系统默认的shell
Bash和sh一般是兼容的，声明 #!/bin/sh 改为 #!/bin/bash 一般也ok


cd ~ :进入root命令的主目录