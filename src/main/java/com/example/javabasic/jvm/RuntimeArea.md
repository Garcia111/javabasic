运行时数据区域

   1.程序计数器
        程序技术器是一块较小的内存空间，可以看做是当前线程所执行的字节码的行号指示器。
        字节码解释器工作时就是通过改变这个计数器的值来选取下一条需要执行的字节码指令，分支 循环 跳转 异常处理
        线程恢复等基础功能都需要依赖这个计数器来完成。
        
        由于Java虚拟机的多线程是通过线程轮流切换并分配处理器执行时间的方式来实现的，在任何一个确定的时刻，一个处理器
        （对于多核处理器来说是一个内核）都只会执行一条线程中的指令，因此，为了线程切换后能够恢复到正确的执行位置，每条
        线程都需要有一个独立的程序计数器，各条线程之间的计数器互不影响，独立存储，我们称这类内存区域为"线程私有"的内存 
        
        
        如果线程正在执行的是一个Java方法，这个计数器记录的是正在执行的虚拟机字节码指令的地址；
        如果正在执行的是Native方法，这个计数器的值则为空
        【此内存区域是唯一一个在Java的虚拟机规范中没有规定任何OutOfMemory情况的区域】
   
   2.Java虚拟机栈
        私有：与程序计数器一样，Java虚拟机栈也是线程私有的。
        生命周期：它的生命周期与线程相同；
        虚拟机栈描述的是Java方法执行的内存模型：每个方法在执行的同时都会创建一个栈，用于存储局部变量表 操作数栈 动态链接 方法出口等信息。
        每一个方法从调用直至执行完成的时间，就对应着一个栈在虚拟机中入栈到出栈的过程。
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        