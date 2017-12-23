/**
 * Created by 11007122 on 13.12.2017.
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

/**
 * Scans object "from" for all getters. If object "to"
 * contains correspondent setter, it will invoke it
 * to set property value for "to" which equals to the property of "from".
 * <p/>
 * Тип в сеттере должен быть совместим с возвращаемым значением
 * по геттеру (если нет, никакой вызов не выполнялся).
 * Совместимость означает, что тип параметра в сеттере должен
 * быть одинаковым или быть суперклассом возвращаемого типа геттера.
 * <p/>
 * The method takes care only about public methods.
 */

public class BeanUtils {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Integer a = 24;
        String b = "cool";
        String b1 = "yes";
        assign(b1, b);
    }

    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        // Картинка в блокноте  акрониса!!!
        Class classTo = to.getClass();
        Class classFrom = from.getClass();

        // Получили все методы класса
        // И запишем в массив getter-ов
        Method[] metodsFrom = classFrom.getMethods();
        Set <Method> getters = new HashSet<>();
        for (Method metod: metodsFrom) {
            //System.out.println(metod.getName());
            if (isGetter(metod)) {
                getters.add(metod);
                System.out.println(metod.getName());
            }
        }

        System.out.println("************");


        // Запишем все seter-ы
        Set <Method> setters = new HashSet<>();
        Method[] metodsTo = classFrom.getMethods();

        for (Method metod: metodsTo) {
            //System.out.println(metod.getName());
            if (isSetter(metod)) {
                setters.add(metod);
                System.out.println(metod.getName());
            }
        }

        // Сопоставляем методы:
        for (Method i:getters) {
            for (Method j: setters) {
                if (areComparableTypes(i.getClass(), j.getClass()) && areSameNames(i, j)){
                    // execute
                    j.invoke(to, i.invoke(from));
                }
            }
        }

    }

    public static boolean isGetter(Method method){
        if(!method.getName().startsWith("get"))
            return false;
        if(method.getParameterTypes().length != 0)
            return false;
        if(void.class.equals(method.getReturnType()))
            return false;
        return true;
    }

    public static boolean isSetter(Method method){
        if(!method.getName().startsWith("set"))
            return false;
        if(method.getParameterTypes().length != 1)
            return false;
        return true;
    }

    public static boolean areComparableTypes (Class setter, Class getter) {
        if (setter == getter || setter == getter.getSuperclass())
            return true;
        else
            return false;
    }

    public static boolean areSameNames (Method a, Method b) {
        if (a.getName().substring(3).equals(b.getName().substring(3))) {
            return true;
        } else {
            return false;
        }
    }

//    public void setFromTo () {
//
//    }

}

