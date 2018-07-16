import food.Food;
        import food.FoodFactory;

/**
 * @author LightDance
 */


public class FactoryMethordTest {
    //静态工厂方法与构造器相比，优势在于：
    // 1.它有名称，可以通过不同名称的静态工厂方法区别不同类型实例，
    // 这样可以避免API中定义多个难以区别的重载构造方法，对程序员的使用造成麻烦

    // 2.不必每次调用都创建一个新的对象，
    // 如果需要频繁返回相同的对象，这个会极大程度减少重复对象的创建。
    // 例如数据库连接类，它十分庞大，如果每次都去创建新的实例，
    // 会出现大量庞大、重复的链接类，这时候用单例思想通过工厂方法就可以完美解决

    // 3.可以返回原返回类型的任意子类型对象，在选择返回类型的时候能够有更大的灵活性，
    // 这使得API能够通过接口与继承根据需要自行判断应该返回何种类型的子类，
    // 而不需要API的使用者费劲阅读文档，这一点需要借助反射实现

    //但这种方法也存在一些局限性：
    // 1.服务-提供者框架的工厂方法不允许公有构造方法，无法实例化，于是无法被继承，
    // 这也鼓励开发者使用复合代替继承
    // 2.静态工厂方法不能与其他静态方法区别开来，或许寻找构造方法时查阅文档会有些麻烦，
    // 这时规范命名的重要性就体现出来了。

    //命名规范：
//     #valueOf 提供与参数值相同的实例
//     #of 简化版的valueOf
//     #getInstance 根据参数的描述获取实例，但未必与参数具有相同的值，对于单例，
//          这个方法没有参数，返回唯一的实例
//     #newInstance 类似getInstance，但newInstance保证获取的每一个实例都与其它实例不同
//     #getType 类似getInstance，工厂方法处于不同的类中时使用Type为工厂方法所返回的类型
//     #newType 同理newInstance

    public static void main(String[] args) {
        Food newFood =  FoodFactory.getFoodByType(FoodFactory.TYPE_APPLE);
        newFood.introduce();
        Food newFood2 =  FoodFactory.getDefaultFood();
        newFood2.introduce();
    }
}