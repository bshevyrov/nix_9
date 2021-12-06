package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.stream.Stream;

public class Convertor {

    public static String objectToJson(Object object) {
//        {"name":"asd","booksId":["1","2"],"visible":false}
        StringBuilder stringBuilder = new StringBuilder();
        Class clss = null;
        try {
            clss = Class.forName(object.getClass().getSuperclass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] fields = clss.getDeclaredFields();
        stringBuilder.append("{");
        stringBuilder.append(classFieldsToString(fields, object));
        try {
            clss = Class.forName(object.getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        fields = clss.getDeclaredFields();
        stringBuilder.append(classFieldsToString(fields, object));

        if (stringBuilder.lastIndexOf(",") == stringBuilder.length() - 1) {
            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length() - 1, "}");
        } else {
            stringBuilder.append("}");
        }
        if ((stringBuilder.charAt(stringBuilder.length() - 1) == ',')
                && (stringBuilder.charAt(stringBuilder.length() - 2) == '}')) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
//            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length() - 1, "}");
        return stringBuilder.toString();
    }

    public static Object fromJsonToObject(String json, Class clss) {
        //1 строка
        StringBuilder builder = new StringBuilder();
        json=StringUtils.removeStart(json,"{");
        json=StringUtils.removeEnd(json,"}");
//        "booksId":["1","2"],
// в метод выделение масивов
        int arraysNum = StringUtils.countMatches(json,"[");
         int indexOpenSquareBrasers = StringUtils.indexOf(json,"[");
         int indexCloseSquareBrasers= StringUtils.indexOf(json,"]");
         int indexCloseComas = StringUtils.lastIndexOf(StringUtils.substring(json,0,indexOpenSquareBrasers),"\"");
         int indexOpenComas = StringUtils.lastIndexOf(StringUtils.substring(json,0,indexCloseComas),"\"");
        builder.append(StringUtils.substring(json,indexOpenComas,indexCloseSquareBrasers+1));
        System.out.println(builder.toString());


        Field[] fields = clss.getDeclaredFields();
        System.out.println(fields.length);
//        for (Field field : fields) {
//            field.getType().is
//        }
        return new Object();
    }

    private static String classFieldsToString(Field[] fields, Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean primitive = false; //String и ENUM только стринги??
        try {
            for (Field field : fields) {

                stringBuilder.append("\"").append(field.getName()).append("\":");
                field.setAccessible(true);
                if (field.getType().isArray()) {

                    if (isPrimitive(field)) {
                        primitive = true;
                    }

                    Object array = field.get(object);
                    if (null != array) {
                        int length = Array.getLength(array);
                        stringBuilder.append("[");
                        for (int i = 0; i < length; i++) {
                            if (primitive) {
                                stringBuilder.append(Array.get(array, i));
                            } else {
                                stringBuilder.append("\"");
                                stringBuilder.append(Array.get(array, i));
                                stringBuilder.append("\"");
                            }
                            if (i != length - 1) {
                                stringBuilder.append(",");
                            }
                        }
                    } else {
                        stringBuilder.append("[");
                    }
                    stringBuilder.append("]")
                            .append(",");
                } else {
                    if (isPrimitive(field)) {
                        stringBuilder.append(field.get(object))
                                .append(",");
                    } else {
                        stringBuilder.append("\"")
                                .append(field.get(object))
                                .append("\",");
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private static boolean isPrimitive(Field field) {
        return StringUtils.containsAny(
                field.getType().getTypeName(),
                "int", "long", "double", "float", "boolean", "byte", "char",
                "Long","Integer");//etc
    }
}
