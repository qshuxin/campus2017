package service;

import bean.Character;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qinshuxin on 2017/7/5.
 */
@Service
public class Counter {

    public Character count(String word) {
        Character character = new Character();
        character = init();

        int length = word.length();
        Integer enCount=0;
        Integer numCount=0;
        Integer chCount=0;
        Integer puCount=0;
        String chaMax1="";
        String chaMax2="";
        String chaMax3="";
        Integer chaMax1Count=0;
        Integer chaMax2Count=0;
        Integer chaMax3Count=0;

        TreeMap<String,Integer> treeMap = new TreeMap<String, Integer>();
        for (int i = 0; i < length; i++) {
            String a = word.substring(i, i+1);
            if(chPattern(a))
            {
                chCount++;
            }
            if(enPattern(a))
            {
                enCount++;
            }
            if(numPattern(a))
            {
                numCount++;
            }
            if(puPattern(a))
            {
                puCount++;
            }
            if(treeMap.containsKey(a))
            {
                treeMap.put(a,treeMap.get(a)+1);
            }
            else
            {
                treeMap.put(a,1);
            }
        }
        character.setNumCount(numCount);
        character.setPuCount(puCount);
        character.setChCount(chCount);
        character.setEnCount(enCount);

        // 将map.entrySet()转换成list
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(treeMap.entrySet());
        // 通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 升序排序
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int z=1;

        for (Map.Entry<String, Integer> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
            if(z==1)
            {
                chaMax1=mapping.getKey();
                chaMax1Count=mapping.getValue();
            }
            if(z==2)
            {
                chaMax2=mapping.getKey();
                chaMax2Count=mapping.getValue();
            }
            if(z==3)
            {
                chaMax3=mapping.getKey();
                chaMax3Count=mapping.getValue();
            }
            z++;
        }

        character.setChaMax1(chaMax1);
        character.setChaMax2(chaMax2);
        character.setChaMax3(chaMax3);
        character.setChaMax1Count(chaMax1Count);
        character.setChaMax2Count(chaMax2Count);
        character.setChaMax3Count(chaMax3Count);

        return character;
    }

    public boolean chPattern(String word)
    {
        String reg="^[\\u0391-\\uFFE5]";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(word);
        return matcher.find();
    }
    public boolean enPattern(String word)
    {
        String reg="^[A-Za-z]";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(word);
        return matcher.find();
    }
    public boolean numPattern(String word)
    {
        String reg="^[0-9]";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(word);
        return matcher.find();
    }
    public boolean puPattern(String word)
    {
        String reg="^\\p{P}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(word);
        return matcher.find();
    }

    public Character init() {
        Character character = new Character();
        character.setChaMax1("");
        character.setChaMax1Count(0);
        character.setChaMax2("");
        character.setChaMax2Count(0);
        character.setChaMax3("");
        character.setChaMax3Count(0);
        character.setEnCount(0);
        character.setChCount(0);
        character.setPuCount(0);
        character.setNumCount(0);
        return character;
    }
}
