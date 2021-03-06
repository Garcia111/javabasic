内部类
    可以将一个类的定义放在另一个类的定义内部
 1.内部类自动拥有对其外围类所有成员的访问权，这是如何做到的呢？
    【**当某个外围类的对象创建了一个内部类对象时，此内部类对象必定会秘密地捕获一个指向那个外围类对象的引用。**】
    然后，在访问此外围类的成员时，就是那个引用来选择外围类的成员。编译器会处理所有所有细节，
    内部类的对象只能在与其外围类的对象相关联的情况下才能被创建。


 2.如果需要生成对外部类对象的引用，可以使用外部类的名字.this。
    这样产生的引用自动地具有正确的类型，这一点在编译器就被知晓并受到检查，因此没有任何运行时开销。

 3.在外部类中创建内部类的对象，需要使用外部类对象的引用.new 内部类对象名称()
   创建内部类的对象，必须使用外部类的对象，
   **在拥有外部类对象之前是不可能创建内部类对象的，这是因为内部类对象会暗暗地连接到创建它的外部类对象上。但是，如果你
   创建的是静态内部类，它就不需要对外部类对象的引用。**

 4.内部类型与向上转型
    当将实现了某个接口或者继承了某个基类的private内部类，向上转型为一个接口，或者向上转型为基类的对象后，
    这个private内部类就能够变得完全不可见，并且不可用，其他类能够得到的只是指向基类或者接口的引用，所以能够很方便
    地隐藏实现细节。

 5.在方法和作用域内的内部类
    可以在一个方法里面或者在任意的作用域内定义内部类。
        在方法内部定义的内部类，是方法的一部分，在方法外部不能访问该内部类。
        在方法的局部范围定义一个内部类，如if语句中，则在if语句外不能访问该内部类。

    1）如果定义一个匿名内部类，并且希望它使用一个在其外部定义的对象，那么编译器会要求其参数引用是final的。
    public Destination destination(final String dest){
            return new Destination() {

                private String label = dest;

                @Override
                public String readLabel() {
                    return label;
                }
            };
        }


    2）如果变量是被传递给匿名类的基类的构造器，并不会在匿名类内部被直接使用时，参数不必用final修饰
    public static Base getBase(int i){
            return new Base(i) {

                { System.out.println("Inside instance initializer"); }

                @Override
                public void f() {
                    System.out.println("In anoymous f()");
                }
            };
        }
        匿名内部类与正规的继承相比有些受限，因为匿名内部类既可以扩展类，也可以实现接口，但是不能两者兼备。而且如果是实现
        接口，也只能实现一个接口。


 6.嵌套类
    使用static关键字修饰的静态内部类称为嵌套类，此时内部类对象与外围类对象之间没有联系。
    普通的内部类对象隐式地保存了一个引用，指向创建它的外围类对象，当内部类是static时：
    （1）要创建嵌套类的对象，并不需要其外围类的对象；
    （2）**不能从嵌套类的对象中访问非静态的外围类对象**

    普通的内部类不能有static数据和static字段，也不能包含嵌套类，但是嵌套类可以包含

   接口内部的类
    嵌套类可以作为接口的一部分，你放到接口中的任何类都自动地使public和static的，甚至可以在内部类中实现其外围接口。
    **如果你想要创建某些公共代码，使得它们可以被某个接口的所有不同实现所共用那么使用接口内部的嵌套类会很方便**。

   从多层嵌套类中访问外部类的成员
     从嵌套类中可以透明地访问它所嵌入的外围类的所有成员。

 7.为什么需要内部类
    一般内部类继承自某各类或实现某个接口，内部类的代码操作创建它的外围类的对象。如果只是需要一个对接口的引用，
    为什么不通过外围类实现那个接口？
    内部类实现一个接口与外围类实现这个接口有什么区别呢？
    每个内部类都能独立地继承自一个接口的实现，所以无论外围类是否已经继承了某个接口的实现，对于内部类都没有影响。
    如果使用内部类，可以获得一些特性：
    1）内部类可以有多个实例，每个实例都有自己的状态信息，并且其外围类对象的信息相互独立；
    2）在单个外围类中，可以让多个内部类以不同的方式实现同一个类，或者继承同一个接口；
    3）创建内部类对象的时刻并不依赖于外围类对象的创建；
    4）内部类并没有令人迷惑的"is-a"关系，它就是一个独立的个体

        例如Sequence类中的内部类SequenceSelector实现了Selector接口，可以包含另外一个内部类实现逆序的选择元素
        reverseSelector，可以包含多个内部类实现多种元素选取方式
        如果你只是使用外围类实现Selector接口，则只能有一种元素select方式

   闭包与回调
    闭包：是一个可以调用的对象，它记录了一些信息，这些信息来自于创建它的作用域。
        内部类是面向对象的闭包，因为它不仅包含外围类对象的信息，还自动拥有一个指向此外围类对象的引用。在此作用域内，
        内部类有权操作所有的成员，包括peivate成员。
    回调：
        在Java中，通常就是编写另一个类或者类库的人规定一个接口，然后你去实现这个接口，然后将这个接口的一个对象
        作为参数传递给别人的程序，别人的程序必要时就会通过那个接口来调用你编写的函数。
        //todo
        回调看的晕头转向的，后续还需再研究


 8.内部类与控制框架

 9.内部类的继承
   内部类的构造器必须连接到指向其外围类对象的引用，在继承内部类的时候，指向外围类对象的秘密引用必须被初始化，
   【而在导出类中不再存在可连接的默认对象？？】，在继承内部类时，除了需要传递一个该内部类的外围类对象的引用之外，
   还需要使用如下语法：
   被继承的内部类的外围类的引用.super();
   这样才能对指向外围类的引用进行初始化，编译才能通过，实在是太绕了，具体实例，请看InheritInner.java 和 SecondOuter.java

 10.内部类可以被覆盖吗？
    如果创建了一个内部类，然后继承其外围类并重新定义此内部类时，会发生什么呢？内部类可以被覆盖吗？
    1.当仅仅继承了某个外围类的时候，如果重写了该内部类，原来的内部类并没有发生什么特别神奇的变化，
      这两个内部类是完全独立的两个实体，新的内部类并没有覆盖原有的内部类
      各自在自己的命名空间内。实例见：BigEgg.java
    2.如果明确的继承某个内部类呢？
      一个外围类A1继承了一个外围类A，A1的内部类B1继承了A的内部类B，此时B1真正覆盖了内部类B；
      实例见：BigEgg2.java


 11.局部内部类
    可以在代码块中创建内部类，典型的方式是在一个方法体中创建。
    局部内部类不能有访问修饰符，因为它不是外围类的一部分。

   匿名内部类vs局部内部类
   1.匿名内部类只能用于实例初始化，当需要一个已经命名的构造器或者需要重载构造器时，不能使用匿名内部类，这种情况下只能
   使用局部内部类。
   2.当需要不止一个该内部类的对象时，需要使用局部内部类，而不使用匿名内部类。

 12.内部类标识符
    每个类都会产生一个.class文件，其中包含了如何创建该类型的额对象的全部信息。
    内部类也必须生成一个 .class文件，以包含他们的Class对象信息，**内部类类文件的命名规则：外围类的名字$内部类的名字**

