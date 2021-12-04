package ua.com.alevel.thirdlevel;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;

public class Logic {

    City[] cities;
    String[] ways;

    public LinkedList<String> findEasyWay(String[] input) {
        initCities(input);
        return doMath(createMatrix(cities));
    }

    private void initCities(String[] input) {
        int cityNumber = 0;
        input = Arrays.copyOfRange(input, 1, input.length);
        for (int i = 0; i < input.length; i++) {
            if (StringUtils.isAlphaSpace(input[i + 2]) && StringUtils.countMatches(input[i + 2], " ") == 1) {
                ways = new String[Integer.parseInt(input[i])];
                for (int j = 0; j < ways.length; j++) {
                    ways[j] = input[i + j + 1];
                }
                break;
            }
            City city = new City();
            city.setId(cityNumber++);
            city.setName(input[i++]);
            int[][] path = new int[Integer.parseInt(input[i])][2];
            for (int j = 0; j < path.length; j++) {
                i++;
                path[j][0] = Integer.parseInt(String.valueOf(input[i].charAt(0))) - 1;//тк у меня индексы с 0
                path[j][1] = Integer.parseInt(String.valueOf(input[i].charAt(2)));
            }
            city.setPathToNeighbours(path);
            cities = ArrayUtils.add(cities, city);
        }
    }

    private int[][] createMatrix(City[] cities) {
        int[][] matrix = new int[cities.length][cities.length];
        for (City city : cities) {
            int[][] pathToNeighbours = city.getPathToNeighbours();
            for (int[] pathToNeighbour : pathToNeighbours) {
                matrix[city.getId()][pathToNeighbour[0]] = pathToNeighbour[1];
            }
        }
        return matrix;
    }

    private LinkedList<String> doMath(int[][] matrix) {
        //Флойд-Уоршел
        LinkedList<String> rsl = new LinkedList<>();
        int maxCost = 200000;
        int vNum = cities.length;
        for (int i = 0; i < vNum; i++) {
            for (int j = 0; j < vNum; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = maxCost;
                }
            }
        }
        for (int k = 0; k < vNum; k++) {
            for (int i = 0; i < vNum; i++) {
                for (int j = 0; j < vNum; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        int[][] whatToFind = new int[ways.length][2];
        for (int i = 0; i < ways.length; i++) {
            for (City city : cities) {
                if (StringUtils.equals(city.getName(), ways[i].substring(0, ways[i].indexOf(' ')))) {
                    whatToFind[i][0] = city.getId();
                }
                if (StringUtils.equals(city.getName(), ways[i].substring(ways[i].indexOf(' ') + 1))) {
                    whatToFind[i][1] = city.getId();
                }
            }
        }
        for (int i = 0; i < ways.length; i++) {
            rsl.add(String.valueOf(matrix[whatToFind[i][0]][whatToFind[i][1]]));
        }
        return rsl;
    }
}
