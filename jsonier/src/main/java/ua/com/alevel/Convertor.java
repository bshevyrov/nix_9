package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.exceptions.JsonException;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;

public class Convertor<T> {

    public String objectsToJson(LinkedList<Object> objects) {
//        {"name":"asd","booksId":["1","2"],"visible":false}
        StringBuilder stringBuilder = new StringBuilder();
        if(objects.size()>1){
            stringBuilder.append("[");
        }
        Class clss = null;
        for (int i = 0; i < objects.size(); i++) {


            try {
                clss = Class.forName(objects.get(i).getClass().getSuperclass().getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Field[] fields = clss.getDeclaredFields();
            stringBuilder.append("{");
            stringBuilder.append(classFieldsToString(fields, objects.get(i)));
            try {
                clss = Class.forName(objects.get(i).getClass().getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            fields = clss.getDeclaredFields();
            stringBuilder.append(classFieldsToString(fields, objects.get(i)));

            if (stringBuilder.lastIndexOf(",") == stringBuilder.length() - 1) {
                stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length() - 1, "}");
            } else {
                stringBuilder.append("}");
            }
            if ((stringBuilder.charAt(stringBuilder.length() - 1) == ',')
                    && (stringBuilder.charAt(stringBuilder.length() - 2) == '}')) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            if (i < objects.size() - 1) {
                stringBuilder.append(",");
            }
        }
        if(objects.size()>1){
            stringBuilder.append("]");
        }
//            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length() - 1, "}");
        return stringBuilder.toString();
    }

    public LinkedList<T> fromJsonToObjects(String json, T t)  {
        LinkedList<T> list = new LinkedList<>();

        LinkedList<HashMap<String, String>> jsonArray = convertFromJsonToParameters(json);
        String fieldName;
//        System.out.println(jsonArray.size());

        for (HashMap<String, String> stringStringHashMap : jsonArray) {
            Object obj = null;
            try {
                Class<?> cl = Class.forName(t.getClass().getName());
                Constructor<?> cons = cl.getDeclaredConstructor();

                obj = cons.newInstance();

            } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

            Class clssCurrent = obj.getClass();

            Field[] fields = clssCurrent.getDeclaredFields();
            Field[] fields1 = clssCurrent.getSuperclass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                fieldName = field.getName();
                try {
                    //todo проверка типа массива и такой вот метод сделать/переделать
                    if (field.getType().isArray()) {
//                        System.out.println(fieldName);
//                        System.out.println(stringStringHashMap.get(fieldName)+"~~~");
                        int length = stringToArrayString(stringStringHashMap.get(fieldName)).length;
                        Object array = Array.newInstance(field.getType().getComponentType(), length);
                        for (int i = 0; i < length; i++) {
                            Array.set(array, i, (stringToArrayString(stringStringHashMap.get(fieldName))[i]));
                        }

                        field.set(obj, array);

                    } else {

                        //Todo проверка на другие типы
                        if (StringUtils.equals(field.getType().getSimpleName(), "int")) {
//                          if (StringUtils.equals(stringStringHashMap.get(fieldName),"null")){
//                              continue;
//                            }
                            field.set(obj, Integer.parseInt(stringStringHashMap.get(fieldName)));
                        } else {
                            field.set(obj, stringStringHashMap.get(fieldName));
                        }
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            for (Field field : fields1) {
                field.setAccessible(true);
                fieldName = field.getName();
                try {
                    if (StringUtils.equals(field.getType().getSimpleName(), "boolean")) {
                        field.set(obj, Boolean.getBoolean(stringStringHashMap.get(fieldName)));
                    } else {
                        if (isPrimitive(field)) {
                            switch (field.getType().getTypeName()) {
                                //Todo приведение к другим типам
                                case "long":
                                    field.set(obj, Long.valueOf(stringStringHashMap.get(fieldName)));
                                    break;
                                case "boolean":
                                    field.set(obj, Boolean.valueOf(stringStringHashMap.get(fieldName)));
                                    break;
                            }
                        } else {
                            field.set(obj, stringStringHashMap.get(fieldName));
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            list.add((T) obj);
        }
        return list;
    }

    private String classFieldsToString(Field[] fields, Object object) {
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

    private String[] stringToArrayString(String str) {
        str = StringUtils.remove(str, '[');
        str = StringUtils.remove(str, ']');
        return StringUtils.split(str, ',');

    }

    private boolean isPrimitive(Field field) {
        return StringUtils.containsAny(
                field.getType().getTypeName(),
                "int", "long", "double", "float", "boolean", "byte", "char",
                "Long", "Integer");//etc
    }

    private LinkedList<HashMap<String, String>> convertFromJsonToParameters(String json) {

        String[] jsonArr = new String[]{json};
//        if(json.length()==0){
//                throw new JsonException("Json File пуст");
//        }
        if (json.charAt(0) == '[') {
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

            json = StringUtils.deleteWhitespace(json);
            if (JsonVerification.stringVerification(json)) {
//                throw new JsonException("Скобки в не правильном порядке");
            }

        }
        LinkedList<HashMap<String, String>> jsonArray = new LinkedList<>();
//        HashMap<String, String> jsonKeyValue = new HashMap<>();
        for (String jsonStr : jsonArr) {
            HashMap<String, String> jsonKeyValue = new HashMap<>();

            // jsonKeyValue.clear();
            while (jsonStr.length() > 1) {
                int indexStartKey = 0;
                int indexFinishKey = 0;
                int indexStartValue = 0;
                int indexFinishValue = 0;
                int indexDelimiterKeyValue = 0;

                indexStartKey = StringUtils.indexOf(jsonStr, "\"");
                indexFinishKey = StringUtils.indexOf(jsonStr, "\"", indexStartKey + 1);
                //имеет ли смысл эта проверка по стандарту Джсон
                if (!StringUtils.equals(String.valueOf(jsonStr.charAt(indexFinishKey + 1)), ":")) {

//                    throw new JsonException("Битый Json не хватает \":\" ");
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
//                        if (StringUtils.countMatches(jsonStr.substring(indexStartValue + 1, indexFinishValue - 1), "[") != StringUtils.countMatches(jsonStr.substring(indexStartValue, indexFinishValue), "]")) {
//                            System.out.println("Бида в массиве, ты не так его опредлил в Джсоне");
//                        }
                    }
                } else {
                    if ((StringUtils.equals(String.valueOf(jsonStr.charAt(indexStartValue)), "\""))) {
                        indexFinishValue = StringUtils.indexOf(jsonStr, "\"", indexStartValue + 1);
                    } else {
                        if (StringUtils.contains(jsonStr.substring(indexStartValue), ',')) {
                            indexFinishValue = StringUtils.indexOf(jsonStr, ',', indexStartValue);
                        } else {
                            indexFinishValue = StringUtils.indexOf(jsonStr,'}',indexStartValue);
                        }
                    }
                }

                String key = StringUtils.remove(StringUtils.substring(jsonStr, indexStartKey + 1, indexFinishKey), '"');
                if (jsonStr.charAt(indexFinishValue) == ']') {
//                    indexFinishValue += 1;
                }
                if (jsonStr.charAt(indexStartValue) == '\"') {
                    indexStartValue += 1;

                }
                String value = StringUtils.remove(StringUtils.substring(jsonStr, indexStartValue, indexFinishValue), '"');
                if (jsonStr.charAt(indexFinishValue) == '}' && indexFinishValue  == jsonStr.length()) {
                    break;
                    //jsonStr = StringUtils.removeStart(jsonStr, jsonStr.substring(0, indexFinishValue + 2));
                } else {
                    jsonStr = StringUtils.removeStart(jsonStr, jsonStr.substring(0, indexFinishValue + 1));
                }

                //i = indexFinishValue + 1;
                if (!StringUtils.contains(value, "null")) {
                    jsonKeyValue.put(key, value);
                }
            }
            jsonArray.add(jsonKeyValue);
        }
        return jsonArray;
    }

}
