package primitive;
import util.Parser;
import util.Predicate;
import util.MyString;
import util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;

public class Satisfy<T1, T2 extends LinkedList<T1>> extends
							Parser<T1, T2> {
    private Predicate<T1> p;

    public Satisfy(Predicate<T1> p) {
	this.p = p;
    }

    @Override
    public ArrayList<Pair<T1, T2>> parse(T2 inp) {
	T1 head = inp.pollFirst();

	if (head.equals(null))
	    return (new Fail<T1, T2>()).parse(inp);
	
	if (p.eval(head))
	    return (new Succeed<T1, T2>(head)).parse(inp);
	
	return (new Fail<T1, T2>()).parse(inp);
    }
}