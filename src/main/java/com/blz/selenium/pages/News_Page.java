package com.blz.selenium.pages;

import com.blz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class News_Page extends BaseClass {

    @FindBy(css = "a.storylink")
    List<WebElement> news;

    @FindBy(css = "tr td span.score")
    List<WebElement> points;

    public News_Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void new_headings(){
        List<String> newsList = new ArrayList();
        List<Integer> pointsList = new ArrayList<>();

        //used for loop for getting news in the console
        for (WebElement webElementHeader : news) {

            System.out.println(webElementHeader.getText());
            newsList.add(webElementHeader.getText());
        }

        //used for loop for getting points in the console
        for (WebElement webElementPoints : points) {

            System.out.println(webElementPoints.getText().substring(0, webElementPoints.getText().length() - 7));
            pointsList.add(Integer.parseInt(webElementPoints.getText().substring(0, webElementPoints.getText().length() - 7)));
        }

        //Used map collection so that it should iterate the news list and points
        Map<String, Integer> newsHeaderMap = new HashMap<>();
        Iterator<String> newsIterator = newsList.iterator();
        Iterator<Integer> scorePointIterator = pointsList.iterator();

        //used while loop so that if one news get completed it takes to next news
        while (newsIterator.hasNext() && scorePointIterator.hasNext()) {
            newsHeaderMap.put(newsIterator.next(), scorePointIterator.next());
        }

        //used entrySet so that each news should get print
        newsHeaderMap.entrySet().stream().forEach(System.out::println);

        //created wordlist which will get all the news list
        List<String> wordList = listOfWords(newsList);

        wordList.stream().forEach(System.out::println);

        //used map which gonna find words having maximum count
        Map<String, Integer> wordCountMap = findWordHavingMaxCount(wordList);
        String countWordInMap = getMaxCountWordInMap(wordCountMap);

        System.out.println("Word which repeating More Times:->" + countWordInMap);
        String popularNewsHeading = getPopularNewsAmongAll(newsHeaderMap, countWordInMap);

        System.out.println(popularNewsHeading);


    }

    //Created private method for getting popular news among all
    private String getPopularNewsAmongAll(Map<String, Integer> newsHeaderMap, String countWordInMap) {
        int value = 0;
        String mostPopular="";
        for (Map.Entry<String, Integer> val : newsHeaderMap.entrySet()) {
            if (val.getKey().contains(countWordInMap )) {
                if ( val.getValue()>value){
                    value=val.getValue();
                    mostPopular=val.getKey();
                }
            }

        }
        System.out.println("Most populaR TEST DATA:"+mostPopular);
        return mostPopular;
    }

    //Created private method which will take max count word
    private String getMaxCountWordInMap(Map<String, Integer> wordCountMap) {
        String key = "";
        Integer value = 0;

        for (Map.Entry<String, Integer> val : wordCountMap.entrySet()) {
            if (val.getValue() > value) {
                value = val.getValue();
                key = val.getKey();
            }
            System.out.println("Word " + val.getKey() + " "
                    + "repeated"
                    + ": " + val.getValue() + " times");
        }
        return key;
    }

    //Created private method find word having maximum count
    private Map<String, Integer> findWordHavingMaxCount(List<String> wordList) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String i : wordList) {
            Integer j = wordMap.get(i);
            wordMap.put(i, (j == null) ? 1 : j + 1);
        }
        wordMap.entrySet().stream().forEach(System.out::println);
        return wordMap;
    }

    //Created method which will take list of all words
    private List<String> listOfWords(List<String> newsList) {
        List<String> words = new ArrayList<>();

        for (String s1 : newsList) {
            String[] arrOfWords = s1.split(" ");
            List<String> l1 = Arrays.asList(arrOfWords);
            words.addAll(l1);

        }
        return words;
    }

}
