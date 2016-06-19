
import util.MyString;
import util.Pair;
import util.EqualX;
import util.Number;
import util.Word;
import primitive.Succeed;
import primitive.Fail;
import primitive.Satisfy;
import primitive.Literal;
import combinator.Alt;
import combinator.Then;
import combinator.Using;
import combinator.Many;
import combinator.Some;
import example.AlwaysOne;
import java.util.ArrayList;
import java.util.List;

abstract class ParsecJ<T1, T2> {

    public static void main(String[] args) {

	Succeed<Integer, MyString> s =
	    new Succeed<Integer, MyString>(5);
	Fail<Integer, MyString> f =
	    new Fail<Integer, MyString>();
	/*
	EqualX<Character> eqx =
	    new EqualX<Character>('h');
	Satisfy<Character, MyString> st =
	    new Satisfy<Character, MyString>(eqx);
	*/
	Literal li = new Literal('a');
	Using<Character, Integer, MyString> ch_using_num =
	    new Using(li, new AlwaysOne());
	Many<Character, MyString> mli =
	    new Many<Character, MyString>(li);
	Some<Character, MyString> sli =
	    new Some<Character, MyString>(li);
	Number np =
	    new Number();
	Word wp =
	    new Word();

	MyString inp = new MyString("hello,world");
	MyString inp1 = new MyString("aaab");
	MyString inp2 = new MyString("123abc");
	
	ArrayList<Pair<Integer, MyString>> s1 = s.parse(inp.clone());
	ArrayList<Pair<Integer, MyString>> f1 = f.parse(inp.clone());
	//ArrayList<Pair<Character, MyString>> p1 = st.parse(inp.clone());
	ArrayList<Pair<Character, MyString>> li1 = li.parse(inp1.clone());
	ArrayList<Pair<Integer, MyString>> cn =
	    ch_using_num.parse(inp1.clone());
	ArrayList<Pair<ArrayList<Character>, MyString>> mli1 =
	    mli.parse(inp1.clone());
	ArrayList<Pair<ArrayList<Character>, MyString>> sli1 =
	    sli.parse(inp1.clone());
	ArrayList<Pair<ArrayList<Character>, MyString>> np1 =
	    np.parse(inp2.clone());
	ArrayList<Pair<ArrayList<Character>, MyString>> wp1 =
	    wp.parse(inp.clone());

	print(s1);
	print(f1);
	//print(p1);
	print(li1);
	print(cn);
	print(mli1);
	print(sli1);
	print(np1);
	print(wp1);
    }

    private static void print(ArrayList a) {
	boolean x = false;
	System.out.print("[");
	for(Object a1 : a) {
	    Pair p = (Pair)a1;
	    if (!x) {
		x = true;
		System.out.print(p);
	    } else {
		System.out.print(", " + p);
	    }
	}
	System.out.println("]");
    }

    abstract <T2 extends MyString> List<Pair<T1, T2>> parse(T2 inp);
}










