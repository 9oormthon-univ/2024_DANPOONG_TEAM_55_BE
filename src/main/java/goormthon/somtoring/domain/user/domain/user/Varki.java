package goormthon.somtoring.domain.user.domain.user;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Varki {
	private int v;
	private int a;
	private int r;
	private int k;
	private int i;

	public static Varki of(int v, int a, int r, int k, int i) {
		Varki varki = new Varki();
		varki.v = v;
		varki.a = a;
		varki.r = r;
		varki.k = k;
		varki.i = i;
		return varki;
	}

	public void delete() {
		this.v = 0;
		this.a = 0;
		this.r = 0;
		this.k = 0;
		this.i = 0;
	}
}
