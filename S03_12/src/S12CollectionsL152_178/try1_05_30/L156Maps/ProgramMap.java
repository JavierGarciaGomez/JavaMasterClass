package S12CollectionsL152_178.try1_05_30.L156Maps;

import java.util.HashMap;
import java.util.Map;

public class ProgramMap {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        // Key and value
        languages.put("Java", "a compiled high level, object-oriented, platform independent language");
        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness");

        System.out.println("get(): "+languages.get("Java"));
        System.out.println("containsValue(): "+languages.containsValue("Therein lies madness"));
        System.out.println("size() and keySet()"+languages.size()+" "+languages.keySet());

        if(languages.containsKey("Java")) {
            System.out.println("Java already exists");
        } else {
            languages.put("Java", "a compiled high level, object-oriented, platform independent language");
            System.out.println("Java added successfully");
        }

        // For printing all
        System.out.println("****************Print all with a for*******");
        for(String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

        /* 157. Map continued and adventure game*/

        // remove() and replace
        System.out.println("--------removing algol and replacing lisp");
        languages.remove("Algol");

        //replace()


        // This print lisp and then it changes it
        System.out.println("replace() "+languages.replace("Lisp", "A funcional programming language with imperative features"));
        System.out.println(languages.get("Lisp"));
        for(String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
        // We can use a map and use a key and a value with any value. Even a hashmap can be a value for another map




        }
}
