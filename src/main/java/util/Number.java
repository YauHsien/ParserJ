package util;
import util.Predicate;
import primitive.Satisfy;
import combinator.Some;
import java.util.ArrayList;

public class Number
    extends Parser<ArrayList<Character>, MyString, Character> {
    
    @Override
    protected ArrayList<Pair<ArrayList<Character>, MyString>> parse1
	(MyString inp) {
	
	Satisfy<Character, MyString> p =
	    new Satisfy<Character, MyString>(new Digit());
					    
	Some<Character, MyString, Character> sp =
	    new Some<Character, MyString, Character>(p);

	return sp.parse(inp);
    }
}



class Digit extends Predicate<Character> {

    @Override
    protected Boolean eval(Character c) {
	return '0' <= c && c <= '9';
    }
}
