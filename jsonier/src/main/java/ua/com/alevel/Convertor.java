package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.exceptions.JsonException;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

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

    public static Object fromJsonToObject(String json, Class clss) throws JsonException {
        //1 строка
        StringBuilder builder = new StringBuilder();
        boolean array = false;
        String[] jsonArr = new String[]{json};
        if (json.charAt(0) == '[') {
            array = true;

            jsonArr = StringUtils.splitByWholeSeparator(json, "},{");

            for (int i = 0; i < jsonArr.length; i++) {
                if (i == 0) {
                    jsonArr[i] = StringUtils.substring(jsonArr[0], 1, jsonArr[0].length()).concat("}");
                }
                if (i == jsonArr.length - 1) {
                    jsonArr[i] = "{".concat(StringUtils.substring(jsonArr[i], 0, jsonArr[0].length() - 1));
                }
                if (i != 0 && i != jsonArr.length - 1) {
                    jsonArr[i] = "{".concat(jsonArr[i]).concat("}");
                }

            }
            System.out.println("jsonArr = " + jsonArr.length);
            System.out.println(jsonArr[0]);
            System.out.println(jsonArr[1]);
            System.out.println(jsonArr[2]);

            int numOfPairs = StringUtils.countMatches(json, ":");
//
//        json = StringUtils.removeStart(json, "{");
//        json = StringUtils.removeEnd(json, "}");
            json = StringUtils.deleteWhitespace(json);

            if (JsonVerification.stringVerification(json)) {
                System.out.println(json);
                throw new JsonException("Скобки в не правильном порядке");
            }

        }
        char[] jsonByChars = json.toCharArray();
        LinkedList<HashMap<String, String>> jsonArray = new LinkedList<>();

        HashMap<String, String> jsonKeyValue = new HashMap<>();
        for (String jsonStr : jsonArr) {

            jsonKeyValue.clear();
            for (int i = 1; i < jsonStr.length() - 2; i++) {
                int currentIndex = 0;
                int indexStartKey = 0;
                int indexFinishKey = 0;
                int indexStartValue = 0;
                int indexFinishValue = 0;
                int indexDelimiterKeyValue = 0;
                // скип открывающей и закрывающей скобки
//            if (!StringUtils.equals(String.valueOf(jsonStr.charAt(i)), "\"")) {
//                throw new JsonException("Битый Json не хватает \"\"\"  в начале файла");
//            }

                indexStartKey = StringUtils.indexOf(jsonStr, "\"");
                indexFinishKey = StringUtils.indexOf(jsonStr, "\"", indexStartKey + 1);
                //имеет ли смысл эта проверка по стандарту Джсон
                if (!StringUtils.equals(String.valueOf(jsonStr.charAt(indexFinishKey + 1)), ":")) {

                    throw new JsonException("Битый Json не хватает \":\" ");
                }
                indexDelimiterKeyValue = indexFinishKey + 1;
                indexStartValue = indexDelimiterKeyValue + 1;
                if (StringUtils.equals(String.valueOf(jsonStr.charAt(indexStartValue)), "[")) {
                    indexFinishValue = StringUtils.indexOf(jsonStr, "]");
                    //TODO Порешать биду
                    if (StringUtils.contains(jsonStr.substring(indexStartValue, indexFinishValue), "{") || StringUtils.contains(jsonStr.substring(indexStartValue, indexFinishValue), "[")) {
                        if (StringUtils.countMatches(jsonStr.substring(indexStartValue, indexFinishValue), "{") != StringUtils.countMatches(jsonStr.substring(indexStartValue, indexFinishValue), "}")) {
                            System.out.println("Бида в массиве, ты не так его опредлил в Джсоне");
                        }//минус один потому что массив САм начинается и заканчивается со скобок
                        if (StringUtils.countMatches(jsonStr.substring(indexStartValue + 1, indexFinishValue - 1), "[") != StringUtils.countMatches(jsonStr.substring(indexStartValue, indexFinishValue), "]")) {
                            System.out.println("Бида в массиве, ты не так его опредлил в Джсоне");
                        }
                    }
                } else {
                    if ((StringUtils.equals(String.valueOf(jsonStr.charAt(indexStartValue)), "\""))) {
                        indexFinishValue = StringUtils.indexOf(jsonStr, "\"", indexStartValue + 1);
                    } else {
                        if (StringUtils.contains(jsonStr.substring(indexStartValue), ',')) {
                            indexFinishValue = StringUtils.indexOf(jsonStr, ',', indexStartValue);
                        } else {
                            indexFinishValue = jsonStr.substring(indexStartValue).indexOf('}');
                        }
                    }
                }

                String key = StringUtils.substring(jsonStr, indexStartKey + 1, indexFinishKey);
                if (jsonStr.charAt(indexFinishValue) == ']') {
                    indexFinishValue += 1;
                }
                if (jsonStr.charAt(indexStartValue) == '\"') {
                    indexStartValue += 1;

                }
                String value = StringUtils.substring(jsonStr, indexStartValue, indexFinishValue);
                if (jsonStr.charAt(indexFinishValue + 1) == '}' && indexFinishValue + 1 == jsonStr.length()) {
                    break;
                    //jsonStr = StringUtils.removeStart(jsonStr, jsonStr.substring(0, indexFinishValue + 2));
                } else {
                    jsonStr = StringUtils.removeStart(jsonStr, jsonStr.substring(0, indexFinishValue + 1));
                }

                i = indexFinishValue + 1;
                if (!StringUtils.contains(value, "null")) {
                    jsonKeyValue.put(key, value);
                }
//            continue;


//            break;

//            {"name":"asd","booksId":["1","2"],"visible":false}


            }
            System.out.println(jsonKeyValue.size());
            System.out.println(jsonKeyValue.toString());
            jsonArray.add(jsonKeyValue);

        }
        System.out.println(jsonArray.size());

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
                "Long", "Integer");//etc
    }


    private static String getArrayAndRemoveItFromJson(String json) {
        StringBuilder builder = new StringBuilder();

        int arraysNum = StringUtils.countMatches(json, "[");
        int indexOpenSquareBrasers = StringUtils.indexOf(json, "[");
        int indexCloseSquareBrasers = StringUtils.indexOf(json, "]");
        int indexCloseComas = StringUtils.lastIndexOf(StringUtils.substring(json, 0, indexOpenSquareBrasers), "\"");
        int indexOpenComas = StringUtils.lastIndexOf(StringUtils.substring(json, 0, indexCloseComas), "\"");
        builder.append(StringUtils.substring(json, indexOpenComas, indexCloseSquareBrasers + 1));
//        if (StringUtils.equals(String.valueOf(json.charAt(indexCloseSquareBrasers + 2)), ",")) {
//            json = StringUtils.remove(json, builder.append(",").toString());
//        } else {
//            json = StringUtils.remove(json, builder.toString());
//        }
        return builder.toString();


    }
}
