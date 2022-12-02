package com.example.dictionary;

import java.util.HashMap;

public class DictionaryUsngHashMap {
    private HashMap<String ,String> dictionary;
    public DictionaryUsngHashMap(){
        dictionary=new HashMap<>();
        addListOfWord();

    }
    public boolean insert(String word,String meaning)
    {
        dictionary.put(word,meaning);
        return  true;
    }
    public  String findMeaning(String word){
        if(!dictionary.containsKey(word)){
            return  "Given word not found!";
        }
        else return  dictionary.get(word);
    }
    private  void addListOfWord(){
        insert( "Mango","Fruit");
        insert( "hospital","an institution providing medical and surgical treatment");
        insert("tumid","not in or exhibiting good health in body or mind");
        insert("filigree","delicate and intricate ornamentation");
        insert("rubric","category name");
        insert("intemperance","excess in action and immoderate indulgence of appetites");
        insert("narcissist","someone who is excessively self centered");
        insert("tautology","useless repetition");
        insert("consider","deem to be");
        insert("minute","infinitely or immeasurably small");
        insert("accord","concurrence of opinion");
        insert("evident","clearly revealed to the mind or the senses or judgment");
        insert("practice","a customary way of operation or behavior");
        insert("intend","have in mind as a purpose");
        insert("concern","something that interests you because it is important");
        insert("commit","perform an act, usually with a negative connotation");
        insert("issue","some situation or event that is thought about");
        insert("approach","move towards");
        insert("establish","set up or found");
        insert("utter","without qualification");
        insert("conduct","direct the course of; manage or control");
        insert("engage","consume all of one's attention or time");
        insert("obtain","come into possession of");
        insert("scarce","deficient in quantity or number compared with the demand ");
    }
}
