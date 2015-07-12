package app.templateMethod;

/*
 * Copyright (c) 2001, 2005. Steven J. Metsker.
 * 
 * Steve Metsker makes no representations or warranties about
 * the fitness of this software for any particular purpose, 
 * including the implied warranty of merchantability.
 *
 * Please use this software as you wish with the sole
 * restriction that you may not claim that you wrote it.
 */

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import com.oozinoz.firework.Rocket;

public class NameComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Rocket r1 = (Rocket) o1;
        Rocket r2 = (Rocket) o2;
        return r1.toString().compareTo(r2.toString());
    }

	@Override
	public Comparator reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator thenComparing(Comparator other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator thenComparing(Function keyExtractor,
			Comparator keyComparator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator thenComparing(Function keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator thenComparingInt(ToIntFunction keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator thenComparingLong(ToLongFunction keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator thenComparingDouble(ToDoubleFunction keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

}
