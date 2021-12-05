package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

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
        return stringBuilder.toString();
    }

    private static String classFieldsToString(Field[] fields, Object object) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            for (Field field : fields) {
                stringBuilder.append("\"").append(field.getName()).append("\":");
                field.setAccessible(true);
                if (StringUtils.equals(field.getType().getTypeName(), "boolean")) {
                    stringBuilder.append(field.get(object))
                            .append("\",");
                }
                if (field.getType().isArray()) {
                    Object array = field.get(object);
                    int length = Array.getLength(array);
                    stringBuilder.append("[");
                    for (int i = 0; i < length; i++) {
                        stringBuilder.append("\"");
                        stringBuilder.append(Array.get(array, i));
                        stringBuilder.append("\"");
                        if (i != length - 1) {
                            stringBuilder.append(",");
                        }
                    }
                    stringBuilder.append("]")
                            .append(",");
                } else {
                    stringBuilder.append("\"")
                            .append(field.get(object))
                            .append("\",");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}

