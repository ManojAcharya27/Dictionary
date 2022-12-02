package com.example.dictionary;

public class Trie {
    public static  class  TrieNode{
        boolean endOfWord;
        String meaning;
        TrieNode[] children;
        TrieNode()
        {
            endOfWord=false;
            meaning="";
            children=new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                children[i]=null;
            }
        }
    }
    static  TrieNode root;

    public static  void insert(String word,String meaning)
    {
        int index;
        TrieNode temp=root;
        for (int i = 0; i <word.length() ; i++) {
            index=word.charAt(i)-'a';
            if(temp.children[index]==null)
            {
                temp.children[index]=new TrieNode();
            }
            temp=temp.children[index];
        }
        temp.endOfWord=true;
        temp.meaning=meaning;
    }
    public static  String search(String word){
        TrieNode temp=root;
        if(temp==null)
        {
            return "word not found";
        }
        int index;
        for (int i = 0; i < word.length(); i++) {
            index=word.charAt(i)-'a';
            if(temp.children[index]==null)
            {
                return "word not found";
            }else
            temp=temp.children[index];
        }
       return temp.meaning;
    }
    static String meaning="";
    public  static String getWord(String word)
    {
        if(word.isBlank())
        {
            return "Word not found";
        }else
        return meaning=search(word);

    }

    public static void main(String[] args) {
        root=new TrieNode();

        //root.meaning
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
        System.out.println(search("approach"));
        System.out.println(search("obtain"));

    }
}
