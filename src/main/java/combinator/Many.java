package combinator;
import util.Pair;
import util.MyString;
import util.Cons;
import util.Parser;
import primitive.Succeed;
import java.util.ArrayList;
import java.util.LinkedList;

public class Many<T1, T2 extends LinkedList<T3>, T3>
    extends Parser<ArrayList<T1>, T2> {
    
    private Parser<T1, T2> p;
    
    public Many(Parser<T1, T2> p) {
	this.p = p;
    }

    @Override
    public ArrayList<Pair<ArrayList<T1>, T2>> parse(T2 inp) {
	
	Many<T1, T2, T3> mp = new Many<T1, T2, T3>(p);
	
	Then<T1, ArrayList<T1>, T2, T3> then =
	    new Then<T1, ArrayList<T1>, T2, T3>(p, mp);

	Cons<T1> cons = new Cons<T1>();
	
	Using<Pair<T1, ArrayList<T1>>, ArrayList<T1>, T2, T3> using =
	    new Using<Pair<T1, ArrayList<T1>>, ArrayList<T1>, T2, T3>(then,
								      cons);

	Succeed<ArrayList<T1>, T2> succeed =
	    new Succeed<ArrayList<T1>, T2>(new ArrayList<T1>());

	Alt<ArrayList<T1>, T2, T3> alt =
	    new Alt<ArrayList<T1>, T2, T3>(using, succeed);

	return alt.parse(inp);
    }
}
