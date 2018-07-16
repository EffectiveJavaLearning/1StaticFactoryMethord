package food;

import food.Food;

/**
 * 服务-提供者框架模型，一种服务（打印食物信息）多个提供者，通过FoodFactory静态工厂方法自动获取提供者
 *
 * @author LightDance
 */
public class FoodFactory {

    private FoodFactory(){
        super();
    }
    public static final String TYPE_APPLE = "Apple";
    public static final String TYPE_BANANA = "Banana";
    private static final String TYPE_DEFAULT = "Bread";

    public static Food getFoodByType(String foodType){
        Food food = null;
        try {
            food = (Food) Class.forName("food."+foodType).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return food;
    }

    public static Food getDefaultFood(){
        return getFoodByType(TYPE_DEFAULT);
    }
}